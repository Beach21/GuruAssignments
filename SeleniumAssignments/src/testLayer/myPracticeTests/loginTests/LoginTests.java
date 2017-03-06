package testLayer.myPracticeTests.loginTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import pageObjects.myTestSite.HomePage;
import pageObjects.myTestSite.LoginPage;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

public class LoginTests {

	static WebDriver driver;

	HomePage homePage;

	LoginPage loginPage;

  @BeforeMethod

  public void beforeMethod() {

	  String baseURL = "http://www.store.demoqa.com";		
	  System.setProperty("webdriver.chrome.driver", "C:\\Work\\Practice\\Selenium\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();        
	  driver.get(baseURL);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get(baseURL);

      homePage = PageFactory.initElements(driver, HomePage.class);
      loginPage = PageFactory.initElements(driver, LoginPage.class);
      
  }

  @Test

  public void test() {

      homePage.lnk_MyAccount.click();

      loginPage.LogIn_Action("username212121", "password212121");

      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

      homePage.lnk_LogOut.click();

  }

  @AfterMethod

  public void afterMethod() {

	  driver.quit();

  }

}