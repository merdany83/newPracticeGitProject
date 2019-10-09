package com.cybertek.practice;

import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;



public class SingeltonDriverTest {
    @Test
    public  void test1(){
        Driver.getDriver().get("http://google.com");
        Driver.closeDriver();


    }
}
