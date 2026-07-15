package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductsTitle() {
        return productsTitle.getText();
    }

    public void addBackpackToCart() {
        backpackButton.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public CartPage openCart() {
        cartIcon.click();
        return new CartPage(driver);
    }
}