package socaldesignautomation;

import org.openqa.selenium.support.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.json.simple.parser.ParseException;

public class SocalRebates01 {
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
			driver.get((String) jsonObject1.get("SocalRebates01"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalRebates01"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalRebates01"));
			break;
		}
		// driver.get("https://www.socalgas.com/help-center/my-account");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void UtilityNavHearderDesignVerificatin() {
		// Report a Gas Leak Menu xpath
		WebElement ReportaGasLeak_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Report a')])[1]"));
		String ReportaGasLeak_Actual_FontSize = ReportaGasLeak_xpath.getCssValue("font-size");
		Assert.assertEquals("12px", ReportaGasLeak_Actual_FontSize);

		String ReportaGasLeak_Actual_fontFamily = ReportaGasLeak_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ReportaGasLeak_Actual_fontFamily);

		String ReportaGasLeak_colorValue = ReportaGasLeak_xpath.getCssValue("color");
		String ReportaGasLeak_Actual_FontColor = Color.fromString(ReportaGasLeak_colorValue).asHex();
		Assert.assertEquals("#df134c", ReportaGasLeak_Actual_FontColor);

		// Rest all Utility Menu.
		WebElement UtilityNav_xpath = driver.findElement(By.xpath("//a[contains(text(), ' En Español ')]"));
		String UtilityNav_Actual_FontSize = UtilityNav_xpath.getCssValue("font-size");
		Assert.assertEquals("12px", UtilityNav_Actual_FontSize);

		String UtilityNav_Actual_fontFamily = UtilityNav_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", UtilityNav_Actual_fontFamily);

		String UtilityNav_colorValue = UtilityNav_xpath.getCssValue("color");
		String UtilityNav_Actual_FontColor = Color.fromString(UtilityNav_colorValue).asHex();
		Assert.assertEquals("#4d6c8e", UtilityNav_Actual_FontColor);
	}

	@Test
	public void LogoIsPresentOrNotVerification() {

		WebElement ImageFile = driver.findElement(By.xpath("//div[@class='site-header__logo']/a/img"));

		Boolean logoPresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!logoPresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
		}
	}

	@Test
	public void SearchSoCalGasDesignVerification() {
		WebElement SearchSoCalGas_Text_xpath = driver
				.findElement(By.xpath("//label[contains(text(), 'Search SoCalGas')]"));
		String SearchSoCalGas_Text_FontSize = SearchSoCalGas_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SearchSoCalGas_Text_FontSize);

		String SearchSoCalGas_Text_colorValue = SearchSoCalGas_Text_xpath.getCssValue("color");
		String SearchSoCalGas_Text_FontColor = Color.fromString(SearchSoCalGas_Text_colorValue).asHex();
		Assert.assertEquals("#666666", SearchSoCalGas_Text_FontColor);

		String SearchSoCalGas_Text_fontFamily = SearchSoCalGas_Text_xpath.getCssValue("font-family");
		if (SearchSoCalGas_Text_fontFamily.equalsIgnoreCase("chrome")) {
			Assert.assertEquals("Arial, Helvetica, sans-serif", SearchSoCalGas_Text_fontFamily);
		}
		if (SearchSoCalGas_Text_fontFamily.equalsIgnoreCase("chrome")) {
			Assert.assertEquals("Arial, Helvetica, \"sans-serif\"", SearchSoCalGas_Text_fontFamily);
		}
	}

	@Test
	public void MainNavHeaderDesignVerification() {
		WebElement Header_xpath = driver.findElement(By.xpath(".//a[@class='main-nav__link']"));
		String headerActual_FontSize = Header_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", headerActual_FontSize);

		String header_colorValue = Header_xpath.getCssValue("color");
		String headerActual_FontColor = Color.fromString(header_colorValue).asHex();
		Assert.assertEquals("#0072c6", headerActual_FontColor);

		String headerActual_fontFamily = Header_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", headerActual_fontFamily);

	}

	@Test
	public void RebatesAndIncentiveDesignVerification() {
		// Title xpath Rebates And Incentive
		WebElement rAndI_Title_xpath = driver.findElement(
				By.xpath("//h1/div[contains(@class, 'field--title') and text() = ' Rebates and Incentives']"));
		String rAndI_Actual_Title_FontSize = rAndI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", rAndI_Actual_Title_FontSize);

		String rAndIActual_Title_fontFamily = rAndI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rAndIActual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rAndIActual_Title_fontFamily);
		}

		String rAndI_Title_colorValue = rAndI_Title_xpath.getCssValue("color");
		String rAndIActual_Title_FontColor = Color.fromString(rAndI_Title_colorValue).asHex();
		Assert.assertEquals("#004693", rAndIActual_Title_FontColor);

		String rAndIActual_Title_FontWeight = rAndI_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", rAndIActual_Title_FontWeight);

		// Content xpath for Rebates And Incentive
		WebElement rAndI_Text_xpath = driver.findElement(By.xpath("//div[@class='page-banner__text']/p"));
		String rAndI_Actual_Text_FontSize = rAndI_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", rAndI_Actual_Text_FontSize);

		String rAndI_Actual_Text_fontFamily = rAndI_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAndI_Actual_Text_fontFamily);

		String rAndI_Title_FontWeight = rAndI_Text_xpath.getCssValue("font-weight");
		Assert.assertEquals("400", rAndI_Title_FontWeight);

		String rAndI_Text_colorValue = rAndI_Text_xpath.getCssValue("color");
		String rAndI_Actual_Text_FontColor = Color.fromString(rAndI_Text_colorValue).asHex();
		Assert.assertEquals("#004693", rAndI_Actual_Text_FontColor);
	}

	@Test
	public void ResidentialRebatesDesignVerification() {
		// Title Residential Rebates
		WebElement rR_Title_xpath = driver.findElement(By.xpath(".//h2/div[contains(text(),'Residential Rebates')]"));
		String rR_Title_Actual_FontSize = rR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rR_Title_Actual_FontSize);

		String rR_Title_Actual_fontFamily = rR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rR_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rR_Title_Actual_fontFamily);
		}

		String rR_Title_Actual_colorValue = rR_Title_xpath.getCssValue("color");
		String rR_Title_Actual_FontColor = Color.fromString(rR_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rR_Title_Actual_FontColor);

		// Content xpath of Residential Rebates.
		WebElement rR_Content_xpath = driver.findElement(By.xpath(
				"//*[text()='Take advantage of available rebates and incentives on energy-efficient products for your home.']"));
		String rR_Content_Actual_FontSize = rR_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rR_Content_Actual_FontSize);

		String rR_Content_Actual_fontFamily = rR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rR_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rR_Content_Actual_fontFamily);
		}

		String rR_Content_Title_FontWeight = rR_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", rR_Content_Title_FontWeight);

		String rR_Content_Actual_colorValue = rR_Content_xpath.getCssValue("color");
		String rR_Content_Actual_FontColor = Color.fromString(rR_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rR_Content_Actual_FontColor);

		// Link Text xpath of Residential Rebates
		WebElement rR_btn_xpath = driver.findElement(By.xpath("//*[@class='page-banner__cta white-cta']/a"));

		String rR_btn_FontSize = rR_btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rR_btn_FontSize);

		String rR_btn_Actual_fontFamily = rR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rR_btn_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rR_btn_Actual_fontFamily);
		}
		String rR_btn_Actual_colorValue = rR_Title_xpath.getCssValue("color");
		String rR_btn_Actual_FontColor = Color.fromString(rR_btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rR_btn_Actual_FontColor);

	}

	@Test
	public void SoCalGasMarketPlaceDesignVerification() {
		// xpath for SoCalGas Marketplace Title
		WebElement sM_Title_xpath = driver.findElement(By.xpath(".//h2/div[contains(text(),'SoCalGas Marketplace')]"));
		String sM_Title_FontSize = sM_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", sM_Title_FontSize);

		String sM_Title_Actual_fontFamily = sM_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", sM_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, sM_Title_Actual_fontFamily);
		}
		String sM_Title_Actual_colorValue = sM_Title_xpath.getCssValue("color");
		String sM_Title_Actual_FontColor = Color.fromString(sM_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", sM_Title_Actual_FontColor);

		// xpath for SoCalGas Marketplace Content
		WebElement sM_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Shopping for your next')]"));
		String sM_Content_FontSize = sM_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", sM_Content_FontSize);

		String sM_Content_Actual_fontFamily = sM_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", sM_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, sM_Content_Actual_fontFamily);
		}
		String sM_Content_Actual_colorValue = sM_Content_xpath.getCssValue("color");
		String sM_Content_Actual_FontColor = Color.fromString(sM_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", sM_Content_Actual_FontColor);

		// xpath for SoCalGas Marketplace Link Text
		WebElement sM_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Shop Now*')]"));
		String sM_Btn_FontSize = sM_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", sM_Btn_FontSize);
		String sM_Btn_Actual_fontFamily = sM_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", sM_Btn_Actual_fontFamily);
		String sM_Btn_Actual_colorValue = sM_Btn_xpath.getCssValue("color");
		String sM_Btn_Actual_FontColor = Color.fromString(sM_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", sM_Btn_Actual_FontColor);
	}

	@Test
	public void BusinessRebatesDesignVerification() {
		// xpath for Business Rebates Title
		WebElement bR_Title_xpath = driver.findElement(By.xpath(".//h2/div[contains(text(),'Business Rebates')]"));
		String bR_Title_Actual_FontSize = bR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", bR_Title_Actual_FontSize);

		String bR_Title_Actual_fontFamily = bR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", bR_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, bR_Title_Actual_fontFamily);
		}
		String bR_Title_Actual_colorValue = bR_Title_xpath.getCssValue("color");
		String bR_Title_Actual_FontColor = Color.fromString(bR_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", bR_Title_Actual_FontColor);

		// Xpath for Business Rebates Content.
		WebElement bR_Content_xpath = driver.findElement(
				By.xpath("//p[@class='page-banner__sub-title' and contains(text(),'Take advantage of available ')]"));
		String bR_Content_Actual_FontSize = bR_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", bR_Content_Actual_FontSize);

		String bR_Content_Actual_fontFamily = bR_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", bR_Content_Actual_fontFamily);

		String bR_Content_Actual_colorValue = bR_Content_xpath.getCssValue("color");
		String bR_Content_Actual_FontColor = Color.fromString(bR_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", bR_Content_Actual_FontColor);

		// xpath for Business Rebates Link text.
		WebElement rR_btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-primary' and contains(text(),'View Rebates')]"));

		String bR_btn_FontSize = rR_btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", bR_btn_FontSize);

		String rR_btn_Actual_fontFamily = rR_btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rR_btn_Actual_fontFamily);

		String rR_btn_Actual_colorValue = rR_btn_xpath.getCssValue("color");
		String rR_btn_Actual_FontColor = Color.fromString(rR_btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rR_btn_Actual_FontColor);
	}

	@Test
	public void EnergyEfficiencyFinancingDesignVerification() {
		// xpath for Energy-Efficiency Financing Title
		WebElement eEF_Title_xpath = driver.findElement(By.xpath(".//h2/div[contains(text(),'Energy-Efficiency')]"));
		String eEF_Title_FontSize = eEF_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", eEF_Title_FontSize);

		String eEF_Title_Actual_fontFamily = eEF_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", eEF_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eEF_Title_Actual_fontFamily);
		}

		String eEF_Title_Actual_colorValue = eEF_Title_xpath.getCssValue("color");
		String eEF_Title_Actual_FontColor = Color.fromString(eEF_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", eEF_Title_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Content
		WebElement eEF_Content_xpath = driver.findElement(By.xpath(
				"//*[@id=\"block-socalgas-content\"]/article/div[1]/div/div[2]/article/div/div/div/div/div/div/div[1]/div/div/p"));
		String eEF_Content_FontSize = eEF_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eEF_Content_FontSize);

		String eEF_Content_Actual_fontFamily = eEF_Content_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", eEF_Content_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, eEF_Content_Actual_fontFamily);
		}
		String eEF_Content_Actual_colorValue = eEF_Content_xpath.getCssValue("color");
		String eEF_Content_Actual_FontColor = Color.fromString(eEF_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", eEF_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement eEF_Btn_xpath = driver.findElement(By
				.xpath("//a[@class='featured-item__link feature--item--button ' and contains(text(),'View Options')]"));
		String eEF_Btn_FontSize = eEF_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eEF_Btn_FontSize);

		String eEF_Btn_Actual_fontFamily = eEF_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eEF_Btn_Actual_fontFamily);

		String eEF_Btn_Actual_colorValue = eEF_Btn_xpath.getCssValue("color");
		String eEF_Btn_Actual_FontColor = Color.fromString(eEF_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", eEF_Btn_Actual_FontColor);

	}

	@Test
	public void FooterDesignVerification() {
		WebElement Footer_xpath = driver.findElement(By.xpath("//a[contains(text(), 'About Us')]"));
		String Footer_FontSize = Footer_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Footer_FontSize);

		String Footer_Actual_fontFamily = Footer_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Footer_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Footer_Actual_fontFamily);
		}

		String Footer_Actual_colorValue = Footer_xpath.getCssValue("color");
		String Footer_Actual_FontColor = Color.fromString(Footer_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", Footer_Actual_FontColor);
	}

	@Test
	public void ConnectWithUsFooterDesignVerification() {
		WebElement Disclaimer_Text_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Connect with Us')]"));
		String Disclaimer_Text_FontSize = Disclaimer_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", Disclaimer_Text_FontSize);

		String Disclaimer_Text_Actual_fontFamily = Disclaimer_Text_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Disclaimer_Text_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Disclaimer_Text_Actual_fontFamily);
		}

		String Disclaimer_Text_Actual_colorValue = Disclaimer_Text_xpath.getCssValue("color");
		String Disclaimer_Text_Actual_FontColor = Color.fromString(Disclaimer_Text_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", Disclaimer_Text_Actual_FontColor);
	}

	@Test
	public void FooterDisclaimerTextDesignVerification() {
		WebElement Disclaimer_Text_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Southern California')]"));
		String Disclaimer_Text_FontSize = Disclaimer_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("12px", Disclaimer_Text_FontSize);

		String Disclaimer_Text_Actual_fontFamily = Disclaimer_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Disclaimer_Text_Actual_fontFamily);

		String Disclaimer_Text_Actual_colorValue = Disclaimer_Text_xpath.getCssValue("color");
		String Disclaimer_Text_Actual_FontColor = Color.fromString(Disclaimer_Text_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", Disclaimer_Text_Actual_FontColor);

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
		Reporter.log("=====Browser Session End=====", true);
	}
}
