package pageObjects.guruAssignmentTestSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AboutPage {

	// Variables and constants
	final WebDriver driver;

	// Locators
	@FindBy(how = How.XPATH, using = "username")
	public WebElement txtbx_UserName;

	// Methods
	public AboutPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getPageURL() {

		return driver.getCurrentUrl();
	}

	public boolean isAboutPageLoaded(WebDriver driver) {
		String currentURL = driver.getCurrentUrl();
		String aboutURLString = "pages/about";

		if (currentURL.contains(aboutURLString)) {
			return true;
		}

		else {
			System.out.println("Not reached 'About' page");
			System.out.println("About URL substring is:  " + aboutURLString);
			System.out.println("Current page is: " + currentURL);
			return false;
		}
	}

}
