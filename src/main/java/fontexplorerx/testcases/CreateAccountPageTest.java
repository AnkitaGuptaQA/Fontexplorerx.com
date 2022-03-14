package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.HomePage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.LoginPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void createAccountTest() throws Throwable {
        Log.startTestCase("createAccountTest");
        Log.info("Navigated to the login page.");
        indexPage = new IndexPage();
        Log.info("Navigated to the signin/signup page.");
        loginPage = indexPage.clickOnSignIn();
        String signinemail = "ankita+" +randNum+ "@uba-solutions.com";
        Log.info("Enter the details to create an account.");
        homePage = loginPage.createNewAccount(
                prop.getProperty("fullname"),
                prop.getProperty("streetname"),
                prop.getProperty("cityname"),
                prop.getProperty("zipcode"),
                prop.getProperty("countryname1"),
                (signinemail),
                prop.getProperty("signuppassword"),
                prop.getProperty("signuppasswordconfirm"));
        System.out.println(signinemail);
        Log.info("Validate if the logged in user name is displayed.");
        String validatename = homePage.validateloggedusername();
        String expectedname = "TEST NAME";
        Assert.assertEquals(validatename,expectedname);
        Log.info("validate if the logout is displayed.");
        String checklogouttext = homePage.validatelogoutText();
        Assert.assertEquals(checklogouttext,"LOGOUT");
        Log.endTestCase("createAccountTest");
    }
}
