package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID {
  static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
       // test1();
        test2();
    }

    public static void test1() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login"); //give url
        driver.findElement(By.id("woodenspoon")).click();

      // driver.quit();
}

    public static void test2() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login"); //give url
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

       // WebElement message=driver.findElement(By.className("subheader"));

        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";

        String actualMessage=driver.findElement(By.className("subheader")).getText();

        SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
        driver.findElement(By.linkText("Logout")).click();

//        if (actualMessage.equals(expectedMessage)){
//            System.out.println("Passed");
//        }else{
//            System.out.println("Failed");
//        }


         driver.quit();
    }

}
