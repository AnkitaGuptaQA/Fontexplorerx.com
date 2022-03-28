package fontexplorerx.pageobjects;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

    @FindBy(id = "signInEmail")
    WebElement email;

    @FindBy(id = "signInPassword")
    WebElement password;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/div[3]/div[1]/section[1]/form[1]/button[1]")
    WebElement signInButton;

    @FindBy(id = "FirstName")
    WebElement fName;

    @FindBy(id = "Street")
    WebElement streetName;

    @FindBy(id = "City")
    WebElement cityName;

    @FindBy(id = "ZipCode")
    WebElement zipCode;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/div[3]/div[1]/section[2]/form[1]/div[1]/div[1]/div[6]/div[1]/select[1]")
    WebElement countryName;

    @FindBy(id = "signUpEmail")
    WebElement signupEmail;

    @FindBy(id = "Password")
    WebElement signUpPassword;

    @FindBy(id = "PasswordConfirmation")
    WebElement signUpPasswordConfirmation;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/div[3]/div[1]/section[2]/form[1]/div[3]/div[2]/button[1]")
    WebElement createNewAccount;

    @FindBy(xpath = "/html/body/div[3]/div/section/div[2]/div/section/h1")
    WebElement loginTitle;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordButton;

    public LoginPage(){
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    public HomePage login(String uemail, String Upassword) throws Throwable {
        Action.isDisplayed(BaseClass.getDriver(),loginTitle);
        Action.type(email, uemail);
        Action.type(password, Upassword);
        Action.click(BaseClass.getDriver(),signInButton);
        return new HomePage();
    }
    public CheckoutPage login1(String uemail, String Upassword) throws Throwable {
        Action.isDisplayed(BaseClass.getDriver(),loginTitle);
        Action.type(email, uemail);
        Action.type(password, Upassword);
        Action.click(BaseClass.getDriver(),signInButton);
        return new CheckoutPage();
    }
    public boolean validateloginPageTitle() throws Throwable {
        return Action.isDisplayed(BaseClass.getDriver(),loginTitle);
    }
    public HomePage createNewAccount(String fullname, String streetname, String cityname, String zipcode, String countryname1, String signupemail, String signuppassword, String signuppasswordconfirm) throws Throwable {
        Action.type(fName, fullname);
        Action.type(streetName , streetname);
        Action.type(cityName, cityname);
        Action.type(zipCode, zipcode);
        Action.selectByVisibleText(countryname1, countryName);
       // Action.type(countryName, countryname);
        Action.type(signupEmail, signupemail);
        Action.type(signUpPassword, signuppassword);
        Action.type(signUpPasswordConfirmation,signuppasswordconfirm);
        Action.click(BaseClass.getDriver(),createNewAccount);
        return new HomePage();
    }
    public ForgotPasswordPage clickOnForgotPassword() throws Throwable {
        Action.click(getDriver(),forgotPasswordButton);
        return new ForgotPasswordPage();
    }
}
