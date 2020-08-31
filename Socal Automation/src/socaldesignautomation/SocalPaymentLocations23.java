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

public class SocalPaymentLocations23 {
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
			driver.get((String) jsonObject1.get("SocalPaymentLocations23"));
			break;
		case "staging":
			Object obj2 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\stageUrl.json"));
			JSONObject jsonObject2 = (JSONObject) obj2;
			driver.get((String) jsonObject2.get("SocalPaymentLocations23"));
			break;
		case "socalgasmigration":
			Object obj3 = parser
					.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\Socal Automation\\migration.json"));
			JSONObject jsonObject3 = (JSONObject) obj3;
			driver.get((String) jsonObject3.get("SocalPaymentLocations23"));
			break;
		}
//		driver.get("https://www.socalgas.com/pay-bill/ways-to-pay/payment-locations");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void PaymentLocationsDesignVerification() {
		WebElement Payment_Lo_Title_xpath = driver
				.findElement(By.xpath("//h1/div[contains(text(), 'Payment Locations')]"));
		String Payment_Lo_Title_FontSize = Payment_Lo_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("30px", Payment_Lo_Title_FontSize);

		String Payment_Lo_Title_fontFamily = Payment_Lo_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", Payment_Lo_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Payment_Lo_Title_fontFamily);
		}
		String Payment_Lo_Title_FontWeight = Payment_Lo_Title_xpath.getCssValue("font-weight");
		Assert.assertEquals("700", Payment_Lo_Title_FontWeight);

		String Payment_Lo_Title_colorValue = Payment_Lo_Title_xpath.getCssValue("color");
		String Payment_Lo_Title_Actual_FontColor = Color.fromString(Payment_Lo_Title_colorValue).asHex();
		Assert.assertEquals("#004693", Payment_Lo_Title_Actual_FontColor);

		// Desc
		WebElement IfYouWish_Para_xpath = driver.findElement(By.xpath("//div[contains(text(), 'If you wish' )]"));

		String IfYouWish_Para_FontSize = IfYouWish_Para_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", IfYouWish_Para_FontSize);

		String IfYouWish_Para_fontFamily = IfYouWish_Para_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", IfYouWish_Para_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, IfYouWish_Para_fontFamily);
		}
		String IfYouWish_Para_colorValue = IfYouWish_Para_xpath.getCssValue("color");
		String IfYouWish_Para_Actual_FontColor = Color.fromString(IfYouWish_Para_colorValue).asHex();
		Assert.assertEquals("#666666", IfYouWish_Para_Actual_FontColor);
	}

	@Test
	public void EnterAnAddressDesignVerification() {
		WebElement EnterAddr_Title_xpath = driver.findElement(By.xpath("//div[@class= 'maps-header-text cng-header']"));
		String EnterAddr_Title_FontSize = EnterAddr_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", EnterAddr_Title_FontSize);

		String EnterAddr_Title_fontFamily = EnterAddr_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", EnterAddr_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, EnterAddr_Title_fontFamily);
		}
		String EnterAddr_Title_colorValue = EnterAddr_Title_xpath.getCssValue("color");
		String EnterAddr_Title_Actual_FontColor = Color.fromString(EnterAddr_Title_colorValue).asHex();
		Assert.assertEquals("#000000", EnterAddr_Title_Actual_FontColor);

		//
		WebElement Example_Title_xpath = driver.findElement(By.xpath("//*[@id=\"socalmaps-search\"]/label"));
		String Example_Title_FontSize = Example_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Example_Title_FontSize);

		String Example_Title_fontFamily = Example_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", Example_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, Example_Title_fontFamily);
		}
		String Example_Title_colorValue = Example_Title_xpath.getCssValue("color");
		String Example_Title_Actual_FontColor = Color.fromString(Example_Title_colorValue).asHex();
		Assert.assertEquals("#000000", Example_Title_Actual_FontColor);

		//
		WebElement Submit_Text_xpath = driver.findElement(By.xpath("//input[@id = 'socalmaps-submit']"));
		String Submit_Text_FontSize = Submit_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Submit_Text_FontSize);

		String Submit_Text_fontFamily = Submit_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", Submit_Text_fontFamily);

		String Submit_Text_colorValue = Submit_Text_xpath.getCssValue("color");
		String Submit_Text_Actual_FontColor = Color.fromString(Submit_Text_colorValue).asHex();
		Assert.assertEquals("#ffffff", Submit_Text_Actual_FontColor);

		// Click to use current location
		WebElement CurrentLoc_Link_xpath = driver.findElement(By.xpath("//a[@class='current-location']"));
		String CurrentLoc_Link_FontSize = CurrentLoc_Link_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", CurrentLoc_Link_FontSize);

		String CurrentLoc_Link_fontFamily = CurrentLoc_Link_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", CurrentLoc_Link_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, CurrentLoc_Link_fontFamily);
		}
		String CurrentLoc_Link_colorValue = CurrentLoc_Link_xpath.getCssValue("color");
		String CurrentLoc_Link_Actual_FontColor = Color.fromString(CurrentLoc_Link_colorValue).asHex();
		Assert.assertEquals("#0072c6", CurrentLoc_Link_Actual_FontColor);
	}

	@Test
	public void LocationFilterDesignVerification() {
		//
		WebElement LocationFilter_xpath = driver.findElement(By.xpath("//span[contains(text(), 'Location Filter')]"));
		String LocationFilter_FontSize = LocationFilter_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", LocationFilter_FontSize);

		String LocationFilter_fontFamily = LocationFilter_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", LocationFilter_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, LocationFilter_fontFamily);
		}
		String LocationFilter_colorValue = LocationFilter_xpath.getCssValue("color");
		String LocationFilter_Actual_FontColor = Color.fromString(LocationFilter_colorValue).asHex();
		Assert.assertEquals("#000000", LocationFilter_Actual_FontColor);

		//
		WebElement Option_Text_xpath = driver.findElement(By.xpath("(//*[@class='option'])[1]"));
		String Option_Text_FontSize = Option_Text_xpath.getCssValue("font-size");
		Assert.assertEquals("16px", Option_Text_FontSize);

		String Option_Text_fontFamily = Option_Text_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", Option_Text_fontFamily);

		String Option_Text_colorValue = Option_Text_xpath.getCssValue("color");
		String Option_Text_Actual_FontColor = Color.fromString(Option_Text_colorValue).asHex();
		Assert.assertEquals("#666666", Option_Text_Actual_FontColor);
	}

	@Test
	public void ListedAddresDesignVerification() {
		//
		WebElement SuperiorGrocer_xpath = driver
				.findElement(By.xpath("(//span[contains(text(), 'Superior Grocers')])[1]"));
		String SuperiorGrocer_FontSize = SuperiorGrocer_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", SuperiorGrocer_FontSize);

		String SuperiorGrocer_fontFamily = SuperiorGrocer_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", SuperiorGrocer_fontFamily);

		String SuperiorGrocer_colorValue = SuperiorGrocer_xpath.getCssValue("color");
		String SuperiorGrocer_Actual_FontColor = Color.fromString(SuperiorGrocer_colorValue).asHex();
		Assert.assertEquals("#000000", SuperiorGrocer_Actual_FontColor);

		//
		WebElement address_xpath = driver.findElement(By.xpath("(//div[contains(text(), '7316 South Compton')])[1]"));
		String address_FontSize = address_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", address_FontSize);

		String address_fontFamily = address_xpath.getCssValue("font-family");
//		Assert.assertEquals("Arial, Helvetica, sans-serif", address_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, address_fontFamily);
		}
		String address_colorValue = address_xpath.getCssValue("color");
		String address_Actual_FontColor = Color.fromString(address_colorValue).asHex();
		Assert.assertEquals("#666666", address_Actual_FontColor);

		//
		WebElement GetDirections_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'Get Directions')])[2]"));
		String GetDirections_FontSize = GetDirections_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", GetDirections_FontSize);

		String GetDirections_fontFamily = GetDirections_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", GetDirections_fontFamily);

		String GetDirections_colorValue = GetDirections_xpath.getCssValue("color");
		String GetDirections_Actual_FontColor = Color.fromString(GetDirections_colorValue).asHex();
		Assert.assertEquals("#0072c6", GetDirections_Actual_FontColor);

		//
		WebElement ViewOnMap_xpath = driver.findElement(By.xpath("(//a[contains(text(), 'View On Map')])[2]"));
		String ViewOnMap_FontSize = ViewOnMap_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", ViewOnMap_FontSize);

		String ViewOnMap_fontFamily = ViewOnMap_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", ViewOnMap_fontFamily);

		String ViewOnMap_colorValue = ViewOnMap_xpath.getCssValue("color");
		String ViewOnMap_Actual_FontColor = Color.fromString(ViewOnMap_colorValue).asHex();
		Assert.assertEquals("#0072c6", ViewOnMap_Actual_FontColor);
	}

	@Test
	public void PaymentLocationLegendDesignVerification() {
		//
		WebElement PLL_Title_xpath = driver.findElement(By.xpath("//h2[contains(text(), 'Payment Location Legend')]"));
		String PLL_Title_FontSize = PLL_Title_xpath.getCssValue("font-size");
		Assert.assertEquals("24px", PLL_Title_FontSize);

		String PLL_Title_fontFamily = PLL_Title_xpath.getCssValue("font-family");
//		Assert.assertEquals("Interstate, Helvetica, sans-serif", PLL_Title_fontFamily);
		if (firefox_font_family.equals("Chrome")) {
			Assert.assertEquals(firefox_font_family, PLL_Title_fontFamily);
		}
		String PLL_Title_colorValue = PLL_Title_xpath.getCssValue("color");
		String PLL_Title_Actual_FontColor = Color.fromString(PLL_Title_colorValue).asHex();
		Assert.assertEquals("#000000", PLL_Title_Actual_FontColor);

		//
		WebElement BranchOffices_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Branch Offices')]"));
		String BranchOffices_FontSize = BranchOffices_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", BranchOffices_FontSize);

		String BranchOffices_fontFamily = BranchOffices_xpath.getCssValue("font-family");
		Assert.assertEquals("Interstate", BranchOffices_fontFamily);

		String BranchOffices_colorValue = BranchOffices_xpath.getCssValue("color");
		String BranchOffices_Actual_FontColor = Color.fromString(BranchOffices_colorValue).asHex();
		Assert.assertEquals("#000000", BranchOffices_Actual_FontColor);

		// Authorized Payment Locations
		WebElement APL_xpath = driver.findElement(By.xpath("//p[contains(text(), 'Authorized Payment Locations')]"));
		String APL_FontSize = APL_xpath.getCssValue("font-size");
		Assert.assertEquals("14px", APL_FontSize);

		String APL_fontFamily = APL_xpath.getCssValue("font-family");
		Assert.assertEquals("Arial", APL_fontFamily);

		String APL_colorValue = APL_xpath.getCssValue("color");
		String APL_Actual_FontColor = Color.fromString(APL_colorValue).asHex();
		Assert.assertEquals("#666666", APL_Actual_FontColor);
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
