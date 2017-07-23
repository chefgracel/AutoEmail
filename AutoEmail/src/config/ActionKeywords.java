package config;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flux.modules.emails.AccountReview;
import com.flux.modules.inbound.AdminLoginAction;
import com.flux.modules.inbound.AdminSignupElectricityAction;
import com.flux.modules.inbound.UKSwitch;
import com.flux.modules.outbound.SwitchOut;
import com.flux.utility.LoadProperties;
import com.flux.utility.Log;

public class ActionKeywords {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void AdminLogin() {
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

		AdminLoginAction.Execute(driver, wait);
	}

	public static void Signup() {
		AdminSignupElectricityAction.Execute(driver, wait);
	}

	public static void Swtching() {
		UKSwitch.Execute();
	}

	public static void SwitchComplete() {
		UKSwitch.SwitchDone(driver, wait);
	}
	
	public static void SwitchAway() {
		SwitchOut.Execute(driver, wait);
	}

	public static void AccountReviewComing() {
		AccountReview.Bill(driver, wait);
		AccountReview.BillComing(driver, wait);
	}

}
