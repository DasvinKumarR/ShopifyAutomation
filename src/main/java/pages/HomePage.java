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

public class HomePage {
	
	WebDriver driver;
	CommonActions ca = new CommonActions();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@FindBy(xpath = "(//details-modal[contains(@class,'search')])[2]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[contains(@class,'heading-link')]//span")
	private WebElement pageTitle;
	
	@FindBy(id = "Search-In-Modal")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "(//ul[contains(@id,'search-result')]//li//a)")
	private WebElement firstResultProduct;
	
	public void validatePageTitle(String Title) {
		String actual = ca.getTextValue(driver, pageTitle);
		String expected = ca.getPropertyValue(Title);
		assertEquals(actual, expected, "Page title not matches with expected");
	}
	
	public void searchAndSelectProduct(String searchText) {
		ca.clickButton(driver, searchButton);
		String text = ca.getPropertyValue(searchText);
		ca.enterText(driver, searchTextbox, text);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(firstResultProduct));
		ca.clickButton(driver, firstResultProduct);
	}

}
