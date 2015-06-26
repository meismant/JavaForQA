package com.example.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.firstname = "Name";
		contact.lastname = "Surname";
		contact.address = "City and street";
		// person.home = "569825";
		contact.home = app.getContactHelper().phoneRand(); // random
		// person.mobile = "29588991";
		contact.mobile = app.getContactHelper().phoneRand();// random
		// person.work = "744115";
		contact.work = app.getContactHelper().phoneRand();// random
		contact.email = "test@mail.com";
		contact.email2 = "test2@mail.com";
		// person.bday="28";
		contact.bday = app.getContactHelper().bdayRand(); // random from list
		// person.bmonth="April";
		contact.bmonth = app.getContactHelper().bmonthRand(); // random from list
		// person.byear = "1990";
		contact.byear = app.getContactHelper().byearRand(); // random
		// person.new_group = "Rob";
		contact.new_group = app.getContactHelper().new_groupRand();// random from list
		contact.address2 = "City2 and street2";
		// person.phone2 = "688251";
		contact.phone2 = app.getContactHelper().phoneRand();// random fillPersonForm(person);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}
}
