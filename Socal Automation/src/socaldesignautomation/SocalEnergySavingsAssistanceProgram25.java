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

public class SocalEnergySavingsAssistanceProgram25 {
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
			driver.get((String) jsonObject1.get("SocalEnergySavingsAssistanceProgram25"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalEnergySavingsAssistanceProgram25"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalEnergySavingsAssistanceProgram25"));
			break;
		}
//		driver.get("https://www.socalgas.com/save-money-and-energy/assistance-programs/energy-savings-assistance-program");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void EnergySavingsAssistanceProgramDesignVerification() {
		WebElement ESAP_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Energy Savings Assistance')]"));
		String ESAP_FontSize = ESAP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", ESAP_FontSize);

		String ESAP_xpath_Actual_fontFamily = ESAP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ESAP_xpath_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ESAP_xpath_Actual_fontFamily);
		}
		String ESAP_Title_colorValue = ESAP_Title_xpath.getCssValue("color");
		String ESAP_Actual_Title_FontColor = Color.fromString(ESAP_Title_colorValue).asHex();
		Assert.assertEquals("#004693", ESAP_Actual_Title_FontColor);

		// Sub Description.
		WebElement ESAP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Save energy and money')]"));
		String ESAP_Desc_FontSize = ESAP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", ESAP_Desc_FontSize);

		String ESAP_Desc_fontFamily = ESAP_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", ESAP_Desc_fontFamily);

		String ESAP_Desc_colorValue = ESAP_Desc_xpath.getCssValue("color");
		String ESAP_Desc_Actual_FontColor = Color.fromString(ESAP_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", ESAP_Desc_Actual_FontColor);
	}

	@Test
	public void HowToApplyDesignVerification() {
		// Title
		WebElement HTP_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'How to Apply')]"));
		String HTP_Title_FontSize = HTP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", HTP_Title_FontSize);

		String HTP_Title_fontFamily = HTP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", HTP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, HTP_Title_fontFamily);
		}
		String HTP_Title_colorValue = HTP_Title_xpath.getCssValue("color");
		String HTP_Title_Actual_FontColor = Color.fromString(HTP_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", HTP_Title_Actual_FontColor);

		// Descriptions.
		WebElement HTP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'If you are recently')]"));
		String HTP_Desc_FontSize = HTP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", HTP_Desc_FontSize);

		String HTP_Desc_fontFamily = HTP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", HTP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, HTP_Desc_fontFamily);
		}
		String HTP_Desc_colorValue = HTP_Desc_xpath.getCssValue("color");
		String HTP_Desc_Actual_FontColor = Color.fromString(HTP_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", HTP_Desc_Actual_FontColor);

		// Login Button.
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(),'Complete Form')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#000000", Link_Text_Actual_FontColor);
	}

	@Test
	public void WaystoQualifyDesignVerification() {
		WebElement WTQ_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Ways to qualify:')]"));

		String WTQ_Title_FontSize = WTQ_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", WTQ_Title_FontSize);

		String WTQ_Title_fontFamily = WTQ_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTQ_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTQ_Title_fontFamily);
		}
		String WTQ_Title_FontWeight = WTQ_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", WTQ_Title_FontWeight);

		String WTQ_Title_colorValue = WTQ_Title_xpath.getCssValue("color");
		String WTQ_Title_Actual_FontColor = Color.fromString(WTQ_Title_colorValue).asHex();
		Assert.assertEquals("#000000", WTQ_Title_Actual_FontColor);

		WebElement Table_Text_xpath = driver.findElement(By.xpath("(//table/tbody/tr[2]/td)[1]"));

		String Table_Text_FontSize = Table_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Table_Text_FontSize);

		String Table_Text_fontFamily = Table_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Table_Text_fontFamily);

		String Table_Text_colorValue = Table_Text_xpath.getCssValue("color");
		String Table_Text_Actual_FontColor = Color.fromString(Table_Text_colorValue).asHex();
		Assert.assertEquals("#666666", Table_Text_Actual_FontColor);

		WebElement HouseholdSize_Title_xpath = driver.findElement(By.xpath("//table/thead/tr/th[1]"));

		String HouseholdSize_Title_FontSize = HouseholdSize_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", HouseholdSize_Title_FontSize);

		String HouseholdSize_Title_fontFamily = HouseholdSize_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", HouseholdSize_Title_fontFamily);

		String HouseholdSize_Title_FontWeight = HouseholdSize_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", HouseholdSize_Title_FontWeight);

		String HouseholdSize_Title_colorValue = HouseholdSize_Title_xpath.getCssValue("color");
		String HouseholdSize_Title_Actual_FontColor = Color.fromString(HouseholdSize_Title_colorValue).asHex();
		Assert.assertEquals("#000000", HouseholdSize_Title_Actual_FontColor);
	}

	@Test
	public void ServicesAvailableDesignVerification() {
		WebElement Services_Avai_Title_xpath = driver
				.findElement(By.xpath("//h2[contains(text(), 'Services Available')]"));

		String Services_Avai_Title_FontSize = Services_Avai_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", Services_Avai_Title_FontSize);

		String Services_Avai_Title_fontFamily = Services_Avai_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Services_Avai_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Services_Avai_Title_fontFamily);
		}
		String Services_Avai_Title_FontWeight = Services_Avai_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", Services_Avai_Title_FontWeight);

		String Services_Avai_Title_colorValue = Services_Avai_Title_xpath.getCssValue("color");
		String Services_Avai_Title_Actual_FontColor = Color.fromString(Services_Avai_Title_colorValue).asHex();
		Assert.assertEquals("#000000", Services_Avai_Title_Actual_FontColor);

		WebElement Table_Text_xpath = driver.findElement(By.xpath("(//table/tbody/tr[1]/td[1])[2]"));

		String Table_Text_FontSize = Table_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Table_Text_FontSize);

		String Table_Text_fontFamily = Table_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Table_Text_fontFamily);

		String Table_Text_colorValue = Table_Text_xpath.getCssValue("color");
		String Table_Text_Actual_FontColor = Color.fromString(Table_Text_colorValue).asHex();
		Assert.assertEquals("#666666", Table_Text_Actual_FontColor);
	}

	@Test
	public void HowThisProgramWorksDesignVerification() {
		// Title xpath of Rebates And Incentives
		WebElement HTPWs_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'How this Program')]"));
		String HTPWs_Title_Actual_FontSize = HTPWs_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", HTPWs_Title_Actual_FontSize);

		String HTPWs_Title_Actual_fontFamily = HTPWs_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", HTPWs_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, HTPWs_Title_Actual_fontFamily);
		}
		String HTPWs_Title_Actual_colorValue = HTPWs_Title_xpath.getCssValue("color");
		String HTPWs_Title_Actual_FontColor = Color.fromString(HTPWs_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", HTPWs_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement HTPWs_Content_xpath = driver.findElement(By.xpath("//li[contains(text(), 'The authorized')]"));
		String HTPWs_Content_FontSize = HTPWs_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", HTPWs_Content_FontSize);

		String HTPWs_Content_Actual_fontFamily = HTPWs_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", HTPWs_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, HTPWs_Content_Actual_fontFamily);
		}
		String HTPWs_Content_colorValue = HTPWs_Content_xpath.getCssValue("color");
		String HTPWs_Content_Actual_FontColor = Color.fromString(HTPWs_Content_colorValue).asHex();
		Assert.assertEquals("#666666", HTPWs_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement HTPWs_Link_xpath = driver.findElement(By.xpath("//a[contains(text(), 'interest form')]"));
		String HTPWs_Link_FontSize = HTPWs_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", HTPWs_Link_FontSize);

		String HTPWs_Link_Actual_fontFamily = HTPWs_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", HTPWs_Link_Actual_fontFamily);

		String HTPWs_Link_colorValue = HTPWs_Link_xpath.getCssValue("color");
		String HTPWs_Link_Actual_FontColor = Color.fromString(HTPWs_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", HTPWs_Link_Actual_FontColor);
	}

	@Test
	public void VerifyingYourAuthorizedContractorDesignVerification() {
		// Title xpath of Rebates And Incentives
		WebElement VYAC_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Verifying Your')]"));
		String VYAC_Title_Actual_FontSize = VYAC_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", VYAC_Title_Actual_FontSize);

		String VYAC_Title_Actual_fontFamily = VYAC_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", VYAC_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, VYAC_Title_Actual_fontFamily);
		}
		String VYAC_Title_Actual_colorValue = VYAC_Title_xpath.getCssValue("color");
		String VYAC_Title_Actual_FontColor = Color.fromString(VYAC_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", VYAC_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement VYAC_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Contractors authorized')]"));
		String VYAC_Content_FontSize = VYAC_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", VYAC_Content_FontSize);

		String VYAC_Content_Actual_fontFamily = VYAC_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", VYAC_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, VYAC_Content_Actual_fontFamily);
		}
		String VYAC_Content_colorValue = VYAC_Content_xpath.getCssValue("color");
		String VYAC_Content_Actual_FontColor = Color.fromString(VYAC_Content_colorValue).asHex();
		Assert.assertEquals("#666666", VYAC_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement VYAC_Link_xpath = driver.findElement(By.xpath("//a[contains(text(), 'List of authorized')]"));
		String VYAC_Link_FontSize = VYAC_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", VYAC_Link_FontSize);

		String VYAC_Link_Actual_fontFamily = VYAC_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", VYAC_Link_Actual_fontFamily);

		String VYAC_Link_colorValue = VYAC_Link_xpath.getCssValue("color");
		String VYAC_Link_Actual_FontColor = Color.fromString(VYAC_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", VYAC_Link_Actual_FontColor);
	}

	@Test
	public void WhatifIDontQualifyDesignVerification() {
		// Title xpath of Rebates And Incentives
		WebElement WIDQ_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'What if I')]"));
		String WIDQ_Title_Actual_FontSize = WIDQ_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", WIDQ_Title_Actual_FontSize);

		String WIDQ_Title_Actual_fontFamily = WIDQ_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WIDQ_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WIDQ_Title_Actual_fontFamily);
		}
		String WIDQ_Title_Actual_colorValue = WIDQ_Title_xpath.getCssValue("color");
		String WIDQ_Title_Actual_FontColor = Color.fromString(WIDQ_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", WIDQ_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement WIDQ_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), '**This dollar')]"));
		String WIDQ_Content_FontSize = WIDQ_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WIDQ_Content_FontSize);

		String WIDQ_Content_Actual_fontFamily = WIDQ_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", WIDQ_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WIDQ_Content_Actual_fontFamily);
		}
		String WIDQ_Content_colorValue = WIDQ_Content_xpath.getCssValue("color");
		String WIDQ_Content_Actual_FontColor = Color.fromString(WIDQ_Content_colorValue).asHex();
		Assert.assertEquals("#666666", WIDQ_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement WIDQ_Link_xpath = driver
				.findElement(By.xpath("//a[contains(text(), 'energy efficiency programs')]"));
		String WIDQ_Link_FontSize = WIDQ_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WIDQ_Link_FontSize);

		String WIDQ_Link_Actual_fontFamily = WIDQ_Link_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", WIDQ_Link_Actual_fontFamily);

		String WIDQ_Link_colorValue = WIDQ_Link_xpath.getCssValue("color");
		String WIDQ_Link_Actual_FontColor = Color.fromString(WIDQ_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", WIDQ_Link_Actual_FontColor);
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
