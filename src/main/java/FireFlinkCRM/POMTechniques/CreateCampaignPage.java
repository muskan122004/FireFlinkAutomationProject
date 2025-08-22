package FireFlinkCRM.POMTechniques;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	
	 @FindBy(name = "campaignName") private WebElement campaignName;
	    @FindBy(name = "targetSize") private WebElement targetSize;
	    @FindBy(xpath = "//button[.='Create Campaign']") private WebElement createCampaign;
	    public  CreateCampaignPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	    public WebElement getCampaignName() {
	        return campaignName;
	    }
	    public WebElement getTargetSize() {
	        return targetSize;
	    }
	    public WebElement getCreateCampaign() {
	        return createCampaign;
	    }
	    
	    public void createCampaign(String name, String size) {
	        campaignName.clear();
	        campaignName.sendKeys(name);

	        targetSize.clear();
	        targetSize.sendKeys(size);

	        createCampaign.click();
	    }
	    
	   
}
