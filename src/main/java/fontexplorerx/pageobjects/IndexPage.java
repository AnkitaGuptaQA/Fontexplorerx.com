package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[1]/div[1]/div[2]/a[1]")
    WebElement signInButton;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[2]/a[1]")
    WebElement fontexplorerLogo;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/header[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement cartIcon;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/a[2]")
    WebElement buyNowButton;

//    @FindBy(xpath = "html body div.page header.page-header div.header-inner nav.page-nav a.nav-item")
//    WebElement freeTriallink;

    @FindBy(css = "body > div.page > header > div.header-inner > nav > a:nth-child(1)")
    WebElement freeTriallink;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/nav[1]/a[2]")
    WebElement featureLink;

    @FindBy(css = "a.nav-item:nth-child(3)")
    WebElement productLink;

    @FindBy(xpath = "/html/body/div[3]/header/div[2]/nav/a[4]")
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

    public LoginPage clickOnSignIn() throws Throwable {
        Action.click(getDriver(),signInButton);
        return new LoginPage();
    }

    public FreeTrialPage clickOnFreeTrial() throws Throwable {
        Action.click(getDriver(),freeTriallink);
        return new FreeTrialPage();
    }

    public ProductsPage clickOnProduct() throws Throwable{
        Action.click(getDriver(),productLink);
        return new ProductsPage();
    }

    public AddToCartPage clickOnCart () throws Throwable {
        Action.click(getDriver(),cartIcon);
        return new AddToCartPage();
    }


}
