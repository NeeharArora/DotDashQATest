package TestPass1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;



public class Test6_DropDown {
	private WebDriver driver;
	
  @Test
  public void Test6_DropDown() {
	  Select dropdown = new Select(driver.findElement(By.id("dropdown")));
	  dropdown.selectByVisibleText("Option 1");
	  Thread.sleep(1000);
	  dropdown.selectByVisibleText("Option 2");
	  Thread.sleep(1000);
	  dropdown.selectByVisibleText("Option 1");
	  Thread.sleep(1000);
	  String option1 = dropdown.getFirstSelectedOption().getText();
	  Assert.assertEquals("Option 1", getSelectedOption(dropdown), "Selected Value not displaying");
	  dropdown.selectByVisibleText("Option 2");
	  Thread.sleep(1000);
	  Assert.assertEquals("Option 2", getSelectedOption(dropdown), "Selected Value not displaying");

  }
  
  
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/checkboxes");   
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
