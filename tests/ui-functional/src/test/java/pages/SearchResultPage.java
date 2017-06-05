package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.framework.SeleniumUtils;

public class SearchResultPage extends OpenCartBasePage {
	
	public SearchResultPage(WebDriver driver){
		super(driver);
	}
	
	public void addToCart(String prod) throws InterruptedException {
		SeleniumUtils.waitForElementToBeVisible(driver, By.xpath("//button[contains(@class,'disabled')]"), 10);
		SeleniumUtils.waitForElementToDisappear(driver, By.xpath("//button[contains(@class,'disabled')]"), 10);
		WebElement addToCartButton = SeleniumUtils.getWebElement(driver, By.xpath("(//h4//a[text()='"+ prod +"']//following::button[contains(@onclick,'cart.add')])[1]"), 10);
		addToCartButton.click();
		SeleniumUtils.waitForElementToBeVisible(driver, By.xpath("//button[contains(@class,'disabled')]"), 10);
		SeleniumUtils.waitForElementToDisappear(driver, By.xpath("//button[contains(@class,'disabled')]"), 10);
	}
	
}

