package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {

	// to do: check if there are no any groups
	@Test
	public void deleteSomeGroup() {

		// save old state
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app
				.getModel().getGroups());

		Random rnd = new Random();
		int index = 0;
		if (oldList.size() > 1) {
			index = rnd.nextInt(oldList.size() - 1);
		}

		// actions
		app.getGroupHelper().deleteGroup(index);

		// save new state
		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app
				.getModel().getGroups());

		// compare states
		assertThat(newList, equalTo(oldList.without(index)));

		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(app.getModel().getGroups(), equalTo(app
						.getHibernateHelper().listGroups()));
			}

			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(app.getModel().getGroups(), equalTo(app
						.getGroupHelper().getUiGroups()));
			}
		}
	}
}
