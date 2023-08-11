package phpAgent;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_SearchHotelsByCity extends BaseClassTwo
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
	public void ClickHotelsLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Hotels']")).click();
		Thread.sleep(3000);
		boolean pres = driver.findElement(By.xpath("//strong[normalize-space()='Search for best hotels']")).isDisplayed();
		
		AssertJUnit.assertEquals(pres, true);
	}
	
	@Test(priority=3, dependsOnMethods="ClickHotelsLink")
	public void SearchHotel() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//b[@role='presentation']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"select2-hotels_city-results\"]/div/div[1]")).click();
		
		//driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Dubai, United Arab Emiratesw");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		boolean result = driver.findElement(By.xpath("//span[@class='j_listABTit']")).isDisplayed();
		
		AssertJUnit.assertEquals(result, true);
	}
}
