package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String user, String pass) {

        waitUtils.waitForVisibility(username);

        username.sendKeys(user);
        password.sendKeys(pass);

        loginButton.click();

        return new ProductsPage(driver);
    }
}