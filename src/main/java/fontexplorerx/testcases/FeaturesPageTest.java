package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.FeaturesPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeaturesPageTest extends BaseClass {
    IndexPage indexPage;
    FeaturesPage featuresPage;

    @Test
    public void featurePageTest() throws Throwable {
        Log.startTestCase("Start test for feature page.");
        Log.info("Navigated to the index page");
        indexPage = new IndexPage();
        Log.info("Navigated to the feature page");
        featuresPage = indexPage.clickOnFeatures();

        Log.info("Verify title of the page.");
        String title;
        title = "Font Management for pros, beginners, and everyone in-between.";
        String gettitle;
        gettitle = featuresPage.verifyTitle();
        Assert.assertEquals(gettitle,title);

        Log.endTestCase("End test for feature page.");

    }
}
