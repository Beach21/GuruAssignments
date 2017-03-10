package testLayer.guruAssignmentTests.loginTests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.guruAssignmentTestSite.AboutPage;
import pageObjects.guruAssignmentTestSite.CreateAccountPage;
import pageObjects.guruAssignmentTestSite.ForgotPasswordPage;

public class LoginTests extends BaseTest{
	
	
  @BeforeTest  
  public void setUp() {
	  
	super.setUp();    
  }
    

  @AfterTest

  public void cleanUp() {	  
   
	 super.cleanUp();
  }

  
  
  @Test

  public void testInvalidUserName() { 	  
	  
	  String errorMessageString = "";
	  String badUserNameString = "User";
	  boolean isUserNameinMsg = false;
	 	  
      loginPage.login("invalidUserName", "password");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isUserNameinMsg = StringUtils.containsIgnoreCase(errorMessageString, badUserNameString);    
      Assert.assertTrue(isUserNameinMsg, "Correct message not displayed for invalid user name");
  }
  
  @Test

  public void testInvalidPassword() { 	  
	  
	  String errorMessageString = "";
	  String badPasswordString = "password";
	  boolean isPasswordinMsg = false;
	 	  
      loginPage.login("Username", "invalidPassword");      
      errorMessageString = loginPage.getBadNamePassWordMsg().getText();
      isPasswordinMsg = StringUtils.containsIgnoreCase(errorMessageString, badPasswordString);    
      Assert.assertTrue(isPasswordinMsg, "Correct message is not displayed for incorrect password");
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
      Assert.assertTrue(isUserNameAndPassWdinMsg, "Correct message is not displayed for incorrect user name and password");
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
      Assert.assertTrue(isUserNameinMsg, "Correct message is not displayed for incorrect user name");
  }
  
  @Test

  public void testBlankPassword() { 
	  
	  boolean passwordRequirement = loginPage.isPasswordRequired();	 
      Assert.assertTrue(passwordRequirement, "Password field is not a required field");
  }
  
  /**
   * Tests to access other pages
   */
  
  @Test
  
 public void testAccessCreateAccountPg() { 
	
	  boolean isCreateAccountPageLoaded = false;
	  CreateAccountPage ca = loginPage.createAccount();	
	  isCreateAccountPageLoaded = ca.isCreateAccountPageLoaded();
	  
	  Assert.assertTrue(isCreateAccountPageLoaded, "Create Account page not loaded");	 
  }
  
  @Test
  
  public void testAccessAboutPg() { 
 	
	  boolean isAboutPageLoaded = false;
 	  AboutPage ap = loginPage.clickLnkAbout();	
 	  isAboutPageLoaded = ap.isAboutPageLoaded(driver);
 	  
 	  Assert.assertTrue(isAboutPageLoaded, " 'About' page not loaded");	 
   }
  
@Test
  
  public void testAccessForgotPasswordPg() { 
 	
 	  boolean isForgotPasswordPageLoaded = false;
 	  ForgotPasswordPage fp = loginPage.clickLnkResetPassword();	
 	  isForgotPasswordPageLoaded = fp.isForgotPasswordPageLoaded();
 	  
 	  Assert.assertTrue(isForgotPasswordPageLoaded, "Create Account page not loaded");	 
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

