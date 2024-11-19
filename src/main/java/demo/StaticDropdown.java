package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		Dropdown
		
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select option = new Select(dropdown);
		
		option.selectByValue("INR");
		Thread.sleep(2000);
		
		option.selectByVisibleText("AED");
		Thread.sleep(2000);
		
		option.selectByIndex(3);
		Thread.sleep(2000);
		driver.close();
		
	}

}
