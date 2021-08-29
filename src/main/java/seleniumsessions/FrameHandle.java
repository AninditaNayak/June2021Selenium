package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		//How many frames available
				List<WebElement> frameList = driver.findElements(By.tagName("frame"));
				System.out.println(frameList.size());
		
		//driver.switchTo().frame(2);//but index is not a good choice, if One more frame added the frame index will change
		
		//driver.switchTo().frame("main");//Using frame nameorID
		
		//Frame is also a WebElement
		
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
			
		String header=driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		//Now my driver is present inside the frame, then we have to back to page
		driver.switchTo().defaultContent();
		

	}

}
