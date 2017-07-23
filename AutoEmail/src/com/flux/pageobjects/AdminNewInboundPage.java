package com.flux.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminNewInboundPage {
	
	public static WebElement user_brand_id(WebDriver driver){
		return driver.findElement(By.id("user_brand_id"));
	}
	
	public static WebElement user_email(WebDriver driver){
		return driver.findElement(By.id("user_email"));
	}
	
	public static WebElement user_first_name(WebDriver driver){
		return driver.findElement(By.id("user_first_name"));
	}
	
	public static WebElement user_last_name(WebDriver driver){
		return driver.findElement(By.id("user_last_name"));
	}
	
	public static WebElement user_date_of_birth(WebDriver driver){
		return driver.findElement(By.id("user_date_of_birth_3i"));
	}
	
	public static WebElement user_month_of_birth(WebDriver driver){
		return driver.findElement(By.id("user_date_of_birth_2i"));
	}
	
	public static WebElement user_year_of_birth(WebDriver driver){
		return driver.findElement(By.id("user_date_of_birth_1i"));
	}
	
	public static WebElement user_contact_number(WebDriver driver){
		return driver.findElement(By.id("user_contact_number"));
	}
	
	public static WebElement email_popup(WebDriver driver){
		return driver.findElement(By.id("ac_ul"));
	}
	
	public static WebElement inbound_consumer_current_situation_existing(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_current_situation_existing"));
	}
	
	public static WebElement inbound_consumer_icp_number(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_icp_number"));
	}

	public static WebElement inbound_consumer_usual_bill_60(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_usual_bill_60"));
	}
	
	public static WebElement inbound_consumer_powershop_accepted_terms(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_powershop_accepted_terms"));
	}
	
	public static WebElement inbound_consumer_admin_confirmed_quote_provided_at(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_admin_confirmed_quote_provided_at"));
	}
	
	public static WebElement inbound_consumer_override_cool_off(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_override_cool_off"));
	}
	
	public static WebElement commit(WebDriver driver){
		return driver.findElement(By.name("commit"));
	}
}
