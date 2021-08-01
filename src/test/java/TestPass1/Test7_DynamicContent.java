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

public class Test7_DynamicContent {
	private WebDriver driver;
	
  @Test(priority = 1)
  public void Test7_DynamicContent() throws InterruptedException {
	  Thread.sleep(1000);
	  String orginalText = driver.findElement(By.cssSelector
			  ("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) "
			  		+ "div.row:nth-child(7) div.large-10.columns.large-centered div.row:nth-child(7)"
			  		+ " > div.large-10.columns")).getText();
	  System.out.println(orginalText);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'click here')]")).click();
	  Thread.sleep(500);
	  String bodyText = driver.findElement(By.tagName("body")).getText();
	  Thread.sleep(500);
	  Assert.assertFalse(bodyText.contains(orginalText));
  }
  

  
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	     driver.get("http://localhost:7080/dynamic_content?with_content=static");   
	     
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
