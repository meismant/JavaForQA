package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	// to do: check if there are no any groups
	@Test
	public void deleteSomeGroup() {

		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int index = 0;		
		if (oldList.size() > 1) {
			index = rnd.nextInt(oldList.size() - 1);
		}
	
		// actions
		app.getGroupHelper().deleteGroup(index);

		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare states
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}
}
