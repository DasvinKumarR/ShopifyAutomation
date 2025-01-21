package utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActions {
	
	String value = null;
	
	public String getPropertyValue(String key) {
		try {
			Properties prop = new Properties();
			FileReader file = new FileReader(System.getProperty("user.dir")+"/src/test/resources/propertyFile/data.properties");
			prop.load(file);
			value = prop.getProperty(key);
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in file reading");
		}
		return value;
	}
	
	public void openPage(WebDriver driver, String url) {
		try {
			driver.get(url);
		}catch (SessionNotCreatedException e) {
			System.out.println("Can't open the url");
		}
	}
	
	public void enterText(WebDriver driver, WebElement element , String text) {
		try {
			element.sendKeys(text);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Element Not available in DOM");
		}
	}
	
	public void clickButton(WebDriver driver, WebElement element) {
		try {
			element.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Element not available in DOM");
		}catch (ElementNotInteractableException e) {
			e.printStackTrace();
			System.out.println("element is not clickable");
		}
	}
	
	public String getTextValue(WebDriver driver, WebElement element) {
		String value = null;
		try {
			value = element.getText();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Element not present in DOM");
		}
		return value;
	}
	
	public void hitEnter(WebDriver driver, WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
		}catch (Exception e) {
			System.out.println("error in pressing enter button");
		}
	}

}
