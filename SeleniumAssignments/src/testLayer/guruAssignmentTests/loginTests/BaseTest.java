package testLayer.guruAssignmentTests.loginTests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.guruAssignmentTestSite.LoginPage;

public class BaseTest {

	protected static WebDriver driver;
	LoginPage loginPage;

	protected void setUp() {
		
		//File file = new File("D:/Dev/ReadData/src/datafile.properties");

		String baseURL = "https://www.leagueplanit.com";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Work\\Practice\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseURL);

		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	protected void cleanUp() {

		if (driver != null) {
			//driver.close();
		}

	}
}
