package socaldesignautomation;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocalLinksNavigation {
	WebDriver driver;

	@BeforeMethod
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("=====Browser Session Started=====", true);
		driver.get("https://socalgasmigration.prod.acquia-sites.com/");
		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void f() {
		driver.findElement(By.xpath("//button[@class='close']")).click();
	}

	@Test(enabled = true)
	public void UtilityNavLinksNavigation() {

		List<WebElement> UtilityNavAllLinks = driver.findElements(By.xpath("//ul[@class='utility-nav__list']/li/a"));
		Reporter.log("Total Size of Utility Nav Links:" + UtilityNavAllLinks.size());

		String hrefHolder[] = new String[UtilityNavAllLinks.size()];

		for (int i = 0; i < UtilityNavAllLinks.size(); i++) {
			WebElement element = UtilityNavAllLinks.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void GlobalNavigation() {
		List<WebElement> globalLink = driver.findElements(By.xpath("//a[@class='main-nav__link']"));
		Reporter.log("Total no of links Available: " + globalLink.size());
		String hrefHolder[] = new String[globalLink.size()];

		for (int i = 0; i < globalLink.size(); i++) {
			WebElement element = globalLink.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void PayBillsNavigation() {
		Actions action = new Actions(driver);
		WebElement payBill = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[1]"));
		action.moveToElement(payBill);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[2]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void ScheduleServiceNavigation() {
		Actions action = new Actions(driver);
		WebElement ScheduleServiceNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[2]"));
		action.moveToElement(ScheduleServiceNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[3]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void StaySafeNavigation() {
		Actions action = new Actions(driver);
		WebElement StaySafeNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[3]"));
		action.moveToElement(StaySafeNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[4]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void SaveMoneyAndEnergyNavigation() {
		Actions action = new Actions(driver);
		WebElement SaveMoneyAndEnergyNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[4]"));
		action.moveToElement(SaveMoneyAndEnergyNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[5]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void ForYourBusinessNavigation() {
		Actions action = new Actions(driver);
		WebElement ForYourBusinessNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[5]"));
		action.moveToElement(ForYourBusinessNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[6]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void SmartEnergyNavigation() {
		Actions action = new Actions(driver);
		WebElement SmartEnergyNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[6]"));
		action.moveToElement(SmartEnergyNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[7]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void OurCommunityNavigation() {
		Actions action = new Actions(driver);
		WebElement OurCommunityNavi = driver.findElement(By.xpath("(//a[@class='main-nav__link'])[7]"));
		action.moveToElement(OurCommunityNavi);
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> subMenu = driver
				.findElements(By.xpath("//div[@class=\"main-nav__wrapper\"]/ul/li[8]/ul/ul/li/a"));
		Reporter.log("Total no of links Available: " + subMenu.size());
		String hrefHolder[] = new String[subMenu.size()];
		for (int i = 0; i < subMenu.size(); i++) {
			WebElement element = subMenu.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void FooterLinkNavigation() {
		List<WebElement> FooterLinks = driver
				.findElements(By.xpath("//*[@id=\"footer\"]/div/div[1]/div[1]/div[1]/ul/li/a"));
		Reporter.log("Total Size of Footer Links:" + FooterLinks.size());
		String hrefHolder[] = new String[FooterLinks.size()];
		for (int i = 0; i < FooterLinks.size(); i++) {
			WebElement element = FooterLinks.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	@Test(enabled = true)
	public void ConnectWithUsNavigation() {
		List<WebElement> SocalLinkNavi = driver.findElements(By.xpath("//a[@class='site-footer__social-link']"));
		Reporter.log("Total Size of Social Links:" + SocalLinkNavi.size());
		String hrefHolder[] = new String[SocalLinkNavi.size()];
		for (int i = 0; i < SocalLinkNavi.size(); i++) {
			WebElement element = SocalLinkNavi.get(i);
			Reporter.log(element.getText());
			hrefHolder[i] = element.getAttribute("href");
		}
		verifyLink(hrefHolder);
	}

	public void verifyLink(String a[]) {

		for (String s : a) {
			try {
//				Reporter.log(s + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				URL link = new URL(s);
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.setConnectTimeout(10000);
				httpConn.connect();
				if (httpConn.getResponseCode() == 200) {
					Reporter.log(s + " - " + httpConn.getResponseMessage());
				}
				if (httpConn.getResponseCode() == 201) {
					Reporter.log(s + " - " + httpConn.getResponseMessage());
				}
				if (httpConn.getResponseCode() == 404) {
					Reporter.log(s + " - " + httpConn.getResponseMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	@Test(enabled = false)
	public void FooterLogoNavigation() {
		WebElement footerLogoImg = driver.findElement(By.xpath("//div[@class='site-footer__logo']/a"));

		if (footerLogoImg.isDisplayed() && footerLogoImg.isEnabled()) {
			footerLogoImg.click();
			Reporter.log("Footer Logo image is Displayed & Enabled");
		}
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
		driver.close();
		Reporter.log("=====Browser Session End=====", true);
	}
}
