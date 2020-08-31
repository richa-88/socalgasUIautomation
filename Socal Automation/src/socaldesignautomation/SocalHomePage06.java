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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocalHomePage06 {
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
			driver.get((String) jsonObject1.get("SocalHomePage06"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalHomePage06"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalHomePage06"));
			break;
		}
//		driver.get("https://www.socalgas.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void CovidSupportResponce() {
		// Covid-19 block path.
		WebElement c_BG_clr_xpath = driver.findElement(By.cssSelector(".maintenance"));

		String c_BG_clr_colorValue = c_BG_clr_xpath.getCssValue("background-color");
		String c_BG_clr_Actual_Title_FontColor = Color.fromString(c_BG_clr_colorValue).asHex();
		Assert.assertEquals("#f2a900", c_BG_clr_Actual_Title_FontColor);

		WebElement c_FontSize_xpath = driver.findElement(By.xpath("//a[contains(text(),'COVID-19 Our Support')]"));
		String c_Actual_FontSize = c_FontSize_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", c_Actual_FontSize);

		String c_Actual_fontFamily = c_FontSize_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", c_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, c_Actual_fontFamily);
		}
		String c_colorValue = c_FontSize_xpath.getCssValue("color");
		String c_Actual_FontColor = Color.fromString(c_colorValue).asHex();
		Assert.assertEquals("#004695", c_Actual_FontColor);

	}

	@Test
	public void FinancialSupportForYouAndYourFamily() {
		WebElement fSFYAYF_xpath = driver.findElement(By.xpath("//div[contains(text(),'FINANCIAL SUPPORT')]"));
		String fSFYAYF_FontSize = fSFYAYF_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", fSFYAYF_FontSize);

		String fSFYAYF_xpath_Actual_fontFamily = fSFYAYF_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", fSFYAYF_xpath_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, fSFYAYF_xpath_Actual_fontFamily);
		}
		String fSElement_clr = driver.findElement(By.tagName("h1")).getAttribute("style");
		String fSElement_Actula_clr = "color: rgb(0, 70, 147);";
		Assert.assertEquals(fSElement_Actula_clr, fSElement_clr);

		WebElement learn_More_text = driver.findElement(By.xpath("//a[@class='page-banner__link blue-cta']"));
		String learn_More_text_FontSize = learn_More_text.getCssValue("font-size");
		Assert.assertEquals("16px", learn_More_text_FontSize);

		String learn_More_text_Actual_fontFamily = learn_More_text.getCssValue("font-family");
		Assert.assertEquals("Interstate", learn_More_text_Actual_fontFamily);
	}

	@Test
	public void LogintoMyAccounttopayyourbill() {
		WebElement login_My_Acc_Title_xpath = driver.findElement(By.cssSelector("#log-in-title"));
		String Lma_Title_FontSize = login_My_Acc_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", Lma_Title_FontSize);

		String login_My_Acc_Actual_fontFamily = login_My_Acc_Title_xpath.getCssValue("font-family");

//		Assert.assertEquals("Interstate, Helvetica, sans-serif", login_My_Acc_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, login_My_Acc_Actual_fontFamily);
		}

		String login_My_Acc_Title_colorValue = login_My_Acc_Title_xpath.getCssValue("color");
		String login_My_Acc_Actual_Title_FontColor = Color.fromString(login_My_Acc_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", login_My_Acc_Actual_Title_FontColor);

		// Dont have an account text.
		WebElement DonthaveAccText = driver.findElement(By.xpath("(//span[@class='binding_register_link'])[1]"));
		String DonthaveAccText_FontSize = DonthaveAccText.getCssValue("font-size");

		Assert.assertEquals("16px", DonthaveAccText_FontSize);
		String DonthaveAccText_colorValue = DonthaveAccText.getCssValue("color");
		String DonthaveAccText_FontColor = Color.fromString(DonthaveAccText_colorValue).asHex();
		Assert.assertEquals("#ffffff", DonthaveAccText_FontColor);
	}

	@Test
	public void BillPaymentOptions() {
		// Title of Bill Payment options.
		WebElement BPO_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Bill payment')]"));

		String BPO_Title_FontSize = BPO_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", BPO_Title_FontSize);

		String BPO_Title_fontFamily = BPO_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BPO_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BPO_Title_fontFamily);
		}
		String BPO_Title_colorValue = BPO_Title_xpath.getCssValue("color");
		String BPO_Title_Actual_FontColor = Color.fromString(BPO_Title_colorValue).asHex();
		Assert.assertEquals("#000000", BPO_Title_Actual_FontColor);

		// Desc
		WebElement BPO_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Find the one')]"));

		String BPO_Desc_FontSize = BPO_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BPO_Desc_FontSize);

		String BPO_Desc_fontFamily = BPO_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", BPO_Desc_fontFamily);

		String BPO_Desc_colorValue = BPO_Desc_xpath.getCssValue("color");
		String BPO_Desc_Actual_FontColor = Color.fromString(BPO_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", BPO_Desc_Actual_FontColor);

		// Link Text
		WebElement BPO_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-secondary'])[1]"));
		String BPO_Link_Text_FontSize = BPO_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", BPO_Link_Text_FontSize);

		String BPO_Link_Text_fontFamily = BPO_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", BPO_Link_Text_fontFamily);

		String BPO_Link_Text_colorValue = BPO_Link_Text.getCssValue("color");
		String BPO_Link_Text_Actual_FontColor = Color.fromString(BPO_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", BPO_Link_Text_Actual_FontColor);

	}

	@Test
	public void SocalgasNews() {
		// Title of Bill Payment options.
		WebElement SN_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'SoCalGas')]"));

		String SN_Title_FontSize = SN_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", SN_Title_FontSize);

		String SN_Title_fontFamily = SN_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", SN_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SN_Title_fontFamily);
		}
		String SN_Title_colorValue = SN_Title_xpath.getCssValue("color");
		String SN_Title_Actual_FontColor = Color.fromString(SN_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", SN_Title_Actual_FontColor);

		// Desc
		WebElement SN_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'View the latest on')]"));

		String SN_Desc_FontSize = SN_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SN_Desc_FontSize);

		String SN_Desc_fontFamily = SN_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", SN_Desc_fontFamily);

		String SN_Desc_colorValue = SN_Desc_xpath.getCssValue("color");
		String SN_Desc_Actual_FontColor = Color.fromString(SN_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", SN_Desc_Actual_FontColor);

		// Link Text
		WebElement SN_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-primary'])[1]"));
		String SN_Link_Text_FontSize = SN_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", SN_Link_Text_FontSize);

		String SN_Link_Text_fontFamily = SN_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", SN_Link_Text_fontFamily);

		String SN_Link_Text_colorValue = SN_Link_Text.getCssValue("color");
		String SN_Link_Text_Actual_FontColor = Color.fromString(SN_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", SN_Link_Text_Actual_FontColor);
	}

	@Test
	public void OurVisionDesignVerification() {
		// Title of Bill Payment options.
		WebElement OV_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Our Vision')]"));

		String OV_Title_FontSize = OV_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", OV_Title_FontSize);

		String OV_Title_fontFamily = OV_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", OV_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, OV_Title_fontFamily);
		}
		String OV_Title_colorValue = OV_Title_xpath.getCssValue("color");
		String OV_Title_Actual_FontColor = Color.fromString(OV_Title_colorValue).asHex();
		Assert.assertEquals("#000000", OV_Title_Actual_FontColor);

		// Desc
		WebElement OV_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Learn about our')]"));

		String OV_Desc_FontSize = OV_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", OV_Desc_FontSize);

		String OV_Desc_fontFamily = OV_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", OV_Desc_fontFamily);

		String OV_Desc_colorValue = OV_Desc_xpath.getCssValue("color");
		String OV_Desc_Actual_FontColor = Color.fromString(OV_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", OV_Desc_Actual_FontColor);

		// Link Text
		WebElement OV_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-secondary'])[2]"));
		String OV_Link_Text_FontSize = OV_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", OV_Link_Text_FontSize);

		String OV_Link_Text_fontFamily = OV_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", OV_Link_Text_fontFamily);

		String OV_Link_Text_colorValue = OV_Link_Text.getCssValue("color");
		String OV_Link_Text_Actual_FontColor = Color.fromString(OV_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", OV_Link_Text_Actual_FontColor);
	}

	@Test
	public void StartYourDIYProjectWithSafety() {
		// Title of Bill Payment options.
		WebElement SYDPWS_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Start your DIY')]"));

		String SYDPWS_Title_FontSize = SYDPWS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", SYDPWS_Title_FontSize);

		String SYDPWS_Title_fontFamily = SYDPWS_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", SYDPWS_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, SYDPWS_Title_fontFamily);
		}
		String SYDPWS_Title_colorValue = SYDPWS_Title_xpath.getCssValue("color");
		String SYDPWS_Title_Actual_FontColor = Color.fromString(SYDPWS_Title_colorValue).asHex();
		Assert.assertEquals("#004693", SYDPWS_Title_Actual_FontColor);

		// Desc
		WebElement SYDPWS_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Contact 811 before')]"));

		String SYDPWS_Desc_FontSize = SYDPWS_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", SYDPWS_Desc_FontSize);

		String SYDPWS_Desc_fontFamily = SYDPWS_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", SYDPWS_Desc_fontFamily);

		String SYDPWS_Desc_colorValue = SYDPWS_Desc_xpath.getCssValue("color");
		String SYDPWS_Desc_Actual_FontColor = Color.fromString(SYDPWS_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", SYDPWS_Desc_Actual_FontColor);

		// Link Text
		WebElement SYDPWS_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-primary'])[2]"));
		String SYDPWS_Link_Text_FontSize = SYDPWS_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", SYDPWS_Link_Text_FontSize);

		String SYDPWS_Link_Text_fontFamily = SYDPWS_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", SYDPWS_Link_Text_fontFamily);

		String SYDPWS_Link_Text_colorValue = SYDPWS_Link_Text.getCssValue("color");
		String SYDPWS_Link_Text_Actual_FontColor = Color.fromString(SYDPWS_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", SYDPWS_Link_Text_Actual_FontColor);
	}

	@Test
	public void UnderstandingYourBill() {
		// Title of Bill Payment options.
		WebElement UYB_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Understanding')]"));

		String UYB_Title_FontSize = UYB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", UYB_Title_FontSize);

		String UYB_Title_fontFamily = UYB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", UYB_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, UYB_Title_fontFamily);
		}
		String UYB_Title_colorValue = UYB_Title_xpath.getCssValue("color");
		String UYB_Title_Actual_FontColor = Color.fromString(UYB_Title_colorValue).asHex();
		Assert.assertEquals("#000000", UYB_Title_Actual_FontColor);

		// Desc
		WebElement UYB_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Learn how your natural')]"));

		String UYB_Desc_FontSize = UYB_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", UYB_Desc_FontSize);

		String UYB_Desc_fontFamily = UYB_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", UYB_Desc_fontFamily);

		String UYB_Desc_colorValue = UYB_Desc_xpath.getCssValue("color");
		String UYB_Desc_Actual_FontColor = Color.fromString(UYB_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", UYB_Desc_Actual_FontColor);

		// Link Text
		WebElement UYB_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-secondary'])[3]"));
		String UYB_Link_Text_FontSize = UYB_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", UYB_Link_Text_FontSize);

		String UYB_Link_Text_fontFamily = UYB_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", UYB_Link_Text_fontFamily);

		String UYB_Link_Text_colorValue = UYB_Link_Text.getCssValue("color");
		String UYB_Link_Text_Actual_FontColor = Color.fromString(UYB_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", UYB_Link_Text_Actual_FontColor);
	}

	@Test
	public void ServicesDesignVerification() {
		WebElement Service_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Services')]"));
		String Service_Title_FontSize = Service_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", Service_Title_FontSize);

		String Service_Title_fontFamily = Service_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Service_Title_fontFamily);

		String Service_Title_colorValue = Service_Title_xpath.getCssValue("color");
		String Service_Title_Actual_FontColor = Color.fromString(Service_Title_colorValue).asHex();
		Assert.assertEquals("#000000", Service_Title_Actual_FontColor);

		// Sub Title
		WebElement Transfer_Service_Title_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Transfer Service')]"));
		String Transfer_Service_Title_FontSize = Transfer_Service_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", Transfer_Service_Title_FontSize);

		String Transfer_Service_Title_fontFamily = Transfer_Service_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Transfer_Service_Title_fontFamily);

		String Transfer_Service_Title_colorValue = Transfer_Service_Title_xpath.getCssValue("color");
		String Transfer_Service_Title_Actual_FontColor = Color.fromString(Transfer_Service_Title_colorValue).asHex();
		Assert.assertEquals("#000000", Transfer_Service_Title_Actual_FontColor);

		// Sub Description.
		WebElement Transfer_Service_Desc_xpath = driver
				.findElement(By.xpath("//p[contains(text(),'Getting ready to')]"));
		String Transfer_Service_Desc_FontSize = Transfer_Service_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Transfer_Service_Desc_FontSize);

		String Transfer_Service_Desc_fontFamily = Transfer_Service_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", Transfer_Service_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Transfer_Service_Desc_fontFamily);
		}
		String Transfer_Service_Desc_colorValue = Transfer_Service_Desc_xpath.getCssValue("color");
		String Transfer_Service_Desc_Actual_FontColor = Color.fromString(Transfer_Service_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", Transfer_Service_Desc_Actual_FontColor);
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
		}
	}

	@AfterTest
	public void terminateBrowser() {
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
	}
}
