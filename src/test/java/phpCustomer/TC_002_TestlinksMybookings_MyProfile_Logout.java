package phpCustomer;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_TestlinksMybookings_MyProfile_Logout extends BaseClassThree
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
	public void TestMyProfileLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='My Profile']")).click();
		
		boolean prese = driver.findElement(By.xpath("//h5[normalize-space()='Profile Information']")).isDisplayed();
		
		Assert.assertEquals(prese, true);
	}
	
	@Test(priority=4)
	public void TestLogoutLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='bg-light nav-link dropdown-toggle btn btn-outline-secondary px-0 ps-3 text-center d-flex align-items-center justify-content-center gap-2 border-0 waves-effect']//*[name()='svg']")).click();
		
		List<WebElement> Options = driver.findElements(By.xpath("//ul[@class='dropdown-menu bg-white rounded-4 show']//li//a"));
		
		for(WebElement opt: Options)
		{
			if(opt.getText().equals("Logout"))
			{
				opt.click();
			}
		}
		Thread.sleep(3000);
	}
	
}
