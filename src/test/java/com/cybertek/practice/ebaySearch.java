package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ebaySearch {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        ebay();
    }

    public static void ebay() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com");
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Java Book", Keys.ENTER);

       String result=driver.findElement(By.xpath("//h1/span[1]")).getText();

       System.out.println(result);

       driver.close();
    }
}