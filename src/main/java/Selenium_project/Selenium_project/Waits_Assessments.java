package Selenium_project.Selenium_project;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits_Assessments {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("rahulshettyacademy");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("learning");
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=' User']")));
		
		WebElement user = driver.findElement(By.xpath("//span[text()=' User']"));
		user.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		WebElement okBtn = driver.findElement(By.xpath("//button[@id='okayBtn']"));	
		okBtn.click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select options = new  Select(dropdown);
		options.selectByValue("consult");
		WebElement terms = driver.findElement(By.name("terms"));
		terms.click();
		
		WebElement submit = driver.findElement(By.id("signInBtn"));
		submit.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));
		
		List <WebElement> cart = driver.findElements(By.xpath("//div[@class='card-body']"));
				
		for(int i =0; i< cart.size();i++) {
			WebElement add = driver.findElements(By.xpath("//button[text()='Add ']")).get(i);
			add.click();
		}
		
		WebElement checkout = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"));
		checkout.click();
	}
}
