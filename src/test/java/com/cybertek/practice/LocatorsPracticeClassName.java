package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {

    static WebDriver driver= BrowserFactory.getDriver("chrome");


    public static void  test1(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");

         List<WebElement> examples=driver.findElements(By.className("list-group-item"));
         for (WebElement item:examples) {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
             System.out.println(item.getText());
        }
             System.out.println(examples.size());
        driver.quit();
    }

    public static void  test2() {

        Faker faker = new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.xpath("//*[@type=\"text\"]"));
        fullName.sendKeys(faker.funnyName().name());

        WebElement email = driver.findElement(By.xpath("//*[@type=\"email\"]"));
        email.sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//*[@class=\"radius\"]")).click();

        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";

        String actualResult = driver.findElement(By.xpath("//*[@name=\"signup_message\"]")).getText();
        SeleniumUtils.verifyEquals(expectedResult, actualResult);

    }
    public static void  test3() {

        Faker faker=new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(" http://practice.cybertekschool.com/signup_confirmation");

        WebElement home=driver.findElement(By.id("wooden_spoon"));
        home.click();

        // driver.quit();
    }
    public static void main(String[] args) {
        test3();
    }
}
