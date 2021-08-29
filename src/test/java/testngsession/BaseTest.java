package testngsession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	
	
                                  
    @Parameters({"browser","url"}) //the browser value is Chrome in testng.xml ,tis browser value given to (browserName),
                                   //this mapping happen automatically with the Annotation,                            
	@BeforeTest
	public void setUp(String browserName, String url) { // if we will not pass parameter here, we are supplying some Parameter, 
    	     
    	                                               //but we dont have any Holding parameter 
		  
    	System.out.println("browser name is :"+browserName );
		//String browserName="firefox";
		   if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		   else if(browserName.equals("firefox")) {
			   WebDriverManager.firefoxdriver().setup();
			   driver=new FirefoxDriver();
		   }
		   
		   else {
			   System.out.println("Please Pass the Correct Browser..."+browserName);
		   }
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
