package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test12_FloatingMenu {
	private WebDriver driver;
	
	
  @Test
  public void Test12_FloatingMenu() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,2000)");
	  Thread.sleep(2000);
	  if(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed()) {
		  System.out.println("Visible");
	  }
	  else {
		  System.out.println("not visible");
	  }
	  
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/floating_menu"); 
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	
  }

}
