package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testConntactCreationWithValidData(ContactData contact)
			throws Exception {
		//app.navigateTo().mainPage();

		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contact, CREATION);		

		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
