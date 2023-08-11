package phpAgent;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_ChangeUSDtoINR extends BaseClassTwo
{
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("agent@phptravels.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("demoagent");
		driver.findElement(By.xpath("//button[@id='submitBTN']")).click();
		Thread.sleep(3000);
		
		boolean presence = driver.findElement(By.xpath("//div[@class='author-content']")).isDisplayed();
		
		AssertJUnit.assertEquals(presence, true);
	}
	
	@Test(priority=2, dependsOnMethods="login")
	public void changeUSDtoINR() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle btn px-0 ps-3 text-center d-flex align-items-center justify-content-center gap-1 waves-effect']//*[name()='svg']")).click();
	
		List<WebElement> currencies = driver.findElements(By.xpath("//ul[@class='dropdown-menu rounded-1 show']//li//a"));
	
		Thread.sleep(3000);
		for(WebElement cur:currencies)
		{
			if(cur.getText().equals("INR"))
			{
				cur.click();
			}
		}
		
		boolean text = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[2]/a/strong")).getText().equals("USD");
		Thread.sleep(3000);
		AssertJUnit.assertEquals(text, true);
	
	}
}
