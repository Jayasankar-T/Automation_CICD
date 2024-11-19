package Selenium_project.Selenium_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assessment_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String selected = driver.findElement(By.xpath("//label[@for='benz']")).getText();
//		System.out.println(selected);
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select option = new Select(dropdown);
		option.selectByVisibleText(selected);
		
		driver.findElement(By.id("name")).sendKeys(selected);
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
//		System.out.println(text);
		
		if(text.contains(selected)) {
			alert.accept();
			driver.quit();
			System.out.println("Selected option is available in the alert message");
		}
		else {
			driver.quit();
			System.out.println("Selected option is not available in the alert message");
		}
	}

}
