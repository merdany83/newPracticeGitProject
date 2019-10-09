package com.cybertek.practice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class checkboxes {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();//setup webdriver

        WebDriver driver =new ChromeDriver();// create object of chromedriver
        driver.manage().window().maximize();//maximize window
        driver.get("http://practice.cybertekschool.com/forgot_password"); //give url


        WebElement emailInputBox=driver.findElement(By.name("email"));//input box
        WebElement submitBtn= driver.findElement(By.id("form_submit"));// submit button
      //emailInputBox.sendKeys("email@gmail.com");// enter text  input box

        Faker faker =new Faker();

        String name=faker.pokemon().name().replace(" ","").toLowerCase();
        Thread.sleep(2000);
        emailInputBox.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        emailInputBox.clear();

        Thread.sleep(2000);
        emailInputBox.sendKeys("email@gmail.com",Keys.ENTER);// enter text  input box


        // emailInputBox.sendKeys(name+"@gmail.com", Keys.ENTER);
       // emailInputBox.sendKeys("email@gmail.com"+Keys.ENTER);// enter text to input box + press Enter
      //submitBtn.click();//clicking submit button


        Thread.sleep(2000);
        WebElement message=driver.findElement(By.name("confirmation_message"));

        String actulaMessage=message.getText();

        //verify that expected message is the same with actual
        if (actulaMessage.equals("Your e-mail's been sent!"))
    {
            System.out.println("Good to go");
        }

        driver.quit();

    }
}
