package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstTestClass {
	
	public static void main(String[] args){
		//String baseURL = "http://www.google.com";
		String baseURL = "https://letscodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\Practice\\Selenium\\Firefox\\geckodriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability("marionette", true);
        cap.setBrowserName("firefox");
        WebDriver driver = new FirefoxDriver();
		
		driver.get(baseURL);
	}	
}
