package testngsession;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount=10)
	public void homePageTest() {
    	System.out.println("homePageTest");
	}

	//In this case it will execute 10 times
	//Ex: Specially in API Automation we will do,If want to do Login, 100 times back to back, sequentially then we can give invocationCount
	//here the Output will be 10 times,same Tc will execute 10 times 
}
