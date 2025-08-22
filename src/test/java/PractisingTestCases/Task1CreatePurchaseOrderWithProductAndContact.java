package PractisingTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.Select;

public class Task1CreatePurchaseOrderWithProductAndContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Task 1 
		//Create Purchase Order With Product And Contact
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\CommonData1.properties");
		
		Properties pobj= new Properties();
		pobj.load(fis);
		String Url=pobj.getProperty("url");
		String UserName =pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\TestData.xlsx");
		
		  Workbook wb= WorkbookFactory.create(fis1);
		  Sheet sheet=wb.getSheet("Sheet1");
		      Row r=sheet.getRow(4);
		  
		    String contactName = r.getCell(4).toString();
		    String organization = r.getCell(2).toString();
		    String mobile = r.getCell(5).toString();
		    String title = r.getCell(3).toString();
		    String quantity = r.getCell(9).toString();
		    String productName = r.getCell(7).toString();
		    String price = r.getCell(10).toString();
		    String subject = r.getCell(12).toString();
		    String DueDate = r.getCell(13).toString();
		    String UpdatedcontactName = r.getCell(14).toString();
		    String billingAddress = r.getCell(15).toString();
		    String billingPoBox = r.getCell(16).toString();
		    String billingCity= r.getCell(17).toString();
		    String billingState= r.getCell(18).toString();
		    String billingPostelCode= r.getCell(19).toString();
		    String billingCountry= r.getCell(20).toString();
		    String shippingAddress= r.getCell(21).toString();
		    String shippingPOBox= r.getCell(22).toString();
		    String city= r.getCell(23).toString();
		    String state= r.getCell(24).toString();
		    String postelCode= r.getCell(25).toString();
		    String country= r.getCell(26).toString();
		    String addProduct= r.getCell(27).toString();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
	
		driver.get(Url);
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("inputPassword")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
		driver.findElement(By.xpath("//button[@class='btn btn-info']//span")).click();
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		driver.findElement(By.xpath("(//button[@type='button'])[last()]")).click();
		String element = driver.getWindowHandle();
		Set<String> elements = driver.getWindowHandles();
		for(String window:elements) {
			if(!window.equals(element)) {
				driver.switchTo().window(window);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@class='select-btn'])[last()]")).click();
				
				
			}
		}
		Thread.sleep(2000);
		
		driver.switchTo().window(element);
		
		act.scrollByAmount(20, 20).perform();
		driver.findElement(By.xpath("//button[@type='submit' and text()='Create Contact']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		WebElement ele=driver.findElement(By.xpath("//input[@name='quantity']"));
		ele.clear();
		ele.sendKeys(quantity);
		WebElement ele2=driver.findElement(By.xpath("//input[@name='price']"));
		ele2.clear();
		ele2.sendKeys(price);
	     driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(productName);
	    WebElement select=  driver.findElement(By.xpath("//select[@name='productCategory']"));
	     Select s = new Select(select);
	    select.click();
	    s.selectByIndex(1);
	    
	   WebElement select2= driver.findElement(By.xpath("//select[@name='vendorId']"));
	   select2.click();
	   Select s1 = new Select(select2);
	   Thread.sleep(2000);
	   s1.selectByIndex(3);
	   driver.findElement(By.xpath("//button[text()='Add']")).click();
	   
	   
	   Thread.sleep(2000);
	   
	   
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
		Thread.sleep(8000);
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(icon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
	   
	}
	

}
