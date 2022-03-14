package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass {

    @FindBy(css = ".blue-header")
    WebElement checkoutPageTitle;

    @FindBy(id = "card-new")
    WebElement selectpaymentgateway;

    @FindBy(id = "CheckOutCardPayment_Name")
    WebElement cardName;

    @FindBy(id = "CheckOutCardPayment_AccountNumber")
    WebElement cardNumber;

    @FindBy(id = "CheckOutCardPayment_ExpirationMonth")
    WebElement cardMonth;

    @FindBy(id = "CheckOutCardPayment_ExpirationYear")
    WebElement cardYear;

    @FindBy(id = "CheckOutCardPayment_CvvNumber")
    WebElement securityCode;

    @FindBy(id = "CheckOutCardPayment_LicensesAndTerms")
    WebElement paymentTerms;

    @FindBy(xpath = "/html/body/div/div/section/section[2]/div[1]/div/div[1]/form[1]/div/div/div[3]/div[2]/button")
    WebElement placeOrderButton;




    public CheckoutPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getCheckoutTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),checkoutPageTitle);
    }

    public PaymentPage enterCardDetails(String cname, String cnumber, String cmonth, String cYear , String scode) throws Throwable {
        Action.click(getDriver(),selectpaymentgateway);
        Action.type(cardName, cname);
        Action.type(cardNumber,cnumber);
        Action.selectByVisibleText(cmonth,cardMonth);
        Action.selectByVisibleText(cYear,cardYear);
        Action.type(securityCode,scode);
        Action.click(getDriver(),paymentTerms);
        Action.click(getDriver(),placeOrderButton);
        return new PaymentPage();

    }

}
