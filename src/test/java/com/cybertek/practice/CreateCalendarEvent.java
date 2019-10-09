package com.cybertek.practice;

import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateCalendarEvent {
    WebDriver driver;
    String CreateCalendarEveent="//a[@title='Create Calendar event']";


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }
    @AfterMethod
    public void tearDown(){
       // driver.quit();

    }
    @Test
    public void  salesManagerTest() throws InterruptedException {
        Thread.sleep(2000);
        VyTrackUtils.login(driver,"User155","UserUser123");
        Thread.sleep(2000);
        VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
        Thread.sleep(3000);
        driver.findElement(By.xpath(CreateCalendarEveent)).click();
       Thread.sleep(2000);



}}
