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
import org.openqa.selenium.JavascriptExecutor;
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

public class SocalMyAccount08 {
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
			driver.get((String) jsonObject1.get("SocalMyAccount08"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalMyAccount08"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalMyAccount08"));
			break;
		}
//		driver.get("https://www.socalgas.com/pay-bill/my-account");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void BenefitsOfMyAccount() {
		WebElement BOMA_Title_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--title') and text() = 'Benefits of My Account']"));
//		System.out.println(BOMA_Title_xpath);
		String BOMA_FontSize = BOMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", BOMA_FontSize);

		String BOMA_xpath_Actual_fontFamily = BOMA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BOMA_xpath_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BOMA_xpath_Actual_fontFamily);
		}
		String BOMA_Title_colorValue = BOMA_Title_xpath.getCssValue("color");
		String BOMA_Actual_Title_FontColor = Color.fromString(BOMA_Title_colorValue).asHex();
		Assert.assertEquals("#004693", BOMA_Actual_Title_FontColor);

		// Description.
		WebElement BOMA_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Learn about the')]"));
		String BOMA_Desc_FontSize = BOMA_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", BOMA_Desc_FontSize);

		String BOMA_Desc_fontFamily = BOMA_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", BOMA_Desc_fontFamily);

		String BOMA_Desc_colorValue = BOMA_Desc_xpath.getCssValue("color");
		String BOMA_Desc_Actual_FontColor = Color.fromString(BOMA_Desc_colorValue).asHex();
		Assert.assertEquals("#004693", BOMA_Desc_Actual_FontColor);
	}

	@Test
	public void RegisterForMyAccount() {
		// Title xpath
		WebElement RFMA_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Register for My Account')]"));

		String RFMA_Title_FontSize = RFMA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", RFMA_Title_FontSize);

		String RFMA_Actual_fontFamily = RFMA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", RFMA_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, RFMA_Actual_fontFamily);
		}
		String RFMA_Title_colorValue = RFMA_Title_xpath.getCssValue("color");
		String RFMA_Actual_Title_FontColor = Color.fromString(RFMA_Title_colorValue).asHex();
		Assert.assertEquals("#ffffff", RFMA_Actual_Title_FontColor);

		// sub Title xpath.
		WebElement RFMA_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Not a My Account')]"));

		String RFMA_Desc_FontSize = RFMA_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", RFMA_Desc_FontSize);

		String RFMA_Actual_Desc_fontFamily = RFMA_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", RFMA_Actual_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, RFMA_Actual_Desc_fontFamily);
		}
		String RFMA_Desc_colorValue = RFMA_Desc_xpath.getCssValue("color");
		String RFMA_Actual_Desc_FontColor = Color.fromString(RFMA_Desc_colorValue).asHex();
		Assert.assertEquals("#ffffff", RFMA_Actual_Desc_FontColor);

		// Login Button.
		WebElement Register_Now_Text_xpath = driver.findElement(By.xpath("//a[@class='feature--item--button']"));
		String Register_Now_Text_FontSize = Register_Now_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Register_Now_Text_FontSize);

		String Register_Now_Text_fontFamily = Register_Now_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Register_Now_Text_fontFamily);

		String Register_Now_Text_colorValue = Register_Now_Text_xpath.getCssValue("color");
		String Register_Now_Text_Actual_FontColor = Color.fromString(Register_Now_Text_colorValue).asHex();
		Assert.assertEquals("#000000", Register_Now_Text_Actual_FontColor);
	}

	@Test
	public void LogInToMyAccountt() {
		// Title xpath
		WebElement login_My_Acc_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Log In')]"));

		String login_My_Acc_Title_FontSize = login_My_Acc_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", login_My_Acc_Title_FontSize);

		String login_My_Acc_Actual_fontFamily = login_My_Acc_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", login_My_Acc_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, login_My_Acc_Actual_fontFamily);
		}
		String login_My_Acc_Title_colorValue = login_My_Acc_Title_xpath.getCssValue("color");
		String login_My_Acc_Actual_Title_FontColor = Color.fromString(login_My_Acc_Title_colorValue).asHex();
		Assert.assertEquals("#000000", login_My_Acc_Actual_Title_FontColor);

		// sub Title xpath.
		WebElement login_My_Acc_Desc_xpath = driver.findElement(By.xpath("//p[contains(text(),'Log in today to')]"));

		String login_My_Acc_Desc_FontSize = login_My_Acc_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", login_My_Acc_Desc_FontSize);

		String login_My_Acc_Actual_Desc_fontFamily = login_My_Acc_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", login_My_Acc_Actual_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, login_My_Acc_Actual_Desc_fontFamily);
		}
		String login_My_Acc_Desc_colorValue = login_My_Acc_Desc_xpath.getCssValue("color");
		String login_My_Acc_Actual_Desc_FontColor = Color.fromString(login_My_Acc_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", login_My_Acc_Actual_Desc_FontColor);

		// Login Button.
		WebElement Login_Button_Text_xpath = driver
				.findElement(By.xpath("//a[@class='featured-item__link feature--item--button ']"));
		String Login_Button_Text_FontSize = Login_Button_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Login_Button_Text_FontSize);

		String Login_Button_Text_fontFamily = Login_Button_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Login_Button_Text_fontFamily);

		String Login_Button_Text_colorValue = Login_Button_Text_xpath.getCssValue("color");
		String Login_Button_Text_Actual_FontColor = Color.fromString(Login_Button_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Login_Button_Text_Actual_FontColor);
	}

	@Test
	public void RegisterForMyAccount_01() {
		// Title xpath
		WebElement RFMA_01_Title_xpath = driver
				.findElement(By.xpath("//h2[contains(text(),'Register for My Account')]"));

		String RFMA_01_Title_FontSize = RFMA_01_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", RFMA_01_Title_FontSize);

		String RFMA_01_Actual_fontFamily = RFMA_01_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", RFMA_01_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, RFMA_01_Actual_fontFamily);
		}
		String RFMA_01_Title_colorValue = RFMA_01_Title_xpath.getCssValue("color");
		String RFMA_01_Actual_Title_FontColor = Color.fromString(RFMA_01_Title_colorValue).asHex();
		Assert.assertEquals("#000000", RFMA_01_Actual_Title_FontColor);

		// sub Title xpath.
		WebElement RFMA_01_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(),'My Account is')]"));

		String RFMA_01_Desc_FontSize = RFMA_01_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", RFMA_01_Desc_FontSize);

		String RFMA_01_Actual_Desc_fontFamily = RFMA_01_Desc_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", RFMA_01_Actual_Desc_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, RFMA_01_Actual_Desc_fontFamily);
		}
		String RFMA_01_Desc_colorValue = RFMA_01_Desc_xpath.getCssValue("color");
		String RFMA_01_Actual_Desc_FontColor = Color.fromString(RFMA_01_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", RFMA_01_Actual_Desc_FontColor);
	}

	@Test
	public void BillManagementDesignVerification() {
		// Title xpath
		WebElement BM_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Bill Management')]"));

		String BM_Title_FontSize = BM_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", BM_Title_FontSize);

		String BM_fontFamily = BM_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", BM_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, BM_fontFamily);
		}
		String BM_Title_xpath_Title_colorValue = BM_Title_xpath.getCssValue("color");
		String BM_Title_xpath_Actual_Title_FontColor = Color.fromString(BM_Title_xpath_Title_colorValue).asHex();
		Assert.assertEquals("#000000", BM_Title_xpath_Actual_Title_FontColor);

		// sub Title xpath.
		WebElement BM_DESC_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Through')]"));

		String BM_DESC_FontSize = BM_DESC_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", BM_DESC_FontSize);

		String BM_DESC_Actual_fontFamily = BM_DESC_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", BM_DESC_Actual_fontFamily);

		String BM_DESC_colorValue = BM_DESC_xpath.getCssValue("color");
		String BM_DESC_Actual_FontColor = Color.fromString(BM_DESC_colorValue).asHex();
		Assert.assertEquals("#666666", BM_DESC_Actual_FontColor);

		// Login Button.
		WebElement BM_Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Paperless')]"));
		String Login_Button_Text_FontSize = BM_Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Login_Button_Text_FontSize);

		String BM_Link_Text_fontFamily = BM_Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", BM_Link_Text_fontFamily);

		String BM_Link_Text_colorValue = BM_Link_Text_xpath.getCssValue("color");
		String BM_Link_Text_Actual_FontColor = Color.fromString(BM_Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", BM_Link_Text_Actual_FontColor);
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
		System.out.println("Socal My Account Class sucessfully");
	}
}
