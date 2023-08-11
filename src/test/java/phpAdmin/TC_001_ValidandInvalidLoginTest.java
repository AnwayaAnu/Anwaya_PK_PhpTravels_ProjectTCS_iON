package phpAdmin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import phpAgent.BaseClassTwo;

public class TC_001_ValidandInvalidLoginTest extends BaseClassTwo
{
	@Test(dataProvider="login")
	public void loginTest(String email, String pw, String text)
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@id='submitBTN']")).click();
		
		boolean presence = driver.findElement(By.xpath("//div[@class='lh-1 border rounded p-3 py-4 mb-2 text-center align-items-center gap-3']")).isDisplayed();
		
		AssertJUnit.assertEquals(presence, true);
		
		driver.findElement(By.xpath("//a[@class='bg-light nav-link dropdown-toggle btn btn-outline-secondary px-0 ps-3 text-center d-flex align-items-center justify-content-center gap-2 border-0 waves-effect']//*[name()='svg']")).click();
		
		List<WebElement> Options = driver.findElements(By.xpath("//ul[@class='dropdown-menu bg-white rounded-4 show']//li//a"));
		
		for(WebElement opt: Options)
		{
			if(opt.getText().equals(text))
			{
				opt.click();
			}
		}
		
	}
	
	@DataProvider(name="login")
	public Object [][]logindata()
	{
		Object [][]data = {{"user@phptravels.com", "demouser", "Logout"},
		                   {"admin@phptravels.com", "demoadmin", "Logout"}
						  };
		
		return data;
	}
}
