package test.java.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import test.java.framework.SeleniumUtils;

public class SignUpPage extends OpenCartBasePage {
	
	@FindBy(how = How.XPATH, using = "//input[@name='firstname']")
	private WebElement firstNameInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='lastname']")
	private WebElement lastNameInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement emailInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='telephone']")
	private WebElement telephoneInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='address_1']")
	private WebElement addressInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	private WebElement cityInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='postcode']")
	private WebElement postCodeInput;
	
	@FindBy(how = How.XPATH, using = "//select[@name='country_id']")
	private WebElement countrySelect;
	
	@FindBy(how = How.XPATH, using = "//select[@name='zone_id']")
	private WebElement regionSelect;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='confirm']")
	private WebElement confirmPasswordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='agree']")
	private WebElement agreeInput;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submitInput;
	
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	public Boolean registerRandomUser() {
		firstNameInput.sendKeys("First Name");
		lastNameInput.sendKeys("Last Name");
		
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
	    Date dateobj = new Date();
		emailInput.sendKeys("automation" + df.format(dateobj) + "@test.com");
		
		telephoneInput.sendKeys("12345678");
		addressInput.sendKeys("Address for Automation");
		cityInput.sendKeys("Montevideo");
		postCodeInput.sendKeys("11100");
		
		Select country = new Select(countrySelect);
		country.selectByVisibleText("Uruguay");
		
		Select region = new Select(regionSelect);
		region.selectByVisibleText("Montevideo");
		
		passwordInput.sendKeys("1234");
		confirmPasswordInput.sendKeys("1234");
		agreeInput.click();
		submitInput.click();
		
		return 0 != SeleniumUtils.getNumberOfElements(driver, By.xpath("//*[text()='Your Account Has Been Created!']"));
	}

}
