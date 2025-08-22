package FireFlinkCRM.POMTechniques;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(id="username") private WebElement UserNameTF;
	@FindBy(name="password") private WebElement PasswordTF;
	@FindBy(xpath="//button[.='Sign In']") private WebElement UsernameTF;
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}


	public WebElement getUserNameTF() {
		return UserNameTF;
	}


	public WebElement getPasswordTF() {
		return PasswordTF;
	}


	public WebElement getUsernameTF() {
		return UsernameTF;
	}
	
	//Login to Application
	
	public void LoginPage(String username,String password) {
		
		UserNameTF.sendKeys(username);
		PasswordTF.sendKeys(password);
		UsernameTF.click();
		
	}
	
	
	
}
