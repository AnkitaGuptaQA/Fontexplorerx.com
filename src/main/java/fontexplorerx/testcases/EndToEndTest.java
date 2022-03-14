package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    LogoutPage logoutPage;
    PaymentPage paymentPage;
    HomePage homePage;


    @Test
    public void endToEndTest() throws Throwable {
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
        checkoutPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password") );
        Boolean result = checkoutPage.getCheckoutTitle();
        Assert.assertTrue(result);
        Log.info("Enter the card details in the checkout");
        paymentPage = checkoutPage.enterCardDetails(prop.getProperty("cname"), prop.getProperty("cnumber"), prop.getProperty("cmonth"), prop.getProperty("cYear"), prop.getProperty("scode"));
        Log.info("Logout from the application.");
//        indexPage = logoutPage.logoutOption();
        Log.endTestCase("endToEnd");




    }
}
