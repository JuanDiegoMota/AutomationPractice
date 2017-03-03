package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.Common;

public class ProductsResultsPage {
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[4]/div/div[2]/h5/a")
	WebElement product;
	
	public ProductsResultsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(){
		Common.ExplicitWait(driver, product);
		Common.OnClick(product);
	}
	
	
}
