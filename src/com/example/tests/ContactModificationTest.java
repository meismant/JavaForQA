package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	@Test
	public void modifyContact() {
		app.getNavigationHelper().openMainPage();
		if (app.getContactHelper().checkboxExist()) {
			app.getContactHelper().initContactModification(1);
			ContactData contact = new ContactData();
			contact.lastname = "Up surname";
			app.getContactHelper().fillContactForm(contact);
			app.getContactHelper().sumbitContactModification();
			app.getNavigationHelper().gotoHomePage();
		} else
			System.out.println("There is no any contact");
	}
}
