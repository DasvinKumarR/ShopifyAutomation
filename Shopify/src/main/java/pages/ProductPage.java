package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonActions;

public class ProductPage {
	
	WebDriver driver;
	CommonActions ca = new CommonActions();
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@FindBy(tagName = "h1")
	private WebElement productTitle;
	
	@FindBy(id = "prvw__block_title")
	private WebElement pupmberOfferTitle;
	
	@FindBy(id = "prvw__label_1")
	private WebElement standardPriceButton;
	
	@FindBy(id = "prvw__label_2")
	private WebElement twoUnits;
	
	@FindBy(id = "prvw__label_3")
	private WebElement threeUnits;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[@href='/cart']")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Item added to your cart')]")
	private WebElement itemAddedNotify;
	
	public void validateProductTitle(String title) {
		String expected = ca.getTextValue(driver, productTitle);
		String actual = ca.getPropertyValue(title);
		assertEquals(actual, expected, "product title not matching");
	}
	
	public void validatePumperIsPresent() {
		Boolean yes = pupmberOfferTitle.isDisplayed();
		assertEquals(yes, true, "pumper is not for this product");
	}
	
	public void selectStandardPriceOption() {
		ca.clickButton(driver, standardPriceButton);
	}
	
	public void selectTwoUnit() {
		ca.clickButton(driver, twoUnits);
	}
	
	public void selectThreeUnit() {
		ca.clickButton(driver, threeUnits);
	}
	
	public void clickAddToCart() {
		ca.clickButton(driver, addToCartButton);
	}
	
	public void validateItemAdded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(itemAddedNotify));
		Boolean Actual = itemAddedNotify.isDisplayed();
		assertEquals(Actual, true);
	}

}
