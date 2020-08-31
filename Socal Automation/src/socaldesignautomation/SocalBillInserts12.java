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

public class SocalBillInserts12 {
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
			driver.get((String) jsonObject1.get("SocalBillInserts12"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalBillInserts12"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalBillInserts12"));
			break;
		}
//		driver.get("https://www.socalgas.com/regulatory/bill-inserts");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void BillInsertsAndOtherNoticesDesignVerification() {
		WebElement BIAON_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Bill Inserts and Other')]"));

		String BIAON_Title_FontSize = BIAON_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", BIAON_Title_FontSize);

		String BIAON_Title_fontFamily = BIAON_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", BIAON_Title_fontFamily);

		String BIAON_Title_FontWeight = BIAON_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", BIAON_Title_FontWeight);

		String BIAON_Title_colorValue = BIAON_Title_xpath.getCssValue("color");
		String BIAON_Title_Actual_FontColor = Color.fromString(BIAON_Title_colorValue).asHex();
		Assert.assertEquals("#004693", BIAON_Title_Actual_FontColor);
	}

	@Test
	public void YearSubBlkDesignVerification() {
		WebElement Year_SubBlk_xpath = driver.findElement(By.xpath("//table[2]/thead[1]/tr/th"));

		String Year_SubBlk_FontSize = Year_SubBlk_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Year_SubBlk_FontSize);

		String Year_SubBlk_fontFamily = Year_SubBlk_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Year_SubBlk_fontFamily);

		String Year_SubBlk_FontWeight = Year_SubBlk_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", Year_SubBlk_FontWeight);

		String Year_SubBlk_colorValue = Year_SubBlk_xpath.getCssValue("color");
		String Year_SubBlk_Actual_FontColor = Color.fromString(Year_SubBlk_colorValue).asHex();
		Assert.assertEquals("#000000", Year_SubBlk_Actual_FontColor);
	}

	@Test
	public void LinkTextSubBlkDesignVerification() {
		WebElement LinkText_SubBlk_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'FYI Safety and')])[1]"));
		String LinkText_SubBlk_FontSize = LinkText_SubBlk_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", LinkText_SubBlk_FontSize);

		String LinkText_SubBlk_fontFamily = LinkText_SubBlk_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", LinkText_SubBlk_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, LinkText_SubBlk_fontFamily);
		}
		String LinkText_SubBlk_FontWeight = LinkText_SubBlk_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", LinkText_SubBlk_FontWeight);

		String LinkText_SubBlk_colorValue = LinkText_SubBlk_xpath.getCssValue("color");
		String LinkText_SubBlk_Actual_FontColor = Color.fromString(LinkText_SubBlk_colorValue).asHex();
		Assert.assertEquals("#0072c6", LinkText_SubBlk_Actual_FontColor);
	}

	@Test
	public void EndBlkDesignVerification() {
		// 2019 year text Css verification.
		WebElement End_blk_xpath = driver.findElement(By.xpath("//h2[contains(text(), '2019')]"));
		String End_blk_SubBlk_FontSize = End_blk_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", End_blk_SubBlk_FontSize);

		String End_blk_SubBlk_fontFamily = End_blk_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", End_blk_SubBlk_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, End_blk_SubBlk_fontFamily);
		}
		String End_blk_SubBlk_FontWeight = End_blk_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", End_blk_SubBlk_FontWeight);

		String End_blk_SubBlk_colorValue = End_blk_xpath.getCssValue("color");
		String End_blk_SubBlk_Actual_FontColor = Color.fromString(End_blk_SubBlk_colorValue).asHex();
		Assert.assertEquals("#000000", End_blk_SubBlk_Actual_FontColor);

		// Clicking on 2019 then expand text December css Verification.

		WebElement Dec_blk_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'December')]"));
		String Dec_blk_SubBlk_FontSize = Dec_blk_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", Dec_blk_SubBlk_FontSize);

		String Dec_blk_SubBlk_fontFamily = Dec_blk_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Dec_blk_SubBlk_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Dec_blk_SubBlk_fontFamily);
		}
		String Dec_blk_SubBlk_FontWeight = Dec_blk_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", Dec_blk_SubBlk_FontWeight);

		String Dec_blk_SubBlk_colorValue = Dec_blk_xpath.getCssValue("color");
		String Dec_blk_SubBlk_Actual_FontColor = Color.fromString(Dec_blk_SubBlk_colorValue).asHex();
		Assert.assertEquals("#000000", Dec_blk_SubBlk_Actual_FontColor);
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
