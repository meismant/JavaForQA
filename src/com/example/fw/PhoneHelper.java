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

	private SortedListOf<ContactData> phones;
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getPhones() {
		if (phones == null) {
			rebuildPhonesCache();
		}
		return phones;
	}

	private void rebuildPhonesCache() {
		manager.navigateTo().printPhones();
		phones = new SortedListOf<ContactData>();

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
			phones.add(contact);
		}
	}

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildContactsCache();
		}
		return cachedContacts;
	}

	private void rebuildContactsCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> allRows = driver.findElements(By
				.xpath("//tr[@name='entry']"));
		
		
		for (WebElement row : allRows) {
			row.findElement(By.xpath("td[7]/a")).click();

			System.out.println(driver.findElement(By.tagName("h1")).getText());
			if (driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase("Edit / add address book entry")){
				System.out.println("conditions are true");
				ContactData contact = new ContactData();
				contact.withName(driver.findElement(By.name("firstname")).getAttribute("value"))
						.withLastname(driver.findElement(By.name("lastname")).getAttribute("value"))
						.withHome(driver.findElement(By.name("home")).getAttribute("value"))
						.withMobile(driver.findElement(By.name("mobile")).getAttribute("value"))
						.withWork(driver.findElement(By.name("work")).getAttribute("value"))
						.withBday(driver.findElement(By.name("bday")).getAttribute("value"))
						.withBmonth(driver.findElement(By.name("bmonth")).getAttribute("value"))
						.withByear(driver.findElement(By.name("byear")).getAttribute("value"))
						.withPhone2(driver.findElement(By.name("phone2")).getAttribute("value"));
				cachedContacts.add(contact);
			}				
		}
	}
	
	private ContactData getContact(){
		ContactData contact = new ContactData();
		return contact;
	}
	
	//--------------------------------------------------------------------------------------
	
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
