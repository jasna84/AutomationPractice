package test.java;

import main.java.config.Driver;
import main.java.pageObjects.HomePage;

public class BaseTest {

    public void goToHomePage() {

        Driver.getInstance().setDriver();
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
    }

    public void teardown() {
        Driver.getInstance().closeDriver();
    }
}
