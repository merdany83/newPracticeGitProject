package com.cybertek.pages.vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage {
   private WebDriver driver= Driver.getDriver();
  public  String createCalendarEventsLocator="a[title^='Create Calendar']";
  public  String repeatCheckBoxLocator="[id^='recurrence-repeat-']";
  public  String repeatDropDownLocator="[id^='recurrence-repeats-']";




   public List<String> getRepeatOptions(){

   Select select=new Select(driver.findElement(By.cssSelector(repeatDropDownLocator)));
   List<WebElement>options=select.getOptions();
      List<String>optionsText =new ArrayList<>();

      for (WebElement option:options) {
         optionsText.add(option.getText());

      }
     return optionsText;
  }
}