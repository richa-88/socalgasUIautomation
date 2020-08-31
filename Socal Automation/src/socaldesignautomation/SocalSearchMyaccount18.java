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

public class SocalSearchMyaccount18 {
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
			driver.get((String) jsonObject1.get("SocalSearchMyaccount18"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalSearchMyaccount18"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalSearchMyaccount18"));
			break;
		}
//		driver.get("https://www.socalgas.com/search?search_api_language[]=en&search_api_language[]=es&siteref=myaccount&referrer=prod");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void SearchTextDesignVerification() {
		WebElement Search_Text_xpath = driver
				.findElement(By.xpath("//input[@class='button js-form-submit form-submit']"));
		String Search_Text_FontSize = Search_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Search_Text_FontSize);

		String Search_Text_Actual_fontFamily = Search_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Search_Text_Actual_fontFamily);

		String Search_Text_colorValue = Search_Text_xpath.getCssValue("color");
		String Search_Text_Actual_FontColor = Color.fromString(Search_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Search_Text_Actual_FontColor);
	}

	@Test
	public void FilterByLanguageDesignVerification() {
		WebElement FBL_Text_xpath = driver
				.findElement(By.xpath("//*[@id=\"views-exposed-form-acquia-search-page\"]/div[2]/label"));
		String FBL_Text_FontSize = FBL_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FBL_Text_FontSize);

		String FBL_Text_Actual_fontFamily = FBL_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", FBL_Text_Actual_fontFamily);

		String FBL_Text_colorValue = FBL_Text_xpath.getCssValue("color");
		String FBL_Text_Actual_FontColor = Color.fromString(FBL_Text_colorValue).asHex();
		Assert.assertEquals("#000000", FBL_Text_Actual_FontColor);

		//
		WebElement English_Text_xpath = driver.findElement(By.xpath("//option[2]"));
		String English_Text_FontSize = English_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", English_Text_FontSize);

		String English_Text_Actual_fontFamily = English_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", English_Text_Actual_fontFamily);

		String English_Text_colorValue = English_Text_xpath.getCssValue("color");
		String English_Text_Actual_FontColor = Color.fromString(English_Text_colorValue).asHex();
		Assert.assertEquals("#101010", English_Text_Actual_FontColor);
	}

	@Test
	public void ApologiesBlockDesignVerification() {
		WebElement ApologiesBlock_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(),'Apologies, no')]"));
		String ApologiesBlock_Title_FontSize = ApologiesBlock_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", ApologiesBlock_Title_FontSize);

		String ApologiesBlock_Title_Actual_fontFamily = ApologiesBlock_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ApologiesBlock_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ApologiesBlock_Title_Actual_fontFamily);
		}
		String ApologiesBlock_Title_colorValue = ApologiesBlock_Title_xpath.getCssValue("color");
		String ApologiesBlock_Title_Actual_FontColor = Color.fromString(ApologiesBlock_Title_colorValue).asHex();
		Assert.assertEquals("#000000", ApologiesBlock_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement ApologiesBlock_Content_xpath = driver.findElement(By.xpath("//div[@class='result-phrase']"));
		String ApologiesBlock_Content_FontSize = ApologiesBlock_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", ApologiesBlock_Content_FontSize);

		String ApologiesBlock_Content_Actual_fontFamily = ApologiesBlock_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", ApologiesBlock_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ApologiesBlock_Content_Actual_fontFamily);
		}
		String ApologiesBlock_Content_colorValue = ApologiesBlock_Content_xpath.getCssValue("color");
		String ApologiesBlock_Content_Actual_FontColor = Color.fromString(ApologiesBlock_Content_colorValue).asHex();
		Assert.assertEquals("#666666", ApologiesBlock_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_Actual_fontFamily = Link_Text_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", Link_Text_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Link_Text_Actual_fontFamily);
		}
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
		System.out.println("Socal Tradepro Executed sucessfully");
	}
}
