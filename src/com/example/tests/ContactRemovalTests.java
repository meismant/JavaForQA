package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteContact() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactModification(0);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().gotoHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare
		// assertEquals(oldList.size()+1, newList.size(),
		// "Sizes aren't equals");
		oldList.remove(0);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
