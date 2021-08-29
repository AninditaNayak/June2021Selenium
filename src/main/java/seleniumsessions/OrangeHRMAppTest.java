package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMAppTest {

	public static void main(String[] args) {
		
		String browser="chrome";
		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver = brUtil.lunchBrowser(browser);
		brUtil.lunchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		System.out.println(brUtil.getPageTitle());
		
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By contactSales=By.linkText("CONTACT SALES");
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doClick(contactSales);
		
		
		
		//ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendkeys(firstName, "Ani");
		eleUtil.doSendkeys(lastName, "Nayak");
		
		brUtil.closeBrowser();
	}

}
