package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//https://chromedriver.chromium.org/downloads
		//Check the Chrome Verion, then according to Download the chromedriver.exe file ,now we have to start the server
		
		System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\FireFox\\geckodriver.exe");
		
		WebDriver driver=new ChromeDriver();//this concept is called Upcasting(Child class Object can be 
		                                    //referred by Parent Interface reference variable)
		                                    //WebDriver is an Interface, we cannot  create Object of this
		//Because of above line Browser is lunched
		
		//WebDriver driver=new FirefoxDriver();
		//enter the url:
		driver.get("https://www.google.com/");//without https it will not work
		
		//get the title:
		String title=driver .getTitle();
		System.out.println("Page title is:" + title);
		
		//Validation Point/CheckPoint/actual vs expected result
		//Now we have compare Actual with Expected,but now we cannot use Assertion, so using if else
		
		if(title.equals("Google")) {
			System.out.println("Correct Title");
				}
		else {
			System.out.println("InCorrect Title");
		}
		
		//automation steps+ validation point--->automation testing
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource().contains("Copyright The Closure Library"));
		
		driver.quit();//Close the browser
		                                   

	}

}
