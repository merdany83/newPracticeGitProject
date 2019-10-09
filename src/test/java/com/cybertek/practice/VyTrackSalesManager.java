package com.cybertek.practice;

import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackSalesManager {
    WebDriver driver;
    static String createButtonLocator="//*[@class='oro-subtitle']";
    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//
//    }
    @Test
    public void  salesManagerTest() throws InterruptedException {
        Thread.sleep(2000);
        VyTrackUtils.login(driver,"SalesManager253","UserUser123");
        Thread.sleep(2000);
        VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
        System.out.println(driver.findElement(By.xpath(createButtonLocator)).getText());




    }
}
