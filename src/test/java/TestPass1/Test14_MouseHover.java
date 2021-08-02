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

public class Test14_MouseHover {
	private WebDriver driver;
	private Actions actions;
	private WebElement element;
	private String User1ExpectedValue = "name: user1";
	private String User2ExpectedValue = "name: user2";
	private String User3ExpectedValue = "name: user3";
	
  @Test
  public void Test14_MouseHover() throws InterruptedException {
	  element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
	  actions.moveToElement(element).build().perform();
	  Thread.sleep(3000);	  
	  String User1DisplayedValue = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText();
	  System.out.println(User1DisplayedValue);
	  Assert.assertEquals(User1DisplayedValue, User1ExpectedValue);
	  
	  element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
	  actions.moveToElement(element).build().perform();
	  Thread.sleep(3000);	  
	  String User2DisplayedValue = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText();
	  System.out.println(User2DisplayedValue);
	  Assert.assertEquals(User2DisplayedValue, User2ExpectedValue);

	  
	  element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
	  actions.moveToElement(element).build().perform();
	  Thread.sleep(3000);	  
	  String User3DisplayedValue = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText();
	  System.out.println(User3DisplayedValue);
	  Assert.assertEquals(User3DisplayedValue, User3ExpectedValue);
	  
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/hovers");   
	  actions = new Actions(driver);
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
