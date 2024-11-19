package Selenium_project.Selenium_project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_Count {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int checkbox_count = 0;

		for (int i = 0; i < checkboxs.size(); i++) {
			checkbox_count++;
		}
		System.out.println("Total Number of Checkboxes in the page is :"+checkbox_count);
		driver.close();
	}
	
}
