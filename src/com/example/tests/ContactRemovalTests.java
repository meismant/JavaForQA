package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteContact() {
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index=rnd.nextInt(oldList.size()-1);

		// actions
		app.getContactHelper().deleteContact(index);	

		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
