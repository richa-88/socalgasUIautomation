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

public class SocalTradepro05 {
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
			driver.get((String) jsonObject1.get("SocalTradepro05"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalTradepro05"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalTradepro05"));
			break;
		}
//		driver.get("https://www.socalgas.com/tradepro");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TradeProfessionalProgramDesignVerification() {
		WebElement tPP_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Trade Professional Program')]"));
		String tPP_Actual_Title_FontSize = tPP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", tPP_Actual_Title_FontSize);

		String tPP_Actual_Title_fontFamily = tPP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", tPP_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, tPP_Actual_Title_fontFamily);
		}
		String tPP_Title_colorValue = tPP_Title_xpath.getCssValue("color");
		String tPP_Actual_Title_FontColor = Color.fromString(tPP_Title_colorValue).asHex();
		Assert.assertEquals("#004693", tPP_Actual_Title_FontColor);

		// Content xpath.
		WebElement tPP_Text_xpath = driver
				.findElement(By.xpath("//p[contains(text(),'Find experienced vendors who sell')]"));
		String tPP_Actual_Text_FontSize = tPP_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", tPP_Actual_Text_FontSize);

		String rAndI_Actual_Text_fontFamily = tPP_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAndI_Actual_Text_fontFamily);

		String tPP_Text_colorValue = tPP_Text_xpath.getCssValue("color");
		String tPP_Actual_Text_FontColor = Color.fromString(tPP_Text_colorValue).asHex();
		Assert.assertEquals("#004693", tPP_Actual_Text_FontColor);
	}

	@Test
	public void AccessTheTradeProDirectoryDesignVerification() {
		// Tittle xpath of Energy-Saving Tips and Tools.
		WebElement aTTPD_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Access the Trade Pro')]"));
		String aTTPD_Title_FontSize = aTTPD_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", aTTPD_Title_FontSize);

		String aTTPD_Title_Actual_fontFamily = aTTPD_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", aTTPD_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, aTTPD_Title_Actual_fontFamily);
		}
		String aTTPD_Title_colorValue = aTTPD_Title_xpath.getCssValue("color");
		String aTTPD_Title_Actual_FontColor = Color.fromString(aTTPD_Title_colorValue).asHex();
		Assert.assertEquals("#000000", aTTPD_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement aTTPD_Content_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Are you a business customer')]"));
		String aTTPD_Content_FontSize = aTTPD_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aTTPD_Content_FontSize);

		String aTTPD_Content_Actual_fontFamily = aTTPD_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", aTTPD_Content_Actual_fontFamily);

		String aTTPD_Content_colorValue = aTTPD_Content_xpath.getCssValue("color");
		String aTTPD_Content_Actual_FontColor = Color.fromString(aTTPD_Content_colorValue).asHex();
		Assert.assertEquals("#666666", aTTPD_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement aTTPD_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Search Now')]"));
		String aTTPD_Btn_FontSize = aTTPD_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aTTPD_Btn_FontSize);

		String aTTPD_Btn_Actual_fontFamily = aTTPD_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", aTTPD_Btn_Actual_fontFamily);

		String aTTPD_Btn_colorValue = aTTPD_Btn_xpath.getCssValue("color");
		String aTTPD_Btn_Actual_FontColor = Color.fromString(aTTPD_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", aTTPD_Btn_Actual_FontColor);
	}

	@Test
	public void JoinTheTradeProDirectoryDesignVerification() {
		// Tittle xpath of Energy-Saving Tips and Tools.
		WebElement jTTPD_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Join the Trade Pro')]"));
		String jTTPD_Title_FontSize = jTTPD_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", jTTPD_Title_FontSize);

		String jTTPD_Title_Actual_fontFamily = jTTPD_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", jTTPD_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, jTTPD_Title_Actual_fontFamily);
		}
		String jTTPD_Title_colorValue = jTTPD_Title_xpath.getCssValue("color");
		String jTTPD_Title_Actual_FontColor = Color.fromString(jTTPD_Title_colorValue).asHex();
		Assert.assertEquals("#000000", jTTPD_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement jTTPD_Content_xpath = driver
				.findElement(By.xpath("//p[contains(text(),'Vendors and contractors')]"));
		String jTTPD_Content_FontSize = jTTPD_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", jTTPD_Content_FontSize);

		String jTTPD_Content_Actual_fontFamily = jTTPD_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", jTTPD_Content_Actual_fontFamily);

		String jTTPD_Content_colorValue = jTTPD_Content_xpath.getCssValue("color");
		String jTTPD_Content_Actual_FontColor = Color.fromString(jTTPD_Content_colorValue).asHex();
		Assert.assertEquals("#666666", jTTPD_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement jTTPD_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Join Now')]"));
		String jTTPD_Btn_FontSize = jTTPD_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", jTTPD_Btn_FontSize);

		String jTTPD_Btn_Actual_fontFamily = jTTPD_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", jTTPD_Btn_Actual_fontFamily);

		String jTTPD_Btn_colorValue = jTTPD_Btn_xpath.getCssValue("color");
		String jTTPD_Btn_Actual_FontColor = Color.fromString(jTTPD_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", jTTPD_Btn_Actual_FontColor);
	}

	@Test
	public void ReceiveFullRebateApplicationSupportDesignVerification() {
		WebElement rFRAS_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Receive Full Rebate')]"));
		String rFRAS_Title_FontSize = rFRAS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rFRAS_Title_FontSize);

		String rFRAS_Title_Actual_fontFamily = rFRAS_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rFRAS_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rFRAS_Title_Actual_fontFamily);
		}
		String rFRAS_Title_colorValue = rFRAS_Title_xpath.getCssValue("color");
		String rFRAS_Title_Actual_FontColor = Color.fromString(rFRAS_Title_colorValue).asHex();
		Assert.assertEquals("#000000", rFRAS_Title_Actual_FontColor);

		WebElement rFRAS_Content_xpath = driver.findElement(By.xpath("//p[contains(text(),'Energy-efficient')]"));
		String rFRAS_Content_FontSize = rFRAS_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rFRAS_Content_FontSize);

		String rFRAS_Content_Actual_fontFamily = rFRAS_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rFRAS_Content_Actual_fontFamily);

		String rFRAS_Content_colorValue = rFRAS_Content_xpath.getCssValue("color");
		String rFRAS_Content_Actual_FontColor = Color.fromString(rFRAS_Content_colorValue).asHex();
		Assert.assertEquals("#666666", rFRAS_Content_Actual_FontColor);

		// xpath for Template Disclaimer.
		WebElement template_Disclaimer_xpath = driver.findElement(By.cssSelector("#template-disclaimer>.disclaimer"));
		String template_Disclaimer_FontSize = template_Disclaimer_xpath.getCssValue("font-size");
		Assert.assertEquals("12px", template_Disclaimer_FontSize);

		String template_Disclaimer_Actual_fontFamily = template_Disclaimer_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", template_Disclaimer_Actual_fontFamily);

		String template_Disclaimer_colorValue = template_Disclaimer_xpath.getCssValue("color");
		String template_Disclaimer_Actual_FontColor = Color.fromString(template_Disclaimer_colorValue).asHex();
		Assert.assertEquals("#000000", template_Disclaimer_Actual_FontColor);
	}

	@Test
	public void TradeProSpotlightDesignVerification() {
		WebElement tPS_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Trade Pro Spotlight')]"));
		String tPS_Title_FontSize = tPS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", tPS_Title_FontSize);

		String tPS_Title_Actual_fontFamily = tPS_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", tPS_Title_Actual_fontFamily);

		String tPS_Title_colorValue = tPS_Title_xpath.getCssValue("color");
		String tPS_Title_Actual_FontColor = Color.fromString(tPS_Title_colorValue).asHex();
		Assert.assertEquals("#000000", tPS_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement tPS_Content_xpath = driver.findElement(By.xpath("//div[contains(text(),'See how our customers')]"));
		String tPS_Content_FontSize = tPS_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", tPS_Content_FontSize);

		String tPS_Content_Actual_fontFamily = tPS_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", tPS_Content_Actual_fontFamily);

		String tPS_Content_colorValue = tPS_Content_xpath.getCssValue("color");
		String tPS_Content_Actual_FontColor = Color.fromString(tPS_Content_colorValue).asHex();
		Assert.assertEquals("#666666", tPS_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement tPS_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Read More')]"));
		String tPS_Btn_FontSize = tPS_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", tPS_Btn_FontSize);

		String tPS_Btn_Actual_fontFamily = tPS_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", tPS_Btn_Actual_fontFamily);

		String tPS_Btn_colorValue = tPS_Btn_xpath.getCssValue("color");
		String tPS_Btn_Actual_FontColor = Color.fromString(tPS_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", tPS_Btn_Actual_FontColor);
	}

	@Test
	public void EnergyEfficiencyRebatesAndIncentivesDesignVerification() {
		WebElement eERAI_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Energy-Efficiency')]"));
		String eERAI_Title_FontSize = eERAI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", eERAI_Title_FontSize);

		String eERAI_Title_Actual_fontFamily = eERAI_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eERAI_Title_Actual_fontFamily);

		String eERAI_Title_colorValue = eERAI_Title_xpath.getCssValue("color");
		String eERAI_Title_Actual_FontColor = Color.fromString(eERAI_Title_colorValue).asHex();
		Assert.assertEquals("#000000", eERAI_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement eERAI_Content_xpath = driver.findElement(By.xpath("//p[contains(text(),'We offer rebates and')]"));
		String eERAI_Content_FontSize = eERAI_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eERAI_Content_FontSize);

		String eERAI_Content_Actual_fontFamily = eERAI_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eERAI_Content_Actual_fontFamily);

		String eERAI_Content_colorValue = eERAI_Content_xpath.getCssValue("color");
		String eERAI_Content_Actual_FontColor = Color.fromString(eERAI_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eERAI_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement eERAI_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Learn More')]"));
		String eERAI_Btn_FontSize = eERAI_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eERAI_Btn_FontSize);

		String eERAI_Btn_Actual_fontFamily = eERAI_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eERAI_Btn_Actual_fontFamily);

		String eERAI_Btn_colorValue = eERAI_Btn_xpath.getCssValue("color");
		String eERAI_Btn_Actual_FontColor = Color.fromString(eERAI_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", eERAI_Btn_Actual_FontColor);
	}

	@Test
	public void EducationAndTrainingDesignVerification() {
		WebElement eAT_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Education and Training')]"));
		String eAT_Title_FontSize = eAT_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", eAT_Title_FontSize);

		String eAT_Title_Actual_fontFamily = eAT_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eAT_Title_Actual_fontFamily);

		String eAT_Title_colorValue = eAT_Title_xpath.getCssValue("color");
		String eAT_Title_Actual_FontColor = Color.fromString(eAT_Title_colorValue).asHex();
		Assert.assertEquals("#000000", eAT_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement eAT_Content_xpath = driver.findElement(By.xpath("//p[contains(text(),'We offer seminars,')]"));
		String eAT_Content_FontSize = eAT_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eAT_Content_FontSize);

		String eAT_Content_Actual_fontFamily = eAT_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eAT_Content_Actual_fontFamily);

		String eAT_Content_colorValue = eAT_Content_xpath.getCssValue("color");
		String eAT_Content_Actual_FontColor = Color.fromString(eAT_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eAT_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement eAT_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Learn More')]"));
		String eAT_Btn_FontSize = eAT_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eAT_Btn_FontSize);

		String eAT_Btn_Actual_fontFamily = eAT_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eAT_Btn_Actual_fontFamily);

		String eAT_Btn_colorValue = eAT_Btn_xpath.getCssValue("color");
		String eAT_Btn_Actual_FontColor = Color.fromString(eAT_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", eAT_Btn_Actual_FontColor);
	}

	@Test
	public void SubscribeToOurQuarterlyNewsletterDesignVerification() {
		WebElement sTOQN_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Subscribe to Our')]"));
		String sTOQN_Title_FontSize = sTOQN_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", sTOQN_Title_FontSize);

		String sTOQN_Title_Actual_fontFamily = sTOQN_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", sTOQN_Title_Actual_fontFamily);

		String sTOQN_Title_colorValue = sTOQN_Title_xpath.getCssValue("color");
		String sTOQN_Title_Actual_FontColor = Color.fromString(sTOQN_Title_colorValue).asHex();
		Assert.assertEquals("#000000", sTOQN_Title_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement sTOQN_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Join')])[2]"));
		String sTOQN_Btn_FontSize = sTOQN_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", sTOQN_Btn_FontSize);

		String sTOQN_Btn_Actual_fontFamily = sTOQN_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", sTOQN_Btn_Actual_fontFamily);

		String sTOQN_Btn_colorValue = sTOQN_Btn_xpath.getCssValue("color");
		String sTOQN_Btn_Actual_FontColor = Color.fromString(sTOQN_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", sTOQN_Btn_Actual_FontColor);
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
