package com.cybertek.practice;

import com.cybertek.pages.vytrack.CalendarEventsPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarEventsTests extends TestBase{
   CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    @Test
    public void  Test(){
       String username= ConfigurationReader.getProperty("storemanager");
       String password= ConfigurationReader.getProperty("storemanagerpassword");
        VyTrackUtils.login(driver,username,password);

        VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
       // VyTrackUtils.waitUntillScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarEventsPage.createCalendarEventsLocator)).click();
        VyTrackUtils.waitUntillScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarEventsPage.repeatCheckBoxLocator)).click();
        List<String> ecpectedOption= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<String> actualOption= calendarEventsPage.getRepeatOptions();
        System.out.println(ecpectedOption);
        System.out.println(actualOption);
        for (int i = 0; i < ecpectedOption.size(); i++) {
        Assert.assertEquals(actualOption.get(i),ecpectedOption.get(i));
        System.out.println(actualOption.get(i)+"="+ecpectedOption.get(i));

        }}
        @Test
        public void dailyOptionrepeat(){
         String username= ConfigurationReader.getProperty("storemanager");
         String password= ConfigurationReader.getProperty("storemanagerpassword");
         VyTrackUtils.login(driver,username,password);
         VyTrackUtils.navigatToModule(driver,"Activities","Calendar Events");
         driver.findElement(By.cssSelector(calendarEventsPage.createCalendarEventsLocator)).click();
         VyTrackUtils.waitUntillScreenDisappear(driver);



        }
}
