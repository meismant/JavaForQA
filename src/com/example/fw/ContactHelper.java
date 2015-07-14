package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	protected ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contactData,
			boolean formType) {
		type(By.name("firstname"), contactData.getName());
		type(By.name("lastname"), contactData.getLastname());
		type(By.name("address"), contactData.getAddress());
		type(By.name("home"), contactData.getHome());
		type(By.name("mobile"), contactData.getMobile());
		type(By.name("work"), contactData.getWork());
		type(By.name("email"), contactData.getEmail());
		type(By.name("email2"), contactData.getEmail2());
		selectByText(By.name("bday"), contactData.getBday());
		selectByText(By.name("bmonth"), contactData.getBmonth());
		type(By.name("byear"), contactData.getByear());
		if (formType==CREATION) {
			// selectByText(By.name("new_group"), contactData.getNew_group());
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error(
						"Group selector exists  in contact modification form");
			}
		}
		type(By.name("address2"), contactData.getAddress2());
		type(By.name("phone2"), contactData.getPhone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		if (isElementPresent(By.name("selected[]"))) {
			click(By.xpath("(//a/img[@title='Edit'])[" + (index + 1) + "]"));
		} else
			System.out.println("There is no any contact");
		return this;
	}

	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}

	public ContactHelper sumbitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> allRows = driver.findElements(By
				.xpath("//tr[@name='entry']"));
		for (WebElement row : allRows) {
			ContactData contact = new ContactData();
			contact.withName(row.findElement(By.xpath("td[3]")).getText())
					.withLastname(row.findElement(By.xpath("td[2]")).getText())
					.withEmail(row.findElement(By.xpath("td[4]")).getText())
					.withMobile(row.findElement(By.xpath("td[5]")).getText());
			contacts.add(contact);
		}
		return contacts;
	}
}
