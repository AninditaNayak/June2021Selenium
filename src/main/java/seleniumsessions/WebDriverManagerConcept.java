package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();//this line will check the Current browser version and 
		//respective executable file is there or not , if not there, it will go to respective google or mozilla
		//and it will download internally and automatically , this binary files will store in m2 directory(c drive--Users--m2)

		//Is it support downgarde also, it will check in m2 if it there simply it will start the server and execute
		
		//WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}

}
