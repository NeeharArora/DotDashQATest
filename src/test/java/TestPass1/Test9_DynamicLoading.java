package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test9_DynamicLoading {
	private WebDriver driver;
	
  @Test
  public void Test9_DynamicLoading() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	  Thread.sleep(2000);
	  String expectedTextMessage = "//h4[contains(text(),'Hello World!')]";
	  String actualTextMessage = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText();
	  Assert.assertEquals(actualTextMessage, expectedTextMessage);
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/dynamic_loading/2");   
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
