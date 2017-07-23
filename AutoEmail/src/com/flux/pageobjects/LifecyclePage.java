package com.flux.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LifecyclePage {

	public static WebElement CustomerBillingSec(WebDriver driver){
		return driver.findElement(By.id("customer_billing_rows_section"));
	}
	
	public static WebElement BillingRun(WebDriver driver){
		return driver.findElement(By.linkText("New Customer Billing Run"));
	}
	
	public static WebElement BillEndDate(WebDriver driver){
		return driver.findElement(By.id("customer_billing_end_date")); //1-Jul-2017, value="2017-07-01"
	}
	
	public static WebElement CommitBill(WebDriver driver){
		return driver.findElement(By.name("commit"));
	}
	
	public static WebElement BillExpand(WebDriver driver){
		return driver.findElement(By.linkText("Expand"));
	}
	
	public static WebElement BillShow(WebDriver driver){
		return driver.findElement(By.linkText("Show"));
	}
	
	public static WebElement BillAccept(WebDriver driver){
		return driver.findElement(By.linkText("Accept"));
	}
	
	public static WebElement BillReverse(WebDriver driver){
		return driver.findElement(By.linkText("Reverse"));
	}
	
	public static WebElement CustomerSupport(WebDriver driver){
		return driver.findElement(By.linkText("customer_support_section"));
	}
}
