package com.cybertek.practice;

import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaveAndCancel {
    WebDriver driver;
    String CreateCalendarEveent="//a[@title='Create Calendar event']";
    String Cancel="//a[@data-action='cancel']";
    String SaveAndCloseBttn="//button[@class='btn btn-success action-button']";
    String SaveAndCloseDropDownBttn="//*[@class='btn-success btn dropdown-toggle']";
    String SaveAndCloseOption="//li/button[contains(text(),'Save and Close')]";
    String Save="(//li/button[contains(text(),'Save')])[3]";
    String SaveAndNewOption="//li/button[contains(text(),'Save and New')]";


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }
        @AfterMethod
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void  salesManagerTest() throws InterruptedException {
        Thread.sleep(2000);
        VyTrackUtils.login(driver,"SalesManager253","UserUser123");
        Thread.sleep(2000);
        VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
        Thread.sleep(2000);
        driver.findElement(By.xpath(CreateCalendarEveent)).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath(Cancel)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(SaveAndCloseBttn)).isDisplayed());
        driver.findElement(By.xpath(SaveAndCloseDropDownBttn)).click();
        System.out.println(driver.findElement(By.xpath(SaveAndCloseOption)).getText());
        Assert.assertTrue(driver.findElement(By.xpath(SaveAndNewOption)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(Save)).isDisplayed());

    }

   @Test
    public void verifyOwner() throws InterruptedException {

       Thread.sleep(2000);
       VyTrackUtils.login(driver,"User155","UserUser123");
       Thread.sleep(2000);
       VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
       Thread.sleep(3000);
       driver.findElement(By.xpath(CreateCalendarEveent)).click();
       Thread.sleep(2000);
       String actualOwner=driver.findElement(By.cssSelector("span.select2-chosen")).getText();
       String expectedOwner=" Ryder Bradtke";
       Assert.assertEquals(expectedOwner,actualOwner);

   }
    @Test
    public void verifyDate() throws InterruptedException {
        Thread.sleep(2000);
        VyTrackUtils.login(driver,"User155","UserUser123");
        Thread.sleep(3000);
        VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
        Thread.sleep(3000);
        driver.findElement(By.xpath(CreateCalendarEveent)).click();
        Thread.sleep(2000);
        String actualDate=driver.findElement(By.cssSelector("[id^=date_selector_oro_calendar_event_form_s]")).getAttribute("value");
        String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
        Thread.sleep(2000);
        String actualTime=driver.findElement(By.cssSelector("[id^=time_selector_oro_calendar_event_form_st]")).getAttribute("value");
        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        Assert.assertEquals(actualDate,expectedDate);
        Assert.assertEquals(actualTime,expectedTime);

    }


}
