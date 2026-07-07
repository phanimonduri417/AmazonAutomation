package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected static WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver= DriverFactory.createDriver();
        driver.get(ConfigReader.getURL());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Title : " + driver.getTitle());
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
        public static WebDriver getDriver() {
            return driver;
        }
    }

