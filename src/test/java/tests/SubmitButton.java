package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("nav-search-submit-button")));

        WebElement byId = driver.findElement(By.id("nav-search-submit-button"));

        WebElement byCss = driver.findElement(By.cssSelector("#nav-search-submit-button"));

        WebElement byXpath = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

        System.out.println(byId.isDisplayed());
        System.out.println(byCss.isDisplayed());
        System.out.println(byXpath.isDisplayed());

        driver.quit();
    }
}
