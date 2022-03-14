package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"dbcms-content-1t12\"]/table/tbody/tr/td")
    WebElement emptyCart;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/nav[1]/a[3]")
    WebElement redirectProduct;

    @FindBy(id = "LicenseQuantity")
    WebElement licQuantity;

    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/table/tfoot/tr[3]/td/a")
    WebElement proCheckout;

    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/table/tbody/tr/td[4]")
    WebElement unitprice;
    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/table/tfoot/tr[2]/td/span/span")
    WebElement totalprice;

//    @FindBy(css = ".cart-total > span:nth-child(1)")
//    WebElement totalprice;

    @FindBy(xpath = "/html/body/div[1]/div/section/div[1]/div/section/h1")
    WebElement cartTitle;

    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }


    public boolean getCartTitle() throws Throwable {
        return Action.isDisplayed(getDriver(), cartTitle);
    }

    public double getUnitPrice(){
        String unitPrice1 = unitprice.getText();
        String unit = unitPrice1.replaceAll("[^a-zA-Z1-9]","");
        //double finalunitPrice = Double.parseDouble(unit);
        double finalunitPrice = Double.parseDouble(unit);
        return finalunitPrice*10;
        }

    public double getTotalPrice() throws Throwable {
        Action.fluentWait(getDriver(),totalprice,10);
        String totalPrice1 = totalprice.getText();
        String total = totalPrice1.replaceAll("[^a-zA-Z1-9]","");
        double finalTotalPrice = Double.parseDouble(total);
        Action.implicitWait(getDriver(),20);
        Action.pageLoadTimeOut(getDriver(),15);
        Thread.sleep(100);
        return finalTotalPrice*10;
    }


//    public ProductsPage cartPagevalidation(String cart) throws Throwable {
//        cart = emptyCart.getText();
//        if (cart == "YOUR CART IS EMPTY") {
//            Action.click(driver, redirectProduct);
//            return new ProductsPage();
//        }
//
//    }
    public AddToCartPage enterqqantity(String licenseQuan) throws Throwable {

            Action.selectByVisibleText(licenseQuan,licQuantity);
            return new AddToCartPage();
        }

        public LoginPage proceedToCheckout() throws Throwable {
            Action.click(getDriver(),proCheckout);
            return new LoginPage();
        }

    }


