package shopping;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitProgram {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebElement start = driver.findElement(By.cssSelector("[id='start'] button"));
		start.click();
		
//		Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='finish'] h4")));
		
//		Fluent Wiat
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
		    		 return driver.findElement(By.cssSelector("[id='finish'] h4"));
		    	 }
		    	 else {
		    		 return null;
		    	 }
		       
		     }
		   });
		
		
		WebElement message = driver.findElement(By.cssSelector("[id='finish'] h4"));
		System.out.println(message.getText());
	}

}
