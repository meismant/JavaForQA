package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContact(ContactData contact) {

		// save old state
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app
				.getModel().getContacts());

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().modifyContact(index, contact, MODIFICATION);

		// save new state
		SortedListOf<ContactData> newList = new SortedListOf<ContactData>(app
				.getModel().getContacts());

		// compare
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));

		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getHibernateHelper().listContacts()));
			}

			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getContactHelper().getUiContacts()));
			}
		}
	}
}
