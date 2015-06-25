package com.example.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group name 1";
		group.header = "header name 1";
		group.footer = "footer name 1";
		app.groupHelper.fillGroupForm(group);
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.navigationHelper.gotoGroupsPage();
		app.groupHelper.initGroupCreation();
		app.groupHelper.fillGroupForm(new GroupData("", "", ""));
		app.groupHelper.submitGroupCreation();
		app.groupHelper.returnToGroupsPage();
	}
}
