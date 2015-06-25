package com.example.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		openMainPage();
		gotoAddNewPage();
		ContactData contact = new ContactData();
		contact.firstname = "Name";
		contact.lastname = "Surname";
		contact.address = "City and street";
		// person.home = "569825";
		contact.home = phoneRand(); // random
		// person.mobile = "29588991";
		contact.mobile = phoneRand();// random
		// person.work = "744115";
		contact.work = phoneRand();// random
		contact.email = "test@mail.com";
		contact.email2 = "test2@mail.com";
		// person.bday="28";
		contact.bday = bdayRand(); // random from list
		// person.bmonth="April";
		contact.bmonth = bmonthRand(); // random from list
		// person.byear = "1990";
		contact.byear = byearRand(); // random
		// person.new_group = "Rob";
		contact.new_group = new_groupRand();// random from list
		contact.address2 = "City2 and street2";
		// person.phone2 = "688251";
		contact.phone2 = phoneRand();// random fillPersonForm(person);
		submitItemCreation();
		returnToAddNewPage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		openMainPage();
		gotoAddNewPage();
		ContactData contact = new ContactData();
		fillPersonForm(contact);
		submitItemCreation();
		returnToAddNewPage();
	}
}
