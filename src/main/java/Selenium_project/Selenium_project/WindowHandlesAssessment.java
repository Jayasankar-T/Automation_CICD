package Selenium_project.Selenium_project;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAssessment {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		WebElement childWindow = driver.findElement(By.linkText("Click Here"));
		childWindow.click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		WebElement childText = driver.findElement(By.cssSelector(".example"));
		String message = childText.getText();
		System.out.println(message);
		
		driver.switchTo().window(parentId);
		
		WebElement parentText = driver.findElement(By.xpath("//div[@class='example']/h3"));
		String parent_message = parentText.getText();
		System.out.println(parent_message);
		
		driver.quit();
	}

}
