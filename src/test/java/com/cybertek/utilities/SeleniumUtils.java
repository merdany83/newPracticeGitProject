package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 2000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
public static void verifyEquals(String expectedResult, String actualResult){
 if (expectedResult.equals(actualResult)){
        System.out.println("Passed");
    }else{
        System.out.println("failed");
        System.out.println("Expected result "+expectedResult);
        System.out.println("Actual result "+actualResult);
         }
}

public static void openPage(String page, WebDriver driver){

    List<WebElement> listOfExamples=driver.findElements(By.tagName("a"));
    for (WebElement example :listOfExamples){
        if (example.getText().contains(page)){
            example.click();
            break;
        }
    }

}
public static void  verifyIsDisplayed(WebElement element){
    if (element.isDisplayed()){
        System.out.println("Passed");
        System.out.println(element.getText());
    }else{
        System.out.println("Failed");
        System.out.println(element.getText());
    }
}

public static void click(WebDriver driver,By by, int attempts) {
    int counter=0;

  while (counter<attempts){
   try{
    driver.findElement(by).click();
    break;
   }catch (WebDriverException e){
       System.out.println(e);
       System.out.println(++counter);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
}}

}


