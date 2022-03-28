package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import fontexplorerx.testcases.ProductPageTest;
import fontexplorerx.testcases.StudentPageTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseClass {

    @FindBy(xpath = "//h1[normalize-space()='Take control of your font collection.']")
    WebElement productTitle;

    @FindBy(xpath = "//input[@value='Buy']")
    WebElement proBuyButton;

    @FindBy(xpath = "//a[@class='btn-blue-small dev-product-action-selector']")
    WebElement upgradeBuyButton;

    @FindBy(linkText = "special offers")
    WebElement studentLink;

    @FindBy(xpath = "//h1[normalize-space()='Upgrade Version']")
    WebElement upgradetitlw;

    @FindBy(xpath = "//p[normalize-space()='Serial Number is required.']")
    WebElement blankVerification;

    @FindBy(xpath = "//input[@value='Upgrade']")
    WebElement upgradeButton;

    @FindBy(xpath = "//h1[normalize-space()='Special offers for Students and Educators.']")
    WebElement studentTitle;

    @FindBy(xpath = "//input[@value='Buy']")
    WebElement studentBuyButton;

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

    public ProductPageTest clickOnUpgradeButton() throws Throwable{
        Action.click(getDriver(),upgradeBuyButton);
        return new ProductPageTest();
    }

    public AddToCartPage clickOnStudent() throws Throwable{
        Action.click(getDriver(),studentLink);
        return new AddToCartPage();
    }

    public String verifyUpgradeTitle() throws Throwable{
        String upgradeTitle = upgradetitlw.getText();
        return upgradeTitle;
    }

    public ProductPageTest validateblanktext() throws Throwable {
        Action.click(getDriver(),upgradeButton);
        Action.isDisplayed(getDriver(),blankVerification);
        return new ProductPageTest();
    }

    public String verifyStudentPageTitle(){
        String studenttitle = studentTitle.getText();
        return studenttitle;
    }

    public AddToCartPage clickOnStudentBuyButton() throws Throwable {
        Action.click(getDriver(),studentBuyButton);
        return new AddToCartPage();
    }
}
