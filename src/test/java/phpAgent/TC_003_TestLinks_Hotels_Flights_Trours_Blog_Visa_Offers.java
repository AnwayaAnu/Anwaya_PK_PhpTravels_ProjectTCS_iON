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

public class TC_003_TestLinks_Hotels_Flights_Trours_Blog_Visa_Offers extends BaseClassTwo
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
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void TestHotelsLink() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[normalize-space()='Hotels']")).click();
		Thread.sleep(3000);
		boolean pres = driver.findElement(By.xpath("//strong[normalize-space()='Search for best hotels']")).isDisplayed();
		
		AssertJUnit.assertEquals(pres, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void TestFlightLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Flights']")).click();
		Thread.sleep(3000);
		boolean prese = driver.findElement(By.xpath("//strong[normalize-space()='Search for best Flights']")).isDisplayed();
		
		AssertJUnit.assertEquals(prese, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void TestToursLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Tours']")).click();
		Thread.sleep(3000);
		boolean tourPresent = driver.findElement(By.xpath("//strong[normalize-space()='Find Best Tours']")).isDisplayed();
		AssertJUnit.assertEquals(tourPresent, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void TestCarsLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Cars']")).click();
		Thread.sleep(3000);
		boolean isCar = driver.findElement(By.xpath("//h5//strong[contains(text(),'Transfer Cars')]")).isDisplayed();
	
		AssertJUnit.assertEquals(isCar, true);
	
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void TestBlogsLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Blogs']")).click();
		
		boolean blg = driver.findElement(By.xpath("//h2[normalize-space()='PHPTRAVELS Blogs']")).isDisplayed();
		Thread.sleep(3000);
		AssertJUnit.assertEquals(blg, true);
		Thread.sleep(3000);
		
	}

}

