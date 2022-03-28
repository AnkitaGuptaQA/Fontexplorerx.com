package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import fontexplorerx.testcases.HelpPageTest;
import fontexplorerx.testcases.ProductPageTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPage extends BaseClass {

    @FindBy(xpath = "//h1[@class='features-headline']")
    WebElement featureTitle;

    @FindBy(xpath = "//a[@title='Buy Now']")
    WebElement navigateProducts;

    @FindBy(linkText = "try free for 14 days")
    WebElement navigateFreeTrial;

    @FindBy(linkText = "Frequently Asked Questions")
    WebElement navigateHelp;

    public  FeaturesPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String verifyTitle(){
        String gettitle;
        gettitle = featureTitle.getText();
        return gettitle;
    }

    public ProductPageTest navigateProductPage() throws Throwable {
        Action.click(getDriver(),navigateProducts);
        return new ProductPageTest();
    }

    public FreeTrialPage navigateFreeTrialPage() throws Throwable {
        Action.click(getDriver(),navigateFreeTrial);
        return new FreeTrialPage();
    }

    public HelpPageTest navigateHelpPage() throws Throwable {
        Action.click(getDriver(),navigateHelp);
        return new HelpPageTest();
    }

}
