package socaldesignautomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocalBillAssistance26 {
	WebDriver driver;
	String firefox_font_family = ("Arial, Helvetica, \"sans-serif\"").replaceAll("\"", "");
	JSONParser parser = new JSONParser();

	@BeforeTest(alwaysRun = true)
	@Parameters({ "browser", "environment" })
	public void setUpTest(String browser, String environment)
			throws FileNotFoundException, IOException, ParseException {
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
		switch (environment) {
		case "production":
			Object obj1 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\prodUrl.json"));
			JSONObject jsonObject1 = (JSONObject) obj1;
			driver.get((String) jsonObject1.get("SocalBillAssistance26"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalBillAssistance26"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalBillAssistance26"));
			break;
		}
//		driver.get("https://www.socalgas.com/help-center/bill-assistance");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void BillAssistanceDesignVerification() {
		WebElement Bill_Assis_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Bill Assistance')]"));

		String Bill_Assis_Title_FontSize = Bill_Assis_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", Bill_Assis_Title_FontSize);

		String Bill_Assis_Title_fontFamily = Bill_Assis_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Bill_Assis_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Bill_Assis_Title_fontFamily);
		}
		String Bill_Assis_Title_FontWeight = Bill_Assis_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", Bill_Assis_Title_FontWeight);

		String Bill_Assis_Title_colorValue = Bill_Assis_Title_xpath.getCssValue("color");
		String Bill_Assis_Title_Actual_FontColor = Color.fromString(Bill_Assis_Title_colorValue).asHex();
		Assert.assertEquals("#004693", Bill_Assis_Title_Actual_FontColor);
	}

	@Test
	public void LinksDesignVerification() {
		//
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Me gustaría recibir')]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_FontWeight = Link_Text_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", Link_Text_FontWeight);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@AfterMethod
	public void screenShot(ITestResult result) {
		System.out.println("*****************************************");
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src, new File("./screenshots/" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			driver.quit();
			Reporter.log("=====Browser Session End=====", true);
		}
	}

	@AfterTest(enabled = false)
	public void terminateBrowser() {
		driver.quit();
		System.out.println("Socal Bill Inserts Class Executed sucessfully");
	}
}
