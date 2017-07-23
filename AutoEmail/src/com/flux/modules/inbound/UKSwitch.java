package com.flux.modules.inbound;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.utility.Constant;
import com.flux.utility.LoadProperties;

public class UKSwitch {
	public static void Execute() {
		try {
			Runtime rtime = Runtime.getRuntime();
			String exc_inbound = Constant.setupuk_path + " --url " + Constant.surl + " --mpan " + Constant.current_mpan + " --ssd " + Constant.ssd + " --stop " + Constant.stop_at;
			String exc_del_mra = Constant.MRA_DEL_path;
			
			Process chmodx_delmra = rtime.exec("chmod +x " + Constant.MRA_DEL_path);
			chmodx_delmra.waitFor();
			Process chmodx_inbound = rtime.exec("chmod +x " + Constant.setupuk_path);
			chmodx_inbound.waitFor();
			System.out.println(exc_del_mra);
			Process del_mra = rtime.exec(exc_del_mra);
			del_mra.waitFor();
			System.out.println(exc_inbound);
			Process ele_switch = rtime.exec(exc_inbound);
			int wait_switch = ele_switch.waitFor();
			
			InputStreamReader ir= new InputStreamReader(ele_switch.getInputStream()); 
			LineNumberReader input = new LineNumberReader (ir); 
			String line; 
			while ((line = input.readLine ()) != null) {
			System.out.println(line); 
			} 
			System.out.println("exit code: " + wait_switch);
			ir.close();

		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println(t);
		} 
	}
	
	public static void SwitchDone(WebDriver driver, WebDriverWait wait){
		while (!driver.getPageSource().contains(Constant.switch_complete)) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.navigate().refresh();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Surname"))).click();
		wait.until(ExpectedConditions.titleContains("Test Surname"));
		System.out.println("All done!!!");
		
	}
}
