package com.prpportal;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import com.prpportal.LoginPortal;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AddressExceptionTests {
    
    /**
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test (priority = 1)
    
    public void addressExceptionAdd() throws InterruptedException, AWTException
    {
        WebDriverManager.chromedriver().setup();
       ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        
        /*Login to portal */
        driver.get("https://payrollpoint-staging.symmetry.com/#/");
        driver.manage().window().maximize();
        driver.findElement(By.id("token")).sendKeys("1842qqxJz5OmMCXc5KGfDJoPZxBXLOUXNsvLYqeTitdxIpH");
        driver.findElement(By.cssSelector("button")).click();
        
       	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(2000);
        /*Address Exception tab  */ 
      driver.findElement(By.xpath("//a[@href='#/configure/address-exceptions']")).click();
      Thread.sleep(2000);

            /* To verify the title */
            String expectedTitle = "Address Exceptions"; 
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
    
            System.out.println("Title is  " + actualTitle );

      /* add a new address exception  */
      driver.findElement(By.xpath("//*[@id='newAEButton']")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("inStreet")).sendKeys("598 Schoolhouse Rd");
      driver.findElement(By.id("inCity")).sendKeys("Middletown");
      driver.findElement(By.id("inState")).sendKeys("P");
      driver.findElement(By.id("inZip")).sendKeys("17057");
      driver.findElement(By.xpath("//*[@id='verifyAddressButton']")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("latitude")).sendKeys("21");
      driver.findElement(By.id("longitude")).sendKeys("56");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='saveAEButton']")).click();

      Thread.sleep(5000);


          /* To verify if new AE  is present in the table */
    
          String actualAE = "598 Schoolhouse Rd, Middletown, PA 17057";
         
          if ( driver.getPageSource().contains("598 Schoolhouse Rd, Middletown, PA 17057")){
              System.out.println("Test Passed:  " + actualAE + " is present in the table" );
           } else {
              System.out.println("Test failed, Address exception was not added ");
           }
      driver.close();
      driver.quit();
    }
      @Test (priority = 2)
    
      public void addressExceptionEdit() throws InterruptedException, AWTException
      {
          WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--remote-allow-origins=*");
          ChromeDriver driver = new ChromeDriver(chromeOptions);
          
          /* Login to portal */
          driver.get("https://payrollpoint-staging.symmetry.com/#/");
          driver.manage().window().maximize();
          driver.findElement(By.id("token")).sendKeys("1842qqxJz5OmMCXc5KGfDJoPZxBXLOUXNsvLYqeTitdxIpH");
          driver.findElement(By.cssSelector("button")).click();
          
             
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          /*Address Exception tab  */ 
          Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='#/configure/address-exceptions']")).click();

      /* edit an address exception  */
      Thread.sleep(2000);
      driver.findElements(By.xpath("//*[contains(@id, 'editAEButton')]")).get(0).click();

      Thread.sleep(2000);
      driver.findElement(By.id("latitude")).sendKeys("2");
      driver.findElement(By.id("longitude")).sendKeys("7");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='saveAEButton']")).click();
      Thread.sleep(5000);
      driver.close();
      driver.quit();
      }
      @Test (priority = 3)
    
      public void addressExceptionDelete() throws InterruptedException, AWTException
      {
          WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--remote-allow-origins=*");
          ChromeDriver driver = new ChromeDriver(chromeOptions);
          
          /* Login to portal */
          driver.get("https://payrollpoint-staging.symmetry.com/#/");
          driver.manage().window().maximize();
          driver.findElement(By.id("token")).sendKeys("1842qqxJz5OmMCXc5KGfDJoPZxBXLOUXNsvLYqeTitdxIpH");
          driver.findElement(By.cssSelector("button")).click();
          
             
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          /*Address Exception tab  */ 
          Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='#/configure/address-exceptions']")).click();
        Thread.sleep(2000);
      /* delete an address exception */

      driver.findElements(By.xpath("//*[contains(@id, 'deleteAEButton')]")).get(0).click();

      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='primaryPopupDialogButton']")).click();

      
          /* To verify if new AE  is was deleted  */
          Thread.sleep(2000);
          String actualAE = "598 Schoolhouse Rd, Middletown, PA 17057";
         
          if ( driver.getPageSource().contains("598 Schoolhouse Rd, Middletown, PA 17057")){
              System.out.println("Test Failed:  " + actualAE + " is still present in the table" );
           } else {
              System.out.println("Deletion was successful ");
           }

      Thread.sleep(5000);
      driver.close();
      driver.quit();

    }
 
}
