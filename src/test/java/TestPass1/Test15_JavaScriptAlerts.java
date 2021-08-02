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

public class Test15_JavaScriptAlerts {
	private WebDriver driver;
	String button1ExpectedText = "I am a JS Alert"; // we can also pass the value that is displayed on screen
	String button2ExpectedText = "I am a JS Confirm"; // we can also pass the value that is displayed on screen
	String button3UserSentText = "User entered this text message";
  @Test
  public void Test15_JavaScriptAlerts() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
	  Thread.sleep(1000);
	  Assert.assertEquals(button1ExpectedText, driver.switchTo().alert().getText());	 
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
	  Thread.sleep(1000);
	  Assert.assertEquals(button2ExpectedText, driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);

	  driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
	  Thread.sleep(1000);
	  driver.switchTo().alert().sendKeys(button3UserSentText);
	  driver.switchTo().alert().accept(); 
	  Thread.sleep(3000);
	  Assert.assertEquals("You entered: "+button3UserSentText, driver.findElement(By.xpath("//p[@id='result']")).getText());
	   
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/javascript_alerts"); 
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
