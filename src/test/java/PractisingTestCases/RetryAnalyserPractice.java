package PractisingTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = FireFlinkCrmTask.UtilityMethods.RetryAnalyserImplementation.class)
	public void sample() {
		
		Assert.fail();
		System.out.println("Demo ");
		
	}

}
