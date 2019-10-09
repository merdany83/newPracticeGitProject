package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class VyTrackUtils {
   public static String usernamelocator="prependedInput";
   public static String passwordLocator="prependedInput2";
   public static String loaderMask="div[class='loader-mask shown']";

    static String enterBttn="_submit";


    public static void login(WebDriver driver, String username,String password){
       // WebDriverManager.chromedriver().setup();
       // driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        driver.findElement(By.id(passwordLocator)).sendKeys(password);
        driver.findElement(By.id(enterBttn)).click();
}
    public static void navigatToModule(WebDriver driver, String tab,String module) {
        String tabLocator="//span[contains(text(),'"+tab+"')and@class='title title-level-1']";
        String moduleLocator="//span[contains(text(),'"+module+"')and contains(@class,'title title-level-2')]";
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(tabLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(moduleLocator)).click();
        SeleniumUtils.waitPlease(3);
    }
    public static void waitUntillScreenDisappear(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,20);
      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMask))));
    }
}
