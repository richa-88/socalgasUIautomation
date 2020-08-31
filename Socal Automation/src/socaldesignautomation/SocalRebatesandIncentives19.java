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

public class SocalRebatesandIncentives19 {
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
			driver.get((String) jsonObject1.get("SocalRebatesandIncentives19"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalRebatesandIncentives19"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalRebatesandIncentives19"));
			break;
		}
//		driver.get("https://www.socalgas.com/save-money-and-energy/rebates-and-incentives");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void RebatesAndIncentivesDesignVerification() {
		// Title xpath of Rebates And Incentives.
		WebElement rAI_Title_xpath = driver.findElement(By.xpath("//h1/div[contains(text(),'Rebates & Incentives')]"));
		String rAI_Title_Actual_FontSize = rAI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", rAI_Title_Actual_FontSize);

		String rAI_Title_Actual_fontFamily = rAI_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", rAI_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, rAI_Title_Actual_fontFamily);
		}
		String rAI_Title_Actual_colorValue = rAI_Title_xpath.getCssValue("color");
		String rAI_Title_Actual_FontColor = Color.fromString(rAI_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#004693", rAI_Title_Actual_FontColor);

		// content xpath of Rebates And Incentives
		WebElement rAI_Content_xpath = driver.findElement(By.xpath("//p[contains(text(),'Get money back')]"));
		String rAI_Content_FontSize = rAI_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", rAI_Content_FontSize);

		String rAI_Content_Actual_fontFamily = rAI_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rAI_Content_Actual_fontFamily);

		String rAI_Content_colorValue = rAI_Content_xpath.getCssValue("color");
		String rAI_Content_Actual_FontColor = Color.fromString(rAI_Content_colorValue).asHex();
		Assert.assertEquals("#004693", rAI_Content_Actual_FontColor);
	}

	@Test
	public void AvailableRebatesDesignVerification() {
		// Title Residential Rebates
		WebElement AvailableRebates_Title_xpath = driver
				.findElement(By.xpath(".//h2/div[contains(text(),'Available Rebates')]"));
		String AvailableRebates_Title_Actual_FontSize = AvailableRebates_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", AvailableRebates_Title_Actual_FontSize);

		String AvailableRebates_Title_Actual_fontFamily = AvailableRebates_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", AvailableRebates_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, AvailableRebates_Title_Actual_fontFamily);
		}
		String AvailableRebates_Title_Actual_colorValue = AvailableRebates_Title_xpath.getCssValue("color");
		String AvailableRebates_Title_Actual_FontColor = Color.fromString(AvailableRebates_Title_Actual_colorValue)
				.asHex();
		Assert.assertEquals("#000000", AvailableRebates_Title_Actual_FontColor);

		// Content xpath of Residential Rebates.
		WebElement AvailableRebates_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(@class, 'spotlight__blurb') and contains(., 'Buying a new')]"));
		String AvailableRebates_Desc_Actual_FontSize = AvailableRebates_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", AvailableRebates_Desc_Actual_FontSize);

		String AvailableRebates_Desc_Actual_fontFamily = AvailableRebates_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", AvailableRebates_Desc_Actual_fontFamily);

		String AvailableRebates_Desc_Actual_colorValue = AvailableRebates_Desc_xpath.getCssValue("color");
		String AvailableRebates_Desc_Actual_FontColor = Color.fromString(AvailableRebates_Desc_Actual_colorValue)
				.asHex();
		Assert.assertEquals("#666666", AvailableRebates_Desc_Actual_FontColor);

		// Link Text xpath of Residential Rebates
		WebElement AvailableRebates_btn_xpath = driver
				.findElement(By.xpath("//a[@class='btn-secondary' and contains(text(),'Search Rebates')]"));

		String AvailableRebates_btn_FontSize = AvailableRebates_btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", AvailableRebates_btn_FontSize);

		String AvailableRebates_btn_Actual_fontFamily = AvailableRebates_btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", AvailableRebates_btn_Actual_fontFamily);

		String AvailableRebates_btn_Actual_colorValue = AvailableRebates_btn_xpath.getCssValue("color");
		String AvailableRebates_btn_Actual_FontColor = Color.fromString(AvailableRebates_btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", AvailableRebates_btn_Actual_FontColor);

	}

	@Test
	public void ApplyForARebateDesignVerification() {
		// Title Residential Rebates
		WebElement ApplyForARebate_Title_xpath = driver
				.findElement(By.xpath(".//h2/div[contains(text(),'Apply for a Rebate')]"));
		String ApplyForARebate_Title_Actual_FontSize = ApplyForARebate_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", ApplyForARebate_Title_Actual_FontSize);

		String ApplyForARebate_Title_Actual_fontFamily = ApplyForARebate_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", ApplyForARebate_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, ApplyForARebate_Title_Actual_fontFamily);
		}
		String ApplyForARebate_Title_Actual_colorValue = ApplyForARebate_Title_xpath.getCssValue("color");
		String ApplyForARebate_Title_Actual_FontColor = Color.fromString(ApplyForARebate_Title_Actual_colorValue)
				.asHex();
		Assert.assertEquals("#000000", ApplyForARebate_Title_Actual_FontColor);

		// Link Text.
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(),'Submit Application Online')]"));

		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_Actual_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_Actual_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void EnergyEfficiencyFinancingDesignVerification() {
		// xpath for Energy-Efficiency Financing Title
		WebElement eEF_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(),'Energy-Efficiency Financing')]"));
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
		WebElement eEF_Content_xpath = driver.findElement(By.xpath(".//div[contains(text(),'Learn about our')]"));
		String eEF_Content_FontSize = eEF_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eEF_Content_FontSize);

		String eEF_Content_Actual_fontFamily = eEF_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", eEF_Content_Actual_fontFamily);

		String eEF_Content_Actual_colorValue = eEF_Content_xpath.getCssValue("color");
		String eEF_Content_Actual_FontColor = Color.fromString(eEF_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", eEF_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement eEF_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Learn More')])[1]"));
		String eEF_Btn_FontSize = eEF_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", eEF_Btn_FontSize);

		String eEF_Btn_Actual_fontFamily = eEF_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", eEF_Btn_Actual_fontFamily);

		String eEF_Btn_Actual_colorValue = eEF_Btn_xpath.getCssValue("color");
		String eEF_Btn_Actual_FontColor = Color.fromString(eEF_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", eEF_Btn_Actual_FontColor);
	}

	@Test
	public void EnergyEfficiencyStarterKitDesignVerification() {
		// xpath for Energy-Efficiency Financing Title
		WebElement EESK_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(),'Energy-Efficiency Starter')]"));
		String EESK_Title_FontSize = EESK_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", EESK_Title_FontSize);

		String EESK_Title_Actual_fontFamily = EESK_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", EESK_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, EESK_Title_Actual_fontFamily);
		}
		String EESK_Title_Actual_colorValue = EESK_Title_xpath.getCssValue("color");
		String EESK_Title_Actual_FontColor = Color.fromString(EESK_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", EESK_Title_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Content
		WebElement EESK_Content_xpath = driver.findElement(By.xpath(".//div[contains(text(),'Start saving energy')]"));
		String EESK_Content_FontSize = EESK_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EESK_Content_FontSize);

		String EESK_Content_Actual_fontFamily = EESK_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", EESK_Content_Actual_fontFamily);

		String EESK_Content_Actual_colorValue = EESK_Content_xpath.getCssValue("color");
		String EESK_Content_Actual_FontColor = Color.fromString(EESK_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", EESK_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement EESK_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Order Today')]"));
		String EESK_Btn_FontSize = EESK_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EESK_Btn_FontSize);

		String EESK_Btn_Actual_fontFamily = EESK_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", EESK_Btn_Actual_fontFamily);

		String EESK_Btn_Actual_colorValue = EESK_Btn_xpath.getCssValue("color");
		String EESK_Btn_Actual_FontColor = Color.fromString(EESK_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", EESK_Btn_Actual_FontColor);
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
		WebElement rDIP_Content_xpath = driver.findElement(By.xpath(".//div[contains(text(),'Learn about how')]"));
		String rDIP_Content_FontSize = rDIP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rDIP_Content_FontSize);

		String rDIP_Content_Actual_fontFamily = rDIP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", rDIP_Content_Actual_fontFamily);

		String rDIP_Content_Actual_colorValue = rDIP_Content_xpath.getCssValue("color");
		String rDIP_Content_Actual_FontColor = Color.fromString(rDIP_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", rDIP_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement rDIP_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'See If You Qualify')]"));
		String rDIP_Btn_FontSize = rDIP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", rDIP_Btn_FontSize);

		String rDIP_Btn_Actual_fontFamily = rDIP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", rDIP_Btn_Actual_fontFamily);

		String rDIP_Btn_Actual_colorValue = rDIP_Btn_xpath.getCssValue("color");
		String rDIP_Btn_Actual_FontColor = Color.fromString(rDIP_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", rDIP_Btn_Actual_FontColor);
	}

	@Test
	public void ComprehensiveMobileHomeProgramDesignVerification() {
		// xpath for Energy-Efficiency Financing Title
		WebElement cMHP_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(),'Comprehensive Mobile')]"));
		String cMHP_Title_FontSize = cMHP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", cMHP_Title_FontSize);

		String cMHP_Title_Actual_fontFamily = cMHP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", cMHP_Title_Actual_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, cMHP_Title_Actual_fontFamily);
		}
		String cMHP_Title_Actual_colorValue = cMHP_Title_xpath.getCssValue("color");
		String cMHP_Title_Actual_FontColor = Color.fromString(cMHP_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", cMHP_Title_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Content
		WebElement cMHP_Content_xpath = driver.findElement(By.xpath(".//div[contains(text(),'Learn about no-cost')]"));
		String cMHP_Content_FontSize = cMHP_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cMHP_Content_FontSize);

		String cMHP_Content_Actual_fontFamily = cMHP_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cMHP_Content_Actual_fontFamily);

		String cMHP_Content_Actual_colorValue = cMHP_Content_xpath.getCssValue("color");
		String cMHP_Content_Actual_FontColor = Color.fromString(cMHP_Content_Actual_colorValue).asHex();
		Assert.assertEquals("#666666", cMHP_Content_Actual_FontColor);

		// xpath for Energy-Efficiency Financing Link Text
		WebElement cMHP_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Learn More')])[2]"));
		String cMHP_Btn_FontSize = cMHP_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cMHP_Btn_FontSize);

		String cMHP_Btn_Actual_fontFamily = cMHP_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cMHP_Btn_Actual_fontFamily);

		String cMHP_Btn_Actual_colorValue = cMHP_Btn_xpath.getCssValue("color");
		String cMHP_Btn_Actual_FontColor = Color.fromString(cMHP_Btn_Actual_colorValue).asHex();
		Assert.assertEquals("#ffffff", cMHP_Btn_Actual_FontColor);
	}

	public void CheckYourRebateStatusDesignVerification() {
		// Tittle xpath of Trade Professional Program.
		WebElement cYRS_Title_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Check Your Rebate')]"));
		String cYRS_Title_FontSize = cYRS_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", cYRS_Title_FontSize);

		String cYRS_Title_Actual_fontFamily = cYRS_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", cYRS_Title_Actual_fontFamily);

		String cYRS_Title_Actual_colorValue = cYRS_Title_xpath.getCssValue("color");
		String cYRS_Title_Actual_FontColor = Color.fromString(cYRS_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", cYRS_Title_Actual_FontColor);

		// Content xpath of Trade Professional Program.
		WebElement cYRS_Content_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Already submitted')]"));
		String cYRS_Content_FontSize = cYRS_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cYRS_Content_FontSize);

		String cYRS_Content_Actual_fontFamily = cYRS_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cYRS_Content_Actual_fontFamily);

		String cYRS_Content_colorValue = cYRS_Content_xpath.getCssValue("color");
		String cYRS_Content_Actual_FontColor = Color.fromString(cYRS_Content_colorValue).asHex();
		Assert.assertEquals("#666666", cYRS_Content_Actual_FontColor);

		// Link text xpath for Trade Professional Program.
		WebElement cYRS_Btn_xpath = driver.findElement(By.xpath("//a[contains(text(),'Check Status')]"));
		String cYRS_Btn_FontSize = cYRS_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", cYRS_Btn_FontSize);

		String cYRS_Btn_Actual_fontFamily = cYRS_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", cYRS_Btn_Actual_fontFamily);

		String cYRS_Btn_colorValue = cYRS_Btn_xpath.getCssValue("color");
		String cYRS_Btn_Actual_FontColor = Color.fromString(cYRS_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", cYRS_Btn_Actual_FontColor);
	}

	@Test
	public void MultifamilyPropertyRebatesAvailableDesignVerification() {
		// Tittle xpath of Trade Professional Program.
		WebElement mPRA_Title_xpath = driver.findElement(By.xpath("//div[contains(text(),'Multifamily Property')]"));
		String mPRA_Title_FontSize = mPRA_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", mPRA_Title_FontSize);

		String mPRA_Title_Actual_fontFamily = mPRA_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", mPRA_Title_Actual_fontFamily);

		String mPRA_Title_Actual_colorValue = mPRA_Title_xpath.getCssValue("color");
		String mPRA_Title_Actual_FontColor = Color.fromString(mPRA_Title_Actual_colorValue).asHex();
		Assert.assertEquals("#000000", mPRA_Title_Actual_FontColor);

		// Content xpath of Trade Professional Program.
		WebElement mPRA_Content_xpath = driver.findElement(By.xpath("//div[contains(text(),'SoCalGas offers')]"));
		String mPRA_Content_FontSize = mPRA_Content_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", mPRA_Content_FontSize);

		String mPRA_Content_Actual_fontFamily = mPRA_Content_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", mPRA_Content_Actual_fontFamily);

		String mPRA_Content_colorValue = mPRA_Content_xpath.getCssValue("color");
		String mPRA_Content_Actual_FontColor = Color.fromString(mPRA_Content_colorValue).asHex();
		Assert.assertEquals("#666666", mPRA_Content_Actual_FontColor);

		// Link text xpath for Trade Professional Program.
		WebElement mPRA_Btn_xpath = driver.findElement(By.xpath("(//a[contains(text(),'Learn More')])[3]"));
		String mPRA_Btn_FontSize = mPRA_Btn_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", mPRA_Btn_FontSize);

		String mPRA_Btn_Actual_fontFamily = mPRA_Btn_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", mPRA_Btn_Actual_fontFamily);

		String mPRA_Btn_colorValue = mPRA_Btn_xpath.getCssValue("color");
		String mPRA_Btn_Actual_FontColor = Color.fromString(mPRA_Btn_colorValue).asHex();
		Assert.assertEquals("#0072c6", mPRA_Btn_Actual_FontColor);
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
		System.out.println("Socal Tradepro Executed sucessfully");
	}
}
