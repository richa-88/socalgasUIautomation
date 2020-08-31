package dummypck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DummyClass {
	WebDriver driver;

	// This will load csv file 
//	 CSVReader reader = new CSVReader(new FileReader("C:\\Users\\admin\\Downloads\\url.csv"));
	String firefox_fonr_family = ("Arial, Helvetica, \"sans-serif\"").replaceAll("\"", "");

	@Parameters("browser")
	@BeforeTest()
	public void setUpTest(String browser) {
		
		switch (browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get("https://www.socalgas.com/rebates");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void RebatesAndIncentiveDesignVerification() {
		// Title xpath Rebates And Incentive
		WebElement rAndI_Title_xpath = driver.findElement(
				By.xpath("//h1/div[contains(@class, 'field--title') and text() = ' Rebates and Incentives']"));
		String rAndI_Actual_Title_FontSize = rAndI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", rAndI_Actual_Title_FontSize);

		String rAndIActual_Title_fontFamily = rAndI_Title_xpath.getCssValue("font-family");
		if (firefox_fonr_family.equals("Chrome")) {
			Assert.assertEquals(firefox_fonr_family, rAndIActual_Title_fontFamily);
		}
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
