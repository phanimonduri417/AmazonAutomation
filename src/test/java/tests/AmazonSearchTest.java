package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class AmazonSearchTest extends BaseTest {
   /* @Test
    public void searchLaptopTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct("Laptop");
        String actualTitle = resultsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Laptop"));
    }

    @Test
    public void searchWatchTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct("Watch");
        String actualTitle = resultsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Watch"));
    }

    @Test
    public void searchMobileTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct("Mobile");
        String actualTitle = resultsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Mobile"));
    }

    @Test
    public void searchHeadPhonesTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct("Head Phones");
        String actualTitle = resultsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Head Phones"));
    }

    @Test
    public void searchBooksTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct("Books");
        String actualTitle = resultsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Books"));
    }*/

    @DataProvider(name = "searchProducts")
    public Object[][] searchProducts() {
        return new Object[][]{
                {"Laptop"},
                {"Mobile"},
                {"Books"},
                {"Head Phones"},
                {"Watch"},
        };

    }

    @Test(dataProvider = "searchProducts")
    public void searchProductTest(String product) {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.searchProduct(product);
        Assert.assertTrue(resultsPage.getPageTitle().contains(product));
    }
}