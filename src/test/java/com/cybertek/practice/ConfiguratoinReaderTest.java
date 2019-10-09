package com.cybertek.practice;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfiguratoinReaderTest {
    @Test
    public void test1(){
        String excpectedBrowser="chrome";
        String actualBrowser= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,excpectedBrowser);
    }
}
