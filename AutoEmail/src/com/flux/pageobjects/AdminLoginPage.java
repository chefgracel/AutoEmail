package com.flux.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {
	
	public static WebElement admin_email(WebDriver driver){
		return driver.findElement(By.id("admin_email"));
	}
	
	public static WebElement admin_password(WebDriver driver){
		return driver.findElement(By.id("admin_password"));
	}
	
	public static WebElement admin_token(WebDriver driver){
		return driver.findElement(By.id("admin_token"));
	}
	public static WebElement admin_login_button(WebDriver driver){
		return driver.findElement(By.id("login_button"));
	}
}
