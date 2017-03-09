package testLayer.guruAssignmentTests.loginTests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects.guruAssignmentTestSite.CreateAccountPage;
import pageObjects.guruAssignmentTestSite.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginTests {
	
	//New comment
	static WebDriver driver;
	LoginPage loginPage;
	
  @BeforeTest  
  public void setUp() {

	  String baseURL = "https://www.leagueplanit.com";		
	  System.setProperty("webdriver.chrome.driver", "C:\\Work\\Practice\\Selenium\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();        
	  driver.get(baseURL);
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      driver.get(baseURL);

      loginPage = PageFactory.initElements(driver, LoginPage.class);      
  }
  
  
  @Test

  public void testInvalidUserName() { 	  
	  
	  String errorMessageString = "";
	  String badUserNameString = "User";
	  boolean isUserNameinMsg = false;
	 	  
      loginPage.login("invalidUserName", "password");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isUserNameinMsg = StringUtils.containsIgnoreCase(errorMessageString, badUserNameString);    
      Assert.assertTrue("Correct message is not displayed for incorrect user name", isUserNameinMsg);
  }
  
  @Test

  public void testInvalidPassword() { 	  
	  
	  String errorMessageString = "";
	  String badPasswordString = "password";
	  boolean isPasswordinMsg = false;
	 	  
      loginPage.login("Username", "invalidPassword");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isPasswordinMsg = StringUtils.containsIgnoreCase(errorMessageString, badPasswordString);    
      Assert.assertTrue("Correct message is not displayed for incorrect password", isPasswordinMsg);
  }
  
  @Test

  public void testInvalidUsrNmPassWd() { 	  
	  
	  String errorMessageString = "";
	  String badUserNameString = "username";
	  String badPasswordString = "password";
	  boolean isUserNameinMsg = false;
	  boolean isPasswordinMsg = false;
	  boolean isUserNameAndPassWdinMsg = false;
	 	  
      loginPage.login("invalidUserName", "invalidPassword");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isUserNameinMsg = StringUtils.containsIgnoreCase(errorMessageString, badUserNameString);
      isPasswordinMsg = StringUtils.containsIgnoreCase(errorMessageString, badPasswordString); 
      
      // Make sure both user name and password are mentioned in the error message
      isUserNameAndPassWdinMsg = (isUserNameinMsg)&&(isPasswordinMsg);
      Assert.assertTrue("Correct message is not displayed for incorrect user name and password", isUserNameAndPassWdinMsg);
  }
  
  @Test

  public void testBlankUserName() { 	  
	  
	  String errorMessageString = "";
	  String badUserNameString = "User";
	  boolean isUserNameinMsg = false;
	 
	  // Blank user name
      loginPage.login("", "password");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isUserNameinMsg = StringUtils.containsIgnoreCase(errorMessageString, badUserNameString);    
      Assert.assertTrue("Correct message is not displayed for incorrect user name", isUserNameinMsg);
  }
  
  @Test

  public void testBlankPassword() { 
	  
	  boolean passwordRequirement = loginPage.isPasswordRequired();	 
      Assert.assertTrue("Password field is not a required field", passwordRequirement);
  }
  
  /**
   * Tests to access other pages
   */
  
  @Test
  
 public void testAccessCreateAccountPg() { 
	
	  boolean isCreateAccountPageLoaded = false;
	  CreateAccountPage ca = loginPage.createAccount();	
	  isCreateAccountPageLoaded = ca.isCreateAccountPageLoaded();
	  
	  Assert.assertTrue("Create Account page not loaded", isCreateAccountPageLoaded);	 
  }
  
  

  @AfterTest

  public void cleanUp() {
	  
     if(driver != null) {
    	 //driver.close();
     }
	 
  }

}

//TODO - After login credentials are provided
/*
 * Can include tests to verify-
 * 1. Minimum number of characters allowed
 * 2. Should allow alphanumeric and special characters
 * 3. Password should allow alphanumeric with encryption (****)
 * 4. Password should allow to enter minimum characters
 * 5. Check with more than required characters
 * 6. Check with more than maximum characters allowed
 * 
 * 
 */

