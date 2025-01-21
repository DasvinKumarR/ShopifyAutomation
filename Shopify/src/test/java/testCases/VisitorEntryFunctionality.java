package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.DriverSetup;
import pages.HomePage;
import pages.UserEnteryPage;

public class VisitorEntryFunctionality extends DriverSetup {
	
	@Test(priority = 2)
	public void VisitorLoginWithValidPasscode() {
		UserEnteryPage EPage = new UserEnteryPage(driver);
		HomePage HPage = new HomePage(driver);
		EPage.enterToSite("customerKey");
		HPage.validatePageTitle("pageTitle");
	}
	
	@Test(priority = 1)
	public void VisitorLoginWithInvalidPasscode() {
		UserEnteryPage EPage = new UserEnteryPage(driver);
		EPage.invalidVisitorLogin("InvalidKey", "erroMessage");
	}
	
	@AfterClass
	public void terminateDriver() {
		driver.quit();
	}

}
