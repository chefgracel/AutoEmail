package com.flux.test.inbound;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import com.flux.modules.*;
import com.flux.modules.inbound.AdminLoginAction;
import com.flux.modules.inbound.AdminSearchAction;
import com.flux.modules.inbound.AdminSignupElectricityAction;
import com.flux.modules.inbound.UKSwitch;
import com.flux.utility.Constant;
import com.flux.utility.LoadProperties;
import com.flux.utility.Log;


import com.flux.annotations.RetryCountIfFailed;
import com.flux.test.retry.RetryAnalyzer;;

public class AdminNewInbound {

	public WebDriver driver;
	public WebDriverWait wait;

	//@Parameters("browser")
	@BeforeTest
	public void LoadAdminSite() {
		DOMConfigurator.configure("log4j.xml");
        String browser = "chrome";
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		wait = new WebDriverWait(driver, 20);
		driver.get(LoadProperties.getProp().getProperty("url"));
		wait.until(ExpectedConditions.titleContains("Powershop Admin Login"));
		Log.info("Admin log in page loaded.");
	}

	@Test(priority = 0) // retryAnalyzer = RetryAnalyzer.class)
	@RetryCountIfFailed(5)
	public void AdminLogin() {
		AdminLoginAction.Execute(driver, wait);
	}

	@Test(dependsOnMethods = { "AdminLogin" })
	public void Signup() {
		AdminSearchAction.FindAvailable(driver, wait);
		AdminSignupElectricityAction.Execute(driver, wait);
		// verification, site pricing and terms, transfer switch in progress
	}

	
	@Test(dependsOnMethods = { "Signup" })
	public void Swtching() {
		Log.startTestCase("Switching Process.");
		UKSwitch.Execute();
		Log.endTestCase("Switching Process.");
	}

	@Test(dependsOnMethods = { "Swtching" })
	public void SwitchComplete() {
		Log.startTestCase("Verify Switched Customer.");
		UKSwitch.SwitchDone(driver, wait);
		Log.endTestCase("Verify Switched Customer.");
		// welcome
	}

	@AfterTest
	public void testTeardown() {
		// driver.close();
		// driver.quit();
	}

}
