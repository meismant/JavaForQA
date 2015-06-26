package com.example.fw;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	protected ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData) {
		type(By.name("firstname"), contactData.firstname);
		type(By.name("lastname"), contactData.lastname);
		type(By.name("address"), contactData.address);
		type(By.name("home"), contactData.home);
		type(By.name("mobile"), contactData.mobile);
		type(By.name("work"), contactData.work);
		type(By.name("email"), contactData.email);
		type(By.name("email2"), contactData.email2);
		selectByText(By.name("bday"), contactData.bday);
		selectByText(By.name("bmonth"), contactData.bmonth);
		type(By.name("byear"), contactData.byear);
		selectByText(By.name("new_group"), contactData.new_group);
		type(By.name("address2"), contactData.address2);
		type(By.name("phone2"), contactData.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public String bdayRand() {
		String bday = "-";

		WebElement element = driver.findElement(By.name("bday"));
		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(31);
		bday = select.getOptions().get(index + 1).getText();

		return bday;
	}

	public String bmonthRand() {
		String bmonth = "-";

		WebElement element = driver.findElement(By.name("bmonth"));
		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(12);

		bmonth = select.getOptions().get(index + 1).getText();

		return bmonth;
	}

	public String byearRand() {
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

	public String new_groupRand() {
		String group = "[none]";
		WebElement element = driver.findElement(By.name("new_group"));

		Select select = new Select(element);
		Random rnd = new Random();
		int index = rnd.nextInt(select.getOptions().size() - 1);

		group = select.getOptions().get(index + 1).getText();

		return group;
	}

	public String phoneRand() {
		String phone = "";
		Random rnd = new Random();
		int year = rnd.nextInt(9899999);
		year += 100000;
		phone = Integer.toString(year);
		return phone;
	}

}
