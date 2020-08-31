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

public class SocalCoronavirus15 {
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
			driver.get((String) jsonObject1.get("SocalCoronavirus15"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalCoronavirus15"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalCoronavirus15"));
			break;
		}
//		driver.get("https://www.socalgas.com/coronavirus");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void CoronavirusOurSupportAndResponse() {
		// Title
		WebElement COSAR_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(text(), 'Coronavirus (COVID-19)')]"));
		String COSAR_Title_FontSize = COSAR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", COSAR_Title_FontSize);

		String COSAR_Title_fontFamily = COSAR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", COSAR_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, COSAR_Title_fontFamily);
		}
		String COSAR_Title_FontWeight = COSAR_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", COSAR_Title_FontWeight);

		String COSAR_Title_colorValue = COSAR_Title_xpath.getCssValue("color");
		String COSAR_Title_Actual_FontColor = Color.fromString(COSAR_Title_colorValue).asHex();
		Assert.assertEquals("#004693", COSAR_Title_Actual_FontColor);

		// Sub Title
		WebElement COSAR_Subtitle_xpath = driver.findElement(By.xpath("//em[contains(text(),'Updated')]"));
		String COSAR_Subtitle_FontSize = COSAR_Subtitle_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", COSAR_Subtitle_FontSize);

		String COSAR_Subtitle_fontFamily = COSAR_Subtitle_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", COSAR_Subtitle_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, COSAR_Subtitle_fontFamily);
		}
		String COSAR_Subtitle_colorValue = COSAR_Subtitle_xpath.getCssValue("color");
		String COSAR_Subtitle_Actual_FontColor = Color.fromString(COSAR_Subtitle_colorValue).asHex();
		Assert.assertEquals("#666666", COSAR_Subtitle_Actual_FontColor);

		// Descriptions.
		WebElement COSAR_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'We understand this')]"));
		String COSAR_Desc_FontSize = COSAR_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", COSAR_Desc_FontSize);

		String COSAR_Desc_fontFamily = COSAR_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", COSAR_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, COSAR_Desc_fontFamily);
		}
		String COSAR_Desc_colorValue = COSAR_Desc_xpath.getCssValue("color");
		String COSAR_Desc_Actual_FontColor = Color.fromString(COSAR_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", COSAR_Desc_Actual_FontColor);
	}

	@Test
	public void WhatToExpectForYourNaturalGasServiceDesignVerification() {
		WebElement WTEFYNGS_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'What to Expect')]"));

		String WTEFYNGS_title_FontSize = WTEFYNGS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", WTEFYNGS_title_FontSize);

		String WTEFYNGS_title_fontFamily = WTEFYNGS_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTEFYNGS_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTEFYNGS_title_fontFamily);
		}
		String WTEFYNGS_title_FontWeight = WTEFYNGS_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", WTEFYNGS_title_FontWeight);

		String WTEFYNGS_title_colorValue = WTEFYNGS_Title_xpath.getCssValue("color");
		String WTEFYNGS_title_Actual_FontColor = Color.fromString(WTEFYNGS_title_colorValue).asHex();
		Assert.assertEquals("#000000", WTEFYNGS_title_Actual_FontColor);

		// Desc
		WebElement WTEFYNGS_Desc_xpath = driver
				.findElement(By.xpath("//li[contains(text(), 'We are committed to providing')]"));

		String WTEFYNGS_Desc_FontSize = WTEFYNGS_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WTEFYNGS_Desc_FontSize);

		String WTEFYNGS_Desc_fontFamily = WTEFYNGS_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", WTEFYNGS_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTEFYNGS_Desc_fontFamily);
		}
		String WTEFYNGS_Desc_colorValue = WTEFYNGS_Desc_xpath.getCssValue("color");
		String WTEFYNGS_Desc_Actual_FontColor = Color.fromString(WTEFYNGS_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", WTEFYNGS_Desc_Actual_FontColor);
	}

	public void WhatWeAreDoingToHelpCustomersDesignVerification() {
		WebElement WWADTHC_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'What we are Doing')]"));

		String WWADTHC_title_FontSize = WWADTHC_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", WWADTHC_title_FontSize);

		String WWADTHC_title_fontFamily = WWADTHC_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WWADTHC_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WWADTHC_title_fontFamily);
		}
		String WWADTHC_title_colorValue = WWADTHC_Title_xpath.getCssValue("color");
		String WWADTHC_title_Actual_FontColor = Color.fromString(WWADTHC_title_colorValue).asHex();
		Assert.assertEquals("#000000", WWADTHC_title_Actual_FontColor);

		// Desc
		WebElement WWADTHC_Desc_xpath = driver
				.findElement(By.xpath("//li[contains(text(), 'Service disconnections')]"));

		String WWADTHC_Desc_FontSize = WWADTHC_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WWADTHC_Desc_FontSize);

		String WWADTHC_Desc_fontFamily = WWADTHC_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", WWADTHC_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WWADTHC_Desc_fontFamily);
		}
		String WWADTHC_Desc_colorValue = WWADTHC_Desc_xpath.getCssValue("color");
		String WWADTHC_Desc_Actual_FontColor = Color.fromString(WWADTHC_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", WWADTHC_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Apply online today')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);

		// *As of March 4, 2020 all CARE
		WebElement AsOfMar_Text_xpath = driver.findElement(By.xpath("//p[contains(text(), '*As of March 4')]"));
		String AsOfMar_Text_FontSize = AsOfMar_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("10px", AsOfMar_Text_FontSize);

		String AsOfMar_Text_fontFamily = AsOfMar_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", AsOfMar_Text_fontFamily);

		String AsOfMar_Text_colorValue = AsOfMar_Text_xpath.getCssValue("color");
		String AsOfMar_Text_Actual_FontColor = Color.fromString(AsOfMar_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", AsOfMar_Text_Actual_FontColor);

	}

	@Test
	public void BillPaymentOptionsAndServicesDuringCOVIDDesignVerification() {
		WebElement BillPaymentOption_Title_xpath = driver
				.findElement(By.xpath("//h2[contains(text(), 'Bill Payment Options')]"));

		String BillPaymentOption_title_FontSize = BillPaymentOption_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", BillPaymentOption_title_FontSize);

		String BillPaymentOption_title_fontFamily = BillPaymentOption_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BillPaymentOption_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BillPaymentOption_title_fontFamily);
		}
		String BillPaymentOption_title_FontWeight = BillPaymentOption_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", BillPaymentOption_title_FontWeight);

		String BillPaymentOption_title_colorValue = BillPaymentOption_Title_xpath.getCssValue("color");
		String BillPaymentOption_title_Actual_FontColor = Color.fromString(BillPaymentOption_title_colorValue).asHex();
		Assert.assertEquals("#000000", BillPaymentOption_title_Actual_FontColor);

		// Sub Title
		WebElement WhereAndHow_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Where and How')]"));

		String WhereAndHow_title_FontSize = WhereAndHow_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", WhereAndHow_title_FontSize);

		String WhereAndHow_title_fontFamily = WhereAndHow_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WhereAndHow_title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WhereAndHow_title_fontFamily);
		}
		String WhereAndHow_title_FontWeight = WhereAndHow_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("500", WhereAndHow_title_FontWeight);

		String WhereAndHow_title_colorValue = BillPaymentOption_Title_xpath.getCssValue("color");
		String WhereAndHow_title_Actual_FontColor = Color.fromString(WhereAndHow_title_colorValue).asHex();
		Assert.assertEquals("#000000", WhereAndHow_title_Actual_FontColor);

		// Desc
		WebElement WhereAndHow_Desc_xpath = driver
				.findElement(By.xpath("//p[contains(text(), 'Beginning Monday Mar')]"));

		String WhereAndHow_Desc_FontSize = WhereAndHow_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WhereAndHow_Desc_FontSize);

		String WhereAndHow_Desc_fontFamily = WhereAndHow_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", WhereAndHow_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WhereAndHow_Desc_fontFamily);
		}
		String WhereAndHow_Desc_colorValue = WhereAndHow_Desc_xpath.getCssValue("color");
		String WhereAndHow_Desc_Actual_FontColor = Color.fromString(WhereAndHow_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", WhereAndHow_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'www.socalgas')])[1]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);

		// Desc
		WebElement SocalgasPo_Text_xpath = driver
				.findElement(By.xpath("//p[contains(text(), 'Beginning Monday Mar')]"));

		String SocalgasPo_Text_FontSize = SocalgasPo_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SocalgasPo_Text_FontSize);

		String SocalgasPo_Text_fontFamily = SocalgasPo_Text_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", SocalgasPo_Text_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SocalgasPo_Text_fontFamily);
		}
		String SocalgasPo_Text_colorValue = SocalgasPo_Text_xpath.getCssValue("color");
		String SocalgasPo_Text_Actual_FontColor = Color.fromString(SocalgasPo_Text_colorValue).asHex();
		Assert.assertEquals("#666666", SocalgasPo_Text_Actual_FontColor);

	}

	@Test
	public void ScamAlertDesignVerification() {
		// Title
		WebElement ScamAlert_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Scam Alert')]"));

		String ScamAlert_Title_FontSize = ScamAlert_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", ScamAlert_Title_FontSize);

		String ScamAlert_Title_fontFamily = ScamAlert_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ScamAlert_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ScamAlert_Title_fontFamily);
		}
		String ScamAlert_Title_colorValue = ScamAlert_Title_xpath.getCssValue("color");
		String ScamAlert_Title_Actual_FontColor = Color.fromString(ScamAlert_Title_colorValue).asHex();
		Assert.assertEquals("#000000", ScamAlert_Title_Actual_FontColor);

		// Desc
		WebElement ScamAlert_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'SoCalGas is aware')]"));

		String ScamAlert_Desc_FontSize = ScamAlert_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", ScamAlert_Desc_FontSize);

		String ScamAlert_Desc_fontFamily = ScamAlert_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", ScamAlert_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ScamAlert_Desc_fontFamily);
		}
		String ScamAlert_Desc_colorValue = ScamAlert_Desc_xpath.getCssValue("color");
		String ScamAlert_Desc_Actual_FontColor = Color.fromString(ScamAlert_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", ScamAlert_Desc_Actual_FontColor);

		WebElement CDC_Text_xpath = driver.findElement(By.xpath("//b[text()='CDC']"));

		String CDC_Text_FontSize = CDC_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", CDC_Text_FontSize);

		String CDC_Text_fontFamily = CDC_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", CDC_Text_fontFamily);

		String CDC_Text_colorValue = CDC_Text_xpath.getCssValue("color");
		String CDC_Text_Actual_FontColor = Color.fromString(CDC_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", CDC_Text_Actual_FontColor);
	}

	@Test
	public void FacilityLimitationsDesignVerification() {
		// Title
		WebElement FacilityLimitations_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Facility')]"));

		String FacilityLimitations_Title_FontSize = FacilityLimitations_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", FacilityLimitations_Title_FontSize);

		String FacilityLimitations_Title_fontFamily = FacilityLimitations_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", FacilityLimitations_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, FacilityLimitations_Title_fontFamily);
		}
		String FacilityLimitations_Title_colorValue = FacilityLimitations_Title_xpath.getCssValue("color");
		String FacilityLimitations_Title_Actual_FontColor = Color.fromString(FacilityLimitations_Title_colorValue)
				.asHex();
		Assert.assertEquals("#000000", FacilityLimitations_Title_Actual_FontColor);

		// Desc
		WebElement ScamAlert_Desc_xpath = driver
				.findElement(By.xpath("//li[contains(text(), 'Some of our facilities')]"));

		String ScamAlert_Desc_FontSize = ScamAlert_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", ScamAlert_Desc_FontSize);

		String ScamAlert_Desc_fontFamily = ScamAlert_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", ScamAlert_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ScamAlert_Desc_fontFamily);
		}
		String ScamAlert_Desc_colorValue = ScamAlert_Desc_xpath.getCssValue("color");
		String ScamAlert_Desc_Actual_FontColor = Color.fromString(ScamAlert_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", ScamAlert_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Centers for Disease')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void ViewCustomerServiceUpdatesVideoInMultipleLanguageDesignVerification() {
		// Title
		WebElement FacilityLimitations_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'View Customer Service')]"));

		String FacilityLimitations_Title_FontSize = FacilityLimitations_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", FacilityLimitations_Title_FontSize);

		String FacilityLimitations_Title_fontFamily = FacilityLimitations_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", FacilityLimitations_Title_fontFamily);

		String FacilityLimitations_Title_colorValue = FacilityLimitations_Title_xpath.getCssValue("color");
		String FacilityLimitations_Title_Actual_FontColor = Color.fromString(FacilityLimitations_Title_colorValue)
				.asHex();
		Assert.assertEquals("#ffffff", FacilityLimitations_Title_Actual_FontColor);

		// Desc
		WebElement FacilityLimitations_LinkText_xpath = driver
				.findElement(By.xpath("//a[contains(text(), 'English')]"));

		String FacilityLimitations_LinkText_FontSize = FacilityLimitations_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", FacilityLimitations_LinkText_FontSize);

		String FacilityLimitations_LinkText_fontFamily = FacilityLimitations_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", FacilityLimitations_LinkText_fontFamily);

		String FacilityLimitations_LinkText_colorValue = FacilityLimitations_LinkText_xpath.getCssValue("color");
		String FacilityLimitations_LinkText_Actual_FontColor = Color.fromString(FacilityLimitations_LinkText_colorValue)
				.asHex();
		Assert.assertEquals("#ffffff", FacilityLimitations_LinkText_Actual_FontColor);
	}

	@Test
	public void CommunityNewsletterDesignVerification() {
		WebElement Community_Newsletter_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Community Newsletter')]"));

		String Community_Newsletter_FontSize = Community_Newsletter_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", Community_Newsletter_FontSize);

		String Community_Newsletter_fontFamily = Community_Newsletter_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Community_Newsletter_fontFamily);

		String Community_Newsletter_colorValue = Community_Newsletter_xpath.getCssValue("color");
		String Community_Newsletter_Actual_FontColor = Color.fromString(Community_Newsletter_colorValue).asHex();
		Assert.assertEquals("#000000", Community_Newsletter_Actual_FontColor);

		WebElement Download_LinkText_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Download')]"));

		String Download_LinkText_FontSize = Download_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Download_LinkText_FontSize);

		String Download_LinkText_fontFamily = Download_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Download_LinkText_fontFamily);

		String Download_LinkText_colorValue = Download_LinkText_xpath.getCssValue("color");
		String Download_LinkText_Actual_FontColor = Color.fromString(Download_LinkText_colorValue).asHex();
		Assert.assertEquals("#0072c6", Download_LinkText_Actual_FontColor);
	}

	@Test
	public void MultiLanguageBillInfoDesignVerification() {
		WebElement Multi_language_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Community Newsletter')]"));

		String Multi_language_FontSize = Multi_language_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", Multi_language_FontSize);

		String Multi_language_fontFamily = Multi_language_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Multi_language_fontFamily);

		String Multi_language_colorValue = Multi_language_xpath.getCssValue("color");
		String Multi_language_Actual_FontColor = Color.fromString(Multi_language_colorValue).asHex();
		Assert.assertEquals("#000000", Multi_language_Actual_FontColor);

		WebElement LinkText_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Mga Opsyon')]"));

		String LinkText_FontSize = LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", LinkText_FontSize);

		String LinkText_fontFamily = LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", LinkText_fontFamily);

		String LinkText_colorValue = LinkText_xpath.getCssValue("color");
		String LinkText_Actual_FontColor = Color.fromString(LinkText_colorValue).asHex();
		Assert.assertEquals("#0072c6", LinkText_Actual_FontColor);

		//
		WebElement MoreInfo_LinkText_xpath = driver.findElement(By.xpath("//a[contains(text(), 'More Info')]"));

		String MoreInfo_LinkText_FontSize = MoreInfo_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", MoreInfo_LinkText_FontSize);

		String MoreInfo_LinkText_fontFamily = MoreInfo_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", MoreInfo_LinkText_fontFamily);

		String MoreInfo_LinkText_colorValue = MoreInfo_LinkText_xpath.getCssValue("color");
		String MoreInfo_LinkText_Actual_FontColor = Color.fromString(MoreInfo_LinkText_colorValue).asHex();
		Assert.assertEquals("#ffffff", MoreInfo_LinkText_Actual_FontColor);
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
