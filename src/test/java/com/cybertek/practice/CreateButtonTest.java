package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateButtonTest {

    WebDriver driver;
String createButtonLocator="//*[@class='oro-subtitle']";
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
        driver.quit();

    }


    @Test
    public void  storeManagerTest() throws InterruptedException {
        VyTrackUtils.login(driver,"storemanager88","UserUser123");
         driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        VyTrackUtils.navigatToModule(driver,"Activities","Calls");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath(createButtonLocator)).getText());

    }

}