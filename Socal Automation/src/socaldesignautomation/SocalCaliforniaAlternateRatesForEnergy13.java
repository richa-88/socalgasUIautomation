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

public class SocalCaliforniaAlternateRatesForEnergy13 {
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
			driver.get((String) jsonObject1.get("SocalCaliforniaAlternateRatesForEnergy13"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalCaliforniaAlternateRatesForEnergy13"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalCaliforniaAlternateRatesForEnergy13"));
			break;
		}
//		driver.get("http://www.socalgas.com/save-money-and-energy/assistance-programs/california-alternate-rates-for-energy");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void CaliforniaAlternateRatesForEnergyCAREDesignVerification() {
		WebElement CARFE_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(text(), 'California Alternate')]"));

		String CARFE_Title_FontSize = CARFE_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", CARFE_Title_FontSize);

		String CARFE_Title_fontFamily = CARFE_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", CARFE_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CARFE_Title_fontFamily);
		}
		String CARFE_Title_FontWeight = CARFE_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", CARFE_Title_FontWeight);

		String CARFE_Title_colorValue = CARFE_Title_xpath.getCssValue("color");
		String CARFE_Title_Actual_FontColor = Color.fromString(CARFE_Title_colorValue).asHex();
		Assert.assertEquals("#004693", CARFE_Title_Actual_FontColor);

		// Desc
		WebElement CARFE_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'The CARE program can' )]"));

		String CARFE_Desc_FontSize = CARFE_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", CARFE_Desc_FontSize);

		String CARFE_Desc_fontFamily = CARFE_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", CARFE_Desc_fontFamily);

		String CARFE_Desc_FontWeight = CARFE_Desc_xpath.getCssValue("font-weight");
		Assert.assertEquals("400", CARFE_Desc_FontWeight);

		String CARFE_Desc_colorValue = CARFE_Desc_xpath.getCssValue("color");
		String CARFE_Desc_Actual_FontColor = Color.fromString(CARFE_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", CARFE_Desc_Actual_FontColor);
	}

	@Test
	public void SoCalGasCaresDesignVerification() {
		WebElement SoCalGasCares_Title_xpath = driver.findElement(By.xpath("//h2/div[text()='SoCalGas']"));

		String SoCalGasCares_Title_FontSize = SoCalGasCares_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", SoCalGasCares_Title_FontSize);

		String SoCalGasCares_Title_fontFamily = SoCalGasCares_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", SoCalGasCares_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SoCalGasCares_Title_fontFamily);
		}
		String SoCalGasCares_Title_FontWeight = SoCalGasCares_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", SoCalGasCares_Title_FontWeight);

		String SoCalGasCares_Title_colorValue = SoCalGasCares_Title_xpath.getCssValue("color");
		String SoCalGasCares_Title_Actual_FontColor = Color.fromString(SoCalGasCares_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", SoCalGasCares_Title_Actual_FontColor);

		// Desc
		WebElement SoCalGasCares_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'If you have recently')]"));

		String SoCalGasCares_Desc_FontSize = SoCalGasCares_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SoCalGasCares_Desc_FontSize);

		String SoCalGasCares_Desc_fontFamily = SoCalGasCares_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", SoCalGasCares_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SoCalGasCares_Desc_fontFamily);
		}
		String SoCalGasCares_Desc_colorValue = SoCalGasCares_Desc_xpath.getCssValue("color");
		String SoCalGasCares_Desc_Actual_FontColor = Color.fromString(SoCalGasCares_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", SoCalGasCares_Desc_Actual_FontColor);

		// Link Text
		WebElement SoCalGasCares_ApplyNow_xpath = driver.findElement(By.xpath("//a[@class='feature--item--button']"));

		String SoCalGasCares_ApplyNow_FontSize = SoCalGasCares_ApplyNow_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SoCalGasCares_ApplyNow_FontSize);

		String SoCalGasCares_ApplyNow_fontFamily = SoCalGasCares_ApplyNow_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", SoCalGasCares_ApplyNow_fontFamily);

		String SoCalGasCares_ApplyNow_FontWeight = SoCalGasCares_ApplyNow_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", SoCalGasCares_ApplyNow_FontWeight);

		String SoCalGasCares_ApplyNow_colorValue = SoCalGasCares_ApplyNow_xpath.getCssValue("color");
		String SoCalGasCares_ApplyNow_Actual_FontColor = Color.fromString(SoCalGasCares_ApplyNow_colorValue).asHex();
		Assert.assertEquals("#000000", SoCalGasCares_ApplyNow_Actual_FontColor);

		// Link
		WebElement SoCalGasCares_SA_xpath = driver.findElement(By.xpath("//a[contains(text(),'Apply Now')]"));

		String SoCalGasCares_SA_FontSize = SoCalGasCares_SA_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SoCalGasCares_SA_FontSize);

		String SoCalGasCares_SA_fontFamily = SoCalGasCares_SA_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", SoCalGasCares_SA_fontFamily);

		String SoCalGasCares_SA_colorValue = SoCalGasCares_SA_xpath.getCssValue("color");
		String SoCalGasCares_SA_Actual_FontColor = Color.fromString(SoCalGasCares_SA_colorValue).asHex();
		Assert.assertEquals("#000000", SoCalGasCares_SA_Actual_FontColor);
	}

	@Test
	public void TheCaliforniaLifeLineProgramDesignVerification() {
		//
		WebElement TCLLP_Title_xpath = driver
				.findElement(By.xpath("//h3[contains(text(), 'The California LifeLine')]"));

		String TCLLP_Title_FontSize = TCLLP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", TCLLP_Title_FontSize);

		String TCLLP_Title_fontFamily = TCLLP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", TCLLP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, TCLLP_Title_fontFamily);
		}
		String TCLLP_Title_FontWeight = TCLLP_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", TCLLP_Title_FontWeight);

		String TCLLP_Title_colorValue = TCLLP_Title_xpath.getCssValue("color");
		String TCLLP_Title_Actual_FontColor = Color.fromString(TCLLP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", TCLLP_Title_Actual_FontColor);

		// Desc
		WebElement TCLLP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'CARE participants could')]"));

		String TCLLP_Desc_FontSize = TCLLP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", TCLLP_Desc_FontSize);

		String TCLLP_Desc_fontFamily = TCLLP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", TCLLP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, TCLLP_Desc_fontFamily);
		}
		String TCLLP_Desc_colorValue = TCLLP_Desc_xpath.getCssValue("color");
		String TCLLP_Desc_Actual_FontColor = Color.fromString(TCLLP_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", TCLLP_Desc_Actual_FontColor);

		// Link Text
		WebElement TCLLP_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));

		String TCLLP_Link_Text_FontSize = TCLLP_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", TCLLP_Link_Text_FontSize);

		String TCLLP_Link_Text_fontFamily = TCLLP_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", TCLLP_Link_Text_fontFamily);

		String TCLLP_Link_Text_FontWeight = TCLLP_Link_Text_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", TCLLP_Link_Text_FontWeight);

		String TCLLP_Link_Text_colorValue = TCLLP_Link_Text_xpath.getCssValue("color");
		String TCLLP_Link_Text_Actual_FontColor = Color.fromString(TCLLP_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", TCLLP_Link_Text_Actual_FontColor);
	}

	@Test
	public void ApplyByMailDesignVerification() {
		WebElement ABM_Title_xpath = driver.findElement(By.xpath("//h3[text()= 'Apply By Mail']"));

		String ABM_Title_FontSize = ABM_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", ABM_Title_FontSize);

		String ABM_Title_fontFamily = ABM_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ABM_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ABM_Title_fontFamily);
		}
		String ABM_Title_FontWeight = ABM_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", ABM_Title_FontWeight);

		String ABM_Title_colorValue = ABM_Title_xpath.getCssValue("color");
		String ABM_Title_Actual_FontColor = Color.fromString(ABM_Title_colorValue).asHex();
		Assert.assertEquals("#000000", ABM_Title_Actual_FontColor);

		// Desc
		WebElement ABM_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Mail completed form')]"));

		String ABM_Desc_FontSize = ABM_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", ABM_Desc_FontSize);

		String ABM_Desc_fontFamily = ABM_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ABM_Desc_fontFamily);

		String ABM_Desc_colorValue = ABM_Desc_xpath.getCssValue("color");
		String ABM_Desc_Actual_FontColor = Color.fromString(ABM_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", ABM_Desc_Actual_FontColor);

		// Download Link Text
		WebElement Download_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));

		String Download_Link_Text_FontSize = Download_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Download_Link_Text_FontSize);

		String Download_Link_Text_fontFamily = Download_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Download_Link_Text_fontFamily);

//		String Download_Link_Text_FontWeight = Download_Link_Text_xpath.getCssValue("font-weight");
//		Assert.assertEquals("500", Download_Link_Text_FontWeight);

		String Download_Link_Text_colorValue = Download_Link_Text_xpath.getCssValue("color");
		String Download_Link_Text_Actual_FontColor = Color.fromString(Download_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Download_Link_Text_Actual_FontColor);

		// CARE Form (Large Font) Link Text
		WebElement CF_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'CARE Form')]"));

		String CF_Link_Text_FontSize = CF_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", CF_Link_Text_FontSize);

		String CF_Link_Text_fontFamily = CF_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", CF_Link_Text_fontFamily);

		String CF_Link_Text_FontWeight = CF_Link_Text_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", CF_Link_Text_FontWeight);

		String CF_Link_Text_colorValue = CF_Link_Text_xpath.getCssValue("color");
		String CF_Link_Text_Actual_FontColor = Color.fromString(CF_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", CF_Link_Text_Actual_FontColor);
	}

	@Test
	public void PublicAssistanceProgramsDesignVerification() {

		WebElement PAP_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Assistance Programs')]"));

		String PAP_Title_FontSize = PAP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", PAP_Title_FontSize);

		String PAP_Title_fontFamily = PAP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PAP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PAP_Title_fontFamily);
		}
		String PAP_Title_FontWeight = PAP_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", PAP_Title_FontWeight);

		String PAP_Title_colorValue = PAP_Title_xpath.getCssValue("color");
		String PAP_Title_Actual_FontColor = Color.fromString(PAP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PAP_Title_Actual_FontColor);

		// Desc
		WebElement PAP_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'If you or another')]"));

		String ABM_Desc_FontSize = PAP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", ABM_Desc_FontSize);

		String ABM_Desc_fontFamily = PAP_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ABM_Desc_fontFamily);

		String ABM_Desc_colorValue = PAP_Desc_xpath.getCssValue("color");
		String ABM_Desc_Actual_FontColor = Color.fromString(ABM_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", ABM_Desc_Actual_FontColor);

		// Table Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//table/tbody/tr/td[1]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#666666", Link_Text_Actual_FontColor);
	}

	@Test
	public void MaximumHouseholdIncomeDesignVerification() {

		WebElement MHI_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Household Income')]"));

		String MHI_Title_FontSize = MHI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", MHI_Title_FontSize);

		String MHI_Title_fontFamily = MHI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", MHI_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MHI_Title_fontFamily);
		}
		String MHI_Title_FontWeight = MHI_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", MHI_Title_FontWeight);

		String MHI_Title_colorValue = MHI_Title_xpath.getCssValue("color");
		String MHI_Title_Actual_FontColor = Color.fromString(MHI_Title_colorValue).asHex();
		Assert.assertEquals("#000000", MHI_Title_Actual_FontColor);

		// Desc
		WebElement MHI_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Effective June 1')]"));

		String MHI_Desc_FontSize = MHI_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", MHI_Desc_FontSize);

		String MHI_Desc_fontFamily = MHI_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", MHI_Desc_fontFamily);

		String MHI_Desc_colorValue = MHI_Desc_xpath.getCssValue("color");
		String MHI_Desc_Actual_FontColor = Color.fromString(MHI_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", MHI_Desc_Actual_FontColor);

		// Table Text
		WebElement Table_header_Text_xpath = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));

		String Table_header_Text_FontSize = Table_header_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Table_header_Text_FontSize);

		String Table_header_Text_fontFamily = Table_header_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Table_header_Text_fontFamily);

		String Table_header_Text_colorValue = Table_header_Text_xpath.getCssValue("color");
		String Table_header_Text_Actual_FontColor = Color.fromString(Table_header_Text_colorValue).asHex();
		Assert.assertEquals("#666666", Table_header_Text_Actual_FontColor);
	}

	@Test
	public void ConditionsForParticipationDesignVerification() {
		WebElement CFP_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Conditions for')]"));

		String CFP_Title_FontSize = CFP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", CFP_Title_FontSize);

		String CFP_Title_fontFamily = CFP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", CFP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CFP_Title_fontFamily);
		}
		String CFP_Title_FontWeight = CFP_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", CFP_Title_FontWeight);

		String CFP_Title_colorValue = CFP_Title_xpath.getCssValue("color");
		String CFP_Title_Actual_FontColor = Color.fromString(CFP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", CFP_Title_Actual_FontColor);

		// Desc
		WebElement CFP_Desc_xpath = driver.findElement(By.xpath("//li[contains(text(), 'The natural gas')]"));

		String CFP_Desc_FontSize = CFP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", CFP_Desc_FontSize);

		String CFP_Desc_fontFamily = CFP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", CFP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CFP_Desc_fontFamily);
		}
		String CFP_Desc_colorValue = CFP_Desc_xpath.getCssValue("color");
		String CFP_Desc_Actual_FontColor = Color.fromString(CFP_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", CFP_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'here')]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void QualifiedBusinessesDesignVerification() {
		WebElement QBD_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Qualified Businesses')]"));

		String QBD_Title_FontSize = QBD_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", QBD_Title_FontSize);

		String QBD_Title_fontFamily = QBD_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", QBD_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, QBD_Title_fontFamily);
		}
		String QBD_Title_FontWeight = QBD_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", QBD_Title_FontWeight);

		String QBD_Title_colorValue = QBD_Title_xpath.getCssValue("color");
		String QBD_Title_Actual_FontColor = Color.fromString(QBD_Title_colorValue).asHex();
		Assert.assertEquals("#000000", QBD_Title_Actual_FontColor);

		// Desc
		WebElement QBD_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'If you are operating')]"));

		String QBD_Desc_FontSize = QBD_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", QBD_Desc_FontSize);

		String QBD_Desc_fontFamily = QBD_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", QBD_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, QBD_Desc_fontFamily);
		}
		String QBD_Desc_colorValue = QBD_Desc_xpath.getCssValue("color");
		String QBD_Desc_Actual_FontColor = Color.fromString(QBD_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", QBD_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Agricultural')]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void CapitationAgenciesDesignVerification() {
		WebElement CFP_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Capitation Agencies')]"));

		String CFP_Title_FontSize = CFP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", CFP_Title_FontSize);

		String CFP_Title_fontFamily = CFP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", CFP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CFP_Title_fontFamily);
		}
		String CFP_Title_FontWeight = CFP_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", CFP_Title_FontWeight);

		String CFP_Title_colorValue = CFP_Title_xpath.getCssValue("color");
		String CFP_Title_Actual_FontColor = Color.fromString(CFP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", CFP_Title_Actual_FontColor);

		// Desc
		WebElement CFP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Non-profit and')]"));

		String CFP_Desc_FontSize = CFP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", CFP_Desc_FontSize);

		String CFP_Desc_fontFamily = CFP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", CFP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CFP_Desc_fontFamily);
		}
		String CFP_Desc_colorValue = CFP_Desc_xpath.getCssValue("color");
		String CFP_Desc_Actual_FontColor = Color.fromString(CFP_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", CFP_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Capitation')]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
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
		System.out.println("Socal California Alternate Rates For Energy Class Executed sucessfully");
	}
}
