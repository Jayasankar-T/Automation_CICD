package sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	

	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500);");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int totalCount = 0;
		for(int i=0;i<values.size();i++) {
			int  total = Integer.parseInt(values.get(i).getText());
			totalCount = totalCount+total;
			
		}
		System.out.println(totalCount);
		
		String output = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		int newvalue = Integer.parseInt(output.split(":")[1].trim());
		
		Assert.assertEquals(totalCount, newvalue);
		
		driver.quit();
		
	}

	
}
