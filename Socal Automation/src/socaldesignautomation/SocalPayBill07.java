package socaldesignautomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocalPayBill07 {
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
			driver.get((String) jsonObject1.get("SocalPayBill07"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalPayBill07"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalPayBill07"));
			break;
		}
//		driver.get("https://www.socalgas.com/pay-bill");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void PayYourBillsDesignVerification() {
		WebElement PYB_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Pay Your Bills')]"));
		String PYB_FontSize = PYB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", PYB_FontSize);

		String PYB_xpath_Actual_fontFamily = PYB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PYB_xpath_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PYB_xpath_Actual_fontFamily);
		}
		String PYB_Title_colorValue = PYB_Title_xpath.getCssValue("color");
		String PYB_Actual_Title_FontColor = Color.fromString(PYB_Title_colorValue).asHex();
		Assert.assertEquals("#004693", PYB_Actual_Title_FontColor);

		// Sub Description.
		WebElement PYB_Desc_xpath = driver.findElement(By.xpath("//div/p[contains(text(),'Learn about your')]"));
		String PYB_Desc_FontSize = PYB_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", PYB_Desc_FontSize);

		String PYB_Desc_fontFamily = PYB_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", PYB_Desc_fontFamily);

		String PYB_Desc_colorValue = PYB_Desc_xpath.getCssValue("color");
		String PYB_Desc_Actual_FontColor = Color.fromString(PYB_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", PYB_Desc_Actual_FontColor);
	}

	@Test
	public void LogintoMyAccounttopayYourBillDesignVerification() {
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
	public void WaysToPayDesignVerification() {
		// Title
		WebElement WTP_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Ways to Pay')]"));
		String WTP_Title_FontSize = WTP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", WTP_Title_FontSize);

		String WTP_Title_fontFamily = WTP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTP_Title_fontFamily);
		}
		String WTP_Title_colorValue = WTP_Title_xpath.getCssValue("color");
		String WTP_Title_Actual_FontColor = Color.fromString(WTP_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", WTP_Title_Actual_FontColor);

		// Descriptions.
		WebElement WTP_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(),'Ways to Pay')]"));
		String WTP_Desc_FontSize = WTP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", WTP_Desc_FontSize);

		String WTP_Desc_fontFamily = WTP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTP_Desc_fontFamily);
		}
		String WTP_Desc_colorValue = WTP_Desc_xpath.getCssValue("color");
		String WTP_Desc_Actual_FontColor = Color.fromString(WTP_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", WTP_Desc_Actual_FontColor);

		// Login Button.
		WebElement WTP_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(),'Payment Options')]"));
		String WTP_Link_Text_FontSize = WTP_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WTP_Link_Text_FontSize);

		String WTP_Link_Text_fontFamily = WTP_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", WTP_Link_Text_fontFamily);

		String WTP_Link_Text_colorValue = WTP_Link_Text_xpath.getCssValue("color");
		String WTP_Link_Text_Actual_FontColor = Color.fromString(WTP_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", WTP_Link_Text_Actual_FontColor);
	}

	@Test
	public void MyAccountDesignVerfication() {
		// Title of Bill Payment options.
		WebElement MyAccount_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(@class, 'field--title') and text() = 'My Account']"));

		String MyAccount_Title_FontSize = MyAccount_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", MyAccount_Title_FontSize);

		String MyAccount_Title_fontFamily = MyAccount_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", MyAccount_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MyAccount_Title_fontFamily);
		}
		String MyAccount_Title_colorValue = MyAccount_Title_xpath.getCssValue("color");
		String MyAccount_Title_Actual_FontColor = Color.fromString(MyAccount_Title_colorValue).asHex();
		Assert.assertEquals("#000000", MyAccount_Title_Actual_FontColor);

		// Desc
		WebElement MyAccount_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(),'My Account is the')]"));

		String MyAccount_Desc_FontSize = MyAccount_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", MyAccount_Desc_FontSize);

		String MyAccount_Desc_fontFamily = MyAccount_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", MyAccount_Desc_fontFamily);

		String MyAccount_Desc_colorValue = MyAccount_Desc_xpath.getCssValue("color");
		String MyAccount_Desc_Actual_FontColor = Color.fromString(MyAccount_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", MyAccount_Desc_Actual_FontColor);

		// Link Text
		WebElement MyAccount_Link_Text = driver.findElement(By.xpath("//a[contains(text(),'Get Started')]"));
		String MyAccount_Link_Text_FontSize = MyAccount_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", MyAccount_Link_Text_FontSize);

		String MyAccount_Link_Text_fontFamily = MyAccount_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", MyAccount_Link_Text_fontFamily);

		String MyAccount_Link_Text_colorValue = MyAccount_Link_Text.getCssValue("color");
		String MyAccount_Link_Text_Actual_FontColor = Color.fromString(MyAccount_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", MyAccount_Link_Text_Actual_FontColor);
	}

	@Test
	public void NeedMoreTimeToPayDesignVerification() {
		// Title of Need More Time To Pay.
		WebElement NMTTP_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Need More Time')]"));

		String NMTTP_Title_FontSize = NMTTP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", NMTTP_Title_FontSize);

		String NMTTP_Title_fontFamily = NMTTP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", NMTTP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, NMTTP_Title_fontFamily);
		}
		String NMTTP_Title_colorValue = NMTTP_Title_xpath.getCssValue("color");
		String NMTTP_Title_Actual_FontColor = Color.fromString(NMTTP_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", NMTTP_Title_Actual_FontColor);

		// Desc
		WebElement NMTTP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Need more time')]"));

		String NMTTP_Desc_FontSize = NMTTP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", NMTTP_Desc_FontSize);

		String NMTTP_Desc_fontFamily = NMTTP_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", NMTTP_Desc_fontFamily);

		String NMTTP_Desc_colorValue = NMTTP_Desc_xpath.getCssValue("color");
		String NMTTP_Desc_Actual_FontColor = Color.fromString(NMTTP_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", NMTTP_Desc_Actual_FontColor);

		// Link Text
		WebElement NMTTP_Link_Text = driver.findElement(By.xpath("//a[contains(text(), 'Find Out How')]"));
		String NMTTP_Link_Text_FontSize = NMTTP_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", NMTTP_Link_Text_FontSize);

		String NMTTP_Link_Text_fontFamily = NMTTP_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", NMTTP_Link_Text_fontFamily);

		String NMTTP_Link_Text_colorValue = NMTTP_Link_Text.getCssValue("color");
		String NMTTP_Link_Text_Actual_FontColor = Color.fromString(NMTTP_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", NMTTP_Link_Text_Actual_FontColor);

	}

	@Test
	public void UnderstandingYourBillDesignVerification() {
		// Title of Understanding Your Bills.
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
		WebElement UYB_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(),'Confused about your')]"));

		String UYB_Desc_FontSize = UYB_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", UYB_Desc_FontSize);

		String UYB_Desc_fontFamily = UYB_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", UYB_Desc_fontFamily);

		String UYB_Desc_colorValue = UYB_Desc_xpath.getCssValue("color");
		String UYB_Desc_Actual_FontColor = Color.fromString(UYB_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", UYB_Desc_Actual_FontColor);

		// Link Text
		WebElement UYB_Link_Text = driver.findElement(By.xpath("//a[contains(text(),'Get Help')]"));
		String UYB_Link_Text_FontSize = UYB_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", UYB_Link_Text_FontSize);

		String UYB_Link_Text_fontFamily = UYB_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", UYB_Link_Text_fontFamily);

		String UYB_Link_Text_colorValue = UYB_Link_Text.getCssValue("color");
		String UYB_Link_Text_Actual_FontColor = Color.fromString(UYB_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", UYB_Link_Text_Actual_FontColor);
	}

	@Test
	public void ManageHigherBillsDesignVerification() {
		// Title of Bill Payment options.
		WebElement MHB_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Manage Higher Bills')]"));

		String MHB_Title_FontSize = MHB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", MHB_Title_FontSize);

		String MHB_Title_fontFamily = MHB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", MHB_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MHB_Title_fontFamily);
		}
		String MHB_Title_colorValue = MHB_Title_xpath.getCssValue("color");
		String MHB_Title_Actual_FontColor = Color.fromString(MHB_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", MHB_Title_Actual_FontColor);

		// Desc
		WebElement MHB_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Find out how')]"));

		String MHB_Desc_FontSize = MHB_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", MHB_Desc_FontSize);

		String MHB_Desc_fontFamily = MHB_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", MHB_Desc_fontFamily);

		String MHB_Desc_colorValue = MHB_Desc_xpath.getCssValue("color");
		String MHB_Desc_Actual_FontColor = Color.fromString(MHB_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", MHB_Desc_Actual_FontColor);

		// Link Text
		WebElement MHB_Link_Text = driver.findElement(By.xpath("(//a[@class='btn-primary'])[1]"));
		String MHB_Link_Text_FontSize = MHB_Link_Text.getCssValue("font-size");
		Assert.assertEquals("16px", MHB_Link_Text_FontSize);

		String MHB_Link_Text_fontFamily = MHB_Link_Text.getCssValue("font-family");
		Assert.assertEquals("Interstate", MHB_Link_Text_fontFamily);

		String MHB_Link_Text_colorValue = MHB_Link_Text.getCssValue("color");
		String MHB_Link_Text_Actual_FontColor = Color.fromString(MHB_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", MHB_Link_Text_Actual_FontColor);
	}

	@Test
	public void BusinessMyAccountDesignVerification() {
		// Tittle xpath of Business My Account.
		WebElement BMA_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Business My Account')]"));
		String BMA_Title_FontSize = BMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", BMA_Title_FontSize);

		String BMA_Title_Actual_fontFamily = BMA_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", BMA_Title_Actual_fontFamily);

		String BMA_Title_colorValue = BMA_Title_xpath.getCssValue("color");
		String BMA_Title_Actual_FontColor = Color.fromString(BMA_Title_colorValue).asHex();
		Assert.assertEquals("#000000", BMA_Title_Actual_FontColor);

		// Content xpath of Business My Account.
		WebElement BMA_Content_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Business customers now')]"));
		String BMA_Content_FontSize = BMA_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BMA_Content_FontSize);

		String BMA_Content_Actual_fontFamily = BMA_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", BMA_Content_Actual_fontFamily);

		String BMA_Content_colorValue = BMA_Content_xpath.getCssValue("color");
		String BMA_Content_Actual_FontColor = Color.fromString(BMA_Content_colorValue).asHex();
		Assert.assertEquals("#666666", BMA_Content_Actual_FontColor);

		// Link text xpath for Business My Account.
		WebElement BMA_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[2]"));
		String BMA_Btn_FontSize = BMA_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BMA_Btn_FontSize);

		String BMA_Btn_Actual_fontFamily = BMA_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", BMA_Btn_Actual_fontFamily);

		String BMA_Btn_colorValue = BMA_Btn_xpath.getCssValue("color");
		String BMA_Btn_Actual_FontColor = Color.fromString(BMA_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", BMA_Btn_Actual_FontColor);
	}

	public void PaperLessBillingDesignVerification() {
		// Tittle xpath of Do Business With Us.
		WebElement PLB_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Paperless Billing')]"));
		String PLB_Title_FontSize = PLB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", PLB_Title_FontSize);

		String PLB_Title_Actual_fontFamily = PLB_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", PLB_Title_Actual_fontFamily);

		String PLB_Title_colorValue = PLB_Title_xpath.getCssValue("color");
		String PLB_Title_Actual_FontColor = Color.fromString(PLB_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PLB_Title_Actual_FontColor);

		// Content xpath of Do Business With Us.
		WebElement PLB_Content_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Reduce clutter')]"));
		String PLB_Content_FontSize = PLB_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PLB_Content_FontSize);

		String PLB_Content_Actual_fontFamily = PLB_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", PLB_Content_Actual_fontFamily);

		String PLB_Content_colorValue = PLB_Content_xpath.getCssValue("color");
		String PLB_Content_Actual_FontColor = Color.fromString(PLB_Content_colorValue).asHex();
		Assert.assertEquals("#666666", PLB_Content_Actual_FontColor);

		// Link text xpath Do Business With Us.
		WebElement PLB_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Go Paperless')]"));
		String PLB_Btn_FontSize = PLB_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PLB_Btn_FontSize);

		String PLB_Btn_Actual_fontFamily = PLB_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", PLB_Btn_Actual_fontFamily);

		String PLB_Btn_colorValue = PLB_Btn_xpath.getCssValue("color");
		String PLB_Btn_Actual_FontColor = Color.fromString(PLB_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", PLB_Btn_Actual_FontColor);
	}

	public void EmergencyDisasterReliefDesignVerification() {
		// Tittle xpath of Do Business With Us.
		WebElement EDR_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Emergency')]"));
		String EDR_Title_FontSize = EDR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", EDR_Title_FontSize);

		String EDR_Title_Actual_fontFamily = EDR_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", EDR_Title_Actual_fontFamily);

		String EDR_Title_colorValue = EDR_Title_xpath.getCssValue("color");
		String EDR_Title_Actual_FontColor = Color.fromString(EDR_Title_colorValue).asHex();
		Assert.assertEquals("#000000", EDR_Title_Actual_FontColor);

		// Content xpath of Do Business With Us.
		WebElement EDR_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'SoCalGas occasionally')]"));
		String EDR_Content_FontSize = EDR_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EDR_Content_FontSize);

		String EDR_Content_Actual_fontFamily = EDR_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", EDR_Content_Actual_fontFamily);

		String EDR_Content_colorValue = EDR_Title_xpath.getCssValue("color");
		String EDR_Content_Actual_FontColor = Color.fromString(EDR_Content_colorValue).asHex();
		Assert.assertEquals("#666666", EDR_Content_Actual_FontColor);

		// Link text xpath Do Business With Us.
		WebElement EDR_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[3]"));
		String EDR_Btn_FontSize = EDR_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EDR_Btn_FontSize);

		String EDR_Btn_Actual_fontFamily = EDR_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", EDR_Btn_Actual_fontFamily);

		String EDR_Btn_colorValue = EDR_Btn_xpath.getCssValue("color");
		String EDR_Btn_Actual_FontColor = Color.fromString(EDR_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", EDR_Btn_Actual_FontColor);
	}

	@AfterTest
	public void terminateBrowser() {
		driver.quit();
		System.out.println("Socal Pay Bill Executed sucessfully");
	}
}
