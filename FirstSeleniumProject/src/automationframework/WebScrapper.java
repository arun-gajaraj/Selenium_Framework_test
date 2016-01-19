package automationframework;

import java.io.*;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebScrapper {

	public WebDriver driver = new ChromeDriver();

	/**
	 * Open the test website.
	 */
	public void openTestSite() {
//		driver.navigate().to("http://testing-ground.scraping.pro/login");
		driver.navigate().to("http://www.google.co.in");
	}

	/**
	 * 
	 * @param username
	 * @param Password
	 * 
	 *            Logins into the website, by entering provided username and
	 *            password
	 */
	public void login(String username, String Password) {

		WebElement userName_editbox = driver.findElement(By.id("usr"));
		WebElement password_editbox = driver.findElement(By.id("pwd"));
		WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));

		userName_editbox.sendKeys(username);
		password_editbox.sendKeys(Password);
		submit_button.click();

	}

	/**
	 * grabs the status text and saves that into status.txt file
	 * 
	 * @throws IOException
	 */
	public void getText() throws IOException {
		String text = driver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
		writer.write(text);
		writer.close();

	}

	/**
	 * Saves the screenshot
	 * 
	 * @throws IOException
	 */
	public void saveScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("Entered");
		WebScrapper webSrcapper = new WebScrapper();
		
		System.out.println("Webscrapper obj created!");
		webSrcapper.openTestSite();
		
		System.out.println("Page opened!");
		
		webSrcapper.login("admin", "12345");
		webSrcapper.getText();
		webSrcapper.saveScreenshot();
		webSrcapper.closeBrowser();
	}
}