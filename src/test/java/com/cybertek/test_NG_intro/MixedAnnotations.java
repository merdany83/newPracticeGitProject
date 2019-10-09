package com.cybertek.test_NG_intro;

import org.testng.annotations.*;

public class MixedAnnotations {

    @BeforeClass
    public void beforClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }

    @AfterClass
    public void afterClass(){

        System.out.println("After Class");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void afterMethod(){

        System.out.println("After Method");
    }
}
