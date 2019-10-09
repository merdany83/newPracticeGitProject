package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AmazonSearch {
    static WebDriver driver =  BrowserFactory.getDriver("chrome");

    public static void amazon() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

        WebElement searchButton=driver.findElement(By.id("twotabsearchtextbox"));
        searchButton.sendKeys("book");
        driver.findElement(By.xpath("//*[@value=\"Go\"]")).click();
        String title=driver.getTitle();
        System.out.println(title);
        if (title.contains("Book")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }

    public static void wikipedia() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        String url=driver.getCurrentUrl();
        System.out.println(url);
        if (url.endsWith(")")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }

    public static void main(String[] args) {

       // amazon();
          wikipedia();

    }
}