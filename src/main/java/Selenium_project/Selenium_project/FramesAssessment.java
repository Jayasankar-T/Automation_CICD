package Selenium_project.Selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssessment {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		WebElement firstFrame = driver.findElement(By.name("frame-top"));
		
		driver.switchTo().frame(firstFrame);
		
		WebElement middleFrame = driver.findElement(By.name("frame-middle"));
		
		driver.switchTo().frame(middleFrame);
		
		WebElement text = driver.findElement(By.id("content"));
		
		System.out.println(text.getText());	
	}
}
