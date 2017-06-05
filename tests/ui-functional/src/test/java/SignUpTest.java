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
import test.java.pages.SignUpPage;

@RunWith(Parameterized.class)
public class SignUpTest {

	public WebDriver driver;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "Windows 10", Browser.Firefox, "53.0", "vicky@algo.com", "1234" }, 
                 { "Windows 10", Browser.Chrome, "58.0", "testing@algo.com", "1234" },
           });
    }
	
    @Parameter(0)
	public String platform;

    @Parameter(1)
	public Browser browser;
    
    @Parameter(2)
    public String version;
    
    @Parameter(3)
    public String email;
    
    @Parameter(4)
    public String password;
	
	@Before
	public void before() throws MalformedURLException {
		driver = WebDriverUtils.create(platform, browser, version);
//		driver = WebDriverUtils.create();
		driver.get("http://open-cart.azurewebsites.net/");
	}
	
	@After
	public void after() {
		WebDriverUtils.quit(driver);
	}
	
	@Test
	public void signUpTest() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = homePage.navigateToSignUp();
		
		assertTrue("New user was registered in.", signUpPage.registerRandomUser());
		
	}
	
}
