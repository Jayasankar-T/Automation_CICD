package Selenium_project.Selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assessment_1 {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Jayasankar T");
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("jayasankar2303@gmail.com");
	
		WebElement password = driver.findElement(By.id("exampleInputPassword1"));
		password.sendKeys("Jai@2303");
		
		WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
		checkbox.click();
		
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select option = new Select(gender);
		option.selectByVisibleText("Male");
		
		WebElement employment_status = driver.findElement(By.id("inlineRadio1"));
		employment_status.click();
		
		WebElement dob = driver.findElement(By.name("bday"));
		dob.sendKeys("23-03-1997");
		
		WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-success']"));
		submit.click();
		
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		alert.getText();
		System.out.println(alert.getText());
	}
}
