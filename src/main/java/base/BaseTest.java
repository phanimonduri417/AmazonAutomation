package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    @BeforeMethod
    public void setup() throws Exception {

        driver = DriverFactory.createDriver();
        driver.get(ConfigReader.getURL());

        Files.createDirectories(Path.of("target"));

        Files.writeString(
                Path.of("target/page.html"),
                driver.getPageSource()
        );

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(webDriver ->
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                                .equals("complete"));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println(driver.getPageSource());

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            BaseTest.driver.quit();
        }
    }
        public static WebDriver getDriver() {
            return driver;
        }
    }
