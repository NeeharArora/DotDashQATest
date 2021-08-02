package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test17_NewTab {
	private WebDriver driver;
  @Test
  public void Test17_NewTab() throws InterruptedException {
	String parentPageTitle = driver.getTitle();
	driver.findElement(By.linkText("Click Here")).click();
	Thread.sleep(2000);
	
	String childPageTitle1 = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
	
	Assert assertEquals(parentPageTitle, childPageTitle);
	
	
  }
  
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/windows");   
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
