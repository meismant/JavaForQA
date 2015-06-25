package com.example.tests;

import org.testng.annotations.*;

public class PersonCreationTests extends TestBase {

	@Test
	public void testNonEmptyPersonCreation() throws Exception {
		openMainPage();
		gotoAddNewPage();
		PersonData person = new PersonData();
		person.firstname = "Name";
		person.lastname = "Surname";
		person.address = "City and street";
		// person.home = "569825";
		person.home = phoneRand(); // random
		// person.mobile = "29588991";
		person.mobile = phoneRand();// random
		// person.work = "744115";
		person.work = phoneRand();// random
		person.email = "test@mail.com";
		person.email2 = "test2@mail.com";
		// person.bday="28";
		person.bday = bdayRand(); // random from list
		// person.bmonth="April";
		person.bmonth = bmonthRand(); // random from list
		// person.byear = "1990";
		person.byear = byearRand(); // random
		// person.new_group = "Rob";
		person.new_group = new_groupRand();// random from list
		person.address2 = "City2 and street2";
		// person.phone2 = "688251";
		person.phone2 = phoneRand();// random fillPersonForm(person);
		submitItemCreation();
		returnToAddNewPage();
	}

	@Test
	public void testEmptyPersonCreation() throws Exception {
		openMainPage();
		gotoAddNewPage();
		PersonData person = new PersonData();
		fillPersonForm(person);
		submitItemCreation();
		returnToAddNewPage();
	}
}
