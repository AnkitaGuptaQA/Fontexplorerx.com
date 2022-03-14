package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.HomePage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.LoginPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void homepageTest() throws Throwable {
        Log.startTestCase("homepageTest");
        Log.info("navigate to the index page");
        indexPage = new IndexPage();
        Log.info("Navigate to the signin page.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("The user is logged in.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        String validatename = homePage.validateloggedusername();
        Log.info("Validate the logged in user name.");
        String expectedname = "ANKITA GUPTA";
        Assert.assertEquals(validatename,expectedname);
        Log.info("validate if the logout is displayed.");
        String checklogouttext = homePage.validatelogoutText();
        Assert.assertEquals(checklogouttext,"LOGOUT");
        Log.endTestCase("homepageTest");
    }
}
