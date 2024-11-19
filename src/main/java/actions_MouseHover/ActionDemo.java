package actions_MouseHover;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
	
	public static void main(String[] args) {
		 WebDriver driver =  new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.amazon.in/");
		 
		 WebElement hover = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		 
		 Actions a = new Actions(driver);
		 
//		 
		 
		 WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		 
		 a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		 
		 a.moveToElement(hover).contextClick().build().perform();
		 
		 WebElement mobiles = driver.findElement(By.linkText("Mobiles"));
		 
		 System.out.println(mobiles.getLocation());
		 
	}

}
