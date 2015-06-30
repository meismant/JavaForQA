package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);;
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().gotoHomePage();

	}

}
