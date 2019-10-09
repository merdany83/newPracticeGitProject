package com.cybertek.practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.pages.vytrack.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage=new LoginPage();
    @Test
    public void loginTest1(){
        String username= ConfigurationReader.getProperty("username");
        String password= ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }


}
