package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    LogoutPage logOutPage;
    PaymentPage paymentPage;
    CheckoutPage checkoutPage;


    @Test
    public void logoutPageTest() throws Throwable {
        Log.startTestCase("logoutPage");
        Log.info("Navigate to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigate to the sign in page.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("Enter the details");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        Log.endTestCase("loginTest");
    }
}
