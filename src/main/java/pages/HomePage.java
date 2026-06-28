package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {
private WaitUtils waitUtils;
private WebDriver driver;

@FindBy(id = "twotabsearchtextbox")
private WebElement searchBox;

@FindBy(id = "nav-search-submit-button")
private WebElement searchButton;

public HomePage(WebDriver driver) {
    this.driver = driver;
    this.waitUtils = new WaitUtils(driver);
    PageFactory.initElements(driver, this);
}
    public SearchResultsPage searchProduct(String product){
        waitUtils.waitForVisibility(searchBox);
        searchBox.sendKeys(product);
        searchButton.click();

        return new SearchResultsPage(driver);
    }
}