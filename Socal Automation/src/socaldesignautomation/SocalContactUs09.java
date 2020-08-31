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
import org.openqa.selenium.JavascriptExecutor;
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

public class SocalContactUs09 {
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
			driver.get((String) jsonObject1.get("SocalContactUs09"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalContactUs09"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalContactUs09"));
			break;
		}
//		driver.get("https://www.socalgas.com/about-us/contact-us");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ContactTitle() {
		WebElement Contact_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Contact Us')]"));

		String Contact_FontSize = Contact_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", Contact_FontSize);

		String Contact_xpath_Actual_fontFamily = Contact_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Contact_xpath_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Contact_xpath_Actual_fontFamily);
		}
		String Contact_Title_colorValue = Contact_Title_xpath.getCssValue("color");
		String Contact_Actual_Title_FontColor = Color.fromString(Contact_Title_colorValue).asHex();
		Assert.assertEquals("#004693", Contact_Actual_Title_FontColor);
	}

	@Test
	public void ForGasEmergenciesORSafetyIssues() {
		// Title
		WebElement FGEOSI_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'For Gas')]"));

		String FGEOSI_Title_FontSize = FGEOSI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", FGEOSI_Title_FontSize);

		String FGEOSI_Actual_Title_fontFamily = FGEOSI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", FGEOSI_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, FGEOSI_Actual_Title_fontFamily);
		}
		String FGEOSI_Title_colorValue = FGEOSI_Title_xpath.getCssValue("color");
		String FGEOSI_Actual_Title_FontColor = Color.fromString(FGEOSI_Title_colorValue).asHex();
		Assert.assertEquals("#000000", FGEOSI_Actual_Title_FontColor);

		// Description
		WebElement FGEOSI_Desc_xpath = driver.findElement(By.xpath("//li[contains(text(), 'Emergencies')]"));

		String FGEOSI_Desc_FontSize = FGEOSI_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FGEOSI_Desc_FontSize);

		String FGEOSI_Desc_Actual_fontFamily = FGEOSI_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", FGEOSI_Desc_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, FGEOSI_Desc_Actual_fontFamily);
		}
		String FGEOSI_desc_colorValue = FGEOSI_Desc_xpath.getCssValue("color");
		String FGEOSI_Actual_Desc_FontColor = Color.fromString(FGEOSI_desc_colorValue).asHex();
		Assert.assertEquals("#666666", FGEOSI_Actual_Desc_FontColor);

		// Link Text
		WebElement FGEOSI_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), '1-800-427-2200')]"));
		String FGEOSI_Link_Text_FontSize = FGEOSI_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FGEOSI_Link_Text_FontSize);

		String FGEOSI_Link_Text_fontFamily = FGEOSI_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", FGEOSI_Link_Text_fontFamily);

		String FGEOSI_Link_Text_colorValue = FGEOSI_Link_Text_xpath.getCssValue("color");
		String FGEOSI_Link_Text_Actual_FontColor = Color.fromString(FGEOSI_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", FGEOSI_Link_Text_Actual_FontColor);
	}

	@Test
	public void NewsroomDesignVerification() {
		WebElement NewsRoom_Title_xpah = driver.findElement(By.xpath("//div[contains(text(), 'Newsroom')]"));
		String NewsRoom_Title_FontSize = NewsRoom_Title_xpah.getCssValue("font-size");
		Assert.assertEquals("18px", NewsRoom_Title_FontSize);

		String NewsRoom_Title_fontFamily = NewsRoom_Title_xpah.getCssValue("font-family");
		Assert.assertEquals("Interstate", NewsRoom_Title_fontFamily);

		String NewsRoom_Title_colorValue = NewsRoom_Title_xpah.getCssValue("color");
		String NewsRoom_Title_Actual_FontColor = Color.fromString(NewsRoom_Title_colorValue).asHex();
		Assert.assertEquals("#000000", NewsRoom_Title_Actual_FontColor);

		// Desc
		WebElement NewsRoom_Desc_xpah = driver.findElement(By.xpath("//p[contains(text(), 'News releases')]"));
		String NewsRoom_Desc_FontSize = NewsRoom_Desc_xpah.getCssValue("font-size");
		Assert.assertEquals("16px", NewsRoom_Desc_FontSize);

		String NewsRoom_Desc_fontFamily = NewsRoom_Desc_xpah.getCssValue("font-family");
		Assert.assertEquals("Arial", NewsRoom_Desc_fontFamily);

		String NewsRoom_Desc_colorValue = NewsRoom_Desc_xpah.getCssValue("color");
		String NewsRoom_Desc_Actual_FontColor = Color.fromString(NewsRoom_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", NewsRoom_Desc_Actual_FontColor);

		// Login Button.
		WebElement NewsRoom_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Visit Newsroom')]"));
		String NewsRoom_Link_Text_FontSize = NewsRoom_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", NewsRoom_Link_Text_FontSize);

		String NewsRoom_Link_Text_fontFamily = NewsRoom_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", NewsRoom_Link_Text_fontFamily);

		String NewsRoom_Link_Text_colorValue = NewsRoom_Link_Text_xpath.getCssValue("color");
		String NewsRoom_Link_Text_Actual_FontColor = Color.fromString(NewsRoom_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", NewsRoom_Link_Text_Actual_FontColor);
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
		System.out.println("Socal Contact Us Class Executed Sucessfully");
	}
}
