package shopping;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EKart {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		// Expected Items
		String[] items = { "Cucumber","Brocolli","Beetroot"};
		
		addItems (driver, items);
		addcart(driver,wait);
		
		System.out.println("Program run completed");
		driver.quit();
	}
	
	public static void addcart(WebDriver driver, WebDriverWait wait) {
		
		WebElement cart = driver.findElement(By.cssSelector("img[alt='Cart']"));
		cart.click();
		WebElement proceedToCheckout =  driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		proceedToCheckout.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		WebElement promocode = driver.findElement(By.cssSelector("input.promoCode"));
		promocode.sendKeys("rahulshettyacademy");
		
		WebElement applyCoupon = driver.findElement(By.cssSelector("button.promoBtn"));
		applyCoupon.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		WebElement message = driver.findElement(By.cssSelector("span.promoInfo"));
		
		
		
		message.getText();
		System.out.println(message.getText());
	}
	
 	public static void addItems(WebDriver driver, String[] items) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String namecompare = name[0].trim();
//			System.out.println(namecompare);
			
			List itemsList = Arrays.asList(items);

			int j = 0;
			if (itemsList.contains(namecompare)) {
				j++;
				WebElement cart = driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i);
				cart.click();
				if (j == items.length) {
					break;
				}
			}
		}
	}
}