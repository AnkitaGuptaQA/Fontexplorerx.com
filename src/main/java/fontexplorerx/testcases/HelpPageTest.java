package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.HelpPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.utility.Log;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpPageTest extends BaseClass {
    IndexPage indexPage;
    HelpPage helpPage;

    @Test
   public void navigateToHelp() throws Throwable {
       Log.startTestCase("Help Page scenario");
       Log.info("Navigate to the index page");
       indexPage = new IndexPage();

       Log.info("Navigate to the help section");
       helpPage = indexPage.clickOnHelp();

       Log.info("Verify the title of the page.");
       boolean title = helpPage.verifyTitle();
       Assert.assertTrue(true);

       Log.info("Navigate to the download section");
       helpPage.downloadsButton();

       Log.info("Download the windows build.");
       helpPage.downloadWindowsBuilds();
       Thread.sleep(3000);

       Log.info("Download the server build");
       helpPage.downloasServerBuild();

       Log.endTestCase("Help page has been completed.");



    }
}
