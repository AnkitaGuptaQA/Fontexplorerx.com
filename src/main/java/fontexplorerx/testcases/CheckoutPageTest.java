package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;


    @Test
    public void checkoutPageTest() throws Throwable {
        Log.startTestCase("endToEnd");
        Log.info("Navigated to the index oage.");
        indexPage = new IndexPage();
        Log.info("Navigated on the product page.");
        productsPage = indexPage.clickOnProduct();
        Log.info("Selected the pro license and added to cart.");
        addToCartPage = productsPage.clickOnProButton();
        Log.info("User proceed to checkout for the selected license.");
        loginPage = addToCartPage.proceedToCheckout();
        Log.info("The user gets login");
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
        Boolean result = checkoutPage.getCheckoutTitle();
        Assert.assertTrue(result);
        Log.info("Enter the checkout page details.");
        checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
        Log.endTestCase("endToEnd");

    }
}
