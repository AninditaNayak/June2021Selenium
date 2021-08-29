package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;//It is Global reference,so that i can use this thrughout my application and inside main method also 
		                 //and make Static so that without Object we can access

	public static void main(String[] args) {
		
		String browser="safari";//if we pass the safari, it will come to else part and then my driver is never initialized
		                        //and my driver value is nul, so we will get NPE
		//Using if else
		
//		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
//			driver=new ChromeDriver();
//		}
//		
//		else if (browser.equals("firefox")) {
//			
//			System.setProperty("webdriver.gecko.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\FireFox\\geckodriver.exe");
//			driver=new FirefoxDriver();
//			
//		} else {
//			System.out.println("Please pass the correct browser");
//
//		}
		
		//Using Switch case
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\FireFox\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
			
		default:
			System.out.println("Please pass the correct browser");
			break;
		}
		
		
		
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println("Page title is:" + title);
		
		if (title.equals("Google")) {
			System.out.println("Correct Title");
			
		} else {
			System.out.println("InCorrect Title");
		}
		
		driver.quit();
	}

}
