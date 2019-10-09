package com.cybertek.test_NG_intro;
import org.testng.Assert;
import org.testng.annotations.Test;
public class testDemo {
    @Test
    public void test1(){
       String a="A";
       String b="A";
        Assert.assertEquals(a,b);

    }

    @Test
    public void test2(){
        String a="apple";
        String b="grape";
        Assert.assertEquals(a,b);

    }
    @Test
    public static void test3(){
        String a="ADAF";
        String b="AAA";
        Assert.assertTrue(a.contains(b));
    }
    @Test
    public static void test4(){
        String a="ADAF";
        String b="AAA";
        Assert.assertFalse(a.contains(b));
    }

}
