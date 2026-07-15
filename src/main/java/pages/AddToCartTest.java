package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword());

        productsPage.addBackpackToCart();

        Assert.assertEquals(productsPage.getCartCount(), "1");

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack");
    }
}