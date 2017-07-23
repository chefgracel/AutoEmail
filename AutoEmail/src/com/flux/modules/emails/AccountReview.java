package com.flux.modules.emails;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.pageobjects.LifecyclePage;
import com.flux.utility.Constant;

public class AccountReview {

	public static void Bill(WebDriver driver, WebDriverWait wait) {
		GotoLifecycle.Execute(driver, wait);
		wait.until(ExpectedConditions.urlContains("lifecycle"));
		ReverseBill(driver,wait);
		ActionPeriod(driver, wait, 0);
		RunNewBill(driver, wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_end_date")));
		WebElement mySelectElement = LifecyclePage.BillEndDate(driver);
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(dropdown.getOptions().size() - 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("commit")));
		LifecyclePage.CommitBill(driver).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("commit")));
		Verify(driver, wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_rows_section")));
		LifecyclePage.CustomerBillingSec(driver).click();
	}

	public static void BillComing(WebDriver driver, WebDriverWait wait) {
		GotoLifecycle.Execute(driver, wait);
		wait.until(ExpectedConditions.urlContains("lifecycle"));
		ReverseBill(driver,wait);
		ActionPeriod(driver, wait, 2);
		RunNewBill(driver, wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_end_date")));
		WebElement mySelectElement = LifecyclePage.BillEndDate(driver);
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("commit")));
		LifecyclePage.CommitBill(driver).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("commit")));
		Verify(driver, wait);
	}

	public static void RunNewBill(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_rows_section")));
		LifecyclePage.CustomerBillingSec(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Customer Billing Run")));
		LifecyclePage.BillingRun(driver).sendKeys(Keys.RETURN);
	}

	public static void ReverseBill(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_rows_section")));
		LifecyclePage.CustomerBillingSec(driver).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (driver.findElements(By.linkText("Reverse")).size() != 0) {

			driver.findElements(By.linkText("Reverse")).get(0).sendKeys(Keys.RETURN);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(3000);
			} catch (Exception e) {
				// exception handling
			}
			System.out.println("Bill reversed.");
		}
		System.out.println("No active bill exists now.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_billing_rows_section")));
		LifecyclePage.CustomerBillingSec(driver).click();
	}

	public static void ActionPeriod(WebDriver driver, WebDriverWait wait, int days) {
		String actiondays = "" + days;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_preferences_section")));
		driver.findElement(By.id("account_preferences_section")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_call_to_action_expiry_days")));
		driver.findElement(By.id("customer_call_to_action_expiry_days")).clear();
		driver.findElement(By.id("customer_call_to_action_expiry_days")).sendKeys(actiondays);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("commit")));
		driver.findElement(By.name("commit")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("account_preferences_section")).click();
	}

	public static void Verify(WebDriver driver, WebDriverWait wait) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reverse")));
		driver.findElements(By.linkText("Expand")).get(0).sendKeys(Keys.RETURN);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Show")));
		LifecyclePage.BillShow(driver).sendKeys(Keys.RETURN);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Close")));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int count1 = driver.findElements(By.linkText("Download invoice")).size();

		int count2 = driver.findElements(By.linkText("Accept")).size();

		System.out.println("count1: " + count1);
		System.out.println("count2: " + count2);

		if ((count1 == 0) && (count2 == 1)) {
			LifecyclePage.BillAccept(driver).sendKeys(Keys.RETURN);
			System.out.println("Accept bill exception.");
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				// exception handling
			}
		}
		count1 = driver.findElements(By.linkText("Download invoice")).size();
		if (count1 == 2) {
			System.out.println("AccountReview generated.");
		}
		if (count1 == 0) {
			System.out.println("AccountReviewComing generated.");
		}
	}
}
