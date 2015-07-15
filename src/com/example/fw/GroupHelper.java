package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	protected GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();

		manager.navigateTo().groupsPage();
		List<WebElement> checkBoxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkBoxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()
					- ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();		
			selectGroupByIndex(index);
			submitGroupDeletion();
			returnToGroupsPage();
		return this;
	}

	// ----------------------------------------------------

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper sumbitGroupModification() {
		click(By.name("update"));
		return this;
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
	}

}
