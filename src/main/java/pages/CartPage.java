package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public CheckoutPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}