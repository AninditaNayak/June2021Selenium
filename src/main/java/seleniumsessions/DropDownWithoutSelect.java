package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {
	
	static WebDriver driver;	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry=By.xpath("//select[@id='Form_submitForm_Industry']/option");
		
//		List<WebElement> industryList = driver.findElements(industry);
//		System.out.println(industryList.size());
//		
//		for(WebElement e:industryList) {
//			String text=e.getText();
//			if(text.equals("Healthcare")) {
//				e.click();
//				break;
//			}
//			
//		}
		

		clickDropDownvalue(industry, "Education");
	}
	
	public static void clickDropDownvalue(By locator,String value) {
		
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		
		for(WebElement e:optionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
			
		}
		
	}

}
