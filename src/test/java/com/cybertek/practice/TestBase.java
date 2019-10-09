package com.cybertek.practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
   public WebDriver driver;
   public Actions action;


    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        action=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("urlp"));

    }
    @AfterMethod
    public void tearDown(){

       // Driver.closeDriver();
    }


}
