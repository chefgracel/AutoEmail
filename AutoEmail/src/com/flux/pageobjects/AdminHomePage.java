package com.flux.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {
	
	public static WebElement new_inbound_link(WebDriver driver){
		return driver.findElement(By.linkText("New Inbound"));
	}
	
	public static WebElement search(WebDriver driver){
		return driver.findElement(By.id("search"));
	}
	
	public static WebElement search_no_results(WebDriver driver){
		return driver.findElement(By.id("search_no_results"));
	}

}
