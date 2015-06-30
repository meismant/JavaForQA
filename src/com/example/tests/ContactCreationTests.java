package com.example.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.firstname = nameRand();
		contact.lastname = surnameRand();
		contact.address = addressRand();
		contact.home = phoneRand();
		contact.mobile = phoneRand();
		contact.work = phoneRand();
		contact.email = emailRand();
		contact.email2 = emailRand();
		contact.bday = bdayRand();
		contact.bmonth = bmonthRand();
		contact.byear = byearRand();
		contact.new_group = new_groupRand();
		contact.address2 = addressRand();
		contact.phone2 = phoneRand();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.bday = "-";
		contact.bmonth = "-";
		contact.new_group = "[none]";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}

	private String bdayRand() {
		String bday = "-";

		WebElement element = app.driver.findElement(By.name("bday"));
		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(31);
		bday = select.getOptions().get(index + 1).getText();

		return bday;
	}

	private String nameRand() {
		String[] names = new String[] { "Kate", "Mattew", "John", "Marybet" };
		Random rnd = new Random();
		int index = rnd.nextInt(names.length);
		return names[index];
	}

	private String surnameRand() {
		String[] surnames = new String[] { "Goran", "Limiter", "Chan",
				"Jhonson" };
		Random rnd = new Random();
		int index = rnd.nextInt(surnames.length);
		return surnames[index];
	}

	private String addressRand() {
		String[] address = new String[] { "NY, 75 Varick St", "NY, N 7th St",
				"Paris, Rue de la Trémoille, 12", "Milan, Via Ariberto" };
		Random rnd = new Random();
		int index = rnd.nextInt(address.length);
		return address[index];
	}

	private String emailRand() {
		String futureEmail="";
		int index;
		Random rnd = new Random();
		for (int i=0; i<6; i++)
		{
			index = rnd.nextInt(122-97)+97;
			futureEmail+=(char)index;
		}		
		futureEmail+="@test.com";
		return futureEmail;
	}

	private String bmonthRand() {
		String bmonth = "-";

		WebElement element = app.driver.findElement(By.name("bmonth"));
		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(12);

		bmonth = select.getOptions().get(index + 1).getText();

		return bmonth;
	}

	private String byearRand() {
		String byear = "-";

		java.util.Calendar calendar = java.util.Calendar.getInstance(
				java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
		calendar.setTime(new java.util.Date());
		Random rnd = new Random();
		int year = rnd.nextInt(calendar.get(java.util.Calendar.YEAR) - 1900);
		year += 1900;
		byear = Integer.toString(year);
		return byear;
	}

	private String new_groupRand() {
		String group = "[none]";
		WebElement element = app.driver.findElement(By.name("new_group"));

		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(select.getOptions().size() - 1);

		group = select.getOptions().get(index + 1).getText();

		return group;
	}

	private String phoneRand() {
		String phone = "";
		Random rnd = new Random();
		int year = rnd.nextInt(9899999);
		year += 100000;
		phone = Integer.toString(year);
		return phone;
	}

}
