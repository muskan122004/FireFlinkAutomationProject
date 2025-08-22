package FireFlinkCRM.POMTechniques;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	
	 @FindBy(xpath = "//select[@class='form-control']") private WebElement searchCampaigns;
	    @FindBy(xpath = "//input[@placeholder='Search by Campaign Id']") private WebElement searchTextField;
	    @FindBy(xpath = "//span[.='Create Campaign']") private WebElement createCampaign;
	    @FindBy(xpath = "//div[contains(text(),'Successfully Added') and contains(text(),'Campaign')]") private WebElement succcessfullyAddedMsg;
	    public CampaignPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	    public WebElement getSearchCampaigns() {
	        return searchCampaigns;
	    }
	    public WebElement getSearchTextField() {
	        return searchTextField;
	    }
	    public WebElement getCreateCampaign() {
	        return createCampaign;
	    }
	    public WebElement getSucccessfullyAddedMsg() {
	        return succcessfullyAddedMsg;
	    }
	    public void searchCampaignById(String campaignId) {
	        // Assuming you want to select the search criteria first (if dropdown is relevant)
	        // If you want to select a specific option, add logic here, e.g., using Select class

	        // Enter campaign ID in search field
	        searchTextField.clear();
	        searchTextField.sendKeys(campaignId);
	        
	        // Click on Create Campaign button (if this triggers search or creation)
	        createCampaign.click();
	    }

	    public boolean isCampaignAddedSuccessfully() {
	        try {
	            // Check if the success message is displayed
	            return succcessfullyAddedMsg.isDisplayed();
	        } catch (Exception e) {
	            // If element is not found or not visible, return false
	            return false;
	        }
	    }

}
