package com.flux.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InboundConsumerPage {
	
	public static WebElement inbound_consumer_street_mismatch_accepted(WebDriver driver){
		return driver.findElement(By.id("inbound_consumer_street_mismatch_accepted"));
	}
	
	public static WebElement address_submit_button(WebDriver driver){
		return driver.findElement(By.id("address-submit-button"));
	}

}
