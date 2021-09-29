package Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnvironmentManager {
	public static WebDriver initWebDriver() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return driver;
	}
	public static void shutDownDriver(WebDriver driver) {
		driver.quit();
	}
}
