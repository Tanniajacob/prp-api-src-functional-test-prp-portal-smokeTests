package com.prpportal;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.asserts.*;
import org.openqa.selenium.JavascriptExecutor;

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



import io.github.bonigarcia.wdm.WebDriverManager;

public class MapsTests {

     /**
     * @throws InterruptedException
     * @throws AWTException
     */
 
     

    @Test (priority = 1)
    
    public void mapsTestWithAddress() throws InterruptedException, AWTException
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

        /*Enter work and home address */
        Thread.sleep(2000);
        driver.findElement(By.id("workLocationInput")).sendKeys("341 Orchid Ln, Birmingham, AL, 35215");
        driver.findElement(By.id("homeLocationInput")).sendKeys("107 Summit Drive, Lancaster, PA 17603");
        
        /*Find taxes */

        WebElement findTaxesBtn = 
        driver.findElement(By.xpath("//*[@id='submit-btn']"));
        findTaxesBtn.click();
        Thread.sleep(5000);

    

        /* To verify the title */
        String expectedTitle = "Maps"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title is  " + actualTitle );

        /* To verify ER taxes output */
    
        String expectedERTaxes1 = "Alabama Employment Security Assessment";
        String expectedERTaxes2 = "Alabama State Unemployment Tax";

        
       
        if ( driver.getPageSource().contains("Alabama State Unemployment Tax")){
            System.out.println("Test Passed : " + expectedERTaxes1 + " is present" );
         } else {
            System.out.println("Test Failed: " + expectedERTaxes1 + " is not present. ");
         }
        
   
        if ( driver.getPageSource().contains("Alabama State Unemployment Tax")){
            System.out.println("Test Passed : " + expectedERTaxes2 + " is present");
         } else {
            System.out.println("Test Failed: " + expectedERTaxes2 + " is not present. ");
         }
        
       
                  /* To verify EE taxes output */
    
        String expectedEETaxes1 = "Alabama State Tax";
        String expectedEETaxes2 = "Birmingham City Tax";
  
        
       
        if ( driver.getPageSource().contains("Alabama State Tax")){
            System.out.println("Test Passed : " + expectedEETaxes1 + " is present" );
         } else {
            System.out.println("Test Failed:  " + expectedEETaxes1 + " is not present. ");
         }
        
   
        if ( driver.getPageSource().contains("Birmingham City Tax")){
            System.out.println("Test Passed : " + expectedEETaxes2 + " is present");
         } else {
            System.out.println("Test Failed : " + expectedEETaxes2 + " is not present. ");
         }
        
        

        /*Download pdf option */
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='downloadPdfButton']")).click();
        Thread.sleep(2000);

        /*verify if pdf is downloaded 
        String downloadPath = "tannia.jacob/Downloads";
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(fileName.equals("prp-summary(33).pdf")," Downloaded file name is not matching with expected file name");
        File file = new File("tannia.jacob/Downloads/prp-summary(33).pdf"); 
        if(file.delete())
            System.out.println("file deleted");
      System.out.println("file not deleted");



        /* Use work address option */
        

        driver.findElement(By.xpath("//*[@id='useWorkAddressButton']")).click();

        findTaxesBtn.click();
      
       
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='clearMapsBtn']")).click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
//need to add before test here

@Test (priority = 2)
        public void mapsTestWithCoordinates() throws InterruptedException, AWTException
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
    
            new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.id("workLocationInput")));
           
        /* Use lat/long coodinates */
        driver.findElement(By.id("workLocationInput")).sendKeys("33.525302013413, -112.064475705048");
        driver.findElement(By.id("homeLocationInput")).sendKeys("39.990919298629, -76.297554642329");
        WebElement findTaxesBtn = 
        driver.findElement(By.xpath("//*[@id='submit-btn']"));
        findTaxesBtn.click();
        Thread.sleep(5000);
    
        /*Download pdf option */
    
        driver.findElement(By.xpath("//*[@id='downloadPdfButton']")).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
  
    }
}


    

