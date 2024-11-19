package sample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
//		Give the count of links in the web page
		int linksCount = links.size();
		System.out.println(linksCount);
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		List<WebElement> footerlinks = footer.findElements(By.tagName("a"));
//		Give the count of links in the footer section	
		int footerLinksCount = footerlinks.size();
		System.out.println(footerLinksCount);
		
		
		WebElement firstblockLinks = footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		// Give the count of links in the first section links in the footer
		List<WebElement> blockLinksCount = firstblockLinks.findElements(By.tagName("a"));
		System.out.println(blockLinksCount.size());
//		Opening links in new tab
		for (int i=1;i<blockLinksCount.size(); i++) {
			String clickon = Keys.chord(Keys.CONTROL,Keys.ENTER);
			blockLinksCount.get(i).sendKeys(clickon);
		}
		// fetching the titles from the opened tabs
		Set<String> windows = driver.getWindowHandles();
		
		 Iterator<String> it = windows.iterator();
		 
		 for (int i =0;i<windows.size();i++) {
			 WebDriver new_window = driver.switchTo().window(it.next());
			 System.out.println(new_window.getTitle());
		 }
	}
}