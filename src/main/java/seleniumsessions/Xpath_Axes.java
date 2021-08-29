package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Axes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		driver.findElement(By.linkText("CONTACTS")).click();
	
		//Navigate from Parent to child:
		//direct child:/ here we are getting 8 elements
		//indirect child://Indirect+Direct child it will give// here getting 20 elements
		
// Parent to Child:
		//div[@class='private-form__input-wrapper']//child::input[@id='username']
		//select[@id='Form_submitForm_Industry']//option
		
		//can i go to Child to Parent (backward traversing) (immediate parent/..)
//     //input[@id='username']/../../../../../
//    //input[@id='username']//parent::div  (immediate parent)
//   //input[@id='input-email']//parent::div

		
//  ////input[@id='input-email']//ancestor::div  (how many grand parents are there where htmal tag is div)
		
// sibling traversing:
	//preceding sibling
	//following sibling
		
		//a[text()='Aastha Grover']//parent::td//preceding-sibling::td/input[@type='checkbox']
		// or 
//   //a[text()='AB Devilliers']/..//preceding-sibling::td/input[@type='checkbox']
	//a[text()='Akshay patil']/..//preceding-sibling::td/input[@type='checkbox']
	//a[text()='Aastha Grover']/..//preceding-sibling::td/input[@type='checkbox']
		
  //selectContact("AB Devilliers");
  //selectContact("Akshay patil");
  
    String text=getCompany("Aastha Grover");
   System.out.println(text);
    
//    List<WebElement> contactList = driver.findElements(By.xpath("//a[text()='Aliss Jeyhun']/parent::td/following-sibling::td"));
//    System.out.println(contactList.size());
//	int count=0;
//	for(WebElement e : contactList) {
//		if(count==5) {
//			break;
//		}
//		System.out.println(e.getText());
//		count++;
//	}
   
   System.out.println(getContactdetails("Aliss Jeyhun"));

   
	}
	
	public static void selectContact(String name) {
		String checkBox="//a[text()='"+name+"']/..//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(checkBox)).click();
	}
	//xpath of company name
	//a[text()='Aastha Grover']//parent::td//following-sibling::td/a[@context='company']
	
	public static String  getCompany(String name) {
		String compName="//a[text()='"+name+"']/..//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(compName)).getText();
	}
	
	//xpath of all the datails
	//a[text()='Aliss Jeyhun']/parent::td/following-sibling::td
	
	public static List<String> getContactdetails(String name) {
		List<String> eleTextList = new ArrayList<String>();
		String contactDetails="//a[text()='"+name+"']/parent::td/following-sibling::td";
	    List<WebElement> contactList = driver.findElements(By.xpath(contactDetails));
        System.out.println(contactList.size());
	    int count=1;
	    for(WebElement e : contactList) {
		if(count>=contactList.size()) {
			break;
		}
		String text=e.getText();
		eleTextList.add(text);
		count++;
	}
	    
	    return eleTextList;
	
	}
	
	
	
}
	


