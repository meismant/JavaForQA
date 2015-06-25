package com.example.tests;

import static org.junit.Assert.fail;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	protected void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	// block for groups tests
	protected void gotoGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void fillGroupForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.name);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void submitItemCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	// block for add new tests
	protected void gotoAddNewPage() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void fillPersonForm(PersonData person) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(person.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(person.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(person.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(person.home);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(person.mobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(person.work);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(person.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(person.email2);
		new Select(driver.findElement(By.name("bday")))
				.selectByVisibleText(person.bday);
		new Select(driver.findElement(By.name("bmonth")))
				.selectByVisibleText(person.bmonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(person.byear);
		new Select(driver.findElement(By.name("new_group")))
				.selectByVisibleText(person.new_group);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(person.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(person.phone2);
	}

	protected void returnToAddNewPage() {
		driver.findElement(By.linkText("add next")).click();
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
		int index = rnd.nextInt(select.getOptions().size()-1);
		
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

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}
