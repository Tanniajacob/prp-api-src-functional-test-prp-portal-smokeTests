

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

public class SeleniumTestNGTest {
    
    /**
     * @throws InterruptedException
     * @throws AWTException
     */
    @Test
    
    public void sampleTestMethod() throws InterruptedException, AWTException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        
        /* Login to portal */
        driver.get("https://payrollpoint-staging.symmetry.com/#/");
        driver.manage().window().maximize();
        driver.findElement(By.id("token")).sendKeys("762qqxZeMPNDui8fpIvv9Y9u7JSFKZGMczGAK3PZLPoa25");
        driver.findElement(By.cssSelector("button")).click();
        
       	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.id("workLocationInput")));
       
      
        /*Enter work and home address */
        driver.findElement(By.id("workLocationInput")).sendKeys("341 Orchid Ln, Birmingham, AL, 35215-6967");
        driver.findElement(By.id("homeLocationInput")).sendKeys("107 Summit Drive, Lancaster, PA 17603");
        
       
        /*Find taxes */

        WebElement findTaxesBtn = 
        driver.findElement(By.xpath("//*[@id='submit-btn']"));
        findTaxesBtn.click();
       
       
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
  
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        /*Download pdf option 
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='downloadPdfButton']")).click();
        Thread.sleep(2000);

      
        /* Use work address option */
        

        driver.findElement(By.xpath("//*[@id='useWorkAddressButton']")).click();

        findTaxesBtn.click();

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);

 
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='clearMapsBtn']")).click();


        /* Use lat/long coodinates */
        driver.findElement(By.id("workLocationInput")).sendKeys("33.525302013413, -112.064475705048");
        driver.findElement(By.id("homeLocationInput")).sendKeys("39.990919298629, -76.297554642329");

        findTaxesBtn.click();

    
        /*Download pdf option */
        
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        driver.findElement(By.xpath("//*[@id='downloadPdfButton']")).click();


        /* Access Batch tab */

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='#/batch']")).click();
        

        /*Run existing batch
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='toProcessCountButton-5238']")).click();
        driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();
        Thread.sleep(20000);

        /* View Tax Results */
        //driver.findElement(By.xpath("//a[@href='#/batch']")).click();

        driver.findElement(By.xpath("//*[@id='moreActionsButton-5293']")).click();

        driver.findElement(By.xpath("//*[@id='viewTaxResultsButton-5293']")).click();

        driver.findElement(By.xpath("//a[@href='#/batch']")).click();


        /* View Min Wage Results */
        driver.findElement(By.xpath("//*[@id='moreActionsButton-5293']")).click();

        driver.findElement(By.xpath("//*[@id='viewMinWageResultsButton-5293']")).click();

        driver.findElement(By.xpath("//a[@href='#/batch']")).click();

       /* Edit existing batch and add new line */

        driver.findElement(By.xpath("//*[@id='moreActionsButton-5292']")).click();

        driver.findElement(By.xpath("//*[@id='editBatchButton-5292']")).click();

        /*Add new line */

        driver.findElement(By.xpath("//*[@id='addNewBatchLineButton']")).click();

        driver.findElement(By.id("eeIdNoBatchIdInput")).sendKeys("157");
        driver.findElement(By.id("workStreetAddressInput")).sendKeys("14350 N 87th St");
        driver.findElement(By.id("workStreetAddress2Input")).sendKeys("Ste 310");
        driver.findElement(By.id("workCityInput")).sendKeys("Scottsdale");
        driver.findElement(By.id("workStateInput")).sendKeys("Arizona");

        driver.findElement(By.xpath("//*[@id='homeUseWorkButton']")).click();

        driver.findElement(By.xpath("//*[@id='batchEditSaveButton']")).click();

        driver.findElement(By.xpath("//*[@id='batchLineRunIcon-1315942']")).click();
        driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();

        driver.findElement(By.xpath("//*[@id='taxResultsButton']")).click(); //back to tax results
    
        driver.findElement(By.xpath("//a[@href='#/batch']")).click();

        driver.findElement(By.xpath("//*[@id='completedMinWageButton-5302']")).click(); //batch min wage


        /* Delete last batch record */


        /*Import batch */

        driver.findElement(By.xpath("//a[@href='#/batch']")).click();

        driver.findElement(By.xpath("//*[@id='importBatchButton']")).click();

        //driver.findElement(By.xpath("//*[@id='selectBatchFileButton']")).click();
        driver.findElement(By.id("batchFileInput")).sendKeys("/Users/tannia.jacob/R9aBatch.csv");

        driver.findElement(By.id("name")).sendKeys("SelTest5");

        /* to close pop up window 
        Set<String> wnd = driver.getWindowHandles();
        Iterator<String> i = wnd.iterator();
        String parentWindow = i.next();
        String popUpWindow = i.next();
        driver.switchTo().window(popUpWindow);
        driver.close();
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000); */

        /* upload a batch */
        WebElement uploadBatchFileBtn = 
        driver.findElement(By.xpath("//*[@id='uploadBatchFileButton']"));
        uploadBatchFileBtn.click();

        driver.findElement(By.xpath("//*[@id='toProcessCountButton-5306']")).click();

        driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();


        /*Robot robot1 = new Robot();
        robot1.mouseMove(612, 205);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000); 
        robot1.mouseMove(1367, 889);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
        

        /*Create new batch */

        
        driver.findElement(By.xpath("//*[@id='newBatchButton']")).click();
        driver.findElement(By.id("batchNameInput")).sendKeys("R5Employeestest1");
        driver.findElement(By.cssSelector("submit")).click();
        driver.findElement(By.xpath("//*[@id='moreActionsButton-5308']")).click();
        driver.findElement(By.xpath("//*[@id='editBatchButton-5308']")).click();
        driver.findElement(By.xpath("//*[@id='addNewBatchLineButton']")).click();
        driver.findElement(By.id("eeIdNoBatchIdInput")).sendKeys("456");
        driver.findElement(By.id("workStreetAddressInput")).sendKeys("10 centerpointe dr");
        driver.findElement(By.id("workStreetAddress2Input")).sendKeys("ste B ");
        driver.findElement(By.id("workCityInput")).sendKeys("Lake Oswego");
        driver.findElement(By.id("workStateInput")).sendKeys("Oregon");
        driver.findElement(By.id("workZipInput")).sendKeys("97035");
        driver.findElement(By.xpath("//*[@id='homeUseWorkButton']")).click();
        driver.findElement(By.xpath("//*[@id='batchEditSaveButton']")).click();
        driver.findElement(By.xpath("//*[@id='batchLineRunIcon-1315943']")).click();
        driver.findElement(By.xpath("//*[@id='runBatchPopupButton']")).click();
        driver.findElement(By.xpath("//*[@id='taxResultsButton']")).click(); //back to tax results
        driver.findElement(By.xpath("//*[@id='template-select']")).click(); //batch template
        driver.findElement(By.id("template-select")).sendKeys("t"); //select template
        WebElement chooseTemplate= driver.findElement(By.id("template-select"));
        chooseTemplate.sendKeys(Keys.TAB);
        chooseTemplate.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='downloadResultsButton']")).click(); 
        driver.findElement(By.xpath("//a[@href='#/batch?page=0']")).click();
        driver.findElement(By.xpath("//*[@id='completedMinWageButton-5307']")).click(); //batch min wage
        driver.findElement(By.xpath("//*[@id='downloadMWResultsButton']")).click();
        driver.findElement(By.xpath("//*[@id='completedMinWageButton-5307']")).click();
        /* Edit new Batch 
        WebElement editBathBtn = 
        driver.findElement(By.xpath("//*[@id='editBatchButton-5233']"));
        editBathBtn.click();

        /* Edit existing batch 
        Thread.sleep(2000);
        WebElement moreActionsBtn2 = 
        driver.findElement(By.xpath("//*[@id='moreActionsButton-5214']"));
        moreActionsBtn2.click();

        /*Download black CSV */
       driver.findElement(By.xpath("//a[@href='#/batch']")).click();
       driver.findElement(By.xpath("//*[@id='importBatchButton']")).click();
       driver.findElement(By.xpath("//*[@id='download-sample-btn']")).click();

       /* Minimum wage tab */ 
       driver.findElement(By.xpath("//a[@href='#/minimumwage']")).click();
       
       /*To access filter tab */

       /* Filter by State*/
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("P");
       WebElement chooseState = driver.findElement(By.id("state"));
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       WebElement applyFilterBtn = 
       driver.findElement(By.xpath("//*[@id='applyFiltersWagesButton']"));
       applyFilterBtn.click();
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("M");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       applyFilterBtn.click();
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("T");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
       applyFilterBtn.click();


        /* Filter by Authority type */
       driver.findElement(By.id("state")).click();
       driver.findElement(By.id("state")).sendKeys("A");
       chooseState.sendKeys(Keys.TAB);
       chooseState.sendKeys(Keys.ENTER);
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("S");
       WebElement chooseAuthType = driver.findElement(By.id("authorityType"));
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("C");
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        driver.findElement(By.id("authorityType")).click();
        driver.findElement(By.id("authorityType")).sendKeys("M");
        chooseAuthType.sendKeys(Keys.TAB);
        chooseAuthType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();

        /* Filter by industry  */
        driver.findElement(By.id("authorityType")).click();
       driver.findElement(By.id("authorityType")).sendKeys("A");
       chooseAuthType.sendKeys(Keys.TAB);
       chooseAuthType.sendKeys(Keys.ENTER);
        driver.findElement(By.id("industryType")).click();
       driver.findElement(By.id("industryType")).sendKeys("C");
       WebElement chooseIndType = driver.findElement(By.id("industryType"));
       chooseIndType.sendKeys(Keys.TAB);
       chooseIndType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        driver.findElement(By.id("industryType")).click();
        driver.findElement(By.id("industryType")).sendKeys("N");
        chooseIndType.sendKeys(Keys.TAB);
        chooseIndType.sendKeys(Keys.ENTER);
        applyFilterBtn.click();
        driver.findElement(By.id("industryType")).click();
        driver.findElement(By.id("industryType")).sendKeys("A");
        chooseIndType.sendKeys(Keys.TAB);
        chooseIndType.sendKeys(Keys.ENTER);

        applyFilterBtn.click();

       
        /* Filter by major type  */
       driver.findElement(By.id("industryType")).click();
       driver.findElement(By.id("industryType")).sendKeys("A");
       chooseIndType.sendKeys(Keys.TAB);
       chooseIndType.sendKeys(Keys.ENTER);
       driver.findElement(By.id("majorType")).click();
       driver.findElement(By.id("majorType")).sendKeys("A");
       WebElement chooseMajorType = driver.findElement(By.id("majorType"));
       chooseMajorType.sendKeys(Keys.TAB);
       chooseMajorType.sendKeys(Keys.ENTER);
       applyFilterBtn.click();

      /* to download min wage */
      driver.findElement(By.xpath("//*[@id='download-btn']")).click();
      driver.getWindowHandles();
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyPress(KeyEvent.VK_ENTER);

      //WebElement downloadPopUp = driver.findElement(By.cssSelector("button"));
      //downloadPopUp.click();


      /*Address Exception tab  */ 
      driver.findElement(By.xpath("//a[@href='#/configure/address-exceptions']")).click();

      /* add a new address exception  */
      WebElement addNewAEBtn = 
      driver.findElement(By.xpath("//*[@id='newAEButton']"));
      addNewAEBtn.click();
      driver.findElement(By.id("inStreet")).sendKeys("598 Schoolhouse Rd");
      driver.findElement(By.id("inCity")).sendKeys("Middletown");
      driver.findElement(By.id("inState")).sendKeys("P");
      driver.findElement(By.id("inZip")).sendKeys("17057");
      driver.findElement(By.xpath("//*[@id='verifyAddressButton']")).click();
      driver.findElement(By.id("latitude")).sendKeys("21");
      driver.findElement(By.id("longitude")).sendKeys("56");
      WebElement saveAEBtn = 
      driver.findElement(By.xpath("//*[@id='saveAEButton']"));
      saveAEBtn.click();

      /* edit an address exception  */
      WebElement editAEBtn = 
      driver.findElement(By.xpath("//*[@id='editAEButton-13970']"));
      editAEBtn.click();
      driver.findElement(By.id("latitude")).sendKeys("2");
      driver.findElement(By.id("longitude")).sendKeys("7");
      saveAEBtn.click();

      /* delete an address exception */
      WebElement deleteAEBtn = 
      driver.findElement(By.xpath("//*[@id='deleteAEButton-14072']"));
      deleteAEBtn.click();
      driver.findElement(By.id("latitude")).sendKeys("3");
      driver.findElement(By.id("longitude")).sendKeys("8");
      saveAEBtn.click();
      driver.close();
      driver.quit();

    }
    
}