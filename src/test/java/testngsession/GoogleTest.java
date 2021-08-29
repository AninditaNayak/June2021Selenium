package testngsession;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	

	
	
//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
//		
//	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		//driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println("Page title is:"+title);
		Assert.assertEquals(title, "Google");
		
	}
	
	@Test(priority=2)
	public void apppageUrlTest() {
		String url=driver.getCurrentUrl();
		System.out.println("Page url:"+ url);
		Assert.assertTrue(url.contains("google"));
	}
	
	
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
	

}
