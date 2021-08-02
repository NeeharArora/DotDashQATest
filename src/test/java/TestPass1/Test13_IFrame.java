package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test13_IFrame {
	private WebDriver driver;
	private String keyboardInput = "Selenium Webdriver content added via send keys command";
  @Test
  public void Test13_IFrame() throws InterruptedException {
	  driver.switchTo().frame(0);
	  for(int i = 0; i<30; i++) {
		  driver.findElement(By.cssSelector("body.mce-content-body:nth-child(2) > p:nth-child(1)")).sendKeys(Keys.BACK_SPACE);  
	  }
	  driver.findElement(By.cssSelector("body.mce-content-body:nth-child(2) > p:nth-child(1)")).sendKeys(keyboardInput);
	  String userAddedText = driver.findElement(By.cssSelector("body.mce-content-body:nth-child(2) > p:nth-child(1)")).getText();
	  Assert.assertEquals(userAddedText, keyboardInput);
	  Thread.sleep(2000);
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/iframe");   
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
