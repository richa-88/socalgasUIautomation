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

public class SocalBusinessRebates02 {
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
			driver.get((String) jsonObject1.get("SocalBusinessRebates02"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalBusinessRebates02"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalBusinessRebates02"));
			break;
		}
//		driver.get("https://www.socalgas.com/businessrebates");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void SmallAndMediumBusinessDesignVerification() {
		// Title xpath of Small And Medium Business.
		WebElement sAMB_Title_xpath = driver.findElement(
				By.xpath("//h1/div[contains(@class, 'field--title') and text()='Small and Medium Business']"));
		String sAMB_Actual_Title_FontSize = sAMB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", sAMB_Actual_Title_FontSize);

		String sAMB_Actual_Title_fontFamily = sAMB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", sAMB_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, sAMB_Actual_Title_fontFamily);
		}
		String sAMB_Title_colorValue = sAMB_Title_xpath.getCssValue("color");
		String sAMB_Actual_Title_FontColor = Color.fromString(sAMB_Title_colorValue).asHex();
		Assert.assertEquals("#004693", sAMB_Actual_Title_FontColor);

		// Content xpath of Small And Medium Business.
		WebElement sAMB_Text_xpath = driver.findElement(By.xpath("//div[@class='page-banner__text']/p"));
		String sAMB_Actual_Text_FontSize = sAMB_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", sAMB_Actual_Text_FontSize);

		String sAMB_Actual_Text_fontFamily = sAMB_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", sAMB_Actual_Text_fontFamily);

		String sAMB_Text_colorValue = sAMB_Text_xpath.getCssValue("color");
		String sAMB_Actual_Text_FontColor = Color.fromString(sAMB_Text_colorValue).asHex();
		Assert.assertEquals("#004693", sAMB_Actual_Text_FontColor);
	}

	@Test
	public void RebatesAndIncentivesDesignVerification() {
		// Title xpath of Rebates And Incentives.
		WebElement rAI_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(),'Rebates and Incentives')]"));
		String rAI_Title_Actual_FontSize = rAI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rAI_Title_Actual_FontSize);

		String rAI_Title_Actual_fontFamily = rAI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rAI_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rAI_Title_Actual_fontFamily);
		}
		String rAI_Title_Actual_colorValue = rAI_Title_xpath.getCssValue("color");
		String rAI_Title_Actual_FontColor = Color.fromString(rAI_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", rAI_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement rAI_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'Save money and energy')]"));
		String rAI_Content_FontSize = rAI_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rAI_Content_FontSize);

		String rAI_Content_Actual_fontFamily = rAI_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rAI_Content_Actual_fontFamily);

		String rAI_Content_colorValue = rAI_Content_xpath.getCssValue("color");
		String rAI_Content_Actual_FontColor = Color.fromString(rAI_Content_colorValue).asHex();
		Assert.assertEquals("#666666", rAI_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement rAI_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String rAI_Btn_FontSize = rAI_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rAI_Btn_FontSize);

		String rAI_Btn_Actual_fontFamily = rAI_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAI_Btn_Actual_fontFamily);

		String rAI_Btn_colorValue = rAI_Btn_xpath.getCssValue("color");
		String rAI_Btn_Actual_FontColor = Color.fromString(rAI_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", rAI_Btn_Actual_FontColor);

	}

	@Test
	public void TradeProfessionalProgramDesignVerification() {
		// Tittle xpath of Trade Professional Program.
		WebElement tPP_Title_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--title') and (text() = 'Trade Professional Program')]"));
		String tPP_Title_FontSize = tPP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", tPP_Title_FontSize);

		String tPP_Title_Actual_fontFamily = tPP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", tPP_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, tPP_Title_Actual_fontFamily);
		}
		String tPP_Title_Actual_colorValue = tPP_Title_xpath.getCssValue("color");
		String tPP_Title_Actual_FontColor = Color.fromString(tPP_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", tPP_Title_Actual_FontColor);

		// Content xpath of Trade Professional Program.
		WebElement tpp_Content_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--text') and contains(., 'Find experienced')]"));
		String tpp_Content_FontSize = tpp_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", tpp_Content_FontSize);

		String tpp_Content_Actual_fontFamily = tpp_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", tpp_Content_Actual_fontFamily);

		String tPP_Content_colorValue = tpp_Content_xpath.getCssValue("color");
		String tPP_Content_Actual_FontColor = Color.fromString(tPP_Content_colorValue).asHex();
		Assert.assertEquals("#666666", tPP_Content_Actual_FontColor);

		// Link text xpath for Trade Professional Program.
		WebElement tpp_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String tpp_Btn_FontSize = tpp_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", tpp_Btn_FontSize);

		String tpp_Btn_Actual_fontFamily = tpp_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", tpp_Btn_Actual_fontFamily);

		String tPP_Btn_colorValue = tpp_Btn_xpath.getCssValue("color");
		String tPP_Btn_Actual_FontColor = Color.fromString(tPP_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", tPP_Btn_Actual_FontColor);
	}

	@Test
	public void EnergyEfficiencyThirdpartyProgramsDesignVerification() {
		// Tittle xpath of Energy Efficiency Thirdparty Programs.
		WebElement eETP_Title_xpath = driver.findElement(By.xpath(
				"//div[contains(@class, 'field--title') and (text() = 'Energy-Efficiency Third-party Programs')]"));
		String eETP_Title_FontSize = eETP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", eETP_Title_FontSize);

		String eETP_Title_Actual_fontFamily = eETP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", eETP_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eETP_Title_Actual_fontFamily);
		}
		String eETP_Title_Actual_colorValue = eETP_Title_xpath.getCssValue("color");
		String eETP_Title_Actual_FontColor = Color.fromString(eETP_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", eETP_Title_Actual_FontColor);

		// Content xpath of Energy Efficiency Thirdparty Programs.
		WebElement eETP_Content_xpath = driver.findElement(By.xpath(
				"//div[contains(@class, 'field--text') and contains(., 'Find additional contractor implemented ')]"));
		String eETP_Content_FontSize = eETP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eETP_Content_FontSize);

		String eETP_Content_Actual_fontFamily = eETP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eETP_Content_Actual_fontFamily);

		String eETP_Content_colorValue = eETP_Content_xpath.getCssValue("color");
		String eETP_Content_Actual_FontColor = Color.fromString(eETP_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eETP_Content_Actual_FontColor);

		// Link text xpath Energy Efficiency Thirdparty Programs.
		WebElement eETP_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Search Programs')]"));
		String eETP_Btn_FontSize = eETP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eETP_Btn_FontSize);

		String eETP_Btn_Actual_fontFamily = eETP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eETP_Btn_Actual_fontFamily);

		String eETP_Btn_colorValue = eETP_Btn_xpath.getCssValue("color");
		String eETP_Btn_Actual_FontColor = Color.fromString(eETP_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", eETP_Btn_Actual_FontColor);
	}

	@Test
	public void EnergySavingTipsAndToolsDesignVerification() {
		// Tittle xpath of Energy-Saving Tips and Tools.
		WebElement eSTAT_Title_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--title') and (text() = 'Energy-Saving Tips and Tools')]"));
		String eSTAT_Title_FontSize = eSTAT_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", eSTAT_Title_FontSize);

		String eSTAT_Title_Actual_fontFamily = eSTAT_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", eSTAT_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eSTAT_Title_Actual_fontFamily);
		}

		String eSTAT_Title_colorValue = eSTAT_Title_xpath.getCssValue("color");
		String eSTAT_Title_Actual_FontColor = Color.fromString(eSTAT_Title_colorValue).asHex();
		Assert.assertEquals("#000000", eSTAT_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement eETP_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'We offer a variety of tools')]"));
		String eETP_Content_FontSize = eETP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eETP_Content_FontSize);

		String eETP_Content_Actual_fontFamily = eETP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eETP_Content_Actual_fontFamily);

		String eSTAT_Content_colorValue = eETP_Content_xpath.getCssValue("color");
		String eSTAT_Content_Actual_FontColor = Color.fromString(eSTAT_Content_colorValue).asHex();
		Assert.assertEquals("#666666", eSTAT_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement eSTAT_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Find Tools')]"));
		String eSTAT_Btn_FontSize = eSTAT_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eSTAT_Btn_FontSize);

		String eSTAT_Btn_Actual_fontFamily = eSTAT_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eSTAT_Btn_Actual_fontFamily);

		String eSTAT_Btn_colorValue = eSTAT_Btn_xpath.getCssValue("color");
		String eSTAT_Btn_Actual_FontColor = Color.fromString(eSTAT_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", eSTAT_Btn_Actual_FontColor);
	}

	@Test
	public void NaturalGasRatesExplainedDesignVerification() {
		// Tittle xpath of Natural Gas Rates Explained.
		WebElement nGRE_Title_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--title') and (text() = 'Natural Gas Rates Explained')]"));
		String nGRE_Title_FontSize = nGRE_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", nGRE_Title_FontSize);

		String nGRE_Title_Actual_fontFamily = nGRE_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", nGRE_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, nGRE_Title_Actual_fontFamily);
		}
		String nGRE_Title_colorValue = nGRE_Title_xpath.getCssValue("color");
		String nGRE_Title_Actual_FontColor = Color.fromString(nGRE_Title_colorValue).asHex();
		Assert.assertEquals("#000000", nGRE_Title_Actual_FontColor);

		// Content xpath of Natural Gas Rates Explained.
		WebElement nGRE_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'See how natural gas prices')]"));
		String eETP_Content_FontSize = nGRE_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eETP_Content_FontSize);

		String nGRE_Content_Actual_fontFamily = nGRE_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", nGRE_Content_Actual_fontFamily);

		String nGRE_Content_colorValue = nGRE_Content_xpath.getCssValue("color");
		String nGRE_Content_Actual_FontColor = Color.fromString(nGRE_Content_colorValue).asHex();
		Assert.assertEquals("#666666", nGRE_Content_Actual_FontColor);

		// Link text xpath for Natural Gas Rates Explained.
		WebElement nGRE_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String nGRE_Btn_FontSize = nGRE_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", nGRE_Btn_FontSize);

		String nGRE_Btn_Actual_fontFamily = nGRE_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", nGRE_Btn_Actual_fontFamily);

		String nGRE_Btn_colorValue = nGRE_Btn_xpath.getCssValue("color");
		String nGRE_Btn_Actual_FontColor = Color.fromString(nGRE_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", nGRE_Btn_Actual_FontColor);
	}

	@Test
	public void BusinessMyAccountDesignVerification() {
		// Tittle xpath of Business My Account.
		WebElement bMA_Title_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--title') and (text() = 'Business My Account')]"));
		String bMA_Title_FontSize = bMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", bMA_Title_FontSize);

		String bMA_Title_Actual_fontFamily = bMA_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", bMA_Title_Actual_fontFamily);

		String bMA_Title_colorValue = bMA_Title_xpath.getCssValue("color");
		String bMA_Title_Actual_FontColor = Color.fromString(bMA_Title_colorValue).asHex();
		Assert.assertEquals("#000000", bMA_Title_Actual_FontColor);

		// Content xpath of Business My Account.
		WebElement bMA_Content_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Business customers now')]"));
		String bMA_Content_FontSize = bMA_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", bMA_Content_FontSize);

		String bMA_Content_Actual_fontFamily = bMA_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", bMA_Content_Actual_fontFamily);

		String bMA_Content_colorValue = bMA_Content_xpath.getCssValue("color");
		String bMA_Content_Actual_FontColor = Color.fromString(bMA_Content_colorValue).asHex();
		Assert.assertEquals("#666666", bMA_Content_Actual_FontColor);

		// Link text xpath for Business My Account.
		WebElement bMA_Btn_xpath = driver.findElement(
				By.xpath("//div[contains(@class,'featured-item__links-set')]/a[contains(text(),'Learn More')]"));
		String bMA_Btn_FontSize = bMA_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", bMA_Btn_FontSize);

		String bMA_Btn_Actual_fontFamily = bMA_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", bMA_Btn_Actual_fontFamily);

		String bMA_Btn_colorValue = bMA_Btn_xpath.getCssValue("color");
		String bMA_Btn_Actual_FontColor = Color.fromString(bMA_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", bMA_Btn_Actual_FontColor);
	}

	@Test
	public void DoBusinessWithUsDesignVerification() {
		// Tittle xpath of Do Business With Us.
		WebElement dBWUs_Title_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--title') and (text() = 'Do Business With Us')]"));
		String dBWUs_Title_FontSize = dBWUs_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", dBWUs_Title_FontSize);

		String dBWUs_Title_Actual_fontFamily = dBWUs_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", dBWUs_Title_Actual_fontFamily);

		String dBWUs_Title_colorValue = dBWUs_Title_xpath.getCssValue("color");
		String dBWUs_Title_Actual_FontColor = Color.fromString(dBWUs_Title_colorValue).asHex();
		Assert.assertEquals("#000000", dBWUs_Title_Actual_FontColor);

		// Content xpath of Do Business With Us.
		WebElement dBWUs_Content_xpath = driver
				.findElement(By.xpath("//div[(@class='field--text') and contains(text(), 'Business customers now')]"));
		String dBWUs_Content_FontSize = dBWUs_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", dBWUs_Content_FontSize);

		String dBWUs_Content_Actual_fontFamily = dBWUs_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", dBWUs_Content_Actual_fontFamily);

		String dBWUs_Content_colorValue = dBWUs_Content_xpath.getCssValue("color");
		String dBWUs_Content_Actual_FontColor = Color.fromString(dBWUs_Content_colorValue).asHex();
		Assert.assertEquals("#666666", dBWUs_Content_Actual_FontColor);

		// Link text xpath Do Business With Us.
		WebElement dBWUs_Btn_xpath = driver.findElement(By.xpath("//a[contains(.,'866-616-5565')]"));
		String dBWUs_Btn_FontSize = dBWUs_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", dBWUs_Btn_FontSize);

		String dBWUs_Btn_Actual_fontFamily = dBWUs_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", dBWUs_Btn_Actual_fontFamily);

		String dBWUs_Btn_colorValue = dBWUs_Btn_xpath.getCssValue("color");
		String dBWUs_Btn_Actual_FontColor = Color.fromString(dBWUs_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", dBWUs_Btn_Actual_FontColor);
	}

	@Test
	public void CommercialDirectInstallProgramDesignVerification() {
		// Tittle xpath of Commercial Direct Install Program.
		WebElement cDIP_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Commercial Direct Install Program')]"));
		String cDIP_Title_FontSize = cDIP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", cDIP_Title_FontSize);

		String cDIP_Title_Actual_fontFamily = cDIP_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cDIP_Title_Actual_fontFamily);

		String cDIP_Title_colorValue = cDIP_Title_xpath.getCssValue("color");
		String cDIP_Title_Actual_FontColor = Color.fromString(cDIP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", cDIP_Title_Actual_FontColor);

		// Content xpath of Commercial Direct Install Program.
		WebElement cDIP_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'As a small or medium')]"));
		String cDIP_Content_FontSize = cDIP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cDIP_Content_FontSize);

		String cDIP_Content_Actual_fontFamily = cDIP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cDIP_Content_Actual_fontFamily);

		String cDIP_Content_colorValue = cDIP_Content_xpath.getCssValue("color");
		String cDIP_Content_Actual_FontColor = Color.fromString(cDIP_Content_colorValue).asHex();
		Assert.assertEquals("#666666", cDIP_Content_Actual_FontColor);

		// Link text xpath Commercial Direct Install Program.
		WebElement cDIP_Btn_xpath = driver.findElement(
				By.xpath("//div[contains(@class,'featured-item__links-set')]/a[contains(text(),'Learn More')]"));
		String cDIP_Btn_FontSize = cDIP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cDIP_Btn_FontSize);

		String cDIP_Btn_Actual_fontFamily = cDIP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cDIP_Btn_Actual_fontFamily);

		String cDIP_Btn_colorValue = cDIP_Btn_xpath.getCssValue("color");
		String cDIP_Btn_Actual_FontColor = Color.fromString(cDIP_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", cDIP_Btn_Actual_FontColor);
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
		System.out.println("Business Rebates Class 02 Executed sucessfully");
	}
}
