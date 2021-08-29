package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteStatus;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverCombination {

	public static void main(String[] args) {
		
		
		//Want to Lunch Google chrome, so what are different combinations
		
		//1.When we have Only One browser specific, no cross browser then we can use only One browser,here only Chrome
		//we can use
		System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//2.Want to Use cross browser
		
		//WebDriver driver=new ChromeDriver();
		                  //FirefoxDriver, safariDriver..
		//3.RemoteWebDriver driver =new ChromeDriver();(Can do Upcasting  between these two)
		//4.Top Casting between: SearchContext and ChromeDriver
		
		//SearchContext dr=new ChromeDriver(); But not getting ant methods like getTitle, GetUrl..)
		
		//5.Can we TopCasting between RemoteWebDriver and WebDriver
		
		//WebDriver d=new RemoteWebDriver(remoteAddress, capabilities) (This is Valid when we can use the Remote url)
		
		
		
		
		
		

	}

}
