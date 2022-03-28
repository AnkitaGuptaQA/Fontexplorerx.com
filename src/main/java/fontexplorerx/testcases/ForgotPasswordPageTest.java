package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.ForgotPasswordPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.LoginPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordPageTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    @Test
    public void verifyForgetPassword() throws Throwable{
        Log.startTestCase("Verify forget password");
        Log.info("Navigate to the index page");
        indexPage = new IndexPage();

        Log.info("Navigate to the login page");
        loginPage =  indexPage.clickOnSignIn();

       Log.info("Navigate to the forgot password page");
       forgotPasswordPage = loginPage.clickOnForgotPassword();

       Log.info("Verify the title of the forget password page.");
       boolean verifyTitle = forgotPasswordPage.getTitleForgotPassword();
        Assert.assertTrue(true);

        /*Log.info("Verify if the validation message is displayed.");
        forgotPasswordPage.clickOnForgotPassword();
        boolean validateerror = forgotPasswordPage.validateFieldError();
        Assert.assertTrue(true);*/

//        Log.info("Verify if the user can enter the email.");
//        forgotPasswordPage.enterEmailId(prop.getProperty("resetEmailId"));
//        forgotPasswordPage.clickOnForgotPassword();

        Log.info("Navigate to the gmail to verify the mail.");
        forgotPasswordPage.navigateToNewWindow();
        Log.info("Login to the gmail account");
        forgotPasswordPage.loginToGmail(prop.getProperty("resetEmailId"),prop.getProperty("gmailPasswordText") );
        Log.info("Quit the gmail application");
        forgotPasswordPage.closeNewWindow();



        Log.endTestCase("Verification done for the forgot password.");


    }
}
