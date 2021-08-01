package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test4_ContextMenu {
	private WebDriver driver;
	private Actions action;
	String expectedAlertText = "You selected a context menu";
	
	
  @Test
  public void ContextMenuRightClick() throws InterruptedException {
	  Thread.sleep(500);
	  WebElement elementLocator = driver.findElement(By.xpath("//div[@id='hot-spot']"));
	  action.contextClick(elementLocator).perform();
	  Thread.sleep(500);  
  }
  
  @Test(priority = 2, dependsOnMethods = "ContextMenuRightClick")
  public void ContextMenuAlertCheck() throws InterruptedException {
	  String alertText = driver.switchTo().alert().getText();
	  System.out.println(alertText);
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  Assert.assertEquals(alertText, expectedAlertText);
  }
  
  
  
  
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/context_menu");
	  action = new Actions(driver);
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();
  }

}
