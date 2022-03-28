package fontexplorerx.pageobjects;


import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ForgotPasswordPage extends BaseClass {
    public String parentWindowId;
    public String childWindowId;

    @FindBy(xpath = "//h1[normalize-space()='Send new password']")
    WebElement titleFontExplorer;
    @FindBy(xpath = "//span[@class='field-validation-error']")
    WebElement validateBlankFieldError;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmail;
    @FindBy(xpath = "//button[normalize-space()='Send me a new password']")
    WebElement forgotPasswordButton;
    @FindBy(xpath = "//input[@id='identifierId']")
    WebElement gmailEmailId;
    @FindBy(xpath = "//input[@name='password']")
    WebElement gmailPassword;
    @FindBy(css = "button[type='button'] span[class='VfPpkd-vQzf8d']")
    WebElement clickOnNextButton;
    @FindBy(css = "button[type='button'] span[class='VfPpkd-vQzf8d']")
    WebElement clickOnPasswordNext;

    public ForgotPasswordPage(){
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    public boolean getTitleForgotPassword() throws Throwable {
        return Action.isDisplayed(getDriver(),titleFontExplorer);
    }
    public boolean validateFieldError() throws Throwable {
        return Action.isDisplayed(getDriver(),validateBlankFieldError);
    }
    public ForgotPasswordPage enterEmailId(String resetEmailId) throws Throwable{
        Action.type(enterEmail,resetEmailId);
        return new ForgotPasswordPage();
    }

    public ForgotPasswordPage clickOnForgotPassword() throws Throwable {
        Action.click(getDriver(),forgotPasswordButton);
        return new ForgotPasswordPage();
    }

    public void navigateToNewWindow(){
        getDriver().switchTo().newWindow(WindowType.TAB);
        Set<String> handles = getDriver().getWindowHandles();
        List<String> ls = new ArrayList<String>(handles);
        parentWindowId = ls.get(0);
        childWindowId = ls.get(1);
        System.out.println(parentWindowId);
        System.out.println(childWindowId);
        getDriver().get("https://www.gmail.com");
    }

    public void loginToGmail(String resetEmailId, String gmailPasswordText) throws Throwable {
        Action.type(gmailEmailId,resetEmailId);
        Action.click(getDriver(),clickOnNextButton);
        Action.type(gmailPassword,gmailPasswordText);
        Action.click(getDriver(),clickOnPasswordNext);
    }


    public void closeNewWindow(){
        getDriver().close();
        getDriver().switchTo().window(parentWindowId);
    }
}
