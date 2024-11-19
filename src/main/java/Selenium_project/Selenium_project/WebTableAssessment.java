package Selenium_project.Selenium_project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssessment {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		
		System.out.println("Number of rows: "+rows.size());
		
		List<WebElement> column = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		System.out.println("Number of column: "+column.size());
		
		WebElement secondrows = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));
		System.out.println(secondrows.getText());
		
		driver.quit();
	}

}
