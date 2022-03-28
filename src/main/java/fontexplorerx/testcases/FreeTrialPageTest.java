package fontexplorerx.testcases;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.FreeTrialPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.utility.Log;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreeTrialPageTest extends BaseClass {
    IndexPage indexPage;
    FreeTrialPage freeTrialPage;
    public static String downloadPath = "/Users/fexuser/Downloads";

    @Test
    public void freeTrialTest() throws Throwable {
        Log.startTestCase("freeTrialTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigated to the free trial page.");
        freeTrialPage = indexPage.clickOnFreeTrial();

//        freeTrialPage = indexPage.clickOnDownloadTrial();
        Log.info("Assert with the title of the free trial page");
        String titleft = freeTrialPage.titletime();
        System.out.println("The title of the page is:" +titleft);
        String atitle = "Try everything FontExplorer® X has to offer on macOS, completely unrestricted, with a 30-day free trial.";
        Assert.assertEquals(titleft,atitle);

        Log.info("Click on the download free trial button.");
        freeTrialPage.checkValidation();
        Log.info("Displays the validation message in email and checkbox.");
        freeTrialPage.validationMessage();

        Log.info("Add the name and email for the free download.");
        String ftrialemail = "ankit+" +randNum+ "@uba-solutions.com";
        System.out.println(ftrialemail);
        freeTrialPage.freeTrialForm(prop.getProperty("ftrailname"), ftrialemail );

        Log.info("Clicked on the download button");
        freeTrialPage.clickDownload();
        Log.endTestCase("freeTrialTest");
        Action.implicitWait(getDriver(),80);
//        Assert.assertTrue(Action.isFileDownloaded(downloadFilepath,"FontExplorerXPro730.dmg"),"Failed to download expected document.");
        //Additional Settings
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain");

    }



}
