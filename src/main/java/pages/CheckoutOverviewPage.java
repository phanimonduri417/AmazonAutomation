package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WaitUtils(driver).waitForVisibility(finishButton);
    }

    public CheckoutCompletePage finishOrder() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}