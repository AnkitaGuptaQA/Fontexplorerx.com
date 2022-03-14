package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {

    //@FindBy(xpath = "/html/body/div[3]/header/div[1]/div/div[2]/span[3]/a")
    @FindBy(xpath = "/html/body/div[3]/header/div[1]/div/div[2]/span[3]/a")
    WebElement logoutText;

    public LogoutPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public WebElement logoutOption() throws Throwable {
        Action.click(getDriver(),logoutText);
        return logoutText;

    }
}
