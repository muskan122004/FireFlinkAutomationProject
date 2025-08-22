package FireFlinkCrmTask.UtilityMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.ByteString.Output;

/**
 * 
 * This class consists og generic method related to WebDriver
 * @author Muskan
 */

public class WebDriverUtility {
	
	//maximize, minimize,full screen
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the screen
	 * @param driver
	 */
	
	public void manimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to go for fullscreen window
	 * @param driver
	 */
	
	public void fullscreenWindow(WebDriver driver ) {
		driver.manage().window().fullscreen();
	}
	
	//implicitly wait , explicitly -visible, clickable
	public void CustomImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void CustomExplicitlyWait(WebDriver driver, WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//  handle dropdown -- list box 
	
	public void  CustomSelectionMethod(WebElement element , int index) {
		Select select = new Select(element);
		 select.selectByIndex(0);
	}
	
	public void  CustomSelectionMethod (String visibleText, WebElement element) {
		Select select = new Select(element);
		 select.selectByVisibleText(visibleText);
	}
	
	public void  CustomSelectionMethod (WebElement element , String value) {
		Select select = new Select(element);
		 select.selectByValue(value);
	}
	
	//Action class - 
	
	public void mouseHoveringMethods( WebDriver driver,WebElement src) {
		Actions act = new Actions(driver);
		act.moveToElement(src);
		
	}
	
	public void dragAndDropMethods( WebElement src, WebElement dst,WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
		
	}
	
	
	public void ClickAndHoldMethods( WebElement src,WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.clickAndHold(src).perform();
		Thread.sleep(2000);
		act.release().perform();
		
	}
	
	public void MoveByOffsetMethod( int x, int y,WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).perform();
	
		
	}
	
	public void doubleClickMethods( WebElement src,WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick(src).perform();
		
	}
	
	public void contextClickMethods( WebElement src,WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick(src).perform();	
	}
	
	//Handle frame
	
	public void switchFramesMethods(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
		
	}
	
	public void switchFramesMethods(WebDriver driver, String name) {
		
		driver.switchTo().frame(name);
		
	}
	public void switchFramesMethods(WebDriver driver, WebElement element) {
		
		driver.switchTo().frame(element);
		
	}
	
	public void switchparentFrameMethod(WebDriver driver) {
		
		driver.switchTo().parentFrame();
		
		
	}
	
	//Handling Alert
	
	public void switchToAlert(WebDriver driver) {
		
		Alert a =driver.switchTo().alert();
		
	}
	
	public void AcceptTheAlert( WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void DismissTheAlert( WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getText( WebDriver driver) {
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	public void EnterTextintoAlert( WebDriver driver , String text) {
		driver.switchTo().alert().sendKeys(text);;
	}
	
	
	// window
	
	public void switchToNewwindow(WebDriver driver) {
		String window= driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String win: windows) {
			if(!win.equals(window)) {
				driver.switchTo().window(win);
			}
		}
	}
	

	
	
	public void switchtoAnyWindow(WebDriver driver, String title) {
		Set<String> windows= driver.getWindowHandles();
		for(String win: windows) {
			driver.switchTo().window(win);
			String s = driver.getTitle();
			if(s.contains(title)) {
				break;
			}
		}
	}
	
	
	//Capture Screen shot
	
	
	public String captureSceenshot(WebDriver driver, String screenShot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
         File src=  ts.getScreenshotAs(OutputType.FILE);
         File dst = new File(".\\ScreenShots\\" +screenShot+ ".png");
        FileHandler.copy(src, dst);

          return dst.getAbsolutePath();
		
	}
	
	


}
