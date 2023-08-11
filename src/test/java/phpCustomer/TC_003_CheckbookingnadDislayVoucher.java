package phpCustomer;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_CheckbookingnadDislayVoucher extends BaseClassThree
{
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[@id='submitBTN']")).click();
		Thread.sleep(3000);
		
		boolean presence = driver.findElement(By.xpath("//div[@class='author-content']")).isDisplayed();
		
		Assert.assertEquals(presence, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void TestMyBookingsLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='My Bookings']")).click();
		Thread.sleep(3000);
		boolean pres = driver.findElement(By.xpath("//h3[normalize-space()='Bookings']")).isDisplayed();
		
		Assert.assertEquals(pres, true);
	}
	
	@Test(priority=3)
	public void displayBookingInvoice() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//table[@class='table table-striped table-bordered dataTable no-footer']//tbody//tr//td//a")).click();
		Thread.sleep(3000);
		
		Set<String> WindowHandles = driver.getWindowHandles();
		
		for(String winhnd:WindowHandles)
		{
			String hndl = driver.switchTo().window(winhnd).getTitle();
			if(hndl.equals("Hotels Invoice"))
			{
				System.out.println("Booking invoice displayed");
			}
		}
		
		Thread.sleep(3000);
	}
}
