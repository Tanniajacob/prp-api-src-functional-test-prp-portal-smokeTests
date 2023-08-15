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

public class LoginPortal {

   /**
     * @throws InterruptedException
     * @throws AWTException
     */
 

    @Test
    
    public void loginPortalMethod()
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
        
       	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     
    }
}
