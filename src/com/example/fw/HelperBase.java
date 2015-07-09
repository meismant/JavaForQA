package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {

	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;

	protected HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
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

	public void type(By locator, String text) {
		if (text != null) {

			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

	public boolean checkboxExist() {
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  boolean result = isElementPresent(By.name("selected[]"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  return result;
	 }

}