package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTest extends TestBase {

	@Test(dataProvider="randomValidContactGenerator")
	public void modifyContact(ContactData contact) {
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index=rnd.nextInt(oldList.size()-1);
		
		// actions
		app.getContactHelper().modifyContact(index, contact, MODIFICATION);		
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
