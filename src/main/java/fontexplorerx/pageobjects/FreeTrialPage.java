package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeTrialPage extends BaseClass {

    @FindBy(xpath = "//h2[@class='trial-header']")
    WebElement freeTrialTitle;

    @FindBy(id = "fieldName")
    WebElement freename;

    @FindBy(id = "fieldEmail")
    WebElement freeemail;

    @FindBy(xpath = "//*[@id=\"HasAgreed\"]")
    WebElement checkbox;

    @FindBy(xpath = "//button[normalize-space()='Download Free Trial']")
    WebElement downloadft;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    WebElement emailError;

    @FindBy(xpath = "//span[@data-valmsg-for='HasAgreed']")
    WebElement checkoutError;

    @FindBy(xpath = "//div[@class='trial-content']//p[1]")
    WebElement alreadyUsedEmail;

    public FreeTrialPage(){
        PageFactory.initElements(getDriver(),this);
    }

//    public boolean getFreeTrialTitle() throws Throwable {
//        return Action.isDisplayed(getDriver(),freeTrialTitle);
//    }

    public String titletime(){
        String gettitle = freeTrialTitle.getText();
        return gettitle;
    }

    public FreeTrialPage freeTrialForm(String ftrailname, String ftrialemail) throws Throwable {
        Action.type(freename, ftrailname);
        Action.type(freeemail,ftrialemail);
        Action.click(getDriver(),checkbox);
        Action.implicitWait(getDriver(),15);
        Action.fluentWait(getDriver(),downloadft,10);
        Thread.sleep(50);
        return new FreeTrialPage();
    }

    public FreeTrialPage clickDownload() throws Throwable {
        Action.click(getDriver(),downloadft);
        return new FreeTrialPage();
    }

    public FreeTrialPage checkValidation() throws Throwable {
        Action.click(getDriver(),downloadft);
        return new FreeTrialPage();
    }

    public FreeTrialPage validationMessage() throws Throwable {
//        WebElement emailvalidate = emailError.getText();
        Action.isDisplayed(getDriver(),emailError);
        Action.isDisplayed(getDriver(),checkoutError);
        return new FreeTrialPage();
    }

    public FreeTrialPage usedEmailMessage() throws Throwable {
        Action.isDisplayed(getDriver(),alreadyUsedEmail);
        return new FreeTrialPage();
    }




}
