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

public class SocalNaturalgasApplianceRebates14 {
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
			driver.get((String) jsonObject1.get("SocalNaturalgasApplianceRebates14"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalNaturalgasApplianceRebates14"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalNaturalgasApplianceRebates14"));
			break;
		}
//		driver.get("https://www.socalgas.com/save-money-and-energy/rebates-and-incentives/natural-gas-appliance-rebates");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void AvailableRebatesDesignVerification() {
		// Title
		WebElement AR_Title_xpath = driver.findElement(By.xpath("//h1/div[contains(text(), 'Available')]"));
		String AR_Title_FontSize = AR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", AR_Title_FontSize);

		String AR_Title_fontFamily = AR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", AR_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, AR_Title_fontFamily);
		}
		String AR_Title_colorValue = AR_Title_xpath.getCssValue("color");
		String AR_Title_Actual_FontColor = Color.fromString(AR_Title_colorValue).asHex();
		Assert.assertEquals("#004693", AR_Title_Actual_FontColor);

		// Descriptions.
		WebElement AR_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'See all ENERGY')]"));
		String AR_Desc_FontSize = AR_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", AR_Desc_FontSize);

		String AR_Desc_fontFamily = AR_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", AR_Desc_fontFamily);

		String AR_Desc_colorValue = AR_Desc_xpath.getCssValue("color");
		String AR_Desc_Actual_FontColor = Color.fromString(AR_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", AR_Desc_Actual_FontColor);
	}

	@Test
	public void SaveMoneyAndEnergyDesignVerification() {
		WebElement Browse_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Browse')]"));

		String Browse_FontSize = Browse_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", Browse_FontSize);

		String Browse_fontFamily = Browse_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Browse_fontFamily);

		String Browse_colorValue = Browse_Title_xpath.getCssValue("color");
		String Browse_Actual_FontColor = Color.fromString(Browse_colorValue).asHex();
		Assert.assertEquals("#000000", Browse_Actual_FontColor);

		// Desc
		WebElement Browse_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Our Marketplace')]"));

		String Browse_Desc_FontSize = Browse_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Browse_Desc_FontSize);

		String Browse_Desc_fontFamily = Browse_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Browse_Desc_fontFamily);

		String Browse_Desc_colorValue = Browse_Desc_xpath.getCssValue("color");
		String Browse_Desc_Actual_FontColor = Color.fromString(Browse_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", Browse_Desc_Actual_FontColor);
	}

	@Test
	public void SmartThermostatDesignVerification() {
		// Title
		WebElement ST_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Smart Thermostat')]"));

		String ST_title_FontSize = ST_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", ST_title_FontSize);

		String ST_title_fontFamily = ST_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ST_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ST_title_fontFamily);
		}
		String ST_title_colorValue = ST_Title_xpath.getCssValue("color");
		String ST_title_Actual_FontColor = Color.fromString(ST_title_colorValue).asHex();
		Assert.assertEquals("#ffffff", ST_title_Actual_FontColor);

		// Desc
		WebElement ST_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'A $50 rebate is')]"));

		String ST_Desc_FontSize = ST_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", ST_Desc_FontSize);

		String ST_Desc_fontFamily = ST_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ST_Desc_fontFamily);

		String ST_Desc_colorValue = ST_Desc_xpath.getCssValue("color");
		String ST_Desc_Actual_FontColor = Color.fromString(ST_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", ST_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[@class='btn-primary']"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void SoCalGasMarketPlaceDesignVerification() {
		WebElement ST_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'SoCalGas Marketplace')]"));

		String SMP_title_FontSize = ST_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", SMP_title_FontSize);

		String SMP_title_fontFamily = ST_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", SMP_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SMP_title_fontFamily);
		}
		String SMP_title_colorValue = ST_Title_xpath.getCssValue("color");
		String SMP_title_Actual_FontColor = Color.fromString(SMP_title_colorValue).asHex();
		Assert.assertEquals("#ffffff", SMP_title_Actual_FontColor);

		// Desc
		WebElement SMP_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Shopping for your')]"));

		String SMP_Desc_FontSize = SMP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SMP_Desc_FontSize);

		String SMP_Desc_fontFamily = SMP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", SMP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SMP_Desc_fontFamily);
		}
		String SMP_Desc_colorValue = SMP_Desc_xpath.getCssValue("color");
		String SMP_Desc_Actual_FontColor = Color.fromString(SMP_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", SMP_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Shop Now*')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#000000", Link_Text_Actual_FontColor);
	}

	@Test
	public void NaturalGasFireplaceInsertsDesignVerification() {
		WebElement NGFI_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Natural Gas Fireplace')]"));

		String NGFI_title_FontSize = NGFI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", NGFI_title_FontSize);

		String NGFI_title_fontFamily = NGFI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", NGFI_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, NGFI_title_fontFamily);
		}
		String NGFI_title_colorValue = NGFI_Title_xpath.getCssValue("color");
		String NGFI_title_Actual_FontColor = Color.fromString(NGFI_title_colorValue).asHex();
		Assert.assertEquals("#000000", NGFI_title_Actual_FontColor);

		// Desc
		WebElement NGFI_Desc_xpath = driver.findElement(By.xpath("//P[contains(text(), '$300 rebate on')]"));

		String NGFI_Desc_FontSize = NGFI_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", NGFI_Desc_FontSize);

		String NGFI_Desc_fontFamily = NGFI_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", NGFI_Desc_fontFamily);

		String NGFI_Desc_colorValue = NGFI_Desc_xpath.getCssValue("color");
		String NGFI_Desc_Actual_FontColor = Color.fromString(NGFI_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", NGFI_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Qualifying units')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void FurnaceDesignVerification() {
		WebElement Furnace_Title_xpath = driver.findElement(By.xpath("(//div[contains(text(), 'Furnace')])[1]"));

		String Furnace_title_FontSize = Furnace_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", Furnace_title_FontSize);

		String Furnace_title_fontFamily = Furnace_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Furnace_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Furnace_title_fontFamily);
		}
		String Furnace_title_colorValue = Furnace_Title_xpath.getCssValue("color");
		String Furnace_title_Actual_FontColor = Color.fromString(Furnace_title_colorValue).asHex();
		Assert.assertEquals("#000000", Furnace_title_Actual_FontColor);

		// Desc
		WebElement Furnace_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Receive a')]"));

		String Furnace_Desc_FontSize = Furnace_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Furnace_Desc_FontSize);

		String Furnace_Desc_fontFamily = Furnace_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Furnace_Desc_fontFamily);

		String Furnace_Desc_colorValue = Furnace_Desc_xpath.getCssValue("color");
		String Furnace_Desc_Actual_FontColor = Color.fromString(Furnace_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", Furnace_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Apply Now')])[7]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void GravityWallFurnaceDesignVerification() {
		WebElement GWF_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Gravity Wall')]"));

		String GWF_title_FontSize = GWF_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", GWF_title_FontSize);

		String GWF_title_fontFamily = GWF_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", GWF_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, GWF_title_fontFamily);
		}
		String GWF_title_colorValue = GWF_Title_xpath.getCssValue("color");
		String GWF_title_Actual_FontColor = Color.fromString(GWF_title_colorValue).asHex();
		Assert.assertEquals("#000000", GWF_title_Actual_FontColor);

		// Desc
		WebElement GWF_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Receive a ')]"));

		String GWF_Desc_FontSize = GWF_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", GWF_Desc_FontSize);

		String GWF_Desc_fontFamily = GWF_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", GWF_Desc_fontFamily);

		String GWF_Desc_colorValue = GWF_Desc_xpath.getCssValue("color");
		String GWF_Desc_Actual_FontColor = Color.fromString(GWF_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", GWF_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Apply Now')])[8]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void WaysToCheckYourRebateStatusDesignVerififcation() {
		WebElement WTCYRS_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Ways to Check')]"));

		String WTCYRS_title_FontSize = WTCYRS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", WTCYRS_title_FontSize);

		String WTCYRS_title_fontFamily = WTCYRS_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTCYRS_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTCYRS_title_fontFamily);
		}
		String WTCYRS_title_colorValue = WTCYRS_Title_xpath.getCssValue("color");
		String WTCYRS_title_Actual_FontColor = Color.fromString(WTCYRS_title_colorValue).asHex();
		Assert.assertEquals("#000000", WTCYRS_title_Actual_FontColor);

		// Desc
		WebElement WTCYRS_Desc_xpath = driver.findElement(By.xpath("//li[contains(text(), ' applicants who')]"));

		String WTCYRS_Desc_FontSize = WTCYRS_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WTCYRS_Desc_FontSize);

		String WTCYRS_Desc_fontFamily = WTCYRS_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", WTCYRS_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTCYRS_Desc_fontFamily);
		}
		String WTCYRS_Desc_colorValue = WTCYRS_Desc_xpath.getCssValue("color");
		String WTCYRS_Desc_Actual_FontColor = Color.fromString(WTCYRS_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", WTCYRS_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Mobile,')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void OtherWaysToApplyForRebatesDesignVerififcation() {
		WebElement OWTAR_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Other Ways to')]"));

		String OWTAR_title_FontSize = OWTAR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", OWTAR_title_FontSize);

		String OWTAR_title_fontFamily = OWTAR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", OWTAR_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, OWTAR_title_fontFamily);
		}
		String OWTAR_title_colorValue = OWTAR_Title_xpath.getCssValue("color");
		String OWTAR_title_Actual_FontColor = Color.fromString(OWTAR_title_colorValue).asHex();
		Assert.assertEquals("#000000", OWTAR_title_Actual_FontColor);

		// Desc
		WebElement OWTAR_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), ', complete the')]"));

		String OWTAR_Desc_FontSize = OWTAR_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", OWTAR_Desc_FontSize);

		String OWTAR_Desc_fontFamily = OWTAR_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", OWTAR_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, OWTAR_Desc_fontFamily);
		}
		String OWTAR_Desc_colorValue = OWTAR_Desc_xpath.getCssValue("color");
		String OWTAR_Desc_Actual_FontColor = Color.fromString(OWTAR_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", OWTAR_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Download the')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void ImportantNoticesDesignVerififcation() {
		WebElement IN_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Important Notices')]"));

		String IN_title_FontSize = IN_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", IN_title_FontSize);

		String IN_title_fontFamily = IN_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", IN_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, IN_title_fontFamily);
		}
		String IN_title_FontWeight = IN_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", IN_title_FontWeight);

		String IN_title_colorValue = IN_Title_xpath.getCssValue("color");
		String IN_title_Actual_FontColor = Color.fromString(IN_title_colorValue).asHex();
		Assert.assertEquals("#000000", IN_title_Actual_FontColor);

		// Desc
		WebElement IN_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'ENERGY STAR and the')]"));

		String IN_Desc_FontSize = IN_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", IN_Desc_FontSize);

		String IN_Desc_fontFamily = IN_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", IN_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, IN_Desc_fontFamily);
		}
		String IN_Desc_colorValue = IN_Desc_xpath.getCssValue("color");
		String IN_Desc_Actual_FontColor = Color.fromString(IN_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", IN_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Equipment Disclaimer')]"));
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
		System.out.println("Socal Help Center Executed sucessfully");
	}
}
