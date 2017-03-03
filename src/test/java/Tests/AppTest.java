package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Core.Common;
import Pages.BuyProductPage;
import Pages.LoginPage;
import Pages.PrincipalPage;
import Pages.ProductsResultsPage;
import Pages.SearchProductPage;
import Utils.Const;

public class AppTest {
	WebDriver driver;

	
	LoginPage LoginPage;
	PrincipalPage MainPage;
	SearchProductPage SearchProductPage;
	ProductsResultsPage SelectProductPage;
	BuyProductPage BuyProductPage;
	
	public AppTest(){
		driver = Common.instanceBrowser(driver, Const.firefox);
		LoginPage = new LoginPage(driver);
		MainPage = new PrincipalPage(driver);
		SearchProductPage = new SearchProductPage(driver);
		SelectProductPage = new ProductsResultsPage(driver);
		BuyProductPage = new BuyProductPage(driver);
	}
	
	@BeforeTest
	@Parameters({"URL"})
	public void navigate(String url){
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), Const.titleMainPage );
	}
	
	
	@Test(priority=2)
	public void goToLogin(){
		MainPage.goToMyAccount();
		Assert.assertNotEquals(MainPage, LoginPage);
	}
	
	@Test(priority=3)
	@Parameters({"mail", "pass"})
	public void initSession(@Optional("No hay mail") String mail, @Optional("No hay password") String pass){
		LoginPage.setLogin(mail, pass);
		Assert.assertEquals(driver.getTitle(), Const.titleLoginWeb);
	}
	
	@Test(priority=4)
	@Parameters({"nameProduct"})
	public void searchProductInStore(String productName){
		SearchProductPage.searchProduct(productName);
		Assert.assertNotEquals(LoginPage, SearchProductPage);
	}
	
	@Test(priority=5)
	public void selectProduct(){
		SelectProductPage.selectProduct();
		Assert.assertNotEquals(SelectProductPage, SearchProductPage);
	}
	
	@Test(priority=6)
	public void buyProduct(){
		BuyProductPage.addProductToCar();
		Assert.assertNotEquals(SelectProductPage, BuyProductPage);
	}
	
	@AfterMethod
	public void OnFailure(ITestResult testResult){
		if(testResult.getStatus()== ITestResult.FAILURE){
			Common.captureScreenShot(driver);
		}else{
			System.out.println("La prueba fue exitosa");
		}
	}
}