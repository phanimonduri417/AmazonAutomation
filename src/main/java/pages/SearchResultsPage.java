package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;

    private By firstProduct = By.cssSelector("div[data-cpmponent-type='s-search-result]h2");
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getFirstProductName(){
        return driver.findElement(firstProduct).getText();
    }
}
