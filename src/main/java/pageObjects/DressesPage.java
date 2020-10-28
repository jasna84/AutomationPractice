package main.java.pageObjects;

import main.java.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DressesPage extends BasePage {

    By dressesTab = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a[contains(text(),'Dresses')]");
    By categoriesSummerCheckbox = By.id("uniform-layered_category_11");
    By availabilityInStock = By.id("uniform-layered_quantity_1");
    By gridView = By.id("grid");
    By addToCompare = By.className("add_to_compare");
    By compareButtonValue = By.className("total-compare-val");
    By compareButton = By.className("bt_compare");
    By dressItems = By.className("product_image");
    By continueShopping = By.xpath("//*[contains(text(),Continue Shopping')]");
    By subcategoryEveningDresses = By.xpath("//*a[@class = 'subcategory-name'][contains(text(),Evening Dresses')]");
    By breadcrumbEveningDresses = By.xpath("//*div[@class = 'breadcrumb'][contains(text(),Evening Dresses')]");
    By breadcrumbWomen = By.xpath("//*div[@class = 'breadcrumb'][contains(text(),Women')]");
    By categoryName = By.className("category-name");

    public void selectDressesTab() {
        click(dressesTab);
    }

    public void selectSummerDressesCategory() {
        click(categoriesSummerCheckbox);
    }

    public void selectEveningDressesSubcategory() {
        click(subcategoryEveningDresses);
    }

    public void selectInStock() {
        click(availabilityInStock);
        waitForPageLoad();
    }

    public void clickOnGrid() {
        String itemClass = getElementAttribute(gridView, "class");
        if(itemClass.equals("selected")){
            System.out.println("Grid already selected");
        } else {
            click(gridView);
            System.out.println("Grid view clicked");
        }
    }

    public void selectToCompare() {

        List<WebElement> links = getListElements(addToCompare);
        System.out.println("Number of links to compare: " + links.size());

        click(links.get(0));
        hardCodedWaiter(2000);
        click(links.get(1));
        hardCodedWaiter(2000);
    }

    public int getCompareButtonNumber() {
        int number = Integer.parseInt(getElementText(compareButtonValue));
        System.out.println("Compare button: " + number);
        return number;
    }

    public void clickOnCompareButton() {
        click(compareButton);
    }

    public int getComparedProductsNumber() {
        List< WebElement > products = getListElements(dressItems);
        int number = products.size();
        System.out.println("Products to compare: " + number);
        return number;
    }

    public void clickToGoBackShopping() {
        click(continueShopping);
    }

    public boolean eveningDressesFound() {
        return waitForElement(breadcrumbEveningDresses, 3);
    }

    public void clickOnWomenInBreadcrumb() {
        click(breadcrumbWomen);
    }

    public String getCategoryName() {
       return getElementText(categoryName);
    }

    public void scrollToCheckbox() {
        scrollTo(availabilityInStock);
    }

}
