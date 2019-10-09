package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathPractice {

    WebDriver driver = BrowserFactory.getDriver("chrome");
   Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
     driver.manage().window().maximize();
     driver.get("http://practice.cybertekschool.com/sign_up");

    }
    @Test
    public void test1(){
     driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input[@name='full_name']")).sendKeys(faker.funnyName().name());
     driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[2]/div/input[@name='email']")).sendKeys(faker.internet().emailAddress());
     driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button")).click();
     String expectedMessaege="Thank you for signing up. Click the button below to return to the home page.";
     String actualMessage=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/h3")).getText();
        Assert.assertEquals(expectedMessaege,actualMessage);
    }

    @Test
    public void negativeTest(){

        String expectedLink=driver.getCurrentUrl();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input[@name='full_name']")).sendKeys(faker.funnyName().name());
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[2]/div/input[@name='email']")).sendKeys("email");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button")).click();
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink,expectedLink);


    }




//    @AfterMethod
//    public void teradown(){
//    driver.quit();
//    }
}
