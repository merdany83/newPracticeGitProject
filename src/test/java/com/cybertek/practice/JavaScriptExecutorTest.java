package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");
    @BeforeMethod
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
        //  driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String title = (String) js.executeScript("return document.title");
        js.executeScript("alert('HELLO MERDAN!')");

        Alert alert=driver.switchTo().alert();
        SeleniumUtils.waitPlease(2);
        alert.accept();
         System.out.println(title);

 }
    @Test
    public static void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        for (int i = 0; i <11 ; i++) {
            js.executeScript("window.scrollBy(0, 250)");
           SeleniumUtils.waitPlease(1);
        }
    }

    @Test
    public static void scrollTest2(){
        driver.get("http://practice.cybertekschool.com");
        WebElement footLink=driver.findElement(By.linkText("Cybertek School"));
        SeleniumUtils.waitPlease(1);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",footLink);
        SeleniumUtils.waitPlease(1);
        js.executeScript("arguments[0].click()",footLink);
        SeleniumUtils.waitPlease(2);

}}
