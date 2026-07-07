package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchProduct(String product) {

        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(product);

        driver.findElement(searchButton).click();

        return new SearchResultsPage(driver);
    }
}