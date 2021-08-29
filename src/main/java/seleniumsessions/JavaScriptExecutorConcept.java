package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		/*Not everything we cover in selenium,Highlight,Scroll in perticular page and popup ,.. we have to handle through JavaScript
		 * Why because? because Browser understands Only JS, we are using JavaScriptAPI to execute any JavaScript code
		 * 
		 * 
		 * 
		 * 
		 */

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
	}

}
