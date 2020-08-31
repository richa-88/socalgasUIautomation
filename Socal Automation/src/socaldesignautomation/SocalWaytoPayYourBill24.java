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

public class SocalWaytoPayYourBill24 {
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
			driver.get((String) jsonObject1.get("SocalWaytoPayYourBill24"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalWaytoPayYourBill24"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalWaytoPayYourBill24"));
			break;
		}
//		driver.get("https://www.socalgas.com/help-center/way-to-pay-your-bill");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void WaysToPayYourBillDesignVerification() {
		WebElement WTPYB_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(text(), 'Ways to Pay Your Bill')]"));
		String WTPYB_Title_FontSize = WTPYB_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", WTPYB_Title_FontSize);

		String WTPYB_Title_fontFamily = WTPYB_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", WTPYB_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, WTPYB_Title_fontFamily);
		}
		String WTPYB_Title_FontWeight = WTPYB_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", WTPYB_Title_FontWeight);

		String WTPYB_Title_colorValue = WTPYB_Title_xpath.getCssValue("color");
		String WTPYB_Title_Actual_FontColor = Color.fromString(WTPYB_Title_colorValue).asHex();
		Assert.assertEquals("#004693", WTPYB_Title_Actual_FontColor);

		WebElement ScamAlert_xpath = driver.findElement(By.xpath("//em[contains(text(), 'Please note that')]"));
		String ScamAlert_Text_FontSize = ScamAlert_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", ScamAlert_Text_FontSize);

		String ScamAlert_Text_fontFamily = ScamAlert_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", ScamAlert_Text_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ScamAlert_Text_fontFamily);
		}
		String ScamAlert_Text_colorValue = ScamAlert_xpath.getCssValue("color");
		String ScamAlert_Text_Actual_FontColor = Color.fromString(ScamAlert_Text_colorValue).asHex();
		Assert.assertEquals("#666666", ScamAlert_Text_Actual_FontColor);
	}

	@Test
	public void MyAccountDesignVerification() {
		WebElement MyAcc_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'My Account')]"));
		String MyAcc_Title_FontSize = MyAcc_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", MyAcc_Title_FontSize);

		String MyAcc_Title_fontFamily = MyAcc_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", MyAcc_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MyAcc_Title_fontFamily);
		}
		String MyAcc_Title_colorValue = MyAcc_Title_xpath.getCssValue("color");
		String MyAcc_Title_Actual_FontColor = Color.fromString(MyAcc_Title_colorValue).asHex();
		Assert.assertEquals("#000000", MyAcc_Title_Actual_FontColor);

		WebElement MyAcc_Desc_xpath = driver.findElement(By.xpath("(//p[contains(text(), 'You can make')])[1]"));
		String MyAcc_Desc_FontSize = MyAcc_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", MyAcc_Desc_FontSize);

		String MyAcc_Desc_fontFamily = MyAcc_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", MyAcc_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MyAcc_Desc_fontFamily);
		}
		String MyAcc_Desc_colorValue = MyAcc_Desc_xpath.getCssValue("color");
		String MyAcc_Desc_Actual_FontColor = Color.fromString(MyAcc_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", MyAcc_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'logging in')])[1]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void BusinessMyAccountDesignVerification() {
		WebElement BMA_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Business My Account')]"));
		String BMA_Title_FontSize = BMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", BMA_Title_FontSize);

		String BMA_Title_fontFamily = BMA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BMA_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BMA_Title_fontFamily);
		}
		String BMA_Title_colorValue = BMA_Title_xpath.getCssValue("color");
		String BMA_Title_Actual_FontColor = Color.fromString(BMA_Title_colorValue).asHex();
		Assert.assertEquals("#000000", BMA_Title_Actual_FontColor);

		WebElement BMA_Desc_xpath = driver.findElement(By.xpath("(//p[contains(text(), 'You can make')])[2]"));
		String BMA_Desc_FontSize = BMA_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BMA_Desc_FontSize);

		String MyAcc_Desc_fontFamily = BMA_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", MyAcc_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MyAcc_Desc_fontFamily);
		}
		String BMA_Desc_colorValue = BMA_Desc_xpath.getCssValue("color");
		String BMA_Desc_Actual_FontColor = Color.fromString(BMA_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", BMA_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver
				.findElement(By.xpath("//a[contains(text(), 'Register for Business My Account')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void BillMatrixDesignVerification() {
		WebElement BillMatrix_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'BillMatrix')]"));
		String BillMatrix_Title_FontSize = BillMatrix_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", BillMatrix_Title_FontSize);

		String BillMatrix_Title_fontFamily = BillMatrix_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BillMatrix_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BillMatrix_Title_fontFamily);
		}
		String BillMatrix_Title_colorValue = BillMatrix_Title_xpath.getCssValue("color");
		String BillMatrix_Title_Actual_FontColor = Color.fromString(BillMatrix_Title_colorValue).asHex();
		Assert.assertEquals("#000000", BillMatrix_Title_Actual_FontColor);

		WebElement BillMatrix_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'If you choose')]"));
		String BillMatrix_Desc_FontSize = BillMatrix_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BillMatrix_Desc_FontSize);

		String BillMatrix_Desc_fontFamily = BillMatrix_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", BillMatrix_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BillMatrix_Desc_fontFamily);
		}
		String BillMatrix_Desc_colorValue = BillMatrix_Desc_xpath.getCssValue("color");
		String BillMatrix_Desc_Actual_FontColor = Color.fromString(BillMatrix_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", BillMatrix_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'BillMatrix Online')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);

		// Table date

		WebElement ElectronicChecks_Text_xpath = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/strong"));
		String ElectronicChecks_FontSize = ElectronicChecks_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", ElectronicChecks_FontSize);

		String ElectronicChecks_fontFamily = ElectronicChecks_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ElectronicChecks_fontFamily);

		String ElectronicChecks_colorValue = ElectronicChecks_Text_xpath.getCssValue("color");
		String ElectronicChecks_Actual_FontColor = Color.fromString(ElectronicChecks_colorValue).asHex();
		Assert.assertEquals("#666666", ElectronicChecks_Actual_FontColor);
	}

	@Test
	public void PayByPhoneDesignVerificaation() {
		WebElement PBP_Title_xpath = driver.findElement(By.xpath("//h3[contains(text(), 'Pay by Phone')]"));
		String PBP_Title_FontSize = PBP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("20px", PBP_Title_FontSize);

		String PBP_Title_fontFamily = PBP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PBP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PBP_Title_fontFamily);
		}
		String PBP_Title_colorValue = PBP_Title_xpath.getCssValue("color");
		String PBP_Title_Actual_FontColor = Color.fromString(PBP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PBP_Title_Actual_FontColor);

		//
		WebElement PBP_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(), 'SoCalGas offers')]"));
		String PBP_Desc_FontSize = PBP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PBP_Desc_FontSize);

		String PBP_Desc_fontFamily = PBP_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", PBP_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PBP_Desc_fontFamily);
		}
		String PBP_Desc_colorValue = PBP_Desc_xpath.getCssValue("color");
		String PBP_Desc_Actual_FontColor = Color.fromString(PBP_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", PBP_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'BillMatrix Online')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void EndParaDesignVerification() {
		WebElement Byclickingthis_text_xpath = driver
				.findElement(By.xpath("//em[contains(text(), '* By clicking this')]"));
		String Byclickingthis_text_FontSize = Byclickingthis_text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Byclickingthis_text_FontSize);

		String Byclickingthis_text_fontFamily = Byclickingthis_text_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", Byclickingthis_text_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Byclickingthis_text_fontFamily);
		}
		String Byclickingthis_text_colorValue = Byclickingthis_text_xpath.getCssValue("color");
		String Byclickingthis_text_Actual_FontColor = Color.fromString(Byclickingthis_text_colorValue).asHex();
		Assert.assertEquals("#666666", Byclickingthis_text_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Privacy Policy')]"));
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
		System.out.println("Socal Payment Location Class Executed sucessfully");
	}
}
