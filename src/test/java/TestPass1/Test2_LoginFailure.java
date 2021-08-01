package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test2_LoginFailure {
	WebDriver driver;
	String expectedMessage = " You logged into a secure area!";
  @Test
  public void LoginFailure() {
	  driver.get("http://localhost:7080/login"); 
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
	  WebElement errorTextPicker  = driver.findElement(By.id("flash"));
	   String displayedMessage = errorTextPicker.getText();
	   System.out.println(displayedMessage);
	   Assert.assertFalse( displayedMessage.equalsIgnoreCase(expectedMessage));  
  }
  

@BeforeTest
  public void Setup() throws InterruptedException {
	  	 WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  
  }

  @AfterTest
  public void TearDown() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.quit();
  }

}
