package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;

public class Test1_LoginSuccess {
	private WebDriver driver;
	String SuccessMessage = "Welcome to the Secure Area. When you are done click logout below.";
	
  @Test
  public void LoginSuccess() throws InterruptedException {
	 driver.findElement(By.id("username")).sendKeys("tomsmith");
	 driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	 driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
	 Thread.sleep(1000);
	 String displayedMessage = driver.findElement(By.tagName("h4")).getText();
	  Assert.assertEquals(displayedMessage, SuccessMessage); 
    
  }
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	     driver.get("http://localhost:7080/login");   

  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
