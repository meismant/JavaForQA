package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test(dataProvider="randomValidContactGenerator")
	public void modifyContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index=rnd.nextInt(oldList.size()-1);
		
		// actions
		app.getContactHelper()
		.initContactModification(index)	
		.fillContactForm(contact)
		.sumbitContactModification()
		.returnToHomePage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
