package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This utility having different methods for different browser actions
 * @author annayak
 *
 */

public class BrowserUtil {
	
	public WebDriver driver;
	
	/**
	 * This method is used to initialize the driver on the basis of given browser name
	 * @param browserName
	 * @return this returns WebDriver reference
	 */
	
	public WebDriver lunchBrowser(String browserName) {
		
		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if (browserName.equals("firefox")) {
			
			//System.setProperty("webdriver.gecko.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\FireFox\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		} else {
			System.out.println("Please pass the correct browser");

		}
		
		return driver;//returning the driver, and return type also WebDriver
	}
	
	
	public void lunchUrl(String url) {
		if (url==null) {
			return;
		}
		if (url.isEmpty()) {
			return;
		}
		driver.get(url);
	}
	
	public String getPageTitle(){
		
		return driver.getTitle();
	}
	
   public String getPageUrl(){
		
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageSource() {
		
		return driver.getPageSource();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

	//Wrapper functions, main purpose is reusability,these are called Generic functions.
	//will you write ur validation logic,but it is not a good practice,it is the class responsibility and method 
	//responsility to Validate, it is Correct or not, when we are writing Utility dont write ur Assertion inside utility
}
