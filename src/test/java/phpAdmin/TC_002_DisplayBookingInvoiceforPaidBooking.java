package phpAdmin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_002_DisplayBookingInvoiceforPaidBooking extends BaseClass
{
	@Test(priority=1)
	public void login()
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@phptravels.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		boolean presence = driver.findElement(By.xpath("//p[@class='m-0 page_title']")).isDisplayed();
		
		AssertJUnit.assertEquals(presence, true);
		
		driver.findElement(By.xpath("//a[normalize-space()='Bookings']")).click();
	}
	
	@Test(priority=2)
	public void selectConfirmedandPaidBooking()
	{
		WebElement BookingStats = driver.findElement(By.xpath("//select[@name='booking_status']"));
		
		Select sl = new Select(BookingStats);
		sl.selectByVisibleText("Confirmed");
		
		WebElement PaymentStats = driver.findElement(By.xpath("//select[@name='payment_status']"));
		
		Select s2 = new Select(PaymentStats);
		s2.selectByVisibleText("Paid");
		
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
	}
	
	@Test(priority=3)
	public void displayBookingInvoice() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='Booking Details']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String winhand:windowHandles)
		{
			driver.switchTo().window(winhand);
			if(driver.getTitle().equals("Flights Invoice"))
			{
				
		Thread.sleep(3000);		
		boolean pres = driver.findElement(By.xpath("//table[1]")).isDisplayed();
		
		AssertJUnit.assertEquals(pres, true);
		
			}
		}
	}
}
