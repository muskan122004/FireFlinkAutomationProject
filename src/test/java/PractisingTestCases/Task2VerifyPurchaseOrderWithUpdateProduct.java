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

public class Task2VerifyPurchaseOrderWithUpdateProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\CommonData1.properties");
		
		Properties pobj= new Properties();
		pobj.load(fis);
		String Url=pobj.getProperty("url");
		String UserName =pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\TestData.xlsx");
		
		  Workbook wb= WorkbookFactory.create(fis1);
		  Sheet sheet=wb.getSheet("Sheet1");
		      Row r=sheet.getRow(7);
		      
		      String productName = r.getCell(20).toString();
		      String editedPrice = r.getCell(18).toString();
		      String subject = r.getCell(1).toString();
			    String DueDate = r.getCell(2).toString();
			    String UpdatedcontactName = r.getCell(3).toString();
			    String billingAddress = r.getCell(4).toString();
			    String billingPoBox = r.getCell(5).toString();
			    String billingCity= r.getCell(6).toString();
			    String billingState= r.getCell(7).toString();
			    String billingPostelCode= r.getCell(8).toString();
			    String billingCountry= r.getCell(9).toString();
			    String shippingAddress= r.getCell(10).toString();
			    String shippingPOBox= r.getCell(11).toString();
			    String city= r.getCell(12).toString();
			    String state= r.getCell(13).toString();
			    String postelCode= r.getCell(14).toString();
			    String country= r.getCell(15).toString();
			    String addProduct= r.getCell(16).toString();
			    
			    String expectedOutput=editedPrice;
		
		      
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
	
		driver.get(Url);
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("inputPassword")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		  Thread.sleep(4000);
		   driver.findElement(By.xpath("//span[text()='Create Order']")).click();
		   driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		   
	       driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(DueDate);
	       
	      driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
	      
	      String win = driver.getWindowHandle();
			Set<String> wins = driver.getWindowHandles();
			for(String window:wins) {
				if(!window.equals(win)) {
					driver.switchTo().window(window);
					Thread.sleep(3000);
					driver.findElement(By.id("search-input")).sendKeys(UpdatedcontactName);
					Thread.sleep(4000);
					driver.findElement(By.xpath("//button[text()='Select']")).click();
						
				}
			}
			
		 
			
			driver.switchTo().window(win);
			Thread.sleep(2000);
			
			WebElement address =driver.findElement(By.xpath("(//textarea[@name='address'])[1]"));
			
	      act.sendKeys(Keys.TAB,billingAddress,Keys.TAB,billingPoBox,Keys.TAB,billingCity,Keys.TAB,billingState,Keys.TAB,billingPostelCode,Keys.TAB,billingCountry,Keys.TAB,shippingAddress,Keys.TAB,shippingPOBox,Keys.TAB,city,Keys.TAB,state,Keys.TAB,postelCode,Keys.TAB,country).perform();
	      driver.findElement(By.xpath("//button[text()='Add Product']")).click();
	      
	      
	      
	      String win1 = driver.getWindowHandle();
			Set<String> wins1 = driver.getWindowHandles();
			for(String window:wins1) {
				if(!window.equals(win)) {
					driver.switchTo().window(window);
					Thread.sleep(3000);
					 driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(addProduct);
					 driver.findElement(By.xpath("//button[text()='Select']")).click();
					 
						
				}
			}

			
			driver.switchTo().window(win1);
			act.scrollByAmount(50, 50).perform();
			driver.findElement(By.xpath("//button[text()='Create Purchase Order']")).click();
			
			driver.findElement(By.xpath("//a[text()='Products']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@class='form-control']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option[text()='Search by Product Name']")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(productName);
		    Thread.sleep(2000);
		     driver.findElement(By.xpath("//i[@title='Edit']")).click();
		   WebElement element=  driver.findElement(By.xpath("//input[@name='price']"));
		   element.clear();
		   element.sendKeys(editedPrice);
		   driver.findElement(By.xpath("//button[text()='Update']")).click();
		   
		   
//		   driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
//		   driver.findElement(By.xpath("//select[@class='form-control']")).click();
//		   driver.findElement(By.xpath("//option[text()='Search by Subject']")).click();
//		   driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(subject);
//		   driver.findElement(By.xpath("(//i[@title='Edit'])[1]")).click();
		   
		   Thread.sleep(2000);
		   
		   driver.findElement(By.xpath("//select[@class='form-control']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option[text()='Search by Product Name']")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(productName);
		    Thread.sleep(2000);
		     driver.findElement(By.xpath("//i[@title='Edit']")).click();
		     WebElement output= driver.findElement(By.xpath("//input[@name='price']"));
		     
		    String s1= output.getText();
		    System.out.println(s1);
		    output.clear();
		    
		    if(expectedOutput.equals(s1)) {
		    	System.out.println("-----Test Case is passed------");
		    }
		    
		    else {
		    	System.out.println("TestCase is not passed");
		    	
		    }
		    
			WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
			act.moveToElement(icon).perform();
			driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		     
		   
		     
		   

	}

}
