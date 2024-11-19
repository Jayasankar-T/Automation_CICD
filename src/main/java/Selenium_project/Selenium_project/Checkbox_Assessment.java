package Selenium_project.Selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_Assessment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
		checkbox.click();
		checkbox_check(checkbox.isSelected());

		checkbox.click();
		checkbox_check(checkbox.isSelected());
		
		driver.close();		
	}

	public static void checkbox_check(boolean value) {
		if (value == true) {
			System.out.println("Checkbox Enabled");
		} else {
			System.out.println("Checkbox Disabled");
		}
	}
}