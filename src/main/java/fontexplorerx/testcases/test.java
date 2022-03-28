package fontexplorerx.testcases;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {
    public static void main(String[] args){
		//declare the chrome driver from the local machine location
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriverManager.chromedriver().setup();
		//create object of chrome options
		ChromeOptions options = new ChromeOptions();

		//add the headless argument
		options.addArguments("headless");

		//pass the options parameter in the Chrome driver declaration
		WebDriver driver = new ChromeDriver(options);

		//Navigate to toolsQA site url
		driver.get("https://facebook.com/");

		//Print the Title of the Page
		System.out.println("Title of the page is -> " + driver.getTitle());
		System.out.println("Hey you have redirected to the page.");

		//Close the driver
		driver.close();
	}
}
