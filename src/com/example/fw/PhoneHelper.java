package com.example.fw;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class PhoneHelper extends HelperBase {

	protected PhoneHelper(ApplicationManager manager) {
		super(manager);
	}

	public SortedListOf<ContactData> getPhones() {
		manager.navigateTo().printPhones();
		SortedListOf<ContactData> phones = new SortedListOf<ContactData>();

		List<WebElement> cells = driver.findElements(By.tagName("td"));

		for (WebElement cell : cells) {
			String data = cell.getText();

			ContactData contact = new ContactData()
					.withName(findNameAndLastName(data, "name"))
					.withLastname(findNameAndLastName(data, "lastName"))
					.withHome(findPhonesOfContact(data, "home"))
					.withMobile(findPhonesOfContact(data, "mobile"))
					.withWork(findPhonesOfContact(data, "work"))
					.withBday(findBday(data)).withBmonth(findBmonth(data))
					.withByear(findByear(data))
					.withPhone2(findPhonesOfContact(data, "phone2"));
			/*
			 * System.out.println(" name " + contact.getName());
			 * System.out.println(" last name " + contact.getLastname());
			 * System.out.println(" home " + contact.getHome());
			 * System.out.println(" mobile " + contact.getMobile());
			 * System.out.println(" work " + contact.getWork());
			 * System.out.println(" bday " + contact.getBday());
			 * System.out.println(" bmonth " + contact.getBmonth());
			 * System.out.println(" byear " + contact.getByear());
			 * System.out.println(" phone2 " + contact.getPhone2());
			 */
			phones.add(contact);
		}
		return phones;
	}

	private String find(String data, String regex) {
		String result = "";
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(data);
		if (matcher.find()) {
			return result = matcher.group();
		}
		return result;
	}

	private String findNameAndLastName(String data, String tag) {
		String str = find(data, "[ a-zA-z0-9]+:|:");
		switch (tag) {
		case "name":
			str = find(str, "\\w+ ");
			break;
		case "lastName":
			str = find(str, "\\w+:");
			break;
		default:
			break;
		}
		if (str != "") {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	private String findPhonesOfContact(String data, String tag) {
		String regex;
		switch (tag) {
		case "home":
			regex = "H: \\d+";
			break;
		case "mobile":
			regex = "M: \\d+";
			break;
		case "work":
			regex = "W: \\d+";
			break;
		case "phone2":
			regex = "P: \\d+";
			break;

		default:
			regex = "";
			break;
		}
		String str = find(data, regex);
		if (str != "") {
			str = str.substring(3);
		}
		return str;
	}

	private String findBday(String data) {
		String str = find(data, "\\d+\\.");
		if (str != "") {
			str = str.substring(0, (str.length() - 1));
		}
		return str;
	}

	private String findBmonth(String data) {
		String str = find(data, "Birthday:[ .a-zA-z0-9]+");
		str = find(str, " [a-zA-Z]+");
		if (str != "") {
			str = str.substring(1);
		}
		return str;
	}

	private String findByear(String data) {
		String str = find(data, "Birthday:[ .a-zA-z0-9]+");
		str = find(str, "\\d+$");
		return str;
	}

	public boolean compareContacts(List<ContactData> contactsList,
			List<ContactData> phonesList) {
		if (contactsList.size() == phonesList.size()) {
			for (int i = 0; i < contactsList.size(); i++) {
				if (contactsList.get(i).equals(phonesList.get(i))) {
					// System.out.println(i + "are equals");
				} else
					return false;
			}
			// System.out.println(contactsList.size());
			// System.out.println(phonesList.size());
		} else
			return false;
		return true;
	}
}
