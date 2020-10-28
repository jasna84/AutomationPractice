package test.java.cases;

import main.java.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class ShoppingCart extends BaseTest {

    HomePage home = new HomePage();

    @BeforeTest
    public void setUp() {
        goToHomePage();
    }

    @Test(priority = 1)
    public void searchForItems() {

        home.searchForDresses();
        int dressesNumber = home.getNumberFromResult();
        Assert.assertTrue(dressesNumber > 5);

    }

    @Test(priority = 2)
    public void addProductsToCart() {

        home.clickOnList();
        home.selectItems();

        int numberOfProducts = home.getProductNumber();
        Assert.assertEquals( numberOfProducts, 3);

        home.openCartSummary();

        int totalProducts = home.getTotalProducts();
        Assert.assertTrue(totalProducts > 0);

        int totalShipping = home.getTotalShipping();
        Assert.assertTrue(totalShipping > 0);

        int total = home.getTotal();
        Assert.assertTrue(total > 0);

    }

    @AfterTest
    public void tearDown() {
        teardown();
    }

}
