package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.DriverSetup;
import pages.HomePage;
import pages.ProductPage;
import pages.UserEnteryPage;


public class AddToCartFunctionality extends DriverSetup {
	
	@BeforeClass
	public void enterToSite() {
		initDriver();
		UserEnteryPage entry = new UserEnteryPage(driver);
		entry.enterToSite("customerKey");
	}
	
	//product is selected with pumper offer one
	@Test(priority = 1)
	public void addProductOneUnitToCart() {
		HomePage HPage = new HomePage(driver);
		ProductPage PPage = new ProductPage(driver);
		HPage.validatePageTitle("pageTitle");
		HPage.searchAndSelectProduct("productTitle1");
		PPage.validateProductTitle("productTitle1");
		PPage.validatePumperIsPresent();
		PPage.selectStandardPriceOption();
		PPage.clickAddToCart();
		PPage.validateItemAdded();
	}
	
	//product is selected with pumper offer two
	@Test(priority = 2)
	public void addProductTwoUnitToCart() {
		HomePage HPage = new HomePage(driver);
		ProductPage PPage = new ProductPage(driver);
		HPage.validatePageTitle("pageTitle");
		HPage.searchAndSelectProduct("productTitle1");
		PPage.validateProductTitle("productTitle1");
		PPage.validatePumperIsPresent();
		PPage.selectTwoUnit();
		PPage.clickAddToCart();
		PPage.validateItemAdded();
	}

	//product is selected with pumper offer three
	@Test(priority = 3)
	public void addProductThreeUnitToCart() {
		HomePage HPage = new HomePage(driver);
		ProductPage PPage = new ProductPage(driver);
		HPage.validatePageTitle("pageTitle");
		HPage.searchAndSelectProduct("productTitle1");
		PPage.validateProductTitle("productTitle1");
		PPage.validatePumperIsPresent();
		PPage.selectThreeUnit();
		PPage.clickAddToCart();
		PPage.validateItemAdded();
	}
	
	@AfterClass
	public void terminateDriver() {
		driver.quit();
	}
}
