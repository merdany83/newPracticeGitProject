package com.cybertek.practice;


import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemProperiesTest {

    @Test
    public void test1(){
        String os =System.getProperty("os.name");
        String username =System.getProperty("user.name");
        String javaVersion =System.getProperty("java.version");
        String homeDirectory =System.getProperty("user.home");
        System.out.println(os+"\n"+username+"\n"+javaVersion+"\n"+homeDirectory);
        Properties allProperties=System.getProperties();
        System.out.println();
        for (Map.Entry<Object,Object>property:allProperties.entrySet())
            {
                System.out.println("Key:"+property.getKey()+"\nValue:"+property.getValue());

        }
    }
}
