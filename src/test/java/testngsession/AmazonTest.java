package testngsession;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Errors;

public class AmazonTest extends BaseTest{
	
			
	
	@Test(priority=1)
	public void pageTitleTest() {
		//driver.get("https://www.amazon.in/");
		String title=driver.getTitle();
		System.out.println("Page title is:"+title);
		//Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","...title is not matched...");
		//Instaed of Hardcoded error message we can craete Error class and give
		Assert.assertEquals(title, "Online1 Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",Errors.TITLE_MISMATCHED_MESSG);
	}
	
	@Test(priority=2, enabled=true)
	public void apppageUrlTest() {
		String url=driver.getCurrentUrl();
		System.out.println("Page url:"+ url);
		Assert.assertTrue(url.contains("amazon11"),Errors.URL_MISMATCHED_MESSG);
	}
	
	@Test(priority=3)
	public void searchBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(),"Search field is not available");
	}
	
	

}
