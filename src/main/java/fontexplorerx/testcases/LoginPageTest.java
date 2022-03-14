package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.HomePage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.LoginPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void loginTest() throws Throwable {
        Log.startTestCase("loginTest");
        Log.info("Navigate to the login page.");
        indexPage = new IndexPage();
        Log.info("Navigate to the sign in page.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("Enter the details");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        Log.info("Validate the URL after loggedin ");
        String actualURL = homePage.getcurrURL();
        String expectedURL = "https://www.fontexplorerx.com/login/";
        Assert.assertEquals(actualURL,expectedURL);
        Log.info("Validate the logged in user name.");
        String validatename = homePage.validateloggedusername();
        String expectedname = "ANKITA GUPTA";
        Log.info("The user has been logged in.");
        Assert.assertEquals(validatename,expectedname);
        Log.info("Login is successful");
        Log.endTestCase("loginTest");

    }
}
