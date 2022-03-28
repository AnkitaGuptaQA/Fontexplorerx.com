package fontexplorerx.base;

import fontexplorerx.actiondriver.Action;
import fontexplorerx.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static fontexplorerx.utility.ExtentManager.test;
import static org.openqa.selenium.TakesScreenshot.*;

public class BaseClass {
    public static Properties prop;
    public static Random random;
    public static int randNum;
    public static String downloadFilepath;

    //Declare ThreadLocal Driver
    public  static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    public void loadConfig(){
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            System.out.println("Super constuctor invoked ");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/Configurations/Config.properties");
            prop.load(ip);
            System.out.println("driver:" + driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
       // WebDriver driver = new ChromeDriver(options);
        //Get Driver from threadLocalmap
        return driver.get();
    }


    public static void launchApp() throws Throwable {
       // WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");
        downloadFilepath = "/Users/fexuser/Downloads";

        if (browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            //ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_setting.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--test-type");
            options.addArguments("--disable-extensions"); //to disable browser extension popup

           /* DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);*/
            // for the normal browser
            driver.set((new ChromeDriver()));
            // Run the project in the headless browser.
//            driver.set(new ChromeDriver(cap));
        }else if (browserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            // for the normal browser
            driver.set(new FirefoxDriver());
            // Run the project in the headless browser.
//            driver.set(new FirefoxDriver(options));
        }else if (browserName.equalsIgnoreCase("IE")){
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }/*else if (browserName.equalsIgnoreCase("Safari")){
            WebDriverManager.safaridriver.setup();
            driver = new SafariDriver();*/

            driver.get().manage().window().maximize();
            Action.implicitWait( getDriver(),20 );
            Action.pageLoadTimeOut(getDriver(),30);
            getDriver().get(prop.getProperty("url"));


            int min = 5;
            int max = 1230;
            random = new Random();
            randNum = random.nextInt(max - min + 1) + min ;

    }

    @BeforeMethod
    public void setup() throws Throwable {
        launchApp();
    }

    @AfterMethod
    public void tearDown() throws Throwable {
        getDriver().quit();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }
    }






