package com.cybertek.test_NG_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(){
      driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @Test
    public void test1(){
       int ExpectedYear=2019;
       String ExpectedMonth="September";
       int ExpectedDay=30;
       Select Year=new Select(driver.findElement(By.id("year")));
       Select Month=new Select(driver.findElement(By.id("month")));
       Select Day=new Select(driver.findElement(By.id("day")));
        int actualYear=Integer.parseInt(Year.getFirstSelectedOption().getText());
        String actualMonth=Month.getFirstSelectedOption().getText();
        int actualDay=Integer.parseInt(Day.getFirstSelectedOption().getText());

        Assert.assertEquals(ExpectedYear,actualYear);
        Assert.assertEquals(ExpectedMonth,actualMonth);
        Assert.assertEquals(ExpectedDay,actualDay);


    }
    @AfterMethod
    public void tearDown(){
       driver.quit();
}
}
