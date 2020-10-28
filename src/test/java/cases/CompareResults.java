package test.java.cases;

import main.java.pageObjects.DressesPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class CompareResults extends BaseTest {

    DressesPage dresses = new DressesPage();

    @BeforeTest
    public void setUp() {
        goToHomePage();
    }

    @Test(priority = 1)
    public void compareDresses() {

        dresses.selectDressesTab();
        dresses.selectSummerDressesCategory();
        dresses.selectInStock();
        dresses.clickOnGrid();
        dresses.selectToCompare();

        int numberOnTheButton = dresses.getCompareButtonNumber();
        Assert.assertEquals( numberOnTheButton, 2);

        dresses.clickOnCompareButton();
        int numberOfProducts = dresses.getComparedProductsNumber();
        Assert.assertEquals( numberOfProducts, 2);

    }

    @Test(priority = 2)
    public void validateBreadcrumbs() {

        dresses.clickToGoBackShopping();
        dresses.selectDressesTab();
        dresses.selectEveningDressesSubcategory();

        boolean eveningDressVisibleInBreadcrumb = dresses.eveningDressesFound();
        Assert.assertTrue(eveningDressVisibleInBreadcrumb);

        dresses.clickOnWomenInBreadcrumb();

        String categoryName = dresses.getCategoryName().trim();
        Assert.assertEquals(categoryName, "Women");

        boolean eveningDressNotVisibleInBreadcrumb = dresses.eveningDressesFound();
        Assert.assertFalse(eveningDressNotVisibleInBreadcrumb);

    }

    @AfterTest
    public void tearDown() {
        teardown();
    }
}
