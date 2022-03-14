package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseClass {

    @FindBy(xpath = "/html/body/div/div/section/div/div[1]/div/section/h1")
    WebElement productTitle;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div[2]/div/div[2]/div/div[1]/section/div[1]/form/input[2]")
    WebElement proBuyButton;

    public ProductsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean getProductTitle() throws Throwable{
        return Action.isDisplayed(getDriver(),productTitle);
    }

    public AddToCartPage clickOnProButton() throws Throwable {
        Action.click(getDriver(),proBuyButton);
        return new AddToCartPage();


    }
}
