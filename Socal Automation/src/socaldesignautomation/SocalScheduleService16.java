package socaldesignautomation;

import org.openqa.selenium.support.Color;

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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocalScheduleService16 {
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
			driver.get((String) jsonObject1.get("SocalScheduleService16"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalScheduleService16"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalScheduleService16"));
			break;
		}
//		driver.get("https://www.socalgas.com/schedule-service");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ScheduleServiceDesignVerification() {
		// Title xpath Schedule Service
		WebElement ScheduleService_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Schedule Service')]"));
		String ScheduleService_Actual_Title_FontSize = ScheduleService_Title_xpath.getCssValue("font-size");
		System.out.println();
		Assert.assertEquals("30px", ScheduleService_Actual_Title_FontSize);

		String ScheduleServiceActual_Title_fontFamily = ScheduleService_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ScheduleServiceActual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ScheduleServiceActual_Title_fontFamily);
		}
		String ScheduleService_Title_colorValue = ScheduleService_Title_xpath.getCssValue("color");
		String ScheduleServiceActual_Title_FontColor = Color.fromString(ScheduleService_Title_colorValue).asHex();
		Assert.assertEquals("#004693", ScheduleServiceActual_Title_FontColor);

		// Content xpath Schedule service
		WebElement ScheduleService_Text_xpath = driver
				.findElement(By.xpath("//p[contains(text(), 'Take care of all')]"));
		String ScheduleService_Actual_Text_FontSize = ScheduleService_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", ScheduleService_Actual_Text_FontSize);

		String ScheduleService_Actual_Text_fontFamily = ScheduleService_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", ScheduleService_Actual_Text_fontFamily);

		String ScheduleService_Text_colorValue = ScheduleService_Text_xpath.getCssValue("color");
		String ScheduleService_Actual_Text_FontColor = Color.fromString(ScheduleService_Text_colorValue).asHex();
		Assert.assertEquals("#004693", ScheduleService_Actual_Text_FontColor);
	}

	@Test
	public void ReportANaturalGasLeakDesignVerification() {
		// Title Residential Rebates
		WebElement rANGL_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Report a Natural')]"));
		String rANGL_Title_Actual_FontSize = rANGL_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rANGL_Title_Actual_FontSize);

		String rANGL_Title_Actual_fontFamily = rANGL_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rANGL_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rANGL_Title_Actual_fontFamily);
		}
		String rANGL_Title_Actual_colorValue = rANGL_Title_xpath.getCssValue("color");
		String rANGL_Title_Actual_FontColor = Color.fromString(rANGL_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rANGL_Title_Actual_FontColor);

		// Content xpath of Residential Rebates.
		WebElement rANGL_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), ' If you suspect')]"));
		String rANGL_Content_Actual_FontSize = rANGL_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rANGL_Content_Actual_FontSize);

		String rANGL_Content_Actual_fontFamily = rANGL_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", rANGL_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rANGL_Content_Actual_fontFamily);
		}
		String rANGL_Content_Actual_colorValue = rANGL_Content_xpath.getCssValue("color");
		String rANGL_Content_Actual_FontColor = Color.fromString(rANGL_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rANGL_Content_Actual_FontColor);

		// Link Text xpath of Residential Rebates
		WebElement rANGL_btn_xpath = driver.findElement(By.xpath("//a[@class='feature--item--button']"));

		String rANGL_btn_FontSize = rANGL_btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rANGL_btn_FontSize);

		String rANGL_btn_Actual_fontFamily = rANGL_btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rANGL_btn_Actual_fontFamily);

		String rANGL_btn_Actual_colorValue = rANGL_btn_xpath.getCssValue("color");
		String rANGL_btn_Actual_FontColor = Color.fromString(rANGL_btn_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", rANGL_btn_Actual_FontColor);
	}

	@Test
	public void TransferServiceDesignVerification() {
		// Title Residential Rebates
		WebElement transfer_Service_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Transfer Service')]"));
		String transfer_Service_Title_Actual_FontSize = transfer_Service_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", transfer_Service_Title_Actual_FontSize);

		String transfer_Service_Title_Actual_fontFamily = transfer_Service_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", transfer_Service_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, transfer_Service_Title_Actual_fontFamily);
		}
		String transfer_Service_Title_Actual_colorValue = transfer_Service_Title_xpath.getCssValue("color");
		String transfer_Service_Title_Actual_FontColor = Color.fromString(transfer_Service_Title_Actual_colorValue)
				.asHex();
		Assert.assertEquals("#000000", transfer_Service_Title_Actual_FontColor);

		// Content xpath of Residential Rebates.
		WebElement transfer_Service_Content_xpath = driver
				.findElement(By.xpath("//div[contains(text(), ' Getting ready')]"));
		String transfer_Service_Content_Actual_FontSize = transfer_Service_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", transfer_Service_Content_Actual_FontSize);

		String transfer_Service_Content_Actual_fontFamily = transfer_Service_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", transfer_Service_Content_Actual_fontFamily);

		String transfer_Service_Content_Actual_colorValue = transfer_Service_Content_xpath.getCssValue("color");
		String transfer_Service_Content_Actual_FontColor = Color.fromString(transfer_Service_Content_Actual_colorValue)
				.asHex();
		Assert.assertEquals("#666666", transfer_Service_Content_Actual_FontColor);

		// Link Text xpath of Residential Rebates
		WebElement transfer_Service_Link_xpath = driver
				.findElement(By.xpath("(//a[@class='featured-item__link feature--item--button '])[1]"));

		String transfer_Service_Link_FontSize = transfer_Service_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", transfer_Service_Link_FontSize);

		String transfer_Service_Link_fontFamily = transfer_Service_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", transfer_Service_Link_fontFamily);

		String transfer_Service_Link_colorValue = transfer_Service_Link_xpath.getCssValue("color");
		String transfer_Service_Link_Actual_FontColor = Color.fromString(transfer_Service_Link_colorValue).asHex();
		Assert.assertEquals("#ffffff", transfer_Service_Link_Actual_FontColor);
	}

	@Test
	public void PilotRelightDesignVerification() {
		// Title Pilot Relight
		WebElement pilotRelight_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Pilot Relight')]"));
		String pilotRelight_Title_Actual_FontSize = pilotRelight_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", pilotRelight_Title_Actual_FontSize);

		String pilotRelight_Title_Actual_fontFamily = pilotRelight_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", pilotRelight_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, pilotRelight_Title_Actual_fontFamily);
		}
		String pilotRelight_Title_colorValue = pilotRelight_Title_xpath.getCssValue("color");
		String pilotRelight_Title_Actual_FontColor = Color.fromString(pilotRelight_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", pilotRelight_Title_Actual_FontColor);

		// Content xpath of Residential Rebates.
		WebElement pilotRelight_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Schedule your')]"));
		String pilotRelight_Content_Actual_FontSize = pilotRelight_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", pilotRelight_Content_Actual_FontSize);

		String pilotRelight_Content_Actual_fontFamily = pilotRelight_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", pilotRelight_Content_Actual_fontFamily);

		String pilotRelight_Content_Actual_colorValue = pilotRelight_Content_xpath.getCssValue("color");
		String pilotRelight_Content_Actual_FontColor = Color.fromString(pilotRelight_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", pilotRelight_Content_Actual_FontColor);

		// Link Text xpath of Residential Rebates
		WebElement pilotRelight_Link_xpath = driver.findElement(By.xpath("//a[@class='btn-primary']"));

		String pilotRelight_Link_FontSize = pilotRelight_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", pilotRelight_Link_FontSize);

		String pilotRelight_Link_fontFamily = pilotRelight_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", pilotRelight_Link_fontFamily);

		String pilotRelight_Link_colorValue = pilotRelight_Link_xpath.getCssValue("color");
		String pilotRelight_Link_Actual_FontColor = Color.fromString(pilotRelight_Link_colorValue).asHex();
		Assert.assertEquals("#ffffff", pilotRelight_Link_Actual_FontColor);
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
		System.out.println("Socal Schedule Service Class Executed Sucessfully");
	}
}
