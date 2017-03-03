package Core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Const;

public class Common {
	WebDriver driver;
	
	/*
	 * Metodo para inicializar el driver respectivo
	 * del navegador en el que se deseen realizar los Tests.
	 * 
	 * 
	 */
	public static WebDriver instanceBrowser(WebDriver driver, String nameBrowser){
		if(nameBrowser.equalsIgnoreCase(Const.firefox)){
			System.setProperty(Const.FirefoxKey, Const.FirefoxPath);
			driver = new FirefoxDriver();
		}else if(nameBrowser.equalsIgnoreCase(Const.chrome)){
			System.setProperty(Const.ChromeKey, Const.ChromePath);
			driver = new ChromeDriver();
		}else if(nameBrowser.equalsIgnoreCase(Const.IE)){
			System.setProperty(Const.IExplorerKey, Const.IExplorerPath);
			driver = new InternetExplorerDriver();
		}
		return driver;
	}	

	
	/*
	 * Metodos personalizados para el SendKeys, getTitle y el Click 
	 * que traen por defecto los WebElements.
	 */
	
	public static void setText(WebElement element, String text){
		element.sendKeys(text);
	}
	
	public static String getTitlePage(WebDriver driver){
		return driver.getTitle();
	}
	public static void OnClick(WebElement element){
		element.click();
	}


	/*
	 *  Metodos para el funcionamiento de los explicitWaits e implicitWait.
	 */
	
	public static boolean FluentWait(WebElement element){
		return new FluentWait<WebElement>(element)
				.withTimeout(Const.TimeOut, TimeUnit.SECONDS)
				.pollingEvery(Const.VerificationTime, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.until(new Function<WebElement, Boolean>(){
					@Override
					public Boolean apply(WebElement d){
						return d.isDisplayed();
					}
				});
			}
	
	
	public static WebElement ExplicitWait(WebDriver driver, WebElement e){
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Const.TimeOutExplicit);
		element = wait.until(ExpectedConditions.visibilityOf(e));
		return element;
	}
	
	
	public static void ImplicitWait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Const.TimeOutImplict, TimeUnit.SECONDS);
	}
	
	
	/*
	 *  Metodo para realizar los screenshots cuando se cumpla una 
	 *  condicion respectiva en el Test.
	 */
	
	public static void captureScreenShot(WebDriver driver){
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File(Const.ScreenShotPath+System.currentTimeMillis()+".png"));
		}
		catch(IOException e)
		{
			System.out.println(Const.ExceptionMessage + e.getMessage());
		}
	}
		
}
