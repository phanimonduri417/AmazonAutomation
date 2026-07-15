package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginTest(){

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage =
                loginPage.login(
                        "standard_user",
                        "secret_sauce"
                );

        Assert.assertTrue(
                productsPage.getPageTitle().contains("Swag")
        );
    }
}