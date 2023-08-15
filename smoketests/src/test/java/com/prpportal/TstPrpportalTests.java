package com.prpportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

abstract class TstPrpportalTests {
    
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://payrollpoint-test.symmetry.com/#/");
        Thread.sleep(3000);
        driver.quit();
        driver.close();
    }

  
}
