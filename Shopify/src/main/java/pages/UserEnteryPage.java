package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

public class UserEnteryPage {
	
	WebDriver driver;
	CommonActions ca = new CommonActions();
	
	public UserEnteryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@FindBy(id = "password")
	private WebElement pagePasswordEntryTextbox;
	
	@FindBy(xpath = "//button[text()='Enter']")
	private WebElement enterButton;
	
	@FindBy(xpath = "//span[contains(text(),'Password incorrect')]")
	private WebElement errorMessage;
	
	public void enterToSite(String passKey) {
		String url = ca.getPropertyValue("url");
		ca.openPage(driver, url);
		String passCode = ca.getPropertyValue(passKey);
		ca.enterText(driver, pagePasswordEntryTextbox, passCode);
		ca.clickButton(driver, enterButton);
	}
	
	public void invalidVisitorLogin(String key1, String key2) {
		String url = ca.getPropertyValue("url");
		ca.openPage(driver, url);
		String passCode = ca.getPropertyValue(key1);
		ca.enterText(driver, pagePasswordEntryTextbox, passCode);
		ca.clickButton(driver, enterButton);
		String InvalidMessgae = ca.getTextValue(driver, errorMessage);
		String Expected = ca.getPropertyValue(key2);
		assertEquals(InvalidMessgae, Expected, "Error message not matching");
	}

}
