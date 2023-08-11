package phpCustomer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TC_001_ValidandInvalidLoginTest extends BaseClassThree
{
	@Test(groups = {"Sanity"}, dataProvider="login")
	public void loginTest(String email, String pw, String text) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='submitBTN']")).click();
		Thread.sleep(3000);
		
		boolean presence = driver.findElement(By.xpath("//div[@class='author-content']")).isDisplayed();
		
		Assert.assertEquals(presence, true);
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[4]/a"))).click();
		
		Thread.sleep(3000);
		
	}
	
	@DataProvider(name="login")
	public Object [][]logindata()
	{
		Object [][]data = {{"userq@phptravels.com", "demouser", "Logout"},
		                   {"user@phptravels.com", "demouser", "Logout"}
		
		
						  };
		
		return data;
	}
}
