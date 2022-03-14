package fontexplorerx.pageobjects;

import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[1]/div[1]/div[2]/span[1]/a[1]")
    WebElement loggedinUserName;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[1]/div[1]/div[2]/span[3]/a[1]")
    WebElement Logoutlink;


    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String gethomePageTitle(String homepagetitle){
        homepagetitle = getDriver().getTitle();
        return homepagetitle;
    }

    public String validateloggedusername() throws Throwable {
        String loggedUserName = loggedinUserName.getText();
        return loggedUserName;
    }

    public String validatelogoutText(){
        String logoutText = Logoutlink.getText();
        return logoutText;
    }

    public String getcurrURL(){
        String homepageURL = getDriver().getCurrentUrl();
        return homepageURL;
    }
}
