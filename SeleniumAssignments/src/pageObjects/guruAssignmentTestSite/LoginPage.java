package pageObjects.guruAssignmentTestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "username")
	public WebElement txtbx_UserName;

	@FindBy(how = How.ID, using = "password")
	public WebElement txtbx_Password;

	@FindBy(how = How.NAME, using = "btn-login")
	public WebElement btn_Login ;
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'errmsg')]")
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