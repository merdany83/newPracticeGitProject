package com.cybertek.pages.vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;

public class LoginPage  {
    String userNameLocator="prependedInput";
    String passwordNameLocator="prependedInput2";
    String loginBttnLocator="_submit";


    public void login(String userName, String password){
         Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(userName);
         Driver.getDriver().findElement(By.id(passwordNameLocator)).sendKeys(password);
         Driver.getDriver().findElement(By.id(loginBttnLocator)).click();

     }


}
