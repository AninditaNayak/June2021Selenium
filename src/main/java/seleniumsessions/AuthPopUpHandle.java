package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		String username="admin";
		String password="admin"; 
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		//Limitation of this code is that UN and pwd should not have @, in the url can we have 2 @, no write format
		
		//Can we use Auto IT: we can not use in Linux, Docker content,AWS ,and headless mode also it will not work
		//It will work only in Windows, so  we will not prefer AutoIT
		

	}

}
