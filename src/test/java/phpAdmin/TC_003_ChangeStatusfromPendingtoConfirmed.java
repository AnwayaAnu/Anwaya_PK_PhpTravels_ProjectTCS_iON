package phpAdmin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_ChangeStatusfromPendingtoConfirmed extends BaseClass
{
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@phptravels.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		boolean presence = driver.findElement(By.xpath("//p[@class='m-0 page_title']")).isDisplayed();
		
		AssertJUnit.assertEquals(presence, true);
		
		String countbefore  = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[1]/div[3]/div/div/div/div[1]/div[2]")).getText();
		System.out.println("Total count before changing status: "+countbefore);
		
		driver.findElement(By.xpath("//a[normalize-space()='Bookings']")).click();
	

	
		WebElement BookingStats = driver.findElement(By.xpath("//select[@name='booking_status']"));
		
		Select sl = new Select(BookingStats);
		sl.selectByVisibleText("Pending");
		
		WebElement PaymentStats = driver.findElement(By.xpath("//select[@name='payment_status']"));
		
		Select s2 = new Select(PaymentStats);
		s2.selectByVisibleText("Unpaid");
		
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//a[normalize-space()='Booking Details']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> Winhandles = new ArrayList(windowHandles);
		
		String newWindow = Winhandles.get(1);
		
		driver.switchTo().window(newWindow);
		Thread.sleep(3000);
	
	
		driver.findElement(By.xpath("//input[@id='form']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='jsx-iframe-abffcbdcff']")));
		
		driver.findElement(By.xpath("//body")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//span[@class='fw-semibold']")).click();
		
		String count  = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[1]/div[3]/div/div/div/div[1]/div[2]")).getText();
		System.out.println("Total count: "+count);

	}
	
}
