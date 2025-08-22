package CreateCampaign;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FireFlinkCRM.POMTechniques.CampaignPage;
import FireFlinkCRM.POMTechniques.CreateCampaignPage;
import FireFlinkCRM.POMTechniques.DashBoardPage;
import FireFlinkCrmTask.UtilityMethods.BaseClass;



public class TestNGPractise extends BaseClass {
	
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException {

		//Read Data from Excel
		String CAMPAIGNID = fUtil.readDatafROMExcelFile("Sheet1",41, 2);
		String TargetSize = fUtil.readDatafROMExcelFile("Sheet1",41, 3);
		
	DashBoardPage dbp = new DashBoardPage(driver);
	dbp.getCampaignsL().click();
	
	Reporter.log("Clicked on create button", true);
	CampaignPage cp= new CampaignPage(driver);
	cp.getCreateCampaign().click();
	Reporter.log("Clicked on create Campaign button", true);
	Assert.fail();
	CreateCampaignPage ccp = new CreateCampaignPage(driver);
	ccp.createCampaign(CAMPAIGNID, TargetSize);
	Reporter.log("Clicked on create button", true);

	}
	
}
