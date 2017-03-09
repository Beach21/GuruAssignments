package pageObjects.guruAssignmentTestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	/**
	 * Variables and constants
	 */

	final WebDriver driver;

	/**
	 * Locators
	 */

	@FindBy(how = How.XPATH, using = "//h2[@class]")
	public WebElement hdr_CreateAccount;

	@FindBy(how = How.XPATH, using = "//input[@id='Next']")
	public WebElement btn_Next;

	@FindBy(how = How.ID, using = "password")
	public WebElement txtbx_Password;

	// Constructor

	public CreateAccountPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * Methods
	 */

	/*
	 * Checks if Next button is visible on the page and indirectly that the
	 * Create Account page is loaded
	 */
	public boolean isCreateAccountPageLoaded() {

		boolean isNextButtonPresent = false;
		WebElement bn = btn_Next;

		System.out.println(bn.getText());

		if (bn != null) {
			isNextButtonPresent = true;
		}

		return isNextButtonPresent;
	}

	public void clickNextButton() {

		try {
			btn_Next.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
