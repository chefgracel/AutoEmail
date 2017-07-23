package com.flux.modules.emails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.modules.inbound.AdminSearchAction;
import com.flux.modules.inbound.AdminSignupElectricityAction;
import com.flux.modules.inbound.UKSwitch;
import com.flux.utility.Constant;

public class GotoLifecycle {
	
	public static void Execute(WebDriver driver, WebDriverWait wait){
		if (Constant.use_exist_mpan.equals("yes")) {
			Constant.current_mpan = Constant.exist_mpan;
			System.out.println("Current MPAN is: " + Constant.current_mpan);
		}
		if (Constant.use_exist_mpan.equals("no") && Constant.current_mpan == "") {
			AdminSignupElectricityAction.Execute(driver, wait);
			UKSwitch.Execute();
			UKSwitch.SwitchDone(driver, wait);
		}
		AdminSearchAction.FindExist(driver, wait);
	}

}
