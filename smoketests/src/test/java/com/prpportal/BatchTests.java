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
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
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

public class BatchTests {

    /**
    * @throws InterruptedException
    * @throws AWTException
    */


   @Test (priority = 1)
   
   public void batchTestEdit() throws InterruptedException, AWTException
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

          /* Access Batch tab */

          Thread.sleep(2000);
          driver.findElement(By.xpath("//a[@href='#/batch']")).click();
          Thread.sleep(2000);
  
        /* To verify the title */
        String expectedTitle = "Batch"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title is  " + actualTitle );

  
         /* Edit existing batch and add new line */
          driver.findElements(By.xpath("//*[contains(@id, 'moreActionsButton')]")).get(0).click();
          Thread.sleep(2000);
          driver.findElements(By.xpath("//*[contains(@id, 'editBatchButton')]")).get(0).click();
          Thread.sleep(5000);

          /*Add new line */
  
          driver.findElement(By.xpath("//*[@id='addNewBatchLineButton']")).click();
          Thread.sleep(2000);
  
          driver.findElement(By.id("eeIdNoBatchIdInput")).sendKeys("157");
          driver.findElement(By.id("workStreetAddressInput")).sendKeys("14350 N 87th St");
          driver.findElement(By.id("workStreetAddress2Input")).sendKeys("Ste 310");
          driver.findElement(By.id("workCityInput")).sendKeys("Scottsdale");
          driver.findElement(By.id("workStateInput")).sendKeys("Arizona");
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id='homeUseWorkButton']")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id='batchEditSaveButton']")).click();
          Thread.sleep(3000);
          driver.findElements(By.xpath("//*[contains(@id, 'batchLineRunIcon')]")).get(0).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[@id='taxResultsButton']")).click(); //back to tax results
          Thread.sleep(2000);
          driver.findElement(By.xpath("//a[@href='#/batch']")).click();
          Thread.sleep(2000);
          driver.findElements(By.xpath("//*[contains(@id, 'completedMinWageButton')]")).get(1).click();
          Thread.sleep(5000);

          /* View Tax Results */
          driver.findElement(By.xpath("//a[@href='#/batch']")).click();
          driver.findElements(By.xpath("//*[contains(@id, 'moreActionsButton')]")).get(0).click();
                    Thread.sleep(5000);
                    driver.findElements(By.xpath("//*[contains(@id, 'viewTaxResultsButton')]")).get(0).click();
                    Thread.sleep(5000);
            
                    driver.findElement(By.xpath("//a[@href='#/batch']")).click();
            
            
                    /* View Min Wage Results */
          
                    driver.findElements(By.xpath("//*[contains(@id, 'moreActionsButton')]")).get(0).click();
          
                    Thread.sleep(2000);
                    driver.findElements(By.xpath("//*[contains(@id, 'viewMinWageResultsButton-')]")).get(0).click();
                    Thread.sleep(5000);
                    
                    driver.findElement(By.xpath("//a[@href='#/batch']")).click();
                    Thread.sleep(5000);
          driver.close();
          driver.quit();
   }
      
  
          @Test (priority = 2)
   
          public void batchTestImport() throws InterruptedException, AWTException
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
       
                 /* Access Batch tab */
       
                 Thread.sleep(5000);
                 driver.findElement(By.xpath("//a[@href='#/batch']")).click();
                 Thread.sleep(5000);
         
          /*Import batch */
  
          driver.findElement(By.xpath("//a[@href='#/batch']")).click();
  
          driver.findElement(By.xpath("//*[@id='importBatchButton']")).click();
          Thread.sleep(2000);
          driver.findElement(By.id("batchFileInput")).sendKeys("/Users/tannia.jacob/R9aBatch.csv");
          Thread.sleep(2000);
          driver.findElement(By.id("name")).sendKeys("Sel Test 10.4");
          Thread.sleep(2000);
                  /* upload a batch */
        WebElement uploadBatchFileBtn = 
        driver.findElement(By.xpath("//*[@id='uploadBatchFileButton']"));
        uploadBatchFileBtn.click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("//*[contains(@id, 'toProcessCountButton')]")).get(0).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();
        Thread.sleep(5000);

        /* to verify if the batch name matches 
        String expectedBatchName = "R9aBatchSelTest10"; 
        String actualBatchName = driver.findElement(By.xpath("//*[contains(@id, 'batchRow')]")).getAttribute("value");
        Assert.assertEquals(actualBatchName, expectedBatchName, "Batch name is correct"); */

          /* To verify if batch name is correct */
    
          String actualImportBatchName = "R9aBatchSel Test 10.4";
         
          if ( driver.getPageSource().contains("R9aBatchSel Test 10.4")){
              System.out.println("Batch name " + actualImportBatchName + " is correct" );
           } else {
              System.out.println("Batch name is incorrect ");
           }

           /* to delete the new batch that was created */



        driver.close();
        driver.quit();
          } 

    @Test (priority = 3)
   
          public void batchTestCreateNew() throws InterruptedException, AWTException
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
       
                 /* Access Batch tab */
       
                 Thread.sleep(2000);
                 driver.findElement(By.xpath("//a[@href='#/batch']")).click();
                 Thread.sleep(2000);
         
         /*Create new batch */

        
         driver.findElement(By.xpath("//*[@id='newBatchButton']")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("batchNameInput")).sendKeys("R5Employeestest4");
         Thread.sleep(2000);

         //need to wait for save element to complete the test
         driver.findElement(By.xpath("//*[@id='batchNameSaveButton']")).click();
         Thread.sleep(5000);
     

    /* To verify if batch name is correct */
    
    String actualNewBatchName = "R5Employeestest3";
         
    if ( driver.getPageSource().contains("R5Employeestest3")){
        System.out.println("Batch name " + actualNewBatchName + " is correct" );
     } else {
        System.out.println("Batch name is incorrect ");
     }
