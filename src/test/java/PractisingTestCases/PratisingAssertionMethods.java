package PractisingTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import FireFlinkCrmTask.UtilityMethods.BaseClass;

public class PratisingAssertionMethods extends BaseClass {

	
	@Test(groups = "SmokeSuite")
	public void sample() {
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
          Assert.assertEquals("1","1");
      	System.out.println("Step4");
      	Assert.assertEquals(0,1);
    	System.out.println("Step5");
	}
	
	
	@Test
	public void sampleSoft() {
		SoftAssert sa= new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
        sa.assertEquals("1","1");
      	System.out.println("Step4");
      	sa.assertEquals(0,1);
    	System.out.println("Step5");
	}
}
