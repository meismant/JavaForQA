package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData().withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return Integer.toString(rnd.nextInt());
		}
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			if (rnd.nextInt(5) > 0) {
				contact.withName(nameRand()).withLastname(surnameRand())
						.withAddress(addressRand()).withHome(phoneRand())
						.withMobile(phoneRand()).withWork(phoneRand())
						.withEmail(emailRand()).withEmail2(emailRand())
						.withBday(bdayRand()).withBmonth(bmonthRand())
						.withByear(byearRand()).withNew_group(new_groupRand())
						.withAddress2(addressRand()).withPhone2(phoneRand());
			}
			list.add(new Object[] { contact });
		}

		return list.iterator();
	}

	private String nameRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] names = new String[] { "Kate", "Mike", "John", "Marybet",
					"Billy", "Bob", "Henry", "Stu" };
			int index = rnd.nextInt(names.length);
			return names[index];
		}
	}

	private String surnameRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] surnames = new String[] { "Goran", "Limiter", "Chan",
					"West", "Forest", "Woods", "George", "Jhonson", "Black" };
			int index = rnd.nextInt(surnames.length);
			return surnames[index];
		}
	}

	private String addressRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String[] address = new String[] { "221B Baker St.",
					"1313 Mockingbird Lane", "0001 Cemetery Lane",
					"4222 Clinton Way", "12 Grimmauld Place",
					"112 1/2 Beacon St.", "742 Evergreen Terrace" };
			int index = rnd.nextInt(address.length);
			return address[index];
		}
	}

	private String emailRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String futureEmail = "";
			int index;
			int size = rnd.nextInt(20);
			for (int i = 0; i < size; i++) {
				index = rnd.nextInt(122 - 97) + 97;
				futureEmail += (char) index;
			}
			futureEmail += "@test.com";
			return futureEmail;
		}
	}

	private String bdayRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "-";
		} else {
			String bday = "-";
			bday = Integer.toString(rnd.nextInt(30) + 1);
			return bday;
		}
	}

	private String bmonthRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "-";
		} else {
			String bmonth = "-";
			String[] address = new String[] { "January", "February", "March",
					"April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			int index = rnd.nextInt(12);
			bmonth = address[index];
			return bmonth;
		}
	}

	private String byearRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			String byear = "";
			java.util.Calendar calendar = java.util.Calendar.getInstance(
					java.util.TimeZone.getDefault(),
					java.util.Locale.getDefault());
			calendar.setTime(new java.util.Date());
			int year = rnd
					.nextInt(calendar.get(java.util.Calendar.YEAR) - 1900);
			year += 1900;
			byear = Integer.toString(year);
			return byear;
		}
	}

	private String new_groupRand() {
		String group = "[none]";
		// WebElement element = app.driver.findElement(By.name("new_group"));

		// Select select = new Select(element);
		// Random rnd = new Random();
		// int index = rnd.nextInt(select.getOptions().size() - 1);

		// group = select.getOptions().get(index + 1).getText();

		return group;
	}

	private String phoneRand() {
		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			int phone = rnd.nextInt();
			if (phone < 0)
				phone *= -1;
			return Integer.toString(phone);
		}
	}

}
