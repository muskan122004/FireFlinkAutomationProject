package PractisingTestCases;

import org.testng.annotations.Test;

public class ReadDataFromcmdLine {

	
	@Test
	public void readData() {
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
		String UN = System.getProperty("username");
		System.out.println(UN);
		String PWD = System.getProperty("password");
		System.out.println(PWD);
		
	}
}
