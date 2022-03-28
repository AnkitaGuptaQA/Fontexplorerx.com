package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Help']")
    WebElement helpTitle;

    @FindBy(xpath = "//a[normalize-space()='Downloads']")
    WebElement clickOnDownloads;

    @FindBy(xpath = "//a[@class='btn-blue js-link-tooltip']")
    WebElement downloadMacBuild;

    @FindBy(xpath = "//div[@id='dbcms-content-2t46']//a[@class='btn-blue'][normalize-space()='Download']")
    WebElement downloadWindowsBuild;

//    @FindBy(xpath = "//a[@href='https://fex.linotype.com/download/server/FontExplorerXServer.zip']")
    @FindBy(css = "a[href='https://fex.linotype.com/download/server/FontExplorerXServer.zip']")
    WebElement downloadServerBuild;

    public HelpPage(){
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
    public boolean verifyTitle() throws Throwable {
        return Action.isDisplayed(getDriver(),helpTitle);
    }

    public HelpPage downloadsButton() throws Throwable {
        Action.click(getDriver(),clickOnDownloads);
        return new HelpPage();
    }

    public FreeTrialPage downloadMacBuilds() throws Throwable {
        Action.click(getDriver(),downloadMacBuild);
        return new FreeTrialPage();
    }

    public HelpPage downloadWindowsBuilds() throws Throwable{
        Action.click(getDriver(),downloadWindowsBuild);
        Thread.sleep(5000);
        return new HelpPage();
    }

    public HelpPage downloasServerBuild() throws Throwable{
        Action.click(getDriver(),downloadServerBuild);
        Thread.sleep(5000);
        return new HelpPage();
    }
}
