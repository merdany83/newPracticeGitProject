package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {


    String startLocator = "[class='btn btn-primary']";
    String helloWorldMsg = "#finish";
    String userName = "#username";
    String password = "#pwd";
    String submmitBttn = "button[type='submit']";


    static WebDriver driver = BrowserFactory.getDriver("chrome");

    @BeforeMethod
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        //  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(startLocator)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(userName))));
        driver.findElement(By.cssSelector(userName)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(password)).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector(submmitBttn)).click();


    }

    @Test
    public void waitForElementToBeClickable() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebDriverWait wait=new WebDriverWait(driver,10);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("form[id='checkbox-example']"))));
        driver.findElement(By.cssSelector("form[id='checkbox-example']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("form[id='checkbox-example']"))));
        driver.findElement(By.cssSelector("form[id='checkbox-example']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("form[id='checkbox-example']"))));
        System.out.println(driver.findElement(By.cssSelector("form[id='checkbox-example']")).getText());
}
}
