package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MultipleButtonWithXpath {

    static WebDriver driver = BrowserFactory.getDriver("chrome");
    String buttonthree="//button[starts-with(@id,'button_')]";
    String buttonfour="//button[contains(text(),'Button 4')]";
    String buttonfive="//button[5]";
    String buttonsix="//button[@id='disappearing_button']";

    String result="//p[@id='result']";
    @BeforeMethod
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

}

    @Test
    public void test3(){
        String expectedMessage="Clicked on button three!";
        driver.findElement(By.xpath(buttonthree)).click();
        String actualMessage=driver.findElement(By.xpath(result)).getText();
        assertEquals(expectedMessage,actualMessage);

}
    @Test
    public void test4() {
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(buttonfour)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void test5() {
        String expectedMessage = "Clicked on button five!";
        driver.findElement(By.xpath(buttonfive)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void test6() {
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(buttonsix)).click();
        String actualMessage = driver.findElement(By.xpath(result)).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        assertTrue(driver.findElements(By.xpath(buttonsix)).size()==0);
    }

    @Test
    public void allButtons() {
        List<WebElement> all=driver.findElements(By.xpath("//button"));
        for (WebElement button:all) {
            button.click();
            System.out.println(driver.findElement(By.xpath(result)).getText());
        }
    }

//        @AfterMethod
//    public void teardown(){
//        driver.quit();
//}
}
