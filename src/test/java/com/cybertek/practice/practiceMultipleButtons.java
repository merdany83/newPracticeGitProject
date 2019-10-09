package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class practiceMultipleButtons {

   static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
    test1();
    }

    public static void test1(){
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
     driver.get("http://practice.cybertekschool.com/multiple_buttons");

   List<WebElement> buttons=driver.findElements(By.tagName("button"));

        for (WebElement button:buttons) {
            System.out.println(button.getText());
            button.click();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }


    }
}
