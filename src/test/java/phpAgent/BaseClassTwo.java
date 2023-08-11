package phpAgent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClassTwo 
{
	public WebDriver driver;
	@BeforeMethod
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phptravels.net/login");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
