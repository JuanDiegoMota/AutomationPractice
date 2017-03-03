package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.Common;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		
		//Metodo para inicializar WebElement
		PageFactory.initElements(driver, this);
	}
	
	//Definicion de los WebElement 
	@FindBy(id="email")
	WebElement inputEmail;
	
	@FindBy(id="passwd")
	WebElement inputPass;
	
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	
	public void setLogin(String email, String pass){
		Common.ExplicitWait(driver, inputEmail);
		Common.setText(inputEmail, email);
		Common.setText(inputPass, pass);
		Common.OnClick(signInButton);
		//CoreEventsPage.StopImplicit(driver);
	}
	
	
}
