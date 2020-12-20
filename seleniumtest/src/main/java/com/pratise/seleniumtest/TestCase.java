package com.pratise.seleniumtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	 WebDriver driver;
	 
	 
	  
	  @BeforeTest
	  public void beforeTest() {
		  
		    
		  System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://www.cleartrip.com/");
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  System.out.println("Before method setup completed");
		  
	  }
	  
	  @Test(priority=1)
	  public void setDemo() throws InterruptedException {
		    driver.findElement(By.xpath("//body/section[@id='Home']/div[1]/aside[1]/nav[1]/ul[1]/li[1]/a[1]")); //Work needed
		    Thread.sleep(2000);
			driver.findElement(By.xpath("//ul/li/label/input[@id=\"OneWay\"]"));  //Work needed
			driver.findElement(By.xpath("(//input[@title=\"Any worldwide city or airport\"])[1]")).sendKeys("Bangalore"); 
			driver.findElement(By.xpath("(//input[@title=\"Any worldwide city or airport\"])[2]")).sendKeys("Goa");  
			Thread.sleep(1000);
	  }
	  
	  @Test(priority=2)
	  public void date() throws InterruptedException{
		  Calendar cal= Calendar.getInstance();
		  cal.add(Calendar.DATE, 30);
		  cal.add(Calendar.MONTH, 0);
		  cal.add(Calendar.YEAR, 0);
		  
		  Date d=cal.getTime();
		  System.out.println(d);
		  SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/YYYY");
		  String date=sdf.format(d);
		 WebElement d1 = driver.findElement(By.xpath("//input[@class=\"depart_date keyValue span span24 required hasDatepicker placeholder\"]"));
		 d1.sendKeys(date);
		  }
	  
	  @Test(priority=3)
	  public void dropdown() throws InterruptedException {
			  // selecting children
			  WebElement ele = driver.findElement(By.xpath("(//select[@size=\"1\"])[2]")); 
			  Select s = new Select(ele);
			  s.selectByValue("1");
			  
			  // selecting infant
			  WebElement ele1 =driver.findElement(By.xpath("//select[@name=\"infants\" and @id=\"Infants\"]")); 
			  Select s1 = new Select(ele1); 
			  s1.selectByVisibleText("1");
			  Thread.sleep(2000);
	  }
	  
	  
	  @Test(priority=4)
	  public void flight_button() throws InterruptedException {
		  //SoftAssert softassert = new SoftAssert();
		  driver.findElement(By.xpath("//input[@type=\"submit\" and @id=\"SearchBtn\"]" )).click();
		  Thread.sleep(3000);
			//softassert.assertAll();
	  }
	  
	  

	  @Test(priority=5)
	  public void Checking_CheckBox() throws InterruptedException {
		// selecting one way stop
		  WebElement option1=driver.findElement(By.xpath("//p[text()='Non-stop']"));
	      option1.click();
		  Thread.sleep(3000);  
		   }
	  
	  @Test(priority=6)
	  public void slider() throws InterruptedException {
		//slider
		  WebElement slider = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[1]/div/aside/div[4]/div[4]/div[2]/div/div[1]/div/span/span[1]/div"));
	        Actions action = new Actions(driver);
	        slider.click();
	        action.dragAndDropBy(slider,-127, 0).build().perform();
	        action.release();
	        Thread.sleep(3000);
	         }
	  
	 
	  
	  @Test(priority=7)
	  public void Uncheck() throws InterruptedException {
		// unchecking multiline itenaries checkbox
		   WebElement multi=driver.findElement(By.xpath("//p[text()='Show multi-airline itineraries']" ));
		   Thread.sleep(3000);
		   multi.click(); 
		   Thread.sleep(2000);
	  }
	  
	  
	  
	  @Test(priority=8)
	  public void Flight_booking() throws InterruptedException {
		  //Book button 
		  WebElement button=driver.findElement(By.xpath("//button[text()='Book']"));
		   button.click();
		   Thread.sleep(3000);
	  }
	  
	  
	  
	  @Test(priority=9)
	  public void Window_handel() throws InterruptedException {
		//handling itinerary tab
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> itinera= window.iterator();
		   
		   String searchWindow= itinera.next();
		   String iternaryWindow= itinera.next();
		   driver.switchTo().window(iternaryWindow);
		   Thread.sleep(5000); 
		    }
	  
	  
	  
	  
	  @Test(priority=10)
	  public void Continue_booking() throws InterruptedException {
		//continue booking
			 driver.findElement(By.id("itineraryBtn")).click();
			 Thread.sleep(3000);
	  }
	  
	  
	  
	  
	  @Test(priority=11)
	  public void Email() throws InterruptedException {
		  //enter email address
			driver.findElement(By.xpath("//input[@title='Your email address']")).sendKeys("manasa123@gmail.com");
			Thread.sleep(3000);
			
			//clicking on continue button 
			driver.findElement(By.xpath("//input[@id=\"LoginContinueBtn_1\"]")).click();
			Thread.sleep(1000);
	  }
	  
	  
	  
	  
	  @Test(priority=12)
	  public void Adult_traveller() throws InterruptedException {
		//enter travel details	
			 WebDriverWait wait = new WebDriverWait(driver, 20);
			 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@title=\"Adult 1's title\" and @name=\"AdultTitle1\"]")));	
			
			 
			 //adult details
			 WebElement adult=driver.findElement(By.xpath("//select[@title=\"Adult 1's title\" and @name=\"AdultTitle1\"]"));
			Select adrp=new Select(adult);
			adrp.selectByVisibleText("Ms");
			
			driver.findElement(By.xpath(" //input[@id=\"AdultFname1\"]")).sendKeys("Manasa");
			driver.findElement(By.xpath("//input[@id=\"AdultLname1\"]")).sendKeys("M");
			 Thread.sleep(1000);
	  }
	  
	  
	  
	  
	  @Test(priority=13)
	  public void Child() throws InterruptedException {
		//child details
			 WebElement child=driver.findElement(By.xpath("//select[@title=\"Child 1's title\" and @name=\"ChildTitle1\"]"));
			Select cdrp=new Select(child);
			cdrp.selectByVisibleText("Miss");
			
			driver.findElement(By.xpath("//input[@id=\"ChildFname1\"]")).sendKeys("Linisha");
			driver.findElement(By.xpath("//input[@id=\"ChildLname1\"]")).sendKeys("D");
			
			WebElement cdate=driver.findElement(By.xpath("//select[@id=\"ChildDobDay1\"]"));
			Select cday=new Select(cdate);
			cday.selectByVisibleText("18");
			
			WebElement cmonth=driver.findElement(By.xpath("//select[@id=\"ChildDobMonth1\"]"));
			Select cmon=new Select(cmonth);
			cmon.selectByVisibleText("Jul");
			
			Select childYear= new Select(driver.findElement(By.xpath("//select[@id=\"ChildDobYear1\"]")));
	     childYear.selectByVisibleText("2016");
	     Thread.sleep(1000);
	  }
	  
	  
	  
	  @Test(priority=14)
	  public void Infant() throws InterruptedException {
		//Infant details
			 WebElement infant=driver.findElement(By.xpath("//select [@title=\"Infant 1's title\" and @name=\"InfantTitle1\"]"));
			Select idrp=new Select(infant);
			idrp.selectByVisibleText("Mstr");
			
			driver.findElement(By.xpath("//input[@id=\"InfantFname1\"]")).sendKeys("Vrushab");
			driver.findElement(By.xpath("//input[@id=\"InfantLname1\"]")).sendKeys("Patil");
			
			WebElement idate=driver.findElement(By.xpath("//select[@id=\"InfantDobDay1\"]"));
			Select iday=new Select(idate);
			iday.selectByVisibleText("7");
			
			WebElement imonth=driver.findElement(By.xpath("//select[@id=\"InfantDobMonth1\"]"));
			Select imon=new Select(imonth);
			imon.selectByVisibleText("Feb");
			
			Select InfantYear= new Select(driver.findElement(By.xpath("//select[@id=\"InfantDobYear1\"]")));
	     InfantYear.selectByVisibleText("2019");
	     Thread.sleep(1000);
	     
	  }
	  
	  
	  
	  
	  @Test(priority=15)
	  public void Mobile_number() throws InterruptedException {
		//Mobile number
			driver.findElement(By.xpath("//input[@id=\"mobileNumber\"]")).sendKeys("9035271996");
			Thread.sleep(1000);
			  }
	  
	  
	  @Test(priority=16)
	  public void Continue_button() throws InterruptedException {
		//clicking continue button
			driver.findElement(By.xpath("//input[@id=\"travellerBtn\"]")).click();
			Thread.sleep(8000);	 
			System.out.println("All tests Passed");
	  }
	  
	 
	  @AfterTest
	  public void afterTest() {
		  driver.quit(); 
		  System.out.println("After method setup completed");
	  }
}
