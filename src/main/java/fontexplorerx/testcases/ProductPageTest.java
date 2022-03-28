package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.*;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;
    ProductsPage upgradePage;

    @Test
    public void productPageTest() throws Throwable{
        Log.startTestCase("productPageTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();

        Log.info("Assert the product page title.");
        boolean result = productsPage.getProductTitle();
        Assert.assertTrue(result);

        Log.info("Click on the pro button.");
        addToCartPage = productsPage.clickOnProButton();

        Log.info("Validate the title of the cart page");
        boolean atcresult = addToCartPage.getCartTitle();
        Assert.assertTrue(atcresult);
        Log.endTestCase("productPageTest");
    }

    @Test
    public void upgradePageTest() throws Throwable{
        Log.startTestCase("UpgradePageTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();

        Log.info("Navigated to the upgrade page");
        productsPage.clickOnUpgradeButton();

        Log.info("Verify the title of the page.");
        String titleUpgrade = productsPage.verifyUpgradeTitle();
        Assert.assertEquals(titleUpgrade,"Upgrade Version");

        Log.info("Verify the validation message for the blank click");
        productsPage.validateblanktext();
//        Assert.assertEquals();

        Log.endTestCase("UpgradePageTest");

    }

    @Test
    public void specialOfferPageTest() throws Throwable{
        Log.startTestCase("Special Offer");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();

        Log.info("Navigated to the product page");
        productsPage = indexPage.clickOnProduct();

        Log.info("Navigated to the upgrade page");
        productsPage.clickOnStudent();

        Log.info("Verify the title of the page.");
        String titleStudent = productsPage.verifyStudentPageTitle();
        Assert.assertEquals(titleStudent,"Special offers for Students and Educators.");

        Log.info("Add the student version to cart.");
        addToCartPage = productsPage.clickOnStudentBuyButton();

        Log.info("Validate the title of the cart page");
        boolean atcresult = addToCartPage.getCartTitle();
        Assert.assertTrue(atcresult);

        Log.endTestCase("Special Offer");

    }


}
