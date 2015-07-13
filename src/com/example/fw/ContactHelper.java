package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	protected ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData) {
		type(By.name("firstname"), contactData.name);
		type(By.name("lastname"), contactData.lastname);
		type(By.name("address"), contactData.address);
		type(By.name("home"), contactData.home);
		type(By.name("mobile"), contactData.mobile);
		type(By.name("work"), contactData.work);
		type(By.name("email"), contactData.email);
		type(By.name("email2"), contactData.email2);
		selectByText(By.name("bday"), contactData.bday);
		selectByText(By.name("bmonth"), contactData.bmonth);
		type(By.name("byear"), contactData.byear);
		if (isElementPresent(By.name("new_group"))) {
			selectByText(By.name("new_group"), contactData.new_group);
		}
		type(By.name("address2"), contactData.address2);
		type(By.name("phone2"), contactData.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int index) {
		if (isElementPresent(By.name("selected[]"))) {
			click(By.xpath("(//a/img[@title='Edit'])[" + (index + 1) + "]"));
		} else
			System.out.println("There is no any contact");
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void sumbitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> allRows = driver.findElements(By
				.xpath("//tr[@name='entry']"));
		for (WebElement row : allRows) {
			ContactData contact = new ContactData();
			contact.name = row.findElement(By.xpath("td[2]")).getText(); 
			contact.lastname = row.findElement(By.xpath("td[3]")).getText(); 
			contact.email = row.findElement(By.xpath("td[4]")).getText();
			contact.mobile = row.findElement(By.xpath("td[5]")).getText();
			contacts.add(contact);
		}
		return contacts;
	}
}
