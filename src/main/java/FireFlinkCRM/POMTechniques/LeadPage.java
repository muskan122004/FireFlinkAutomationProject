package FireFlinkCRM.POMTechniques;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadPage {

	 @FindBy(xpath = "//select[@class='form-control']") private WebElement searchLeads;
	    @FindBy(xpath = "//input[@placeholder='Search by Lead Id']") private WebElement searchTextField;
	    @FindBy(xpath = "//span[.='Create Lead']") private WebElement createLeadBtn;
	    
	    public LeadPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	    
	    public WebElement getSearchLeads() {
	        return searchLeads;
	    }
	    public WebElement getSearchTextField() {
	        return searchTextField;
	    }
	    public WebElement getCreateLeadBtn() {
	        return createLeadBtn;
	    }
	    
	    public void SeachLead(String searchLeads, String searchTextField ) {
	    	
	    }

public void searchLead(String leadType, String leadId) {
    // Select the value from dropdown (searchLeads)
    Select select = new Select(this.searchLeads);
    select.selectByVisibleText(leadType); // or selectByValue if preferred

    // Enter lead ID or search text
    this.searchTextField.clear();
    this.searchTextField.sendKeys(leadId);
    
    // Optionally, if there's a search button, click it here
    // For now, just entering values assuming live search or further action is triggered elsewhere
}
	    
}
