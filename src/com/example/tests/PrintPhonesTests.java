package com.example.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PrintPhonesTests extends TestBase {
	@Test
	public void CompareDataOfContacts() {
		// List<ContactData> contactsList =
		// app.getContactHelper().getContacts();
		List<ContactData> phonesList = getPhones();
	}

	private List<ContactData> getPhones() {
		app.navigateTo().printPhones();
		List<ContactData> phones = new ArrayList<ContactData>();

		List<WebElement> cells = app.driver.findElements(By.tagName("td"));

		for (WebElement cell : cells) {
			String data = cell.getText();

			ContactData contact = new ContactData()
					.withName(findName(cell.findElement(By.tagName("b")).getText()))
					.withLastname(findLastName(cell.findElement(By.tagName("b")).getText()))
					.withHome(findPhonesOfContact(data, "home"))
					.withMobile(findPhonesOfContact(data, "mobile"))
					.withWork(findPhonesOfContact(data, "work"))
					.withBday(findBday(data))
					.withPhone2(findPhonesOfContact(data, "phone2"));

			System.out.println(" name " + contact.getName());
			phones.add(contact);
		}
		return phones;
	}

	private String findBday(String data) {		
		String str=find(data, "Birthday: \\d*. \\w+ \\d+");		
		str=find(str, "\\d\\d\\.");
		if (str != "") {
			str = str.substring(0, str.length()-1);
		}		
		System.out.println(str);
		return str;
	}	private String findName(String data) {
		String str = find(data, "\\w+ :");
		if (str != "") {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	private String findLastName(String data) {
		String str = find(data, "\\w+:");
		if (str != "") {
			str = str.substring(0, str.length() - 1);
		}
		return str;
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

}
