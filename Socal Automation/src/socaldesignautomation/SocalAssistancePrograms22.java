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

public class SocalAssistancePrograms22 {
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
			driver.get((String) jsonObject1.get("SocalAssistancePrograms22"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalAssistancePrograms22"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalAssistancePrograms22"));
			break;
		}
//		driver.get("https://www.socalgas.com/save-money-and-energy/assistance-programs");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void AssistanceProgramsDesignVerification() {
		// Title xpath of Small And Medium Business.
		WebElement AP_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Assistance Programs')]"));
		String AP_Actual_Title_FontSize = AP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", AP_Actual_Title_FontSize);

		String AP_Actual_Title_fontFamily = AP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", AP_Actual_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, AP_Actual_Title_fontFamily);
		}
		String AP_Title_colorValue = AP_Title_xpath.getCssValue("color");
		String AP_Actual_Title_FontColor = Color.fromString(AP_Title_colorValue).asHex();
		Assert.assertEquals("#004693", AP_Actual_Title_FontColor);

		// Content xpath of Small And Medium Business.
		WebElement AP_Text_xpath = driver.findElement(By.xpath("//div[@class='page-banner__text']/p"));
		String AP_Actual_Text_FontSize = AP_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", AP_Actual_Text_FontSize);

		String AP_Actual_Text_fontFamily = AP_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", AP_Actual_Text_fontFamily);

		String AP_Text_colorValue = AP_Text_xpath.getCssValue("color");
		String AP_Actual_Text_FontColor = Color.fromString(AP_Text_colorValue).asHex();
		Assert.assertEquals("#004693", AP_Actual_Text_FontColor);
	}

	@Test
	public void CaliforniaAlternateRatesForEnergyDesignVerification() {
		// Title xpath of Rebates And Incentives.
		WebElement cARFE_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(),'California Alternate')]"));
		String cARFE_Title_Actual_FontSize = cARFE_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", cARFE_Title_Actual_FontSize);

		String cARFE_Title_Actual_fontFamily = cARFE_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", cARFE_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, cARFE_Title_Actual_fontFamily);
		}
		String cARFE_Title_Actual_colorValue = cARFE_Title_xpath.getCssValue("color");
		String cARFE_Title_Actual_FontColor = Color.fromString(cARFE_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", cARFE_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement cARFE_Content_xpath = driver.findElement(
				By.xpath("//div[contains(@class, 'field--text') and contains(., 'Receive a 20 percent')]"));
		String cARFE_Content_FontSize = cARFE_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cARFE_Content_FontSize);

		String cARFE_Content_Actual_fontFamily = cARFE_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cARFE_Content_Actual_fontFamily);

		String cARFE_Content_colorValue = cARFE_Content_xpath.getCssValue("color");
		String cARFE_Content_Actual_FontColor = Color.fromString(cARFE_Content_colorValue).asHex();
		Assert.assertEquals("#666666", cARFE_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement cARFE_Btn_xpath = driver
				.findElement(By.xpath("(//a[@class='btn-secondary' and contains(text(),'Apply Today')])[1]"));
		String cARFE_Btn_FontSize = cARFE_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cARFE_Btn_FontSize);

		String cARFE_Btn_Actual_fontFamily = cARFE_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cARFE_Btn_Actual_fontFamily);

		String cARFE_Btn_colorValue = cARFE_Btn_xpath.getCssValue("color");
		String cARFE_Btn_Actual_FontColor = Color.fromString(cARFE_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", cARFE_Btn_Actual_FontColor);

	}

	@Test
	public void ResidentialDirectInstallProgramDesignVerification() {
		// xpath for Energy-Efficiency Financing Title
		WebElement rDIP_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Residential Direct')]"));
		String rDIP_Title_FontSize = rDIP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", rDIP_Title_FontSize);

		String rDIP_Title_Actual_fontFamily = rDIP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rDIP_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rDIP_Title_Actual_fontFamily);
		}
		String rDIP_Title_Actual_colorValue = rDIP_Title_xpath.getCssValue("color");
		String rDIP_Title_Actual_FontColor = Color.fromString(rDIP_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", rDIP_Title_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Content
		WebElement rDIP_Content_xpath = driver.findElement(By.xpath(".//p[contains(text(),'Learn about how')]"));
		String rDIP_Content_FontSize = rDIP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rDIP_Content_FontSize);

		String rDIP_Content_Actual_fontFamily = rDIP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rDIP_Content_Actual_fontFamily);

		String rDIP_Content_Actual_colorValue = rDIP_Content_xpath.getCssValue("color");
		String rDIP_Content_Actual_FontColor = Color.fromString(rDIP_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", rDIP_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement rDIP_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Get Started')]"));
		String rDIP_Btn_FontSize = rDIP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rDIP_Btn_FontSize);

		String rDIP_Btn_Actual_fontFamily = rDIP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rDIP_Btn_Actual_fontFamily);

		String rDIP_Btn_Actual_colorValue = rDIP_Btn_xpath.getCssValue("color");
		String rDIP_Btn_Actual_FontColor = Color.fromString(rDIP_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rDIP_Btn_Actual_FontColor);
	}

	@Test
	public void LowIncomeHomeEnergyAssistanceDesignVerification() {
		// Title xpath of Rebates And Incentives.
		WebElement LIHEA_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Low Income Home')]"));
		String LIHEA_Title_Actual_FontSize = LIHEA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", LIHEA_Title_Actual_FontSize);

		String LIHEA_Title_Actual_fontFamily = LIHEA_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", LIHEA_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, LIHEA_Title_Actual_fontFamily);
		}
		String LIHEA_Title_Actual_colorValue = LIHEA_Title_xpath.getCssValue("color");
		String LIHEA_Title_Actual_FontColor = Color.fromString(LIHEA_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", LIHEA_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement LIHEA_Content_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'field--text') and contains(., 'Take advantage of')]"));
		String LIHEA_Content_FontSize = LIHEA_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", LIHEA_Content_FontSize);

		String LIHEA_Content_Actual_fontFamily = LIHEA_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", LIHEA_Content_Actual_fontFamily);

		String LIHEA_Content_colorValue = LIHEA_Content_xpath.getCssValue("color");
		String LIHEA_Content_Actual_FontColor = Color.fromString(LIHEA_Content_colorValue).asHex();
		Assert.assertEquals("#666666", LIHEA_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement LIHEA_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Learn More')]"));
		String LIHEA_Btn_FontSize = LIHEA_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", LIHEA_Btn_FontSize);

		String LIHEA_Btn_Actual_fontFamily = LIHEA_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", LIHEA_Btn_Actual_fontFamily);

		String LIHEA_Btn_colorValue = LIHEA_Btn_xpath.getCssValue("color");
		String LIHEA_Btn_Actual_FontColor = Color.fromString(LIHEA_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", LIHEA_Btn_Actual_FontColor);

	}

	@Test
	public void GasAssistanceFundDesignVerification() {
		// Title xpath of Rebates And Incentives.
		WebElement GAF_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Gas Assistance Fund')]"));
		String GAF_Title_Actual_FontSize = GAF_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", GAF_Title_Actual_FontSize);

		String GAF_Title_Actual_fontFamily = GAF_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", GAF_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, GAF_Title_Actual_fontFamily);
		}
		String GAF_Title_Actual_colorValue = GAF_Title_xpath.getCssValue("color");
		String GAF_Title_Actual_FontColor = Color.fromString(GAF_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", GAF_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement GAF_Content_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Receive a one-time')]"));
		String GAF_Content_FontSize = GAF_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", GAF_Content_FontSize);

		String GAF_Content_Actual_fontFamily = GAF_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", GAF_Content_Actual_fontFamily);

		String GAF_Content_colorValue = GAF_Content_xpath.getCssValue("color");
		String GAF_Content_Actual_FontColor = Color.fromString(GAF_Content_colorValue).asHex();
		Assert.assertEquals("#666666", GAF_Content_Actual_FontColor);

		// Link text xpath Rebates And Incentives.
		WebElement GAF_Btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Get Help')]"));
		String GAF_Btn_FontSize = GAF_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", GAF_Btn_FontSize);

		String GAF_Btn_Actual_fontFamily = GAF_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", GAF_Btn_Actual_fontFamily);

		String GAF_Btn_colorValue = GAF_Btn_xpath.getCssValue("color");
		String GAF_Btn_Actual_FontColor = Color.fromString(GAF_Btn_colorValue).asHex();
		Assert.assertEquals("#ffffff", GAF_Btn_Actual_FontColor);

	}

	@Test
	public void EndParagraphDesignVerification() {
		WebElement End_Para_Text_xpath = driver
				.findElement(By.xpath("//p[contains(text(), 'These programs are funded')]"));
		String End_Para_Text_FontSize = End_Para_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("12px", End_Para_Text_FontSize);

		String End_Para_Text_Actual_fontFamily = End_Para_Text_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", End_Para_Text_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, End_Para_Text_Actual_fontFamily);
		}
		String End_Para_Text_colorValue = End_Para_Text_xpath.getCssValue("color");
		String End_Para_Text_Actual_FontColor = Color.fromString(End_Para_Text_colorValue).asHex();
		Assert.assertEquals("#666666", End_Para_Text_Actual_FontColor);
	}

	@Test
	public void OtherlanguagesDesignVerification() {
		WebElement Otherlanguages_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(), 'Other languages')]"));
		String Otherlanguages_Title_FontSize = Otherlanguages_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", Otherlanguages_Title_FontSize);

		String Otherlanguages_Title_Actual_fontFamily = Otherlanguages_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Otherlanguages_Title_Actual_fontFamily);

		String Otherlanguages_Title_colorValue = Otherlanguages_Title_xpath.getCssValue("color");
		String Otherlanguages_Title_Actual_FontColor = Color.fromString(Otherlanguages_Title_colorValue).asHex();
		Assert.assertEquals("#000000", Otherlanguages_Title_Actual_FontColor);

		// Links
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), '¡Asistencia con')] "));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_Actual_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_Actual_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void UsefulLinksDesignVerification() {
		WebElement UsefulLinks_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Useful Links')]"));
		String UsefulLinks_Title_FontSize = UsefulLinks_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", UsefulLinks_Title_FontSize);

		String UsefulLinks_Title_Actual_fontFamily = UsefulLinks_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", UsefulLinks_Title_Actual_fontFamily);

		String UsefulLinks_Title_colorValue = UsefulLinks_Title_xpath.getCssValue("color");
		String UsefulLinks_Title_Actual_FontColor = Color.fromString(UsefulLinks_Title_colorValue).asHex();
		Assert.assertEquals("#000000", UsefulLinks_Title_Actual_FontColor);

		// Links
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Extend Payment')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_Actual_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_Actual_fontFamily);

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
		System.out.println("Business Rebates Class Executed sucessfully");
	}
}
