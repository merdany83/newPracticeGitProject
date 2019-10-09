package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import cucumber.api.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JavaScriptActions {

    static WebDriver driver = BrowserFactory.getDriver("chrome");
    String figure1="//img[1]";
    String figure1Text="//a[@href='/users/1']/preceding-sibling::h5";
    String enabled="ui-id-3";
    String download="ui-id-4";
    String pdf="(//*[@class='ui-menu-item'])[4]";
    String Moon="draggable";
    String Earth="droptarget";
    @BeforeMethod
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/hovers");
          Actions action = new Actions(driver);
          action.moveToElement(driver.findElement(By.xpath(figure1))).perform();
          String expectedText="name: user1";
          String actualText=driver.findElement(By.xpath(figure1Text)).getText();
          System.out.println(actualText);
          Assert.assertEquals(actualText,expectedText);

    }

   @Test
    public void test2(){
       driver.get("http://practice.cybertekschool.com/hovers");
       Actions action = new Actions(driver);
       List<WebElement> images=driver.findElements(By.tagName("img"));
       for (WebElement image:images)
             {driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
             action.moveToElement(image).perform();

       }

   }
   @Test
   public void test3(){
       driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
       Actions action=new Actions(driver);
       WebElement enabledElement=driver.findElement(By.id(enabled));
       WebElement downloadElement=driver.findElement(By.id(download));
       WebElement pdfElement=driver.findElement(By.xpath(pdf));
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       action.moveToElement(enabledElement);
       action. pause(1000).moveToElement(downloadElement).
               pause(1000).moveToElement(pdfElement).
               build().
               perform();


    }
    @Test
    public void test4() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       Actions action=new Actions(driver);
       WebElement moon=driver.findElement(By.id(Moon));
       WebElement earth=driver.findElement(By.id(Earth));
        Thread.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
       action.dragAndDrop(moon, earth).perform();
        WebDriverWait wait=new WebDriverWait(driver ,10);
        wait.until(ExpectedConditions.visibilityOf(earth));
       String expectedMessage="You did great!";
       String actualMessage=earth.getText();

       Assert.assertEquals(actualMessage,expectedMessage);



    }




}