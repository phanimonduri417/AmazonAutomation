package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver= DriverFactory.createDriver();
        driver.get(ConfigReader.getURL());
    }
    @AfterMethod
    public void tearDown() {
        if(driver!= null) {
            driver.quit();
        }
    }
}
