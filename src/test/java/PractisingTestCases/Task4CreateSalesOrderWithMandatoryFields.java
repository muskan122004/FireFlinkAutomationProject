package PractisingTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task4CreateSalesOrderWithMandatoryFields {

	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
		
FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\SeleniumCourse\\FireFlinkCrmTask\\src\\test\\resources\\CommonData1.properties");
		
		Properties pobj= new Properties();
		pobj.load(fis);
		String Url=pobj.getProperty("url");
		String UserName =pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		  
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
	
		driver.get(Url);
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("inputPassword")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		
		
		

	}

}