/* To add new line items to the new batch */

         Thread.sleep(2000);
         driver.findElements(By.xpath("//*[contains(@id, 'batchRow')]")).get(0).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='addNewBatchLineButton']")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("eeIdNoBatchIdInput")).sendKeys("456");
         driver.findElement(By.id("workStreetAddressInput")).sendKeys("10 centerpointe dr");
         driver.findElement(By.id("workStreetAddress2Input")).sendKeys("ste B ");
         driver.findElement(By.id("workCityInput")).sendKeys("Lake Oswego");
         driver.findElement(By.id("workStateInput")).sendKeys("Oregon");
         driver.findElement(By.id("workZipInput")).sendKeys("97035");
         driver.findElement(By.xpath("//*[@id='homeUseWorkButton']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='batchEditSaveButton']")).click();
         Thread.sleep(2000);
         driver.findElements(By.xpath("//*[contains(@id, 'batchLineRunIcon')]")).get(0).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();
         Thread.sleep(2000);

         driver.findElement(By.xpath("//*[@id='taxResultsButton']")).click(); //back to tax results
         Thread.sleep(2000);
         
        //driver.findElements(By.xpath("//*[contains(@id, 'batchRow')]")).get(0).click();
        //Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@id='taxResultsButton']")).click();
        Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='template-select']")).click(); //batch template
         driver.findElement(By.id("template-select")).sendKeys("t"); //select template
         WebElement chooseTemplate= driver.findElement(By.id("template-select"));
         chooseTemplate.sendKeys(Keys.TAB);
         chooseTemplate.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id='downloadResultsButton']")).click(); 
         Thread.sleep(2000);

         //driver.findElement(By.xpath("//*[@id='downloadPopUpButton']")).click(); 
         //need to wait for download after element is present

         driver.findElement(By.xpath("//a[@href='#/batch?page=0']")).click();
         Thread.sleep(2000);
         driver.findElements(By.xpath("//*[contains(@id, 'completedMinWageButton')]")).get(0).click();
         driver.findElement(By.xpath("//*[@id='downloadMWResultsButton']")).click();
        
         Thread.sleep(2000);
         driver.findElements(By.xpath("//*[contains(@id, 'minWageBatchDownloadButton')]")).get(0).click();
         Thread.sleep(5000);
 
         /*Download black CSV */
        driver.findElement(By.xpath("//a[@href='#/batch']")).click();
        driver.findElement(By.xpath("//*[@id='importBatchButton']")).click();
        driver.findElement(By.xpath("//*[@id='download-sample-btn']")).click();

            /* Delete last batch record */

            //need to add code to delete once element is present

        driver.close();
        driver.quit();
  
    } 

}
