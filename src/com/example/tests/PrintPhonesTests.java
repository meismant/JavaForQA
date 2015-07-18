package com.example.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class PrintPhonesTests extends TestBase {
	@Test
	public void CompareDataOfContacts() {
		//save old state
		SortedListOf<ContactData> contactsList = app.getContactHelper().getContacts();
		SortedListOf<ContactData> phonesList = app.getPhoneHelper().getPhones();
		
		//actions
		app.getPhoneHelper().compareContacts(contactsList, phonesList);
	}

	

}
