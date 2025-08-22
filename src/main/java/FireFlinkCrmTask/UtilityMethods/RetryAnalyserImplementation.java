package FireFlinkCrmTask.UtilityMethods;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count =0;
	int retryCount =3;//Manual Analysis //Fail 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<retryCount) {
			count++;
			return true;
			
		}
		return false;
	}
	
}
