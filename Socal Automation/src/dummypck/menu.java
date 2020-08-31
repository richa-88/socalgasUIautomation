package dummypck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.socalgas.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Title xpath
		/*
		 * WebElement login_My_Acc_Title_xpath =
		 * driver.findElement(By.xpath("//div[contains(text(),'Log in to My')]"));
		 * 
		 * String login_My_Acc_Title_FontSize =
		 * login_My_Acc_Title_xpath.getCssValue("font-size");
		 * Assert.assertEquals("24px", login_My_Acc_Title_FontSize);
		 * 
		 * String login_My_Acc_Actual_fontFamily =
		 * login_My_Acc_Title_xpath.getCssValue("font-family"); //
		 * Assert.assertEquals("Interstate, Helvetica, sans-serif",
		 * login_My_Acc_Actual_fontFamily); if (firefox_font_family.equals("Chrome")) {
		 * Assert.assertEquals(firefox_font_family, login_My_Acc_Actual_fontFamily); }
		 * String login_My_Acc_Title_colorValue =
		 * login_My_Acc_Title_xpath.getCssValue("color"); String
		 * login_My_Acc_Actual_Title_FontColor =
		 * Color.fromString(login_My_Acc_Title_colorValue).asHex();
		 * Assert.assertEquals("#ffffff", login_My_Acc_Actual_Title_FontColor);
		 * 
		 * // sub Title xpath. WebElement login_My_Acc_SubTitle_xpath = driver
		 * .findElement(By.xpath("//p[contains(text(),'Business Customers')]"));
		 * 
		 * String login_My_Acc_SubTitle_FontSize =
		 * login_My_Acc_SubTitle_xpath.getCssValue("font-size");
		 * Assert.assertEquals("16px", login_My_Acc_SubTitle_FontSize);
		 * 
		 * String login_My_Acc_Actual_SubTitle_fontFamily =
		 * login_My_Acc_SubTitle_xpath.getCssValue("font-family"); //
		 * Assert.assertEquals("Arial, Helvetica, sans-serif",
		 * login_My_Acc_Actual_SubTitle_fontFamily); if
		 * (firefox_font_family.equals("Chrome")) {
		 * Assert.assertEquals(firefox_font_family,
		 * login_My_Acc_Actual_SubTitle_fontFamily); } String
		 * login_My_Acc_SubTitle_colorValue =
		 * login_My_Acc_SubTitle_xpath.getCssValue("color"); String
		 * login_My_Acc_Actual_SubTitle_FontColor =
		 * Color.fromString(login_My_Acc_SubTitle_colorValue).asHex();
		 * Assert.assertEquals("#ffffff", login_My_Acc_Actual_SubTitle_FontColor);
		 * 
		 * // Login Button. WebElement Login_Button_Text_xpath =
		 * driver.findElement(By.xpath("//a[@class='feature--item--button']")); String
		 * Login_Button_Text_FontSize =
		 * Login_Button_Text_xpath.getCssValue("font-size"); Assert.assertEquals("16px",
		 * Login_Button_Text_FontSize);
		 * 
		 * String Login_Button_Text_fontFamily =
		 * Login_Button_Text_xpath.getCssValue("font-family");
		 * Assert.assertEquals("Interstate", Login_Button_Text_fontFamily);
		 * 
		 * String Login_Button_Text_colorValue =
		 * Login_Button_Text_xpath.getCssValue("color"); String
		 * Login_Button_Text_Actual_FontColor =
		 * Color.fromString(Login_Button_Text_colorValue).asHex();
		 * Assert.assertEquals("#000000", Login_Button_Text_Actual_FontColor);
		 */
	}

}
