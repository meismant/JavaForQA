package com.example.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PrintPhonesTests extends TestBase {
	@Test
	public void CompareDataOfContacts() {
		//List<ContactData> contactsList = app.getContactHelper().getContacts();
		List<ContactData> phonesList = getPhones();
	}

	private List<ContactData> getPhones() {
		app.navigateTo().printPhones();
		List<ContactData> phones = new ArrayList<ContactData>();

		List<WebElement> cells = app.driver.findElements(By.tagName("td"));		
		System.out.println(cells.get(1).getText());

	for (WebElement cell : cells) {
			String data = cell.getText();			
			ContactData contact = new ContactData()
			.withName(data.substring(0, (data.indexOf(" "))))
			.withLastname(" last name")
			.withHome("home")
			.withWork("work")
			.withBday("")
			.withBmonth("")
			.withByear("")
			.withMobile("");
			System.out.println("-"+contact.getName()+"-");
			phones.add(contact);
		}
		return phones;
	}
}
