package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		String date = "23";
		String month = "6";
		String year = "2027";
		
		String[] expected = {month,date,year};
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
		driver.findElement(By.xpath("//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()="+year+"]")).click();
		
		driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']/button")).get(Integer.parseInt(month)-1).click();
		
		
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
	
		List<WebElement> selectedDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		
		for (int i =0; i<selectedDate.size();i++) {
			String data = selectedDate.get(i).getAttribute("value");
			System.out.println(data);
			Assert.assertEquals(data, expected[i]);
		}
		
		}

}
