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
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ContactData contactData) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname"))
				.sendKeys(contactData.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contactData.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contactData.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contactData.home);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contactData.mobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contactData.work);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contactData.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contactData.email2);
		new Select(driver.findElement(By.name("bday")))
				.selectByVisibleText(contactData.bday);
		new Select(driver.findElement(By.name("bmonth")))
				.selectByVisibleText(contactData.bmonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contactData.byear);
		new Select(driver.findElement(By.name("new_group")))
				.selectByVisibleText(contactData.new_group);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contactData.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contactData.phone2);
	}

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
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
