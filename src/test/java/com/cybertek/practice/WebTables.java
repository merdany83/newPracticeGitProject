package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {


   @Test
    public void testTable(){
       WebElement table=driver.findElement(By.id("table1"));
       System.out.println(table.getText());
    }
    @Test
    public void testHeader(){
        WebElement header=driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(header.getText());
    }
    @Test
    public void testRows(){
        String locator="table[id='table1']>tbody tr";
        List<WebElement> rows=driver.findElements(By.cssSelector(locator));
        System.out.println("Size : " +rows.size());
        for (WebElement row:rows)
              {
                  System.out.println(row.getText());

        }
    }
    @Test
    public void testRowsCount(){
        String locator="#table2 tr";
        List<WebElement> rows=driver.findElements(By.cssSelector(locator));
        Assert.assertEquals(5,rows.size());


} @Test
    public void testSpecificRows(){
        int row=3;
       String locator="//table[1]/tbody/tr["+row+"]";
       WebElement rowElement=driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());


}

    @Test
    public void printColumnTets(){
        System.out.println(getColumn("Email"));
    }

    public List<String>getColumn(String columnName){
       List<String>values=new ArrayList<>();
       List<WebElement>headings=driver.findElements(By.xpath("//table[1]//th"));
       int columnNumber=1;
        for (int i = 0; i <headings.size() ; i++) {
            if (headings.get(i).getText().equals(columnName)){
                columnNumber+=i;
               // break;
            } }
        List<WebElement>columnList=driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));
        for (WebElement columnValue:columnList)
             {values.add(columnValue.getText());

        }
        return values;
    }
}
