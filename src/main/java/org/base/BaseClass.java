package org.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	    public static WebDriver driver;
	    public static Properties prop;
	    public static ExtentReports extent;
	    public static ExtentTest test;

	   


	    public static void launchBrowser(String browser) {
	  	  
	        if (browser.equalsIgnoreCase("chrome")) {
	        	  ChromeOptions options = new ChromeOptions();

	              Map<String, Object> prefs = new HashMap<>();
	              prefs.put("credentials_enable_service", false);
	              prefs.put("profile.password_manager_enabled", false);
	              options.setExperimentalOption("prefs", prefs);

	            
//	              options.addArguments("--disable-save-password-bubble");
//	              options.addArguments("--disable-notifications");
//	              options.addArguments("--disable-infobars");

	              options.addArguments("--incognito");

	              driver = new ChromeDriver(options);
	        } 
	        else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } 
	        else if (browser.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } 
	        else {
	            throw new RuntimeException(" Invalid browser name in config.properties: " + browser);
	        }
	    }
	
	 
	    public static void initializeExtentReport() {
	        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        if (extent != null) {
	            extent.flush();
	        }
	    }

	    public static void launchUrl(String url) {
	    	 driver.get(url);
	    	 driver.manage().window().maximize();
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     }
	     

	    public static void createTest(String testName) {
	        test = extent.createTest(testName);
	    }

	
	    public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    public static void click(WebElement element) {
	    	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 		 wait.until(ExpectedConditions.elementToBeClickable(element)); 
	 		element.click();
	     }
	     
	    
	    public static void sendKeys(WebElement element, String value) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.clear();
	        element.sendKeys(value);
	       
	    }

        public static void sleep(int sec) {
        	try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }



	}


