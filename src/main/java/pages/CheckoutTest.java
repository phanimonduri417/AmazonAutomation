package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword());

        // Verify Products page
        Assert.assertEquals(productsPage.getProductsTitle(), "Products");

        // Add Backpack
        productsPage.addBackpackToCart();

        // Verify cart count
        Assert.assertEquals(productsPage.getCartCount(), "1");

        // Open Cart
        CartPage cartPage = productsPage.openCart();

        // Verify product in cart
        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack");

        // Checkout
        CheckoutPage checkoutPage = cartPage.clickCheckout();

        CheckoutOverviewPage overviewPage =
                checkoutPage.enterCheckoutInformation(
                        "Phani",
                        "Monduri",
                        "500081");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        CheckoutCompletePage completePage =
                overviewPage.finishOrder();

        Assert.assertEquals(
                completePage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}