package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicDropdown {
	
	public static void main(String[] args) throws Exception{
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		from.click();
		from.sendKeys("MAA");
		
		Thread.sleep(1000);
		WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		to.sendKeys("BLR");
		
		Thread.sleep(1000);

		WebElement select_date = driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']"));
		select_date.click();
		
		WebElement expand_list = driver.findElement(By.id("divpaxinfo"));
		expand_list.click();
		Thread.sleep(1000);
		
		WebElement add = driver.findElement(By.id("hrefIncAdt"));
		
		for (int i=1;i<5;i++) {
			add.click();
			
		}
		System.out.println(expand_list.getText());
		Assert.assertEquals(expand_list.getText(),"5 Adult");
		Thread.sleep(1000);
		WebElement done = driver.findElement(By.id("btnclosepaxoption"));
		done.click();
		
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select option = new Select(dropdown);
		Thread.sleep(1000);
		option.selectByValue("INR");
		Thread.sleep(2000);
		
		
		System.out.println("Program done");
		driver.close();
	}

}
