package FireFlinkCrmTask.UtilityMethods;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * This class is used for java generic methods 
 * @author Muskan
 */
public class javaUtility {
	/**
	 * This method will get the random number and return .
	 * @return
	 */
	
	public int getRandomNumber() {
		
		Random random= new Random();
		int r=random.nextInt(100);
		return r;
		
	}
	
	/**
	 * This method will capture current system date and format it and return 
	 * @return
	 */
	
	public String getDate() {
	Date d = new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
	String date =sdf.format(d);
	return date;
	}

}
