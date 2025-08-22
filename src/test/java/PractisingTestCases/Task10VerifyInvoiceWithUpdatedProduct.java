package PractisingTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import FireFlinkCrmTask.UtilityMethods.FileUtility;
import FireFlinkCrmTask.UtilityMethods.WebDriverUtility;
import FireFlinkCrmTask.UtilityMethods.javaUtility;

public class Task10VerifyInvoiceWithUpdatedProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverUtility wbu= new WebDriverUtility();
		FileUtility fu = new FileUtility();
		javaUtility ju= new javaUtility();
		
		String Url=fu. readDataFromPropertyFile("url");
	    String UserName =	fu. readDataFromPropertyFile("username");
		String Password=fu. readDataFromPropertyFile("password");
		
		

		  WebDriver driver = new ChromeDriver();
		wbu. maximizeWindow( driver);
			wbu.CustomImplicitlyWait( driver);
			Actions act = new Actions(driver);
			
			driver.get(Url);
			driver.findElement(By.id("username")).sendKeys(UserName);
			driver.findElement(By.id("inputPassword")).sendKeys(Password);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			
			Thread.sleep(4000);
			
			
			
			String subject =fu.readDatafROMExcelFile("Sheet1",37,1);
		      String validTill= fu.readDatafROMExcelFile("Sheet1",37,2);
		      String contactName =fu.readDatafROMExcelFile("Sheet1",37,3);
		      String salesOrder = fu.readDatafROMExcelFile("Sheet1",37,4);
		      String DueDate =fu.readDatafROMExcelFile("Sheet1",37,5);
		      String BillingAddress =fu.readDatafROMExcelFile("Sheet1",37,6);
		      String BillingPoBox =fu.readDatafROMExcelFile("Sheet1",37,7);
		      String BillingCity = fu.readDatafROMExcelFile("Sheet1",37,8);
		      String BillingState =fu.readDatafROMExcelFile("Sheet1",37,9);
		      String BillingPostelCode = fu.readDatafROMExcelFile("Sheet1",37,10);
		      String BillingCountry = fu.readDatafROMExcelFile("Sheet1",37,11);
		      String ShippingAddress =fu.readDatafROMExcelFile("Sheet1",37,12);
		      String ShippingPoBox =fu.readDatafROMExcelFile("Sheet1",37,13);
		      String city =fu.readDatafROMExcelFile("Sheet1",37,14);
		      String state =fu.readDatafROMExcelFile("Sheet1",37,15);
		      String postelCode =fu.readDatafROMExcelFile("Sheet1",37,16);
		      String Country =fu.readDatafROMExcelFile("Sheet1",37,17);
		      String AddProducts = fu.readDatafROMExcelFile("Sheet1",37,18);
		      String SearchProductId = fu.readDatafROMExcelFile("Sheet1",37,19);
		      String updatePrice= fu.readDatafROMExcelFile("Sheet1",37,20);
		      
		      
		      driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		      driver.findElement(By.xpath("//span[text()='Create Invoice']")).click();
		      
		      
		      Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@name='subject']")).click();
				
			act.sendKeys(subject,Keys.TAB,Keys.TAB,validTill).perform();
			
			driver.findElement(By.xpath("(//button[@class='action-button'])[1]")).click();
			
                  wbu.switchToNewwindow( driver);
		
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(contactName);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();

			  wbu.switchtoAnyWindow( driver, "");
			
			driver.findElement(By.xpath("(//button[@class='action-button'])[2]")).click();	
			
			Set<String> windows1=driver.getWindowHandles();
			
//			for(String win:windows1) {
//				if(!win.equals(window)) {
//					
//					driver.switchTo().window(win);
//					driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(salesOrder);
//					driver.findElement(By.xpath("//button[@class='select-btn']")).click();
//				}
//			}
			
			
			driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(DueDate);
			Thread.sleep(2000);
			act.sendKeys(Keys.TAB,Keys.TAB, BillingAddress,Keys.TAB, BillingPoBox,Keys.TAB, BillingCity,Keys.TAB, BillingState,Keys.TAB,BillingPostelCode,Keys.TAB,BillingCountry,Keys.TAB,ShippingAddress,Keys.TAB,ShippingPoBox,Keys.TAB,city,Keys.TAB,state,Keys.TAB,postelCode,Keys.TAB,Country).perform();
			
			driver.findElement(By.xpath("//button[text()='Add Product']")).click();

			
		       Set<String> windows3=driver.getWindowHandles();
				
//				for(String win:windows3) {
//					if(!win.equals(window)) {
//						
//						driver.switchTo().window(win);
//						driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(AddProducts);
//						driver.findElement(By.xpath("//button[@class='select-btn']")).click();
//					}
//				}
				
//				driver.switchTo().window(window);
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[text()='Create Invoice']")).click();
				Thread.sleep(2000);
		      
		      driver.findElement(By.xpath("//a[text()='Products']")).click();
		      driver.findElement(By.xpath("//input[@placeholder='Search by product Id']")).sendKeys(SearchProductId);
		      driver.findElement(By.xpath("//i[@title='Edit']")).click();
		     WebElement ele= driver.findElement(By.xpath("//input[@name='price']"));
		           Thread.sleep(2000);
		          ele.sendKeys(Keys.CONTROL+"a");
		          act.sendKeys(Keys.DELETE,updatePrice).perform();
		          Thread.sleep(2000);
		          driver.findElement(By.xpath("//button[text()='Update']")).click();
		          
		          String expectedResult = updatePrice;
		          
		          driver.findElement(By.xpath("//i[@title='Edit']")).click();
		          WebElement ele1= driver.findElement(By.xpath("//input[@name='price']"));
		        String result=  ele1.getAttribute("value");
		          
		        
		        if(result.equals(expectedResult)) {
		        	System.out.println("TestCase is passed");
		        	
		        }
		        else {
		        	System.out.println("TestCase is not passed");
		        }
		          
		          
		    
		        Thread.sleep(8000);
				
				WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				act.moveToElement(icon).perform();
				driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		      
		      
	}

}
