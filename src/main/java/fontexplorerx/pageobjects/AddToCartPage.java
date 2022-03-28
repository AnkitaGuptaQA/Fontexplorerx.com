package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    @FindBy(xpath = "//td[normalize-space()='Your cart is empty']")
    WebElement emptyCart;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    WebElement redirectProduct;

    @FindBy(id = "LicenseQuantity")
    WebElement licQuantity;

    @FindBy(xpath = "//a[@class='btn-blue']")
    WebElement proCheckout;

    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/table/tbody/tr/td[4]")
    WebElement unitprice;
    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/table/tfoot/tr[2]/td/span/span")
    WebElement totalprice;

//    @FindBy(css = ".cart-total > span:nth-child(1)")
//    WebElement totalprice;

    @FindBy(xpath = "//h1[normalize-space()='Your Cart']")
    WebElement cartTitle;

    @FindBy(xpath = "//input[@id='VoucherCode']")
    WebElement voucherInputField;

    @FindBy(xpath = "//button[normalize-space()='Redeem']")
    WebElement redeemButton;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    WebElement fieldValidation;

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

        public AddToCartPage clickOnRedeem() throws Throwable {
        Action.click(getDriver(),redeemButton);
        return new AddToCartPage();
        }

        public boolean verifyFieldValidation() throws Throwable{
        return Action.isDisplayed(getDriver(),fieldValidation);
        }

    }


