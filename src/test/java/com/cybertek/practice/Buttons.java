package com.cybertek.practice;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import com.google.gson.stream.JsonToken;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buttons {
    static WebDriver driver =  BrowserFactory.getDriver("chrome");

    public static void radiobttnpage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    public static void radiobttn() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement blueBttn=driver.findElement(By.id("blue"));
       if (blueBttn.isSelected()){
           System.out.println("Passed");
       }else {
           System.out.println("Failed");
       }


     }

    public static void radiobttnSelected() {

       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       List<WebElement> allBttns=driver.findElements(By.xpath("//input[@type='radio']"));
         int counter=0;
        for (WebElement each:allBttns) {

            if (each.isSelected()) {
               counter++;
                System.out.println("selected");
            } else {
                System.out.println("not selected");
            }
        }
               System.out.println(counter);
    }

    public static void checkBoxes() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1=driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        if(!checkbox1.isSelected()&&checkbox2.isSelected()){
            System.out.println("passed");
        }else {
            System.out.println("somthing wrong");
        }


    }


    public static void xpathPractice() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button[1]"));
//    String buttonText=button1.getText();
//    System.out.println(buttonText);
        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class='btn btn-primary']"));

        System.out.println(buttons.size());
        for (WebElement byoneby : buttons) {
            System.out.println(byoneby.getText());

        }

    }
        public static void dropDown(){
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/dropdown");
         WebElement dropdown=driver.findElement(By.id("dropdown"));
         WebElement element=driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
         SeleniumUtils.verifyIsDisplayed(element);
            Select dropdownSelect=new Select(dropdown);
            String actual=dropdownSelect.getFirstSelectedOption().getText();
            String expected="Please select an option";
            SeleniumUtils.verifyEquals(actual,expected);

       }

    public static void dropDownList(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select dropdownSelect=new Select(dropdown);
        List<WebElement> options=dropdownSelect.getOptions();
        for (WebElement option:options) {
            if(option.getText().equals("Option 1")) {
                option.click();
            }

        }
    }
    public static void dropDownAction() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select dropdownState = new Select(dropdown);
//        List<WebElement>stetes=dropdownState.getOptions();
//
//        for (WebElement state:stetes) {
//            System.out.println(state.getText());
//         }

        dropdownState.selectByVisibleText("Texas");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        dropdownState.selectByVisibleText("California");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        dropdownState.selectByVisibleText("Washington");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        dropdownState.selectByVisibleText("Kansas");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        dropdownState.selectByVisibleText("Florida");
        List<WebElement>stetes=dropdownState.getOptions();
        for (WebElement state:stetes) {
            dropdownState.selectByVisibleText(state.getText());
        }
    }
    public static void dropDownAction1() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select dropdownState = new Select(dropdown);
        List<WebElement>stetes=dropdownState.getOptions();
        for (WebElement state:stetes) {
            dropdownState.selectByValue("WA");
        }

        String expected="Washington";
        String actual=dropdownState.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected,actual);

    }
    public static void dropDownByIndex() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select dropdownState = new Select(dropdown);
        dropdownState.selectByIndex(5);
        String expected="California";
        String actual=dropdownState.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected,actual);


    }
    public static void dropDownMultiple() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownMultipleSelection = driver.findElement(By.cssSelector("[name='Languages']"));
        Select dropdownState = new Select(dropdownMultipleSelection);
        dropdownState.selectByVisibleText("Java");
        dropdownState.selectByVisibleText("JavaScript");



    }
   public static void main(String[] args) {

       //   radiobttnpage();
       //   radiobttn();
       //   radiobttnSelected();
       //   checkBoxes();
       //   xpathPractice();
       //   dropDown();
       //   dropDownList();
       //   dropDownAction();
       //  dropDownAction1();
       // dropDownByIndex();
       dropDownMultiple();

    }


}
