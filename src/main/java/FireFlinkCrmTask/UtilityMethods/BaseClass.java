package FireFlinkCrmTask.UtilityMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import FireFlinkCRM.POMTechniques.DashBoardPage;
import FireFlinkCRM.POMTechniques.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * This class consist of basic configuration annotations of TestNG
 * 
 * @author Muskan
 */
public class BaseClass {
	
   public WebDriverUtility wbutil= new WebDriverUtility();
   public javaUtility jutil= new javaUtility();
   public FileUtility fUtil = new FileUtility();
   public WebDriver driver;
   public static WebDriver sdriver;
   
	
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() throws IOException {

		System.out.println("------+++++DB Connection++++++----------");
		
	}
	@AfterSuite(alwaysRun = true)
	public void acConfigg() {
		System.out.println("========DB Connection is closed=================");
	}
	
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcCongig(/*String Browser*/) throws IOException {
		String Browser = fUtil.readDataFromPropertyFile("browser");
		
		
		if(Browser.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		
		driver=new EdgeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		
		else {
			driver=new ChromeDriver();
		}
		
		
		
		String Url = fUtil.readDataFromPropertyFile("url");
		wbutil.maximizeWindow(driver);
		wbutil.CustomImplicitlyWait(driver);
		driver.get(Url);
		
		sdriver=driver;
		System.out.println("------+++++Browser launch successfully+++++-----");
		
		
	}
	
	
	@AfterTest
	//@AfterClass(alwaysRun = true)
	public void  acConfig() {
		driver.quit();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
	String UserName=fUtil.readDataFromPropertyFile("username");
	String Password = fUtil.readDataFromPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginPage(UserName, Password);
	System.out.println("-----+++++Login to App++++-----");
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		DashBoardPage dp= new DashBoardPage(driver);
		Thread.sleep(6000);
		dp.logOut(driver);
	}
	
	
}
