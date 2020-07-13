package setup;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Framework;

public class Hooks {
	
	public static ResourceBundle bundle = ResourceBundle.getBundle("application");
	
	public static WebDriver driver;
	
	@Before
	public void startTest() {
		
		
		switch (bundle.getString("env.navegador").toUpperCase()) {
		
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", bundle.getString("env.path.driver.chrome"));
				driver = new ChromeDriver();
				break;
			
			case "IE":
				System.setProperty("webdriver.ie.driver", bundle.getString("env.path.driver.ie"));
				driver = new InternetExplorerDriver();
				break;
	
			default:
				System.out.println("Opção de Browser incorreta.");
		}
		
		
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(bundle.getString("env.timeout")), TimeUnit.SECONDS);
		driver.get(bundle.getString("env.url.broadleaf"));
		driver.manage().window().maximize();
		
//		if(bundle.getString("env.window.maximize").equals("true"))
//			driver.manage().window().fullscreen();
	}
	
	
	@After
	public void tearDown(Scenario scenario) { 
		Framework.screenshot(scenario);
		driver.close();
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
