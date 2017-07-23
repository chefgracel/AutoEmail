package com.flux.modules.inbound;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.pageobjects.AdminHomePage;
import com.flux.utility.Constant;

public class AdminSearchAction {
	public static void FindAvailable(WebDriver driver, WebDriverWait wait) {
		boolean available_mpan = false;
		while (!available_mpan) {
			AdminHomePage.search(driver).clear();
			AdminHomePage.search(driver).sendKeys(Constant.list.get(0));
			AdminHomePage.search(driver).sendKeys(Keys.ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = driver.findElements(By.id("search_no_results")).size();
			if (count == 0){
				System.out.println("MPAN: " + Constant.list.get(0) + " is already exist.");
				System.out.println("Current MPAN: " + Constant.current_mpan);
				Constant.list.remove(0);
			}
			else{
				System.out.println("MPAN: " + Constant.list.get(0) + " is available.");
				Constant.current_mpan = Constant.list.get(0);
				available_mpan = true;
			}
		}
	}
	
	public static void FindExist(WebDriver driver, WebDriverWait wait) {
		
		AdminHomePage.search(driver).clear();
		AdminHomePage.search(driver).sendKeys(Constant.current_mpan);
		AdminHomePage.search(driver).sendKeys(Keys.ENTER);
		
	}
}
