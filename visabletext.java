package dropdwn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class visabletext 
{
	WebDriver driver;
  @Test
  public void test() throws Exception
  {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();
	  
	  findElement(By.linkText("Admin")).click();
	  findElement(By.linkText("Organization")).click();
	  findElement(By.linkText("Locations")).click();
	  
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("location_name")).sendKeys("levi");
	  
	  Select country=new Select(driver.findElement(By.id("location_country")));
	  country.selectByVisibleText("India");
	  //country.selectByIndex(5);
	  //country.selectByValue("ML");
	  
	  //findElement(By.id("btnSave")).click();
	  
	  List<WebElement> drop=country.getOptions();
	  int counts=drop.size();
	 System.out.println("dropbox is "+counts);
  for(WebElement drop1:drop)
  {
	  System.out.println(drop1.getText());
  }
  }
  
  public WebElement findElement(By by) throws Exception
  {
	  WebElement Elem=driver.findElement(by);
	  
	  if(driver instanceof JavascriptExecutor)
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid black'", Elem);
	  }
	  return Elem;
  }
}

