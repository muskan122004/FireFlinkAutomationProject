package PractisingTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import FireFlinkCRM.POMTechniques.CampaignPage;
import FireFlinkCRM.POMTechniques.CreateCampaignPage;
import FireFlinkCRM.POMTechniques.DashBoardPage;
import FireFlinkCrmTask.UtilityMethods.BaseClass;


@Listeners(FireFlinkCrmTask.UtilityMethods.ListenerImplementations.class)
public class TestNGPractise1 extends BaseClass {
	
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException {

		//Read Data from Excel
		String CAMPAIGNID = fUtil.readDatafROMExcelFile("Sheet1",41, 2);
		String TargetSize = fUtil.readDatafROMExcelFile("Sheet1",41, 3);
		Assert.fail();
	DashBoardPage dbp = new DashBoardPage(driver);
	dbp.getCampaignsL().click();
	
	CampaignPage cp= new CampaignPage(driver);
	cp.getCreateCampaign().click();
	CreateCampaignPage ccp = new CreateCampaignPage(driver);
	
	
	ccp.createCampaign(CAMPAIGNID, TargetSize);

	}
	
}
