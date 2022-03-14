package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    @FindBy(xpath = "/html/body/div/div/section/section[1]/h1")
    WebElement checkoutPageTitle;




    public PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getCheckoutTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),checkoutPageTitle);
    }
}
