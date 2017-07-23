package com.flux.modules.inbound;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.pageobjects.AdminHomePage;
import com.flux.pageobjects.AdminNewInboundPage;
import com.flux.pageobjects.InboundConsumerPage;
import com.flux.utility.Constant;
import com.flux.utility.LoadProperties;

public class AdminSignupElectricityAction {
	
	public static void Execute(WebDriver driver, WebDriverWait wait){
		AdminSearchAction.FindAvailable(driver, wait);
		boolean ValidMPAN = false;
		while ((Constant.list.size() != 0) && (ValidMPAN == false)) {
			Random rand = new Random();
			int n = rand.nextInt(10000);
			driver.get(LoadProperties.getProp().getProperty("url"));
			AdminHomePage.new_inbound_link(driver).click();
			wait.until(ExpectedConditions.titleContains("Inbound"));
			AdminNewInboundPage.user_brand_id(driver).sendKeys(Constant.user_brand);
			AdminNewInboundPage.user_email(driver).sendKeys(Constant.email_prefix + n + Constant.email_suffix);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ac_ul"))).click();
			AdminNewInboundPage.user_email(driver).sendKeys(Keys.ENTER);
			AdminNewInboundPage.user_first_name(driver).sendKeys(Constant.user_first_name);
			AdminNewInboundPage.user_last_name(driver).sendKeys(Constant.user_last_name);
			AdminNewInboundPage.user_date_of_birth(driver).sendKeys(Constant.user_date_of_birth);
			AdminNewInboundPage.user_month_of_birth(driver).sendKeys(Constant.user_month_of_birth);
			AdminNewInboundPage.user_year_of_birth(driver).sendKeys(Constant.user_year_of_birth);
			AdminNewInboundPage.user_contact_number(driver).sendKeys(Constant.user_contact_number);
			AdminNewInboundPage.inbound_consumer_current_situation_existing(driver).click();
			((JavascriptExecutor) driver).executeScript(Constant.js_inbound_consumer_vanity_address_attributes_building_number);
			((JavascriptExecutor) driver).executeScript(Constant.js_inbound_consumer_vanity_address_attributes_thoroughfare);
			((JavascriptExecutor) driver).executeScript(Constant.js_inbound_consumer_vanity_address_attributes_locality);
			((JavascriptExecutor) driver).executeScript(Constant.js_inbound_consumer_vanity_address_attributes_postcode);
			((JavascriptExecutor) driver).executeScript(Constant.js_fm_county);
			((JavascriptExecutor) driver).executeScript(Constant.js_fm_country);
			AdminNewInboundPage.inbound_consumer_icp_number(driver).sendKeys(Constant.current_mpan);
			AdminNewInboundPage.inbound_consumer_usual_bill_60(driver).click();
			AdminNewInboundPage.inbound_consumer_powershop_accepted_terms(driver).click();
			AdminNewInboundPage.inbound_consumer_admin_confirmed_quote_provided_at(driver).click();
			AdminNewInboundPage.inbound_consumer_override_cool_off(driver).click();
			AdminNewInboundPage.commit(driver).click();
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Escalate"))).click();

				InboundConsumerPage.inbound_consumer_street_mismatch_accepted(driver).click();
				wait.until(ExpectedConditions.elementToBeClickable(InboundConsumerPage.address_submit_button(driver))).click();
				try {
					wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.linkText("Waiting to send D0055 file")));
					ValidMPAN = true;
				} catch (Exception e) {

				}
			} catch (Exception e) {

			}finally{
		    	Constant.list.remove(0);
		    }
		}
	}

	

}
