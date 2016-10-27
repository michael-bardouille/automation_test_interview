// MB > 10-27-2016 Added the following imports in order to compile 
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

@Test(groups={"localTest"})
public class GoogleExampleIT {
	// MB > 10-27-2016 Updated to Logger.getLogger, previously LogManager.getLogger
        private static final Logger LOGGER = Logger.getLogger(GoogleExampleIT.class.getName());
 	private WebDriver driver;
        

        @FindBy(css = "[name='q']")
	private WebElement searchBar;

	@Test
	public void googleCheeseExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Cheese!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}
        
        @Test(enabled = true)
	public void googleMilkExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Milk!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: {}" + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}


    @BeforeMethod
    public void setUp() throws Exception {
        // MB > 10-27-2016 > Using selenium standalone jar file 3.0.1 added setProperty pointing to geckodriver
        //As of 3.0.x Firefox is not launched directly by Selenium. 
        System.setProperty("webdriver.gecko.driver", "/Users/LaParis/Downloads/geckodriver");
        
        // MB > 10-27-2016 Removed second new keyword, previously driver = new new FirefoxDriver();   
        driver = new FirefoxDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
        // MB > 10-27-2016 Added get to fill in the URL and launch
        driver.get("http://www.google.com");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }


    
}