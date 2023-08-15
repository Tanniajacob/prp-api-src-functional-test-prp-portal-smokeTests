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
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.prpportal.LoginPortal;

public class MinWageTests {
      /**
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test
    
    public void minWageTestFilter() throws InterruptedException, AWTException
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
    
        Thread.sleep(2000);
        /* Minimum wage tab */ 
        driver.findElement(By.xpath("//a[@href='#/minimumwage']")).click();
        Thread.sleep(2000);
            /* To verify the title */
            String expectedTitle = "Minimum Wage"; 
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
    
            System.out.println("Title is  " + actualTitle );

       /* Filter by State*/
       Thread.sleep(2000);
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("P");
       WebElement chooseState = driver.findElement(By.id("state"));
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       Thread.sleep(2000);
       WebElement applyFilterBtn = 
       driver.findElement(By.xpath("//*[@id='applyFiltersWagesButton']"));
       applyFilterBtn.click();
       Thread.sleep(2000);

       /*To verify Pennsylvania taxes */

       String PATaxId1 = "42-1-000000000-REG-000-000";
       String PATaxId2 = "42-1-000000000-TIP-000-000";
       String PATaxId3 = "42-5-001216878-REG-000-000";
 
       
      
       if ( driver.getPageSource().contains("42-1-000000000-REG-000-000")){
           System.out.println("Test Passed : " + PATaxId1 + " is present" );
        } else {
           System.out.println("Test Failed:  " + PATaxId1 + " is not present. ");
        }
       
  
       if ( driver.getPageSource().contains("42-1-000000000-TIP-000-000")){
           System.out.println("Test Passed : " + PATaxId2 + " is present");
        } else {
           System.out.println("Test Failed : " + PATaxId2 + " is not present. ");
        }
        if ( driver.getPageSource().contains("42-5-001216878-REG-000-000")){
            System.out.println("Test Passed : " + PATaxId3 + " is present");
         } else {
            System.out.println("Test Failed : " + PATaxId3 + " is not present. ");
         }
        
       
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("M");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       applyFilterBtn.click();
       Thread.sleep(2000);

       
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("T");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       applyFilterBtn.click();
       Thread.sleep(2000);
       

        /* Filter by Authority type */
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("A");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       Thread.sleep(2000);
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("S");
       WebElement chooseAuthType = driver.findElement(By.id("authorityType"));
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("C");
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);
        driver.findElement(By.id("authorityType")).click();
        driver.findElement(By.id("authorityType")).sendKeys("M");
        chooseAuthType.sendKeys(Keys.TAB);
        chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);

        /* Filter by industry  */
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("A");
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
       Thread.sleep(2000);
        driver.findElement(By.id("industryType")).click();
       driver.findElement(By.id("industryType")).sendKeys("C");
       WebElement chooseIndType = driver.findElement(By.id("industryType"));
       chooseIndType.sendKeys(Keys.TAB);
       chooseIndType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);
        driver.findElement(By.id("industryType")).click();
        driver.findElement(By.id("industryType")).sendKeys("N");
        chooseIndType.sendKeys(Keys.TAB);
        chooseIndType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);
        driver.findElement(By.id("industryType")).click();
        driver.findElement(By.id("industryType")).sendKeys("A");
        chooseIndType.sendKeys(Keys.TAB);
        chooseIndType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        Thread.sleep(2000);
       
        /* Filter by major type  */
       driver.findElement(By.id("industryType")).click();
       driver.findElement(By.id("industryType")).sendKeys("A");
       chooseIndType.sendKeys(Keys.TAB);
       chooseIndType.sendKeys(Keys.ENTER);
       Thread.sleep(2000);
       driver.findElement(By.id("majorType")).click();
       driver.findElement(By.id("majorType")).sendKeys("A");
       WebElement chooseMajorType = driver.findElement(By.id("majorType"));
       chooseMajorType.sendKeys(Keys.TAB);
       chooseMajorType.sendKeys(Keys.ENTER);
       applyFilterBtn.click();
       Thread.sleep(5000);

      /* to download min wage */
      driver.findElement(By.xpath("//*[@id='download-btn']")).click();
      Thread.sleep(2000);
     // driver.findElement(By.xpath("//*[@id='downloadPopUp']")).click();

     Thread.sleep(2000);
      driver.close();
      driver.quit();


    }
}
