package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import test.java.framework.SeleniumUtils;

public class LoginPage extends OpenCartBasePage{
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement emailUser;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement passwordUser;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement accessButton;
	
	public void login(String email, String password){
		emailUser.sendKeys(email);
		passwordUser.sendKeys(password);
		accessButton.click();
	}
}
