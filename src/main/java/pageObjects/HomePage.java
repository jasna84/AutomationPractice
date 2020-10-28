package main.java.pageObjects;

import main.java.config.BasePage;
import main.java.config.Driver;
import main.java.config.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public String homeURL = "http://automationpractice.com/index.php";

    public void navigateToHomePage() {
        Driver.getInstance().getDriver().navigate().to(homeURL);
    }

    By searchField = By.id("search_query_top");
    By resultCount = By.className("heading-counter");
    By listView = By.id("list");
    By addToCartButtons = By.cssSelector("a[title = 'Add to cart'");
    By continueShopping = By.cssSelector("span[title = 'Continue shopping'");
    By viewShoppingCart = By.cssSelector("a[title = 'View my shopping cart'");
    By productNumber = By.className("ajax_cart_quantity");
    By totalProducts = By.id("total_product");
    By totalShipping = By.id("total_shipping");
    By total = By.id("total_price_without_tax");

    public void searchForDresses() {
        enterSearchTerm(searchField, "dresses");
    }

    public int getNumberFromResult() {
        String text = getElementText(resultCount);
        int number = Integer.parseInt(Utils.extractNumberFromString(text));
        System.out.println(number);
        return number;
    }

    public void clickOnList() {
        String itemClass = getElementAttribute(listView, "class");
        if(itemClass.equals("selected")){
            System.out.println("List already selected");
        } else {
            click(listView);
            System.out.println("List view clicked");
        }
    }

    public void selectItems() {

        List<WebElement> buttons = getListElements(addToCartButtons);
        System.out.println("Number of buttons: " + buttons.size());

        click(buttons.get(0));
        hardCodedWaiter(2000);
        click(continueShopping);
        hardCodedWaiter(2000);
        click(buttons.get(1));
        hardCodedWaiter(2000);
        click(continueShopping);
        hardCodedWaiter(2000);
        click(buttons.get(3));
        hardCodedWaiter(2000);
        click(continueShopping);

    }

    public int getProductNumber() {
        int number = Integer.parseInt(getElementText(productNumber));
        System.out.println("Products: " + number);
        return number;
    }

    public void openCartSummary() {
        clickJS(viewShoppingCart);
    }

    public int getTotalProducts() {
        String text = getElementText(totalProducts);
        int number = Integer.parseInt(Utils.extractNumberFromString(text));
        System.out.println("Total products: " + number);
        return number;
    }

    public int getTotalShipping() {
        String text = getElementText(totalShipping);
        int number = Integer.parseInt(Utils.extractNumberFromString(text));
        System.out.println("Total shipping: " + number);
        return number;
    }

    public int getTotal() {
        String text = getElementText(total);
        int number = Integer.parseInt(Utils.extractNumberFromString(text));
        System.out.println("Total: " + number);
        return number;
    }


}
