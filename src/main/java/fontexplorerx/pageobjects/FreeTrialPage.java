package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeTrialPage extends BaseClass {

    @FindBy(xpath = "/html/body/div[1]/div/section/div[2]/div/h2")
    WebElement freeTrialTitle;

    @FindBy(id = "fieldName")
    WebElement freename;

    @FindBy(id = "fieldEmail")
    WebElement freeemail;

    @FindBy(xpath = "//*[@id=\"HasAgreed\"]")
    WebElement checkbox;

    @FindBy(xpath = "/html/body/div[3]/div/section/div[2]/div/div/section[2]/div/form/button")
    WebElement downloadft;

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
        Action.click(getDriver(),downloadft);

        return new FreeTrialPage();
    }



}
