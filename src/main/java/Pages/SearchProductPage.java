package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.Common;

public class SearchProductPage {
	WebDriver driver;
	
	@FindBy(css="#search_query_top")
	WebElement inputNameProduct;
	
	@FindBy(css=".button-search")
	WebElement searchProductButton;
	
	public SearchProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product){
		Common.ImplicitWait(driver);
		Common.setText(inputNameProduct, product);
		Common.OnClick(searchProductButton);
	}
}
