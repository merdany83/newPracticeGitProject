package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CssPractice {

    WebDriver driver= BrowserFactory.getDriver("chrome");
    String button1 ="[onclick='button1()']";
    String button2 =".btn.btn-primary:nth-of-type(2)";
    String button3 ="[id^='button_']";
    String button4 ="[id$='_button'][onclick='button4()']";
    String button5 ="[onclick*='button5()']";
    String button6="#disappearing_button";



    @BeforeMethod
    public void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    }
    @Ignore
    @Test
    public void test1() {
        System.out.println(driver.findElement(By.cssSelector(button1)).getText());


    }
    @Test
    public void test2(){
        System.out.println( driver.findElement(By.cssSelector(button2)).getText());
    }





    @AfterMethod
    public void tearDown(){
        driver.quit();

    }


}
