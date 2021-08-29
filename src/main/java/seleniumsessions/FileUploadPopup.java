package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopup {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//One thing you need to check ,inspect the choose file, but check type=file is MANDATORY then only it will work
		//should be there and tagname can be anything
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Ddrive\\Bayer\\Document\\Notepad.txt");

	}

}
