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


}
