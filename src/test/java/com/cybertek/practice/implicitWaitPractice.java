package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class implicitWaitPractice {
String startLocator="[class='btn btn-primary']";
String helloWorldMsg="#finish";
    static WebDriver driver =  BrowserFactory.getDriver("chrome");
    @BeforeMethod
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }

    @Test
    public void test1(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startLocator)).click();

        System.out.println(driver.findElement(By.cssSelector(helloWorldMsg)).getText());


}
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(startLocator)).click();

        System.out.println(driver.findElement(By.cssSelector(helloWorldMsg)).getText());


    }



}
