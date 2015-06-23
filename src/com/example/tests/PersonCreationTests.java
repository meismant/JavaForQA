package com.example.tests;

import org.testng.annotations.*;

public class PersonCreationTests extends TestBase {

	@Test
	public void testNonEmptyPersonCreation() throws Exception {
		openMainPage();
		gotoAddNewPage();
		PersonData person = new PersonData();
		person.firstname="Name";
		person.lastname="Surname";
		person.address="City and street";
		person.home="569825";
		person.mobile="29588991";
		person.work="744115";
		person.email="test@mail.com";
		person.email2="test2@mail.com";
		person.bday="28";
		person.bmonth="February";
		person.byear="1990";
		person.new_group="Rob";
		person.address2="City2 and street2";
		person.phone2="688251";
		fillPersonForm(person);
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
