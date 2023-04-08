package PKG1;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	/*
	 * 
	 * JDK 1.8 - environment variables - JAVA_HOME
	 * MVN_HOME
	 * Create maven project
	 * Eclipse
	 * Add Selenium and WebDriverManager dep
	 * 
	 * 
	 */
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	/*
	 * 
	 * Parent child1 = new Child1();
	 * Parent child2 = new Child2();
	 * 
	 */

	public static void main(String[] args) {
		
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}

		String expectedTitle = "http://google.com";	
		//driver.get("http://google.com");
		driver.navigate().to(expectedTitle);
		//driver.navigate().refresh();123
		String title = driver.getTitle();
		System.out.println(title.length());
		System.out.println(title);

		
		//SoftAssert sa = new SoftAssert();
		Assert.assertEquals("google.com", expectedTitle);

		if(title.equals(expectedTitle))
			System.out.println("Test Case pass");
		else
			System.out.println("Test case fail");
		
		
		//driver.close();//close current browser
		driver.quit();//close current browser + all related browser windows + session
		
	}

}
