package Utils;

public final class Const {
	
		/*
		 * Definicion de nombres de navegadores
		 */
		public static final String firefox = "Firefox";
		public static final String chrome = "Chrome";
		public static final String IE = "InternetExplorer";
		
		/*
		 * Definicion de los parametros para instanciar el driver del respectivo navegador. 
		 */
		
		public static final String FirefoxKey = "webdriver.gecko.driver";
		public static final String FirefoxPath = "C:/geckodriver/geckodriver.exe";
		
		public static final String ChromeKey = "webdriver.chrome.driver";
		public static final String ChromePath = "C:/chromedriver/chromedriver.exe";
		
		public static final String IExplorerKey = "webdriver.ie.driver";
		public static final String IExplorerPath = "C:/IEdriver/IEDriverServer.exe";
		
		// Path para los screenshots
		public static final String ScreenShotPath = "C:/ScreenShots/";
		
		// Mensaje para las excepciones
		public static final String ExceptionMessage = "Se presenta la siguiente excepcion: ";
		
		
		/*
		 * Constantes para los tiempos de los Metodos Waits
		 */
		public static final int TimeOut = 40;
		public static final int VerificationTime = 5;
		public static final int TimeOutExplicit = 10;
		public static final int TimeOutImplict = 20;
		
		
		/*
		 * Constantes de los titulos de las paginas del sitio 
		 * requeridos para ser llamados por los Assert para comparaciones.
		 */
		public static final String titleMainPage = "My Store";
		public static final String titleLoginWeb = "Login - My Store";
		public static final String titleResultsProductWeb = "Search - My Store";
}
