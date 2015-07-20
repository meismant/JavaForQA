package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class PrintPhonesTests extends TestBase {
	@Test
	public void CompareDataOfContacts() {
		// get both states
		// SortedListOf<ContactData> contactsList =
		// app.getContactHelper().getContacts();
		SortedListOf<ContactData> contactsList = app.getPhoneHelper().getContacts();
		SortedListOf<ContactData> phonesList = app.getPhoneHelper().getPhones();

		// actions
		app.getPhoneHelper().compareContacts(contactsList, phonesList);

		for (ContactData contact : contactsList) {
			System.out.println("ContactsList : " + contact.toString());
		}
	}

}
