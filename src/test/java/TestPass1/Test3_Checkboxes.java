package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test3_Checkboxes {
	private WebDriver driver;	
	
	
  @Test(priority = 1)
  public void CheckboxesToggle() throws InterruptedException {
	  for(int i=1;i<6;i++) {
		  driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
		  Thread.sleep(500);
		  driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
		  Thread.sleep(500);
	  }
  }
  
  @Test(priority = 2)
  public void CheckboxesSelect() throws InterruptedException {
	  //properly confirming the 1st checkbox is checked, if not, do it
	  Thread.sleep(500);
	  if ( !driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).isSelected() )
	  {
	       driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
	  }
	  Thread.sleep(500);

	//properly confirming the 2nd checkbox is checked, if not, do it
	  if ( !driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).isSelected() )
	  {
	       driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
	  }	
  }
	  
  
  @Test(priority = 3)
  public void CheckboxesUnselect() throws InterruptedException {
	//properly confirming the 1st checkbox is UNCHECKED, if not, do it
	  Thread.sleep(500);
	  if ( driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).isSelected() )
	  {
	       driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
	  }
	  
	  Thread.sleep(500);

	//properly confirming the 2nd checkbox is UNCHECKED, if not, do it
	  if ( driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).isSelected() )
	  {
	       driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
	  }
	  
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
