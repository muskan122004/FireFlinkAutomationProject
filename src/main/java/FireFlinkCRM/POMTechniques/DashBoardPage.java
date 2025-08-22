package FireFlinkCRM.POMTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	

	@FindBy(xpath="//a[.='Campaigns']") private WebElement CampaignsH;
	@FindBy(xpath="//a[.='Contacts']") private WebElement Contacts;
	@FindBy(xpath="//a[.='Leads']") private WebElement Leads;
	@FindBy(xpath="//a[.='Opportunities']") private WebElement Opportunities ;
	@FindBy(xpath="//a[.='Products']") private WebElement Products;
	@FindBy(xpath="//a[.='Quotes']") private WebElement Quotes;
	@FindBy(xpath="Purchase Order") private WebElement PurchaseOrder ;
	@FindBy(xpath="//a[.='Sales Order']") private WebElement SalesOrder;
	@FindBy(xpath="//a[.='Invoice']") private WebElement Invoice;
	@FindBy(xpath="Admin Console") private WebElement AdminConsole ;
	
	@FindBy(xpath="//div[@class='user-icon']") private WebElement UserIcon ;
	
	
	   public DashBoardPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	    public WebElement getCampaignsL() {
	        return CampaignsH;
	    }
	    public WebElement getContactsL() {
	        return Contacts;
	    }
	    public WebElement getLeadsL() {
	        return Leads;
	    }
	    public WebElement getOpportunitiesL() {
	        return Opportunities;
	    }
	    public WebElement getProductsL() {
	        return Products;
	    }
	    public WebElement getQuotesL() {
	        return Quotes;
	    }
	    public WebElement getPurchaseOrderL() {
	        return PurchaseOrder;
	    }
	    public WebElement getSalesOrderL() {
	        return SalesOrder;
	    }
	    public WebElement getInvoiceL() {
	        return Invoice;
	    }
	    public WebElement getAdminConsoleL() {
	        return AdminConsole;
	    }
	    
	    public boolean isUserLoggedIn() {
	        try {
	            return UserIcon.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
		public static WebElement getUserIcon() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void logOut(WebDriver driver) {
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
			driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		}
	

  
}
