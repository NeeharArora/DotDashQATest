package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class Test10_FileDownload {
	private WebDriver driver;
	String downloadFilepath = "C:/";
	private ChromeOptions options;

	
  @Test
  public void Test10_FileDownload() throws InterruptedException {
	  driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
	  options.setAcceptInsecureCerts(true);
	  Thread.sleep(5000);
	  
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/download");   
	  
	  options = new ChromeOptions();
      HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
      chromePrefs.put("profile.default_content_settings.popups", 0);
      chromePrefs.put("download.default_directory", downloadFilepath);
      chromePrefs.put("safebrowsing.enabled", "true"); 
      options.setExperimentalOption("prefs", chromePrefs);
      DesiredCapabilities cap = DesiredCapabilities.chrome();
      cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
      cap.setCapability(ChromeOptions.CAPABILITY, options);
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
