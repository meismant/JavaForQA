package com.example.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group name 1";
		group.header = "header name 1";
		group.footer = "footer name 1";
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		fillGroupForm(new GroupData("", "", ""));
		submitGroupCreation();
		returnToGroupsPage();
	}
}
