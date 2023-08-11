package phpCustomer;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_UpdateAddressDatadriven extends BaseClassThree
{
	String data ="";
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
	public void TestMyProfileLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='My Profile']")).click();
		Thread.sleep(3000);
		
		boolean prese = driver.findElement(By.xpath("//h5[normalize-space()='Profile Information']")).isDisplayed();
		
		Assert.assertEquals(prese, true);
	}
	
	@Test(priority=3)
	public void updateAddress() throws IOException, InterruptedException
	{
		FileInputStream fin = new FileInputStream("/Users/anwaya/eclipse-workspace/PHPTravels_TcsiON/testdata/CustomerTestCase.xlsx");
	
	
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		
		XSSFSheet sheet = workbook.getSheet("data");
		
		for(int i=0;i<2;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<2;j++)
			{
				XSSFCell cell = row.getCell(j);
				
				data = data+cell.toString();
			
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[5]//div[1]//div[1]//input[1]")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[5]//div[1]//div[1]//input[1]")).sendKeys(data);
	
	
		String value = driver.findElement(By.xpath("//div[5]//div[1]//div[1]//input[1]")).getAttribute("value");
		Thread.sleep(3000);
		Assert.assertEquals(value, data);
		driver.findElement(By.xpath("//button[normalize-space()='Update Profile']")).click();
		
	}
}
