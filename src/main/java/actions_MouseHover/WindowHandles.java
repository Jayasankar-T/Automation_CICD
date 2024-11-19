package actions_MouseHover;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandles {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebElement link = driver.findElement(By.xpath("//a[@class='blinkingText']"));
		link.click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		WebElement text = driver.findElement(By.cssSelector("p.im-para.red"));
		
		String message = text.getText();
		
		String mail = message.split("at")[1].split("with")[0].trim();
		System.out.println(mail);
		
		driver.switchTo().window(parentId);
		
		WebElement username = driver.findElement(By.id("username"));
		
		username.sendKeys(mail);
		
		
	}

}
