package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group =new GroupData();
		group.name="new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().sumbitGroupModification();
		
		app.getGroupHelper().returnToGroupsPage();
	}
	
	
}
