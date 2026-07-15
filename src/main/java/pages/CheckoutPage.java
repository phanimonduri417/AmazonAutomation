package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public CheckoutOverviewPage enterCheckoutInformation(
            String first,
            String last,
            String zip) {

        firstName.sendKeys(first);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);

        continueButton.click();
        System.out.println(driver.getPageSource());
        System.out.println("URL after Continue: " + driver.getCurrentUrl());
        System.out.println("Title after Continue: " + driver.getTitle());
        return new CheckoutOverviewPage(driver);
    }
}