package test.java;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import test.java.framework.WebDriverUtils;
import test.java.framework.WebDriverUtils.Browser;
import test.java.pages.HomePage;
import test.java.pages.SearchResultPage;

@RunWith(Parameterized.class)
public class CartTest {
	
	public WebDriver driver;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "Windows 10", Browser.Firefox, "53.0", "iMac" }, 
                 { "Windows 10", Browser.Chrome, "58.0", "iPhone" }
           });
    }
	
    @Parameter(0)
	public String platform;

    @Parameter(1)
	public Browser browser;
    
    @Parameter(2)
    public String version;
    
    @Parameter(3)
	public String productName;
	
	@Before
	public void before() throws MalformedURLException {
		driver = WebDriverUtils.create(platform, browser, version);
		driver.get("http://open-cart.azurewebsites.net/");
	}
	
	@After
	public void after() {
		WebDriverUtils.quit(driver);
	}
	
	@Test
	public void addAndRemoveFromCart() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		SearchResultPage searchResultPage = homePage.search(productName); 
		
		searchResultPage.addToCart(productName);
		assertTrue("Item added to cart.", searchResultPage.getNumberOfItemsOnCart() == 1);
		
		searchResultPage.removeFromCart(productName);
		assertTrue("Item removed from cart.", searchResultPage.getNumberOfItemsOnCart() == 0);
		
	}

}
