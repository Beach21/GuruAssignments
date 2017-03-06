package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverExample {
	
	public static void main(String[] args){
		String baseURL = "http://www.google.com";
		//String baseURL = "https://letscodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Practice\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();        
		driver.get(baseURL);
		
		driver.findElement(By.id("lst-ib")).sendKeys("Lets code it");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);		
		
	}	

}
