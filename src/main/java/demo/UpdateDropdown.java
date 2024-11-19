package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		WebElement expand_list = driver.findElement(By.id("divpaxinfo"));
//		expand_list.click();
//		Thread.sleep(1000);
//		WebElement add = driver.findElement(By.id("hrefIncAdt"));
//		
////		int i=1;
////		while(i<5) {
////			add.click();
////			i++;
////		}
//		
//		for (int i=1;i<5;i++) {
//			add.click();
//		}
		
//		Thread.sleep(1000);
//		WebElement done = driver.findElement(By.id("btnclosepaxoption"));
//		done.click();
//		System.out.println(expand_list.getText());
//		
//		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		Select option = new Select(dropdown);
//		
//		option.selectByValue("INR");
//		Thread.sleep(2000);
		
		String return_date = driver.findElement(By.id("Div1")).getAttribute("style");	
		System.out.println(return_date);
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		Thread.sleep(1000);
		String return_date2 = driver.findElement(By.id("Div1")).getAttribute("style");
		
		
		if(return_date2.contains("1")) {
			System.out.println("Is Enabled");
		}
		else {
			System.out.println("Is Disabled");
		}
		driver.close();
	}

}
