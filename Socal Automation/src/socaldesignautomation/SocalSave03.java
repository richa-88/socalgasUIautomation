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

public class SocalSave03 {
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
			driver.get((String) jsonObject1.get("SocalSave03"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalSave03"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalSave03"));
			break;
		}
//		driver.get("https://www.socalgas.com/save");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void SaveMoneyAndEnergyDesignVerification() {
		// Link text xpath Save Money And Energy
		WebElement sMAE_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(@class, 'field--title') and text() = 'Save Money & Energy']"));
		String sMAE_Actual_Title_FontSize = sMAE_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", sMAE_Actual_Title_FontSize);

		String sMAE_Actual_Title_fontFamily = sMAE_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", sMAE_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, sMAE_Actual_Title_fontFamily);
		}
		String sMAE_Title_colorValue = sMAE_Title_xpath.getCssValue("color");
		String sMAE_Actual_Title_FontColor = Color.fromString(sMAE_Title_colorValue).asHex();
		Assert.assertEquals("#004693", sMAE_Actual_Title_FontColor);

		// Content xpath Save Money And Energy.
		WebElement sMAE_Text_xpath = driver.findElement(By.xpath("//div[@class='page-banner__text']/p"));
		String sMAE_Actual_Text_FontSize = sMAE_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", sMAE_Actual_Text_FontSize);

		String rAndI_Actual_Text_fontFamily = sMAE_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAndI_Actual_Text_fontFamily);

		String sMAE_Text_colorValue = sMAE_Text_xpath.getCssValue("color");
		String sMAE_Actual_Text_FontColor = Color.fromString(sMAE_Text_colorValue).asHex();
		Assert.assertEquals("#004693", sMAE_Actual_Text_FontColor);
	}

	@Test
	public void RebatesAndIncentivesDesignVerifiation() {
		// Title xpath of Rebates And Incentives
		WebElement rAI_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Rebates & Incentives')]"));
		String rAI_Title_Actual_FontSize = rAI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rAI_Title_Actual_FontSize);

		String rAI_Title_Actual_fontFamily = rAI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rAI_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rAI_Title_Actual_fontFamily);
		}
		String rAI_Title_Actual_colorValue = rAI_Title_xpath.getCssValue("color");
		String rAI_Title_Actual_FontColor = Color.fromString(rAI_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rAI_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement rAI_Content_xpath = driver.findElement(By.xpath(
				"//p[contains(@class, 'page-banner__sub-title') and contains(., 'Take advantage of available')]"));
		String rAI_Content_FontSize = rAI_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rAI_Content_FontSize);

		String rAI_Content_Actual_fontFamily = rAI_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rAI_Content_Actual_fontFamily);

		String rAI_Content_colorValue = rAI_Content_xpath.getCssValue("color");
		String rAI_Content_Actual_FontColor = Color.fromString(rAI_Content_colorValue).asHex();
		Assert.assertEquals("#ffffff", rAI_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement rAI_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-primary' and contains(text(),'Search Rebates')]"));
		String rAI_Btn_FontSize = rAI_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rAI_Btn_FontSize);

		String rAI_Btn_Actual_fontFamily = rAI_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAI_Btn_Actual_fontFamily);

		String rAI_Btn_colorValue = rAI_Btn_xpath.getCssValue("color");
		String rAI_Btn_Actual_FontColor = Color.fromString(rAI_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", rAI_Btn_Actual_FontColor);
	}

	@Test
	public void AssistanceProgramsDesignVerification() {
		// Title xpath of Assistance Programs.
		WebElement aP_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Assistance Programs')]"));
		String aP_Title_Actual_FontSize = aP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", aP_Title_Actual_FontSize);

		String aP_Title_Actual_fontFamily = aP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", aP_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, aP_Title_Actual_fontFamily);
		}

		String aP_Title_Actual_colorValue = aP_Title_xpath.getCssValue("color");
		String aP_Title_Actual_FontColor = Color.fromString(aP_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", aP_Title_Actual_FontColor);

		// content xpath of Assistance Programs
		WebElement aP_Content_xpath = driver.findElement(By
				.xpath("//div[contains(@class, 'field--text') and contains(., 'You could save money and conserve')]"));
		String aP_Content_FontSize = aP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aP_Content_FontSize);

		String aP_Content_Actual_fontFamily = aP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", aP_Content_Actual_fontFamily);

		String aP_Content_colorValue = aP_Content_xpath.getCssValue("color");
		String aP_Content_Actual_FontColor = Color.fromString(aP_Content_colorValue).asHex();
		Assert.assertEquals("#666666", aP_Content_Actual_FontColor);

		// Link text xpath of Assistance Programs
		WebElement aP_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Search Programs')]"));
		String aP_Btn_FontSize = aP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aP_Btn_FontSize);

		String aP_Btn_Actual_fontFamily = aP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", aP_Btn_Actual_fontFamily);

		String aP_Btn_colorValue = aP_Btn_xpath.getCssValue("color");
		String aP_Btn_Actual_FontColor = Color.fromString(aP_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", aP_Btn_Actual_FontColor);
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
		Assert.assertEquals("#ffffff", eSTAT_Title_Actual_FontColor);

		// Content xpath of Energy-Saving Tips and Tools.
		WebElement eETP_Content_xpath = driver.findElement(By.xpath(
				"//p[contains(@class, 'page-banner__sub-title') and contains(., 'Learn how to conserve energy')]"));
		String eETP_Content_FontSize = eETP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eETP_Content_FontSize);

		String eETP_Content_Actual_fontFamily = eETP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eETP_Content_Actual_fontFamily);

		String eSTAT_Content_colorValue = eSTAT_Title_xpath.getCssValue("color");
		String eSTAT_Content_Actual_FontColor = Color.fromString(eSTAT_Content_colorValue).asHex();
		Assert.assertEquals("#ffffff", eSTAT_Content_Actual_FontColor);

		// Link text xpath for Energy-Saving Tips and Tools.
		WebElement eSTAT_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-primary' and contains(text(),'Start Saving')]"));
		String eSTAT_Btn_FontSize = eSTAT_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eSTAT_Btn_FontSize);

		String eSTAT_Btn_Actual_fontFamily = eSTAT_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eSTAT_Btn_Actual_fontFamily);

		String eSTAT_Btn_colorValue = eSTAT_Btn_xpath.getCssValue("color");
		String eSTAT_Btn_Actual_FontColor = Color.fromString(eSTAT_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", eSTAT_Btn_Actual_FontColor);
	}

	@Test
	public void SolarWaterHeatingDesignVerification() {
		// Title xpath of Solar Water Heating.
		WebElement sWH_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Assistance Programs')]"));
		String sWH_Title_Actual_FontSize = sWH_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", sWH_Title_Actual_FontSize);

		String sWH_Title_Actual_fontFamily = sWH_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", sWH_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, sWH_Title_Actual_fontFamily);
		}
		String sWH_Title_Actual_colorValue = sWH_Title_xpath.getCssValue("color");
		String sWH_Title_Actual_FontColor = Color.fromString(sWH_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", sWH_Title_Actual_FontColor);

		// content xpath of Solar Water Heating.
		WebElement sWH_Content_xpath = driver.findElement(By
				.xpath("//div[contains(@class, 'field--text') and contains(., 'You could save money and conserve')]"));
		String sWH_Content_FontSize = sWH_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", sWH_Content_FontSize);

		String sWH_Content_Actual_fontFamily = sWH_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", sWH_Content_Actual_fontFamily);

		String sWH_Content_colorValue = sWH_Content_xpath.getCssValue("color");
		String sWH_Content_Actual_FontColor = Color.fromString(sWH_Content_colorValue).asHex();
		Assert.assertEquals("#666666", sWH_Content_Actual_FontColor);

		// Link text of Solar Water Heating.
		WebElement sWH_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Search Programs')]"));
		String sWH_Btn_FontSize = sWH_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", sWH_Btn_FontSize);

		String sWH_Btn_Actual_fontFamily = sWH_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", sWH_Btn_Actual_fontFamily);

		String sWH_Btn_colorValue = sWH_Btn_xpath.getCssValue("color");
		String sWH_Btn_Actual_FontColor = Color.fromString(sWH_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", sWH_Btn_Actual_FontColor);
	}

	@Test
	public void NaturalGasVehiclesDesignVerification() {
		// Tittle xpath of Natural Gas Vehicles.
		WebElement nGV_Title_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--title') and (text() = 'Natural Gas Vehicles')]"));
		String nGV_Title_FontSize = nGV_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", nGV_Title_FontSize);

		String nGV_Title_Actual_fontFamily = nGV_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", nGV_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, nGV_Title_Actual_fontFamily);
		}
		String nGV_Title_colorValue = nGV_Title_xpath.getCssValue("color");
		String nGV_Title_Actual_FontColor = Color.fromString(nGV_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", nGV_Title_Actual_FontColor);

		// Content xpath of Natural Gas Vehicles.
		WebElement nGV_Content_xpath = driver.findElement(
				By.xpath("//p[contains(@class, 'page-banner__sub-title') and contains(., 'Find out how NGVs')]"));
		String nGV_Content_FontSize = nGV_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", nGV_Content_FontSize);

		String nGRE_Content_Actual_fontFamily = nGV_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", nGRE_Content_Actual_fontFamily);

		String nGV_Content_colorValue = nGV_Title_xpath.getCssValue("color");
		String nGV_Content_Actual_FontColor = Color.fromString(nGV_Content_colorValue).asHex();
		Assert.assertEquals("#ffffff", nGV_Content_Actual_FontColor);

		// Link text xpath of Natural Gas Vehicles.
		WebElement nGV_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String nGV_Btn_FontSize = nGV_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", nGV_Btn_FontSize);

		String nGV_Btn_Actual_fontFamily = nGV_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", nGV_Btn_Actual_fontFamily);

		String nGV_Btn_colorValue = nGV_Btn_xpath.getCssValue("color");
		String nGV_Btn_Actual_FontColor = Color.fromString(nGV_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", nGV_Btn_Actual_FontColor);
	}

	@Test
	public void AdvancedMeterDesignVerification() {
		// Tittle xpath of Advanced Meter.
		WebElement aM_Title_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--title') and (text() = 'Solar Water Heating')]"));
		String aM_Title_FontSize = aM_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", aM_Title_FontSize);

		String aM_Title_Actual_fontFamily = aM_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", aM_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, aM_Title_Actual_fontFamily);
		}
		String aM_Title_colorValue = aM_Title_xpath.getCssValue("color");
		String aM_Title_Actual_FontColor = Color.fromString(aM_Title_colorValue).asHex();
		Assert.assertEquals("#000000", aM_Title_Actual_FontColor);

		// Content xpath of Advanced Meter.
		WebElement aM_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'Find out how our Advanced Meter')]"));
		String aM_Content_FontSize = aM_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aM_Content_FontSize);

		String aM_Content_Actual_fontFamily = aM_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", aM_Content_Actual_fontFamily);

		String aM_Content_colorValue = aM_Content_xpath.getCssValue("color");
		String aM_Content_Actual_FontColor = Color.fromString(aM_Content_colorValue).asHex();
		Assert.assertEquals("#666666", aM_Content_Actual_FontColor);

		// Link text xpath of Advanced Meter.
		WebElement aM_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String aM_Btn_FontSize = aM_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", aM_Btn_FontSize);

		String aM_Btn_Actual_fontFamily = aM_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", aM_Btn_Actual_fontFamily);

		String aM_Btn_colorValue = aM_Btn_xpath.getCssValue("color");
		String aM_Btn_Actual_FontColor = Color.fromString(aM_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", aM_Btn_Actual_FontColor);
	}

	@Test
	public void ComplimentaryEnergyEfficiencyStarterKitDesignVerification() {
		// Tittle xpath of Complimentary Energy Efficiency Starter Kit.
		WebElement cEESK_Title_xpath = driver.findElement(By
				.xpath(".//div[contains(@class, 'field--title') and contains(., 'Complimentary Energy-Efficiency')]"));
		String cEESK_Title_FontSize = cEESK_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", cEESK_Title_FontSize);

		String cEESK_Title_Actual_fontFamily = cEESK_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cEESK_Title_Actual_fontFamily);

		String cEESK_Title_colorValue = cEESK_Title_xpath.getCssValue("color");
		String cEESK_Title_Actual_FontColor = Color.fromString(cEESK_Title_colorValue).asHex();
		Assert.assertEquals("#000000", cEESK_Title_Actual_FontColor);

		// Content xpath of Complimentary Energy Efficiency Starter Kit.
		WebElement cEESK_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'Start saving energy and money')]/p"));
		String cEESK_Content_FontSize = cEESK_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cEESK_Content_FontSize);

		String cEESK_Content_Actual_fontFamily = cEESK_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cEESK_Content_Actual_fontFamily);

		String cEESK_Content_colorValue = cEESK_Content_xpath.getCssValue("color");
		String cEESK_Content_Actual_FontColor = Color.fromString(cEESK_Content_colorValue).asHex();
		Assert.assertEquals("#666666", cEESK_Content_Actual_FontColor);

		// Link text xpath of Complimentary Energy Efficiency Starter Kit.
		WebElement cEESK_Btn_xpath = driver.findElement(
				By.xpath("//a[@class='featured-item__link feature--item--link ' and contains(text(),'Order Today')]"));
		String cEESK_Btn_FontSize = cEESK_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cEESK_Btn_FontSize);

		String cEESK_Btn_Actual_fontFamily = cEESK_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cEESK_Btn_Actual_fontFamily);

		String cEESK_Btn_colorValue = cEESK_Btn_xpath.getCssValue("color");
		String cEESK_Btn_Actual_FontColor = Color.fromString(cEESK_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", cEESK_Btn_Actual_FontColor);
	}

	@Test
	public void CaliforniaAlternateRatesForEnergyCAREDesignVerification() {
		// Tittle xpath of California Alternate Rates For Energy CARED.
		WebElement cARFEC_Title_xpath = driver.findElement(
				By.xpath(".//div[contains(@class, 'field--title') and contains(., 'California Alternate Rates')]"));
		String cARFEC_Title_FontSize = cARFEC_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", cARFEC_Title_FontSize);

		String cARFEC_Title_Actual_fontFamily = cARFEC_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cARFEC_Title_Actual_fontFamily);

		String cARFEC_Title_colorValue = cARFEC_Title_xpath.getCssValue("color");
		String cARFEC_Title_Actual_FontColor = Color.fromString(cARFEC_Title_colorValue).asHex();
		Assert.assertEquals("#000000", cARFEC_Title_Actual_FontColor);

		// Content xpath of California Alternate Rates For Energy CARED.
		WebElement cARFEC_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'Qualified customers can get 20')]/p"));
		String cARFEC_Content_FontSize = cARFEC_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cARFEC_Content_FontSize);

		String cARFEC_Content_Actual_fontFamily = cARFEC_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cARFEC_Content_Actual_fontFamily);

		String cARFEC_Content_colorValue = cARFEC_Content_xpath.getCssValue("color");
		String cARFEC_Content_Actual_FontColor = Color.fromString(cARFEC_Content_colorValue).asHex();
		Assert.assertEquals("#666666", cARFEC_Content_Actual_FontColor);

		// Link text xpath for California Alternate Rates For Energy CARED.
		WebElement cARFEC_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='featured-item__link  ' and contains(text(),'See If You Qualify')]"));
		String cARFEC_Btn_FontSize = cARFEC_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cARFEC_Btn_FontSize);

		String cARFEC_Btn_Actual_fontFamily = cARFEC_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cARFEC_Btn_Actual_fontFamily);

		String cARFEC_Btn_colorValue = cARFEC_Btn_xpath.getCssValue("color");
		String cARFEC_Btn_Actual_FontColor = Color.fromString(cARFEC_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", cARFEC_Btn_Actual_FontColor);
	}

	@Test
	public void GasSuppliersforNoncoreCustomersDesignVerification() {
		// Tittle xpath of Gas Suppliers for Noncore Customers
		WebElement gSFNC_Title_xpath = driver
				.findElement(By.xpath(".//div[contains(@class, 'field--title') and contains(., 'Gas Suppliers for')]"));
		String gSFNC_Title_FontSize = gSFNC_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", gSFNC_Title_FontSize);

		String gSFNC_Title_Actual_fontFamily = gSFNC_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", gSFNC_Title_Actual_fontFamily);

		String gSFNC_Title_colorValue = gSFNC_Title_xpath.getCssValue("color");
		String gSFNC_Title_Actual_FontColor = Color.fromString(gSFNC_Title_colorValue).asHex();
		Assert.assertEquals("#000000", gSFNC_Title_Actual_FontColor);

		// Content xpath of Gas Suppliers for Noncore Customers
		WebElement gSFNC_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'View our residential')]/div"));
		String gSFNC_Content_FontSize = gSFNC_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", gSFNC_Content_FontSize);

		String cEESK_Content_Actual_fontFamily = gSFNC_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cEESK_Content_Actual_fontFamily);

		String gSFNC_Content_colorValue = gSFNC_Content_xpath.getCssValue("color");
		String gSFNC_Content_Actual_FontColor = Color.fromString(gSFNC_Content_colorValue).asHex();
		Assert.assertEquals("#666666", gSFNC_Content_Actual_FontColor);

		// Link text xpath for Gas Suppliers for Noncore Customers.
		WebElement gSFNC_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='featured-item__link  ' and contains(text(),'Search Suppliers')]"));
		String gSFNC_Btn_FontSize = gSFNC_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", gSFNC_Btn_FontSize);

		String gSFNC_Btn_Actual_fontFamily = gSFNC_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", gSFNC_Btn_Actual_fontFamily);

		String gSFNC_Btn_colorValue = gSFNC_Btn_xpath.getCssValue("color");
		String gSFNC_Btn_Actual_FontColor = Color.fromString(gSFNC_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", gSFNC_Btn_Actual_FontColor);
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
		System.out.println("Socal Save Class Executed sucessfully");
	}
}
