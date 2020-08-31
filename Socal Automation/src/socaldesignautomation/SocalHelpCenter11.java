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

public class SocalHelpCenter11 {
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
			driver.get((String) jsonObject1.get("SocalHelpCenter11"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalHelpCenter11"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalHelpCenter11"));
			break;
		}
//		driver.get("https://www.socalgas.com/help-center");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void HelpCenterTitleDesignVerification() {
		WebElement Help_Center_Title_xpath = driver.findElement(By.cssSelector(".field--title"));
		String Help_Center_Title_FontSize = Help_Center_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", Help_Center_Title_FontSize);

		String Help_Center_Title_fontFamily = Help_Center_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Help_Center_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Help_Center_Title_fontFamily);
		}
		String Help_Center_Title_colorValue = Help_Center_Title_xpath.getCssValue("color");
		String Help_Center_Title_Actual_FontColor = Color.fromString(Help_Center_Title_colorValue).asHex();
		Assert.assertEquals("#004693", Help_Center_Title_Actual_FontColor);
	}

	@Test
	public void FeaturedSupportCategoriesDesignVerification() {
		WebElement FSC_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Featured Support')]"));
		String FSC_Title_FontSize = FSC_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", FSC_Title_FontSize);

		String FSC_Title_fontFamily = FSC_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", FSC_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, FSC_Title_fontFamily);
		}
		String FSC_Title_colorValue = FSC_Title_xpath.getCssValue("color");
		String FSC_Title_Actual_FontColor = Color.fromString(FSC_Title_colorValue).asHex();
		Assert.assertEquals("#000000", FSC_Title_Actual_FontColor);

		WebElement FSC_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Bill Assistance')]"));
		String FSC_Link_Text_FontSize = FSC_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FSC_Link_Text_FontSize);

		String FSC_Link_Text_fontFamily = FSC_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", FSC_Link_Text_fontFamily);

		String FSC_Link_Text_colorValue = FSC_Link_Text_xpath.getCssValue("color");
		String FSC_Link_Actual_Text_FontColor = Color.fromString(FSC_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", FSC_Link_Actual_Text_FontColor);
	}

	@Test
	public void FrequentlyAskedQuestionsdesignVerification() {
		WebElement FAQ_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Frequently Asked')]"));
		String FAQ_Title_FontSize = FAQ_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", FAQ_Title_FontSize);

		String FAQ_Title_fontFamily = FAQ_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", FAQ_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, FAQ_Title_fontFamily);
		}
		String FAQ_Title_colorValue = FAQ_Title_xpath.getCssValue("color");
		String FAQ_Title_Actual_FontColor = Color.fromString(FAQ_Title_colorValue).asHex();
		Assert.assertEquals("#000000", FAQ_Title_Actual_FontColor);

		WebElement FAQ_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'What is SoCalGas')]"));
		String FAQ_Link_Text_FontSize = FAQ_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FAQ_Link_Text_FontSize);

		String FAQ_Link_Text_fontFamily = FAQ_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", FAQ_Link_Text_fontFamily);

		String FAQ_Link_Text_colorValue = FAQ_Link_Text_xpath.getCssValue("color");
		String FAQ_Link_Actual_Text_FontColor = Color.fromString(FAQ_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", FAQ_Link_Actual_Text_FontColor);
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
		System.out.println("Socal Help Center Executed sucessfully");
	}
}
