package com.flux.modules.inbound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.pageobjects.AdminLoginPage;
import com.flux.utility.Constant;
import com.flux.utility.LoadProperties;
import com.flux.utility.Log;

public class AdminLoginAction {
	
	public static void Execute(WebDriver driver, WebDriverWait wait){
		AdminLoginPage.admin_email(driver).clear();
		AdminLoginPage.admin_email(driver).sendKeys(Constant.superuser_email);
        AdminLoginPage.admin_password(driver).sendKeys(Constant.admin_pwd);
        AdminLoginPage.admin_token(driver).sendKeys(Constant.admin_token);
        AdminLoginPage.admin_login_button(driver).click();
        wait.until(ExpectedConditions.titleContains("Home"));
        Log.info("Logged in as: " + LoadProperties.getProp().getProperty("email"));
	}

}
