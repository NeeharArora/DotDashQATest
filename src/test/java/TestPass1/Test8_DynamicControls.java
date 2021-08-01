package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test8_DynamicControls {
	private WebDriver driver;
	boolean present;

	
  @Test(priority = 1)
  public void Test8_DynamicControlsCheckbox() throws InterruptedException {
	  try {
	     driver.findElement(By.cssSelector("#checkbox"));
	     present = true;
	  } catch (NoSuchElementException e) {
	     present = false;
	  }  
	  
	  if(present == false) {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
		  //wanted to use WebDriverWait class with condition: invisibilityOfTheElementLocated() and presenceOfElementLocated()
		  // but the WebDriverWait class is having problems with the import. 
		  Thread.sleep(4000);
		  String actualRemoveMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
		  String expectedRemoveMessage = "It's gone!";
		  Assert.assertEquals(actualRemoveMessage, expectedRemoveMessage);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		  Thread.sleep(4000);
		  String actualAddMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
		  String expectedAddMessage = "It's back!";
		  Assert.assertEquals(actualAddMessage, expectedAddMessage);
		  Thread.sleep(1000);
	  }
	  else {
		  System.out.println("checkbox not present");
	  }
  }
  
  @Test(priority = 2)
  public void Test8_DynamicControlsButton() throws InterruptedException {
	  
	  
  }
  
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	     driver.get("http://localhost:7080/dynamic_controls"); 
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
