package com.flux.modules.outbound;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.modules.emails.AccountReview;
import com.flux.modules.emails.GotoLifecycle;
import com.flux.utility.Constant;

public class SwitchOut {

	public static void Execute(WebDriver driver, WebDriverWait wait) {
		GotoLifecycle.Execute(driver, wait);
		wait.until(ExpectedConditions.urlContains("lifecycle"));
		AccountReview.ReverseBill(driver, wait);
		try {
			Runtime rtime = Runtime.getRuntime();
			String exc_outbound = Constant.byeuk_path + " --url " + Constant.surl + " --mpan " + Constant.current_mpan
					+ " --rgst " + Constant.meter_number + " --serial " + Constant.register_serial + " --reading "
					+ Constant.last_reading + " --outbounddate " + Constant.outbound_date;

			Process chmodx_outbound = rtime.exec("chmod +x " + Constant.byeuk_path);
			chmodx_outbound.waitFor();

			System.out.println(exc_outbound);
			Process ele_switch = rtime.exec(exc_outbound);
			int wait_switch = ele_switch.waitFor();

			InputStreamReader ir = new InputStreamReader(ele_switch.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("exit code: " + wait_switch);
			ir.close();

		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println(t);
		}
	}
}
