package testngsession;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test
	public void loginTest() {
		System.out.println("login");
		//int i=9/0;
		
	}
    @Test(dependsOnMethods="loginTest",priority=2)
   public void homePageTest() {
    	System.out.println("homePageTest");
	}
    @Test(dependsOnMethods= {"loginTest","homePageTest"},priority=1)// we can pass more that one dependes on  method , it is an Array,
    public void searchTest() {
    	System.out.println("searchTest");
 		
 	}
    
    //If we will execute , First homePageTest will execute then loginTest, how homePageTest will execute first before login
    //so we can use (dependsOnMethods="loginTest"), now TEstNG will assume home page and search depend on the login 
    /*PASSED: homePageTest
    PASSED: loginTest
    PASSED: searchTest */
    
    //Here if loginTest will fail,then both homePageTest and searchTest will skipped.
    
    //In between homePageTest and searchTest, it will Run alphabatic, here we can give Priority also
    
    //never use dependency for test methods, my test methods should be independent
    
    //Maintaince of the framework too high
    //CRUD= Create(POST)  Retrive (GET) Update(Update) Delete(Delete)
    
    
}
