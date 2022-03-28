package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    //Redirect to the free trial page by link text
//    @FindBy(xpath = "html body div.page header.page-header div.header-inner nav.page-nav a.nav-item")
//    WebElement freeTriallink;
    @FindBy(linkText = "Free Trial")
    WebElement freeTrial;
//    @FindBy(css = "body > div.page > header > div.header-inner > nav > a:nth-child(1)")
//    WebElement freeTriallink;

    //Redirect to the free trial page by download button
    @FindBy(xpath = "//a[normalize-space()='Download a 14-day free trial']")
    WebElement downloadButtonFreeTrial;


    // login or signup button


    @FindBy(xpath = "//a[normalize-space()='Login or sign up']")
    WebElement signInButton;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[2]/a[1]")
    WebElement fontexplorerLogo;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement cartIcon;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/a[2]")
    WebElement buyNowButton;


    @FindBy(linkText = "Features")
    WebElement featureLink;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    WebElement productLink;

    @FindBy(linkText = "Help")
    WebElement helpLink;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[2]/nav[1]/a[5]")
    WebElement contactLink;

    public  IndexPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean validateLogo() throws Throwable {
        return Action.isDisplayed(getDriver(),fontexplorerLogo);
    }

    public String getIndexPageTitle(){
        String indextitle = getDriver().getTitle();
        return indextitle;
    }

    public FreeTrialPage clickOnDownloadTrial() throws Throwable {
        Action.click(getDriver(),downloadButtonFreeTrial);
        return new FreeTrialPage();
    }

    public FreeTrialPage clickOnFreeTrial() throws Throwable {
        Action.click(getDriver(),freeTrial);
        return new FreeTrialPage();
    }

    public LoginPage clickOnSignIn() throws Throwable {
        Action.click(getDriver(),signInButton);
        return new LoginPage();
    }

    public ProductsPage clickOnProduct() throws Throwable{
        Action.click(getDriver(),productLink);
        return new ProductsPage();
    }

    public AddToCartPage clickOnCart () throws Throwable {
        Action.click(getDriver(),cartIcon);
        return new AddToCartPage();
    }

    public FeaturesPage clickOnFeatures() throws Throwable {
        Action.click(getDriver(),featureLink);
        return new FeaturesPage();
    }

    public HelpPage clickOnHelp() throws Throwable {
        Action.click(getDriver(),helpLink);
        return new HelpPage();
    }


}
