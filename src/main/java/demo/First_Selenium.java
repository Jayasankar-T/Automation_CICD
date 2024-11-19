package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Selenium {
	
	public static void main(String[] args) throws Exception{
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("Jayasankar2303@gmail.com");
		Thread.sleep(2000);
		driver.close();
	}

}
