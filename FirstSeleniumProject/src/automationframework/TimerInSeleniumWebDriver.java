package automationframework;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TimerInSeleniumWebDriver {
	WebDriver driver;
    
    public void  setup()
    {
    	driver= new FirefoxDriver();
    	System.out.println("browser loaded");	
        System.out.println("Waiting...");
        driver.get("https://qa.console.wostreaming.net/");
    }
    
    public void loginMethod() throws InterruptedException

    {
    	 StopWatch pageLoad = new StopWatch();
         pageLoad.start();
         // Enter UserName
         driver.findElement(By.id("username")).sendKeys("usha");
         // Enter Password
         driver.findElement(By.id("password")).sendKeys("aspire@123");
         // Click on 'Sign In' button
         driver.findElement(By.name("commit")).click();
         //change the user account
         driver.findElement(By.cssSelector(".user-icon>img")).click();
         
         if(driver.findElement(By.cssSelector(".loginname")).getText().equals("Usha"))
         {
        	 System.out.println("Login Successful with user: "+driver.findElement(By.cssSelector(".loginname")).getText().toString());
        	 
        	 driver.findElement(By.cssSelector(".context-switcher")).sendKeys("AspireQA");
        	 //Thread.sleep(1000);
        	 
         }
         
         
         //Open your web app
         driver.navigate().to("https://qa.console.wostreaming.net/campaigns.php");
         
         
       
         // Wait for the required any element (I am waiting for Login button in fb)
 		// WebDriverWait wait = new WebDriverWait(driver, 10);
 		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gs_htif0")));

         pageLoad.stop();
         //Get the time
         long pageLoadTime_ms = pageLoad.getTime();
         long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
         System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
         System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
    	
    }
    
    public void driverclose()
    {
    	driver.close();
    }
    
    public boolean iselementpresent(String cssid)
    {
    	boolean present;
        try {
           driver.findElement(By.id("logoutLink"));
           return true;
        } catch (NoSuchElementException e) {
           return false;
        }
    	
    }
    
    public static void main(String[] args) throws InterruptedException {
    	
    	TimerInSeleniumWebDriver tisd=new TimerInSeleniumWebDriver();
    	tisd.setup();
    	tisd.loginMethod();
//    	tisd.driverclose();
	
    }
    
}