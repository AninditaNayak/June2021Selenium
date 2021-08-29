package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionId {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\JavaSeleniumSoftwares\\Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String title=driver .getTitle();
		System.out.println("Page title is:" + title);//Google
		
		System.out.println(driver.getCurrentUrl());
		
		//1.quit
		//driver.quit();//After quit if we again write getTitle, browser is already closed
		//same session id ChromeDriver: chrome on WINDOWS (13782db4409fcb9f8d477431d9e5b6c6)
		//System.out.println(driver.getTitle());
		//We will get org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		//After quiting the browser, the session id is null (ChromeDriver: chrome on WINDOWS (null))
		
		driver.close();//ChromeDriver: chrome on WINDOWS (169b437664b072af5f9f6466d2ba1c6c)
		
		//System.out.println(driver.getTitle());//After closing the browser we are trying to get the title
		//in this showing same session id (ChromeDriver: chrome on WINDOWS (169b437664b072af5f9f6466d2ba1c6c))
		//But we are getting different message, here session id is not null
		// org.openqa.selenium.NoSuchSessionException: invalid session id
		
		
		//Now i want to capture the title again , hoe we will solve the Problem
		//so we have to Create the Object of Chromedriver Once again,we have to reopen the browser
		
		
		//Reopen the browser
		driver=new ChromeDriver();//here it will craete a new session id
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
	}
	
	

}
