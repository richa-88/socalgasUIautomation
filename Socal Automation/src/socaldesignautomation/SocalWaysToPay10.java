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

public class SocalWaysToPay10 {
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
			driver.get((String) jsonObject1.get("SocalWaysToPay10"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalWaysToPay10"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalWaysToPay10"));
			break;
		}
//		driver.get("https://www.socalgas.com/pay-bill/ways-to-pay");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void WaysToPay() {
		// Title
		WebElement WTP_Title_xpath = driver.findElement(By.xpath("//h1/div[contains(text(),'Ways to Pay')]"));
		String WTP_Title_FontSize = WTP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", WTP_Title_FontSize);

		String WTP_Title_fontFamily = WTP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTP_Title_fontFamily);
		}
		String WTP_Title_colorValue = WTP_Title_xpath.getCssValue("color");
		String WTP_Title_Actual_FontColor = Color.fromString(WTP_Title_colorValue).asHex();
		Assert.assertEquals("#004693", WTP_Title_Actual_FontColor);

		// Descriptions.
		WebElement WTP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'We offer a number')]"));
		String WTP_Desc_FontSize = WTP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", WTP_Desc_FontSize);

		String WTP_Desc_fontFamily = WTP_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", WTP_Desc_fontFamily);

		String WTP_Desc_colorValue = WTP_Desc_xpath.getCssValue("color");
		String WTP_Desc_Actual_FontColor = Color.fromString(WTP_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", WTP_Desc_Actual_FontColor);
	}

	@Test
	public void EasyWaysToPayWithMyAccount() {
		// Title
		WebElement EWTPWMA_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Easy')]"));
		String EWTPWMA_Title_FontSize = EWTPWMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", EWTPWMA_Title_FontSize);

		String EWTPWMA_Title_fontFamily = EWTPWMA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", EWTPWMA_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, EWTPWMA_Title_fontFamily);
		}
		String EWTPWMA_Title_colorValue = EWTPWMA_Title_xpath.getCssValue("color");
		String EWTPWMA_Title_Actual_FontColor = Color.fromString(EWTPWMA_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", EWTPWMA_Title_Actual_FontColor);

		// Descriptions.
		WebElement EWTPWMA_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'View and pay')]"));
		String EWTPWMA_Desc_FontSize = EWTPWMA_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EWTPWMA_Desc_FontSize);

		String EWTPWMA_Desc_fontFamily = EWTPWMA_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", EWTPWMA_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, EWTPWMA_Desc_fontFamily);
		}
		String EWTPWMA_Desc_colorValue = EWTPWMA_Desc_xpath.getCssValue("color");
		String EWTPWMA_Desc_Actual_FontColor = Color.fromString(EWTPWMA_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", EWTPWMA_Desc_Actual_FontColor);

		// Benefits of My Account
		WebElement Benefits_of_My_Account_Title_xpath = driver
				.findElement(By.xpath("//h4[contains(text(),'Benefits of My Account')]"));
		String Benefits_of_My_Account_Title_FontSize = Benefits_of_My_Account_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", Benefits_of_My_Account_Title_FontSize);

		String Benefits_of_My_Account_Title_fontFamily = Benefits_of_My_Account_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Benefits_of_My_Account_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Benefits_of_My_Account_Title_fontFamily);
		}
		String Benefits_of_My_Account_Title_colorValue = Benefits_of_My_Account_Title_xpath.getCssValue("color");
		String Benefits_of_My_Account_Title_Actual_FontColor = Color.fromString(Benefits_of_My_Account_Title_colorValue)
				.asHex();
		Assert.assertEquals("#ffffff", Benefits_of_My_Account_Title_Actual_FontColor);

		// Benefits of My Account
		WebElement Benefits_of_My_Account_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(text(),'Receive a monthly')]"));
		String Benefits_of_My_Account_Desc_FontSize = Benefits_of_My_Account_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", Benefits_of_My_Account_Desc_FontSize);

		String Benefits_of_My_Account_Desc_fontFamily = Benefits_of_My_Account_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Benefits_of_My_Account_Desc_fontFamily);

		String Benefits_of_My_Account_Desc_colorValue = Benefits_of_My_Account_Desc_xpath.getCssValue("color");
		String Benefits_of_My_Account_Actual_Desc_FontColor = Color.fromString(Benefits_of_My_Account_Desc_colorValue)
				.asHex();
		Assert.assertEquals("#ffffff", Benefits_of_My_Account_Actual_Desc_FontColor);

		// Link text
		WebElement Pay_Now_Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Pay Now')])[1]"));
		String Pay_Now_Link_Text_FontSize = Pay_Now_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Pay_Now_Link_Text_FontSize);

		String Pay_Now_Link_Text_fontFamily = Pay_Now_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Pay_Now_Link_Text_fontFamily);

		String Pay_Now_Link_Text_colorValue = Pay_Now_Link_Text_xpath.getCssValue("color");
		String Pay_Now_Link_Text_FontColor = Color.fromString(Pay_Now_Link_Text_colorValue).asHex();
		Assert.assertEquals("#000000", Pay_Now_Link_Text_FontColor);
	}

	@Test
	public void PayByCreditOrDebit() {
		WebElement PBCOD_Title_xpath = driver.findElement(By.xpath("//h4[contains(text(),'Payments Accepted')]"));
		String PBCOD_Title_FontSize = PBCOD_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", PBCOD_Title_FontSize);

		String PBCOD_Title_fontFamily = PBCOD_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PBCOD_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PBCOD_Title_fontFamily);
		}
		String PBCOD_Title_colorValue = PBCOD_Title_xpath.getCssValue("color");
		String PBCOD__Actual_Title_FontColor = Color.fromString(PBCOD_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PBCOD__Actual_Title_FontColor);

		// Description
		WebElement PBCOD_Desc_xpath = driver.findElement(By.xpath("(//p[contains(text(),'Credit or debit card')])"));
		String PBCOD_Desc_FontSize = PBCOD_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PBCOD_Desc_FontSize);

		String PBCOD_Desc_fontFamily = PBCOD_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", PBCOD_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PBCOD_Desc_fontFamily);
		}
		String PBCOD_Desc_colorValue = PBCOD_Desc_xpath.getCssValue("color");
		String PBCOD_Actual_Desc_FontColor = Color.fromString(PBCOD_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", PBCOD_Actual_Desc_FontColor);

		// Link text
		WebElement Pay_Now_Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Pay Now')])[2]"));
		String Pay_Now_Link_Text_FontSize = Pay_Now_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Pay_Now_Link_Text_FontSize);

		String Pay_Now_Link_Text_fontFamily = Pay_Now_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Pay_Now_Link_Text_fontFamily);

		String Pay_Now_Link_Text_colorValue = Pay_Now_Link_Text_xpath.getCssValue("color");
		String Pay_Now_Link_Text_FontColor = Color.fromString(Pay_Now_Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Pay_Now_Link_Text_FontColor);
	}

	@Test
	public void PaymentAccepted() {
		WebElement PA_Title_xpath = driver.findElement(By.xpath("(//div[contains(text(),'Pay by Credit')])"));
		String PA_Title_FontSize = PA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", PA_Title_FontSize);

		String PA_Title_fontFamily = PA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PA_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PA_Title_fontFamily);
		}
		String PA_Title_colorValue = PA_Title_xpath.getCssValue("color");
		String PA_Actual_Title_FontColor = Color.fromString(PA_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PA_Actual_Title_FontColor);

		// Description
		WebElement PA_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Note')]"));
		String PA_Desc_FontSize = PA_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PA_Desc_FontSize);

		String PA_Desc_fontFamily = PA_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", PA_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PA_Desc_fontFamily);
		}
		String PA_Desc_colorValue = PA_Desc_xpath.getCssValue("color");
		String PA_Actual_Desc_FontColor = Color.fromString(PA_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", PA_Actual_Desc_FontColor);
	}

	@Test
	public void PayByHomeBanking() {
		// Title xpath
		WebElement PBHB_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Pay by Home')]"));

		String PBHB_Title_FontSize = PBHB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", PBHB_Title_FontSize);

		String PBHB_Actual_Title_fontFamily = PBHB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PBHB_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PBHB_Actual_Title_fontFamily);
		}
		String PBHB_Title_colorValue = PBHB_Title_xpath.getCssValue("color");
		String PBHB_Actual_Title_FontColor = Color.fromString(PBHB_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PBHB_Actual_Title_FontColor);

		// Desc xpath.
		WebElement PBHB_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'If you pay your')]"));

		String PBHB_Desc_FontSize = PBHB_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PBHB_Desc_FontSize);

		String PBHB_Desc_Actual_fontFamily = PBHB_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", PBHB_Desc_Actual_fontFamily);

		String PBHB_Desc_colorValue = PBHB_Desc_xpath.getCssValue("color");
		String PBHB_Actual_Desc_FontColor = Color.fromString(PBHB_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", PBHB_Actual_Desc_FontColor);

		// Login Button.
		WebElement PBHB_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Fiserv')]"));
		String PBHB_FontSize = PBHB_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PBHB_FontSize);

		String PBHB_fontFamily = PBHB_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", PBHB_fontFamily);

		String PBHB_colorValue = PBHB_xpath.getCssValue("color");
		String PBHB_Actual_FontColor = Color.fromString(PBHB_colorValue).asHex();
		Assert.assertEquals("#0072c6", PBHB_Actual_FontColor);
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
		System.out.println("Socal Ways To Pay Executed Sucessfully");
	}
}
