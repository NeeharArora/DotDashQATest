package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test5_DragDrop {
	private WebDriver driver;
	Actions action;
	String AcolumnTextBeforeSwap = "A";
	String BcolumnTextBeforeSwap = "B";
	
  @Test (priority = 1)
  public void Test5_BeforeDragDropAssert() throws InterruptedException {
	  String AcolumnTextBeforeSwapText = driver.findElement(By.id("column-a")).getText();
	  String BcolumnTextBeforeSwapText = driver.findElement(By.id("column-b")).getText();
	  Assert.assertEquals(AcolumnTextBeforeSwapText, AcolumnTextBeforeSwap);
	  Assert.assertEquals(BcolumnTextBeforeSwapText, BcolumnTextBeforeSwap);
	  Thread.sleep(500);
  }
  
  @Test (priority = 2)
  public void Test5_DragDropOperation() throws InterruptedException {
	  action.clickAndHold(driver.findElement(By.xpath("//div[@id='column-a']"))).pause(Duration.ofMillis(500)).
	  moveToElement(driver.findElement(By.xpath("//div[@id='column-b']"))).pause(Duration.ofMillis(500)).
	  release().build().perform();
  }
  
  @Test (priority = 3)
  public void Test5_AfterDragDropAssert() {
	  String AcolumnTextAfterSwapText = driver.findElement(By.id("column-a")).getText();
	  String BcolumnTextAfterSwapText = driver.findElement(By.id("column-b")).getText();
	  System.out.println(AcolumnTextAfterSwapText);
	  System.out.println(BcolumnTextAfterSwapText);
	  Assert.assertEquals(AcolumnTextAfterSwapText, AcolumnTextBeforeSwap);
	  Assert.assertEquals(BcolumnTextAfterSwapText, BcolumnTextBeforeSwap);
	  
	  
  }

  
  @BeforeTest
  public void Setup() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	     driver.get("http://localhost:7080/drag_and_drop"); 
	 	action = new Actions(driver);
	 	Thread.sleep(200);

  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
