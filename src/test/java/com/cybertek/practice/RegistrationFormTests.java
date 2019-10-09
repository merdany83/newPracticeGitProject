package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormTests {
    WebDriver driver= BrowserFactory.getDriver("chrome");



    @BeforeMethod
    public void setup(){


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");

    }
    @Test
    public void test1() {
       Select select=new Select(driver.findElement(By.cssSelector("[name='department']")));
        List<WebElement> options=select.getOptions();
        for (WebElement option:options)
              {
            System.out.println( option.getText());
              }


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
