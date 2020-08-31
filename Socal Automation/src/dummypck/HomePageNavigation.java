package dummypck;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageNavigation {
	WebDriver driver;
	String homePage = "https://www.socalgas.com";
	int statusCode;

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(homePage);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void f(){
		List<WebElement> allLink = driver.findElements(By.xpath("//a[@class='main-nav__link']"));
		System.out.println("Total no of links Available: " + allLink.size());
		String href;
		for(WebElement link : allLink) {
            href = link.getAttribute("href");
            

            if(200 != statusCode) {
                System.out.println(href + " gave a response code of " + statusCode);
            }
        }
//		
	}

	@AfterTest
	public void terminateBrowser() {
		driver.quit();
		System.out.println("Home page Navigation");
	}
}
