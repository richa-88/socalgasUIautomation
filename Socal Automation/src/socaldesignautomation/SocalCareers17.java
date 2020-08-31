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

public class SocalCareers17 {
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
			driver.get((String) jsonObject1.get("SocalCareers17"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalCareers17"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalCareers17"));
			break;
		}
//		driver.get("https://www.socalgas.com/careers");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void CareersDesignVerification() {
		// Title
		WebElement Careers_Title_xpath = driver.findElement(By.xpath("//h1/div[contains(text(), 'Careers')]"));
		String Careers_Title_FontSize = Careers_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", Careers_Title_FontSize);

		String Careers_Title_fontFamily = Careers_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Careers_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Careers_Title_fontFamily);
		}
		String Careers_Title_FontWeight = Careers_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", Careers_Title_FontWeight);

		String Careers_Title_colorValue = Careers_Title_xpath.getCssValue("color");
		String Careers_Title_Actual_FontColor = Color.fromString(Careers_Title_colorValue).asHex();
		Assert.assertEquals("#004693", Careers_Title_Actual_FontColor);

		// Sub Title
		WebElement Careers_Subtitle_xpath = driver.findElement(By.xpath("//p[contains(text(),'Learn about the')]"));
		String Careers_Subtitle_FontSize = Careers_Subtitle_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", Careers_Subtitle_FontSize);

		String Careers_Subtitle_fontFamily = Careers_Subtitle_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Careers_Subtitle_fontFamily);

		String Careers_Subtitle_colorValue = Careers_Subtitle_xpath.getCssValue("color");
		String Careers_Subtitle_Actual_FontColor = Color.fromString(Careers_Subtitle_colorValue).asHex();
		Assert.assertEquals("#004693", Careers_Subtitle_Actual_FontColor);
	}

	@Test
	public void CareerOpeningsDesignVerification() {
		WebElement CO_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Career Openings')]"));
		String CO_Title_FontSize = CO_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", CO_Title_FontSize);

		String CO_Title_fontFamily = CO_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", CO_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CO_Title_fontFamily);
		}
		String CO_Title_colorValue = CO_Title_xpath.getCssValue("color");
		String CO_Actual_Title_FontColor = Color.fromString(CO_Title_colorValue).asHex();
		Assert.assertEquals("#000000", CO_Actual_Title_FontColor);

		WebElement CO_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Search for all')]"));

		String CO_Desc_FontSize = CO_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", CO_Desc_FontSize);

		String CO_Desc_fontFamily = CO_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", CO_Desc_fontFamily);

		String CO_Desc_colorValue = CO_Desc_xpath.getCssValue("color");
		String CO_Desc_Actual_FontColor = Color.fromString(CO_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", CO_Desc_Actual_FontColor);

		//
		WebElement CO_LinkText_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Search Openings')]"));

		String CO_LinkText_FontSize = CO_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", CO_LinkText_FontSize);

		String CO_LinkText_fontFamily = CO_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", CO_LinkText_fontFamily);

		String CO_LinkText_colorValue = CO_LinkText_xpath.getCssValue("color");
		String CO_LinkText_Actual_FontColor = Color.fromString(CO_LinkText_colorValue).asHex();
		Assert.assertEquals("#ffffff", CO_LinkText_Actual_FontColor);
	}

	@Test
	public void OpportunitiesForStudentsAndCollegeGradsDesignVerification() {
		WebElement OFSACG_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Opportunities for')]"));
		String OFSACG_Title_FontSize = OFSACG_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", OFSACG_Title_FontSize);

		String OFSACG_Title_fontFamily = OFSACG_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", OFSACG_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, OFSACG_Title_fontFamily);
		}
		String OFSACG_Title_colorValue = OFSACG_Title_xpath.getCssValue("color");
		String OFSACG_Actual_Title_FontColor = Color.fromString(OFSACG_Title_colorValue).asHex();
		Assert.assertEquals("#000000", OFSACG_Actual_Title_FontColor);

		WebElement OFSACG_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Learn about the')]"));

		String OFSACG_Desc_FontSize = OFSACG_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", OFSACG_Desc_FontSize);

		String OFSACG_Desc_fontFamily = OFSACG_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", OFSACG_Desc_fontFamily);

		String OFSACG_Desc_colorValue = OFSACG_Desc_xpath.getCssValue("color");
		String OFSACG_Desc_Actual_FontColor = Color.fromString(OFSACG_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", OFSACG_Desc_Actual_FontColor);

		//
		WebElement OFSACG_LinkText_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[1]"));

		String OFSACG_LinkText_FontSize = OFSACG_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", OFSACG_LinkText_FontSize);

		String OFSACG_LinkText_fontFamily = OFSACG_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", OFSACG_LinkText_fontFamily);

		String OFSACG_LinkText_colorValue = OFSACG_LinkText_xpath.getCssValue("color");
		String OFSACG_LinkText_Actual_FontColor = Color.fromString(OFSACG_LinkText_colorValue).asHex();
		Assert.assertEquals("#ffffff", OFSACG_LinkText_Actual_FontColor);
	}

	@Test
	public void ParttimeCustomerServiceRepresentativeDesignVerification() {
		WebElement PTCSR_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Part-time Customer')]"));
		String PTCSR_Title_FontSize = PTCSR_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", PTCSR_Title_FontSize);

		String PTCSR_Title_fontFamily = PTCSR_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PTCSR_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PTCSR_Title_fontFamily);
		}
		String PTCSR_Title_colorValue = PTCSR_Title_xpath.getCssValue("color");
		String PTCSR_Actual_Title_FontColor = Color.fromString(PTCSR_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PTCSR_Actual_Title_FontColor);

		WebElement PTCSR_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Find out if a')]"));

		String PTCSR_Desc_FontSize = PTCSR_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PTCSR_Desc_FontSize);

		String PTCSR_Desc_fontFamily = PTCSR_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", PTCSR_Desc_fontFamily);

		String PTCSR_Desc_colorValue = PTCSR_Desc_xpath.getCssValue("color");
		String PTCSR_Desc_Actual_FontColor = Color.fromString(PTCSR_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", PTCSR_Desc_Actual_FontColor);

		//
		WebElement PTCSR_LinkText_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[2]"));

		String PTCSR_LinkText_FontSize = PTCSR_LinkText_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", PTCSR_LinkText_FontSize);

		String PTCSR_LinkText_fontFamily = PTCSR_LinkText_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", PTCSR_LinkText_fontFamily);

		String PTCSR_LinkText_colorValue = PTCSR_LinkText_xpath.getCssValue("color");
		String PTCSR_LinkText_Actual_FontColor = Color.fromString(PTCSR_LinkText_colorValue).asHex();
		Assert.assertEquals("#ffffff", PTCSR_LinkText_Actual_FontColor);
	}

	@Test
	public void EmployeeBenefitsDesignVerification() {
		// Title
		WebElement EmployeeBenefits_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(), 'Employee Benefits')]"));

		String EmployeeBenefits_Title_FontSize = EmployeeBenefits_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", EmployeeBenefits_Title_FontSize);

		String EmployeeBenefits_Title_fontFamily = EmployeeBenefits_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", EmployeeBenefits_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, EmployeeBenefits_Title_fontFamily);
		}
		String EmployeeBenefits_Title_colorValue = EmployeeBenefits_Title_xpath.getCssValue("color");
		String EmployeeBenefits_Title_Actual_FontColor = Color.fromString(EmployeeBenefits_Title_colorValue).asHex();
		Assert.assertEquals("#000000", EmployeeBenefits_Title_Actual_FontColor);

		// Desc
		WebElement EmployeeBenefits_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Learn more about')]"));

		String EmployeeBenefits_Desc_FontSize = EmployeeBenefits_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", EmployeeBenefits_Desc_FontSize);

		String EmployeeBenefits_Desc_fontFamily = EmployeeBenefits_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", EmployeeBenefits_Desc_fontFamily);

		String EmployeeBenefits_Desc_colorValue = EmployeeBenefits_Desc_xpath.getCssValue("color");
		String EmployeeBenefits_Desc_Actual_FontColor = Color.fromString(EmployeeBenefits_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", EmployeeBenefits_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[3]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void RecruitmentEventsDesignVerification() {
		// Title
		WebElement RecruitmentEvents_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(), 'Recruitment Events')]"));

		String RecruitmentEvents_Title_FontSize = RecruitmentEvents_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", RecruitmentEvents_Title_FontSize);

		String RecruitmentEvents_Title_fontFamily = RecruitmentEvents_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", RecruitmentEvents_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, RecruitmentEvents_Title_fontFamily);
		}
		String RecruitmentEvents_Title_colorValue = RecruitmentEvents_Title_xpath.getCssValue("color");
		String RecruitmentEvents_Title_Actual_FontColor = Color.fromString(RecruitmentEvents_Title_colorValue).asHex();
		Assert.assertEquals("#000000", RecruitmentEvents_Title_Actual_FontColor);

		// Desc
		WebElement RecruitmentEvents_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Search our recruitment')]"));

		String RecruitmentEvents_Desc_FontSize = RecruitmentEvents_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", RecruitmentEvents_Desc_FontSize);

		String RecruitmentEvents_Desc_fontFamily = RecruitmentEvents_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", RecruitmentEvents_Desc_fontFamily);

		String ERecruitmentEvents_Desc_colorValue = RecruitmentEvents_Desc_xpath.getCssValue("color");
		String RecruitmentEvents_Desc_Actual_FontColor = Color.fromString(ERecruitmentEvents_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", RecruitmentEvents_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Search Calendar')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void TheApplicationProcessDesignVerification() {
		// Title
		WebElement TAP_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'The Application')]"));

		String TAP_Title_FontSize = TAP_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", TAP_Title_FontSize);

		String TAP_Title_fontFamily = TAP_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", TAP_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, TAP_Title_fontFamily);
		}
		String TAP_Title_colorValue = TAP_Title_xpath.getCssValue("color");
		String TAP_Title_Actual_FontColor = Color.fromString(TAP_Title_colorValue).asHex();
		Assert.assertEquals("#000000", TAP_Title_Actual_FontColor);

		// Desc
		WebElement TAP_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Information and')]"));

		String TAP_Desc_FontSize = TAP_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", TAP_Desc_FontSize);

		String TAP_Desc_fontFamily = TAP_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", TAP_Desc_fontFamily);

		String TAP_Desc_colorValue = TAP_Desc_xpath.getCssValue("color");
		String TAP_Desc_Actual_FontColor = Color.fromString(TAP_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", TAP_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[4]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void MilitaryVeteransDesignVerification() {
		// Title
		WebElement MV_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Military Veterans')]"));

		String MV_Title_FontSize = MV_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", MV_Title_FontSize);

		String MV_Title_fontFamily = MV_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", MV_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, MV_Title_fontFamily);
		}
		String MV_Title_colorValue = MV_Title_xpath.getCssValue("color");
		String MV_Title_Actual_FontColor = Color.fromString(MV_Title_colorValue).asHex();
		Assert.assertEquals("#000000", MV_Title_Actual_FontColor);

		// Desc
		WebElement MV_Desc_xpath = driver.findElement(By.xpath("//div[contains(text(), 'Learn about our')]"));

		String MV_Desc_FontSize = MV_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", MV_Desc_FontSize);

		String MV_Desc_fontFamily = MV_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", MV_Desc_fontFamily);

		String MV_Desc_colorValue = MV_Desc_xpath.getCssValue("color");
		String MV_Desc_Actual_FontColor = Color.fromString(MV_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", MV_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Learn More')])[5]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Link_Text_Actual_FontColor);
	}

	@Test
	public void WeAreSoCalGasDesignVerification() {
		WebElement WeAreSoCalGas_Title_xpath = driver
				.findElement(By.xpath("//h2/div[contains(text(), 'We are SoCalGas')]"));

		String WeAreSoCalGas_Title_FontSize = WeAreSoCalGas_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", WeAreSoCalGas_Title_FontSize);

		String WeAreSoCalGas_Title_fontFamily = WeAreSoCalGas_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", WeAreSoCalGas_Title_fontFamily);

		String WeAreSoCalGas_Title_colorValue = WeAreSoCalGas_Title_xpath.getCssValue("color");
		String WeAreSoCalGas_Title_Actual_FontColor = Color.fromString(WeAreSoCalGas_Title_colorValue).asHex();
		Assert.assertEquals("#000000", WeAreSoCalGas_Title_Actual_FontColor);

		// Desc
		WebElement WeAreSoCalGas_Desc_xpath = driver
				.findElement(By.xpath("//div[contains(text(), 'Learn how SoCalGas')]"));

		String WeAreSoCalGas_Desc_FontSize = WeAreSoCalGas_Desc_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", WeAreSoCalGas_Desc_FontSize);

		String WeAreSoCalGas_Desc_fontFamily = WeAreSoCalGas_Desc_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", WeAreSoCalGas_Desc_fontFamily);

		String WeAreSoCalGas_Desc_colorValue = WeAreSoCalGas_Desc_xpath.getCssValue("color");
		String WeAreSoCalGas_Desc_Actual_FontColor = Color.fromString(WeAreSoCalGas_Desc_colorValue).asHex();
		Assert.assertEquals("#666666", WeAreSoCalGas_Desc_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Watch video')]"));
		String Link_Text_FontSize = Link_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Link_Text_FontSize);

		String Link_Text_fontFamily = Link_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Link_Text_fontFamily);

		String Link_Text_colorValue = Link_Text_xpath.getCssValue("color");
		String Link_Text_Actual_FontColor = Color.fromString(Link_Text_colorValue).asHex();
		Assert.assertEquals("#0072c6", Link_Text_Actual_FontColor);
	}

	@Test
	public void RelatedInformationDesignVerification() {
		WebElement RI_Title_xpath = driver.findElement(By.xpath("//h2/div[contains(text(), 'Related Information')]"));

		String RI_Title_FontSize = RI_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("18px", RI_Title_FontSize);

		String RI_Title_fontFamily = RI_Title_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", RI_Title_fontFamily);

		String RI_Title_colorValue = RI_Title_xpath.getCssValue("color");
		String RI_Title_Actual_FontColor = Color.fromString(RI_Title_colorValue).asHex();
		Assert.assertEquals("#000000", RI_Title_Actual_FontColor);

		// Link Text
		WebElement Link_Text_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Test study')]"));
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
		System.out.println("Socal Careers Executed sucessfully");
	}
}
