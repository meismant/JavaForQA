package com.example.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.contactHelper.initContactCreation();
		ContactData contact = new ContactData();
		contact.firstname = "Name";
		contact.lastname = "Surname";
		contact.address = "City and street";
		// person.home = "569825";
		contact.home = app.contactHelper.phoneRand(); // random
		// person.mobile = "29588991";
		contact.mobile = app.contactHelper.phoneRand();// random
		// person.work = "744115";
		contact.work = app.contactHelper.phoneRand();// random
		contact.email = "test@mail.com";
		contact.email2 = "test2@mail.com";
		// person.bday="28";
		contact.bday = app.contactHelper.bdayRand(); // random from list
		// person.bmonth="April";
		contact.bmonth = app.contactHelper.bmonthRand(); // random from list
		// person.byear = "1990";
		contact.byear = app.contactHelper.byearRand(); // random
		// person.new_group = "Rob";
		contact.new_group = app.contactHelper.new_groupRand();// random from list
		contact.address2 = "City2 and street2";
		// person.phone2 = "688251";
		contact.phone2 = app.contactHelper.phoneRand();// random fillPersonForm(person);
		app.contactHelper.submitContactCreation();
		app.contactHelper.returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.contactHelper.initContactCreation();
		ContactData contact = new ContactData();
		app.contactHelper.fillContactForm(contact);
		app.contactHelper.submitContactCreation();
		app.contactHelper.returnToHomePage();
	}
}
