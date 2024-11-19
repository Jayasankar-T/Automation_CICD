package demo;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {
	
	public static void main(String[] args) {
		//Chrome
		ChromeOptions options = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("idaddress:444");
		options.setCapability("proxy", proxy);
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		
		//Firefox
//		FirefoxOptions options = new FirefoxOptions();
//		options.setAcceptInsecureCerts(true);
//		WebDriver driver = new FirefoxDriver(options);
		
		//Edge
//		EdgeOptions options = new EdgeOptions();
//		options.setAcceptInsecureCerts(true);
//		WebDriver driver = new EdgeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
	}

}
