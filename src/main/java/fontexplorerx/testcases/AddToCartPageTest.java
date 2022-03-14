package fontexplorerx.testcases;

import fontexplorerx.base.BaseClass;
import fontexplorerx.pageobjects.AddToCartPage;
import fontexplorerx.pageobjects.IndexPage;
import fontexplorerx.pageobjects.ProductsPage;
import fontexplorerx.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {
    IndexPage indexPage;
    ProductsPage productsPage;
    AddToCartPage addToCartPage;

    @Test
    public void addToCartTest() throws Throwable {
        Log.startTestCase("addToCartTest");
        Log.info("Navigated to the index page.");
        indexPage = new IndexPage();
        Log.info("Navigated to the Products page");
        productsPage = indexPage.clickOnProduct();
        Log.info("Click on the pro button");
        addToCartPage = productsPage.clickOnProButton();
        Log.info("Enter the quantity of the license.");
        addToCartPage.enterqqantity(prop.getProperty("licenseQuan"));
        Double licQuantity = Double.valueOf((prop.getProperty("licenseQuan")));
        System.out.println("The license quantity:" +licQuantity);
        Double unitPrice = addToCartPage.getUnitPrice();
        System.out.println("The unit price is: " +unitPrice);
        Double totalExpectedPrice = unitPrice * licQuantity;
        System.out.println("The total price after calculation is: " +totalExpectedPrice);
        Thread.sleep(2000);
        Double totalPrice = addToCartPage.getTotalPrice();
        System.out.println("The total price is: " +totalPrice);
        Log.info("Validate the unit price and the total price.");
        Assert.assertEquals(totalPrice,totalExpectedPrice);
        addToCartPage.proceedToCheckout();
        Log.endTestCase("addToCartTest");





    }

}
