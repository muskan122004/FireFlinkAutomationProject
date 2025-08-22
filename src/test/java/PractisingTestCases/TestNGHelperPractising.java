package PractisingTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FireFlinkCrmTask.UtilityMethods.FileUtility;

public class TestNGHelperPractising {
//	@Test(enabled=false)
//	public void create() {
//		Assert.fail();
//		System.out.println("Hello World");
//		}
//	
//	@Test(invocationCount=2)
//	public void modify() {
//		System.out.println("Modify");
//		
//	}
//	@Test(dependsOnMethods="create")
//	public void delete() {
//		System.out.println("Delete");
//	}
	
	@Test(dataProvider = "customerInfo")
	public void create(String name , String id) {
		System.out.println(name +" and "+id+" -created");
	}
	
	
	@DataProvider(name ="customerInfo")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
//		Object[][] data= new Object[4][2];
//		data[0][0]="Muskan";
//		data[0][1]=1;
		
		
//		data[1][0]="Sakshi";
//		data[1][1]=2;
//		data[2][0]="Nancy";
//		data[2][1]=3;
//		data[3][0]="Aaisha";
//		data[3][1]=4;
//		
//		return data;
		
		FileUtility fu= new FileUtility();
		Object[][] data=fu.readMultipleDataFromExcelFile("Sheet2");
		
		return data;
		
	}
	
	
	

}
