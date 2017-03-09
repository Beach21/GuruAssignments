package pageObjects.guruAssignmentTestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "username")
	public WebElement txtbx_UserName;

	@FindBy(how = How.ID, using = "password")
	public WebElement txtbx_Password;

	@FindBy(how = How.NAME, using = "btn-login")
	public WebElement btn_Login ;	
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href, 'create')]")
	public WebElement lnk_CreateAcct;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href, 'forgot')]")
	public WebElement lnk_ResetPassword;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href, 'about')]")
	public WebElement lnk_About;			
		
	@FindBy(how = How.XPATH, using = "")
	public WebElement div_ErrMsg_MssngNamePassword;

	public LoginPage (WebDriver driver)	{

		this.driver = driver;
	}	
	

// This method will take two arguments ( User name and Password)

	public void login(String sUserName, String sPassword){

		txtbx_UserName.sendKeys(sUserName);
		txtbx_Password.sendKeys(sPassword);
		btn_Login.click();
	}
	

	public WebElement getBadNamePassWordMsg(){
		
		if (div_ErrMsg_MssngNamePassword != null) {
			System.out.println("Error message is: " + div_ErrMsg_MssngNamePassword.getText());
			return div_ErrMsg_MssngNamePassword;
		}
		else {
			System.out.println("Error message for invalid name/password not displayed");
			return null;
		}
	}
	
public boolean isPasswordRequired(){
		
		if (txtbx_Password.getAttribute("required") != null) {
			System.out.println("Password field is required");
			return true;
		}
		else {
			System.out.println("Password field is not required");
			return false;
		}
	}

// Returns a Create Account Page object
public boolean clickCreateAcct(){
	
	try {
		WebElement ca = lnk_CreateAcct;
		ca.click();
		driver.wait(6000);
		//return new CreateAccountPage(driver);
		
	} catch (Exception e) {
		// If element not found 
		System.out.println(e.getMessage());
		System.out.println("Create Account link not found");
		//return null;
	}	
		//return new CreateAccountPage(driver);
	
	return true;
	
}

//Returns a Create Account Page object
public CreateAccountPage createAccount (){	
	
		WebElement ca = lnk_CreateAcct;
		ca.click();	
		
		return PageFactory.initElements(driver, CreateAccountPage.class);
		//return new CreateAccountPage(driver);		
}

/*
 * Checks if the user name text box is visible on the page and indirectly
 * that the Login page is loaded
 */
public boolean isLoginPageLoaded (){
	
	WebElement un = txtbx_UserName;
	
	if (un != null){			
		return true;
	}
	
	else {
		return false;
	}
}

}