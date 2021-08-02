package TestPass1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test11_FileUpload {
	private WebDriver driver;
  @Test
  public void Test11_FileUpload() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\some-file.txt");
	  Thread.sleep(2000);
	  driver.findElement(By.id("file-submit")).click();
	  if(driver.findElement(By.id("uploaded-files")).isDisplayed()){
		  System.out.println("File uploaded successfully");
	  }
	  else {
		  System.out.println("check again, file not uploaded");
	  }
	  
  }
  @BeforeTest
  public void Setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.get("http://localhost:7080/upload");  
  }

  @AfterTest
  public void TearDown() {
	  driver.quit();	  
  }

}
