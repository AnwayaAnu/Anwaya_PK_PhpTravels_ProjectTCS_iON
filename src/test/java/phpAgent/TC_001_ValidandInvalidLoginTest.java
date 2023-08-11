package phpAgent;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidandInvalidLoginTest extends BaseClassTwo
{
	@Test(groups = {"Sanity"}, dataProvider="login")
	public void loginTest(String email, String pw, String text) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='submitBTN']")).click();
		
		boolean presence = driver.findElement(By.xpath("//div[@class='lh-1 border rounded p-3 py-4 mb-2 text-center align-items-center gap-3']")).isDisplayed();
		
		AssertJUnit.assertEquals(presence, true);
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='py-2 fadeout btn btn-outline-dark w-100 d-block mb-2 waves-effect']"))).click();
		
		Thread.sleep(3000);
		
	}
	
	@DataProvider(name="login")
	public Object [][]logindata()
	{
		Object [][]data = {{"agent@phptravels.com", "demoagent", "Logout"},
		                   {"admin@phptravels.com", "deoadmin", "Logout"}
		
		
						  };
		
		return data;
	}
}
