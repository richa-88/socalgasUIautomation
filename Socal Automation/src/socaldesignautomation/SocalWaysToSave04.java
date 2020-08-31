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

public class SocalWaysToSave04 {
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
			driver.get((String) jsonObject1.get("SocalWaysToSave04"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalWaysToSave04"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalWaysToSave04"));
			break;
		}
//		driver.get("http://socalgas.com/waystosave");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void WaystoSaveEnergySavingToolDesignVerification() {
		// Title xpath of Ways to Save Energy Saving Tool.
		WebElement wTSEST_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(text(),'Ways to Save Energy-Saving Tool')]"));
		String wTSEST_Title_FontSize = wTSEST_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", wTSEST_Title_FontSize);

		String wTSEST_Title_Actual_fontFamily = wTSEST_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", wTSEST_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, wTSEST_Title_Actual_fontFamily);
		}
		String wTSEST_Title_colorValue = wTSEST_Title_xpath.getCssValue("color");
		String wTSEST_Title_Actual_FontColor = Color.fromString(wTSEST_Title_colorValue).asHex();
		Assert.assertEquals("#004693", wTSEST_Title_Actual_FontColor);

		// Content xpath of Ways to Save Energy Saving Tool..
		WebElement wTSEST_Content_xpath = driver.findElement(By.xpath("//div[@class='page-banner__text']/p"));
		String wTSEST_Content_FontSize = wTSEST_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", wTSEST_Content_FontSize);

		String wTSEST_Content_Actual_fontFamily = wTSEST_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", wTSEST_Content_Actual_fontFamily);

		String wTSEST_Content_colorValue = wTSEST_Title_xpath.getCssValue("color");
		String wTSEST_Content_Actual_FontColor = Color.fromString(wTSEST_Content_colorValue).asHex();
		Assert.assertEquals("#004693", wTSEST_Content_Actual_FontColor);
	}

	@Test
	public void EnergySavingsMadeEasyDesignVerification() {
		// Title xpath of Energy Savings Made Easy.
		WebElement eSME_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(),'Energy Savings Made Easy')]"));
		String eSME_Title_FontSize = eSME_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", eSME_Title_FontSize);

		String eSME_Title_Actual_fontFamily = eSME_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", eSME_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eSME_Title_Actual_fontFamily);
		}
		String eSME_Title_colorValue = eSME_Title_xpath.getCssValue("color");
		String eSME_Title_Actual_FontColor = Color.fromString(eSME_Title_colorValue).asHex();
		Assert.assertEquals("#000000", eSME_Title_Actual_FontColor);

		// Content xpath of Energy Savings Made Easy.
		WebElement eSME_Content_xpath = driver
				.findElement(By.xpath("//p[contains(text(),'Your personalized energy savings start')]"));
		String eSME_Content_FontSize = eSME_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eSME_Content_FontSize);

		String eSME_Content_Actual_fontFamily = eSME_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", eSME_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eSME_Content_Actual_fontFamily);
		}
		String eSME_Content_colorValue = eSME_Content_xpath.getCssValue("color");
		String eSME_Content_Actual_FontColor = Color.fromString(eSME_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eSME_Content_Actual_FontColor);
	}

	@Test
	public void BenefitsOfWaystoSaveDesignVerification() {
		WebElement bOWTS_Title_xpath = driver
				.findElement(By.xpath("//h3[contains(text(),'Benefits of Ways to Save')]"));
		String bOWTS_Title_FontSize = bOWTS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", bOWTS_Title_FontSize);

		String bOWTS_Title_Actual_fontFamily = bOWTS_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", bOWTS_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, bOWTS_Title_Actual_fontFamily);
		}
		String bOWTS_Title_colorValue = bOWTS_Title_xpath.getCssValue("color");
		String bOWTS_Title_Actual_FontColor = Color.fromString(bOWTS_Title_colorValue).asHex();
		Assert.assertEquals("#000000", bOWTS_Title_Actual_FontColor);

		// Content
		WebElement bOWTS_Content_xpath = driver.findElement(By.xpath("//p[contains(text(),'By using')]"));
		String bOWTS_Content_FontSize = bOWTS_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", bOWTS_Content_FontSize);

		String bOWTS_Content_Actual_fontFamily = bOWTS_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", bOWTS_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, bOWTS_Content_Actual_fontFamily);
		}
		String bOWTS_Content_colorValue = bOWTS_Content_xpath.getCssValue("color");
		String bOWTS_Content_Actual_FontColor = Color.fromString(bOWTS_Content_colorValue).asHex();
		Assert.assertEquals("#666666", bOWTS_Content_Actual_FontColor);

		WebElement custom_recommendations_xpath = driver
				.findElement(By.xpath("//div[@class='field--text']/ul/li[1]/p"));
		String custom_recommendations_FontSize = custom_recommendations_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", custom_recommendations_FontSize);

		String custom_recommendations_Actual_fontFamily = custom_recommendations_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", custom_recommendations_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, custom_recommendations_Actual_fontFamily);
		}
		String custom_recommendations_colorValue = custom_recommendations_xpath.getCssValue("color");
		String custom_recommendations_Actual_FontColor = Color.fromString(custom_recommendations_colorValue).asHex();
		Assert.assertEquals("#666666", custom_recommendations_Actual_FontColor);
	}

	@Test
	public void GettingStartedIsEasyDesignVerification() {
		WebElement gSIE_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(),'Getting Started')]"));
		String gSIE_title_FontSize = gSIE_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", gSIE_title_FontSize);

		String gSIE_Title_Actual_fontFamily = gSIE_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", gSIE_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, gSIE_Title_Actual_fontFamily);
		}
		String gSIE_Title_colorValue = gSIE_Title_xpath.getCssValue("color");
		String gSIE_Title_Actual_FontColor = Color.fromString(gSIE_Title_colorValue).asHex();
		Assert.assertEquals("#000000", gSIE_Title_Actual_FontColor);

		// Xpath of Content of (Getting Started is Easy!).
		WebElement gSIE_Content_xpath = driver
				.findElement(By.xpath("//p[contains(text(),'and click on the Ways to Save')]"));
		String gSIE_Content_FontSize = gSIE_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", gSIE_Content_FontSize);

		String gSIE_Content_Actual_fontFamily = gSIE_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", gSIE_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, gSIE_Content_Actual_fontFamily);
		}
		String gSIE_Content_colorValue = gSIE_Content_xpath.getCssValue("color");
		String gSIE_Content_Actual_FontColor = Color.fromString(gSIE_Content_colorValue).asHex();
		Assert.assertEquals("#666666", gSIE_Content_Actual_FontColor);

		// Xpath of Content of (Getting Started is Easy!) with link text(Log in to My
		// Account).
		WebElement Log_in_to_My_Account_xpath = driver
				.findElement(By.xpath("//a[contains(text(),'Log in to My Account')]"));
		String Log_in_to_My_Account_FontSize = Log_in_to_My_Account_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Log_in_to_My_Account_FontSize);

		String Log_in_to_My_Account_Actual_fontFamily = Log_in_to_My_Account_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Log_in_to_My_Account_Actual_fontFamily);

		String Log_in_to_My_Account_colorValue = Log_in_to_My_Account_xpath.getCssValue("color");
		String Log_in_to_My_Account_Actual_FontColor = Color.fromString(Log_in_to_My_Account_colorValue).asHex();
		Assert.assertEquals("#0072c6", Log_in_to_My_Account_Actual_FontColor);
	}

	@Test
	public void RegisterToStartSavingDesignVerification() {
		WebElement rTSS_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Register to Start Saving')]"));
		String rTSS_Title_FontSize = rTSS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", rTSS_Title_FontSize);

		String rTSS_Actual_fontFamily = rTSS_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rTSS_Actual_fontFamily);

		String rTSS_Title_colorValue = rTSS_Title_xpath.getCssValue("color");
		String rTSS_Title_Actual_FontColor = Color.fromString(rTSS_Title_colorValue).asHex();
		Assert.assertEquals("#000000", rTSS_Title_Actual_FontColor);

		WebElement rTSS_Content_xpath = driver.findElement(By.xpath("//div[contains(text(),'Not yet a My')]"));
		String rTSS_Content_FontSize = rTSS_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rTSS_Content_FontSize);

		String rTSS_Content_Actual_fontFamily = rTSS_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rTSS_Content_Actual_fontFamily);

		String rTSS_Content_colorValue = rTSS_Content_xpath.getCssValue("color");
		String rTSS_Content_Actual_FontColor = Color.fromString(rTSS_Content_colorValue).asHex();
		Assert.assertEquals("#666666", rTSS_Content_Actual_FontColor);// a[contains(text(),'Register Today')]

		// Link Text.
		WebElement rTSS_Link_xpath = driver.findElement(By.xpath("//a[contains(text(),'Register Today')]"));
		String rTSS_Link_FontSize = rTSS_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rTSS_Link_FontSize);

		String rTSS_Link_Actual_fontFamily = rTSS_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rTSS_Link_Actual_fontFamily);

		String rTSS_Link_colorValue = rTSS_Link_xpath.getCssValue("color");
		String rTSS_Link_Actual_FontColor = Color.fromString(rTSS_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", rTSS_Link_Actual_FontColor);
	}

	@Test
	public void EnergySavingTipsDesignVerification() {
		WebElement eST_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Energy Saving Tips')]"));
		String eST_Title_FontSize = eST_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", eST_Title_FontSize);

		String eST_Actual_fontFamily = eST_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eST_Actual_fontFamily);

		String eST_Title_colorValue = eST_Title_xpath.getCssValue("color");
		String eST_Title_Actual_FontColor = Color.fromString(eST_Title_colorValue).asHex();
		Assert.assertEquals("#000000", eST_Title_Actual_FontColor);

		WebElement eST_Content_xpath = driver.findElement(By.xpath("//div[contains(text(),'Start saving right')]"));
		String eST_Content_FontSize = eST_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eST_Content_FontSize);

		String eST_Content_Actual_fontFamily = eST_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eST_Content_Actual_fontFamily);

		String eST_Content_colorValue = eST_Content_xpath.getCssValue("color");
		String eST_Content_Actual_FontColor = Color.fromString(eST_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eST_Content_Actual_FontColor);
		// Link Text.
		WebElement eST_Link_xpath = driver.findElement(By.xpath("//a[contains(text(),'Get Started')]"));
		String eST_Link_FontSize = eST_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eST_Link_FontSize);

		String eST_Link_Actual_fontFamily = eST_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eST_Link_Actual_fontFamily);

		String eST_Link_colorValue = eST_Link_xpath.getCssValue("color");
		String eST_Link_Actual_FontColor = Color.fromString(eST_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", eST_Link_Actual_FontColor);
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
		System.out.println("Ways To Save Class Executed sucessfully");
	}
}
