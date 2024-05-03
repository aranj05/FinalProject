package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Locate all elements
	@FindBy(id="user-name") WebElement userName;
	
	@FindBy(id="password") WebElement pwd;
	
	@FindBy(id="login-button") WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public void login(String strUser, String strPwd) {
		userName.sendKeys(strUser);
		pwd.sendKeys(strPwd);
		loginBtn.click();
	}

}
