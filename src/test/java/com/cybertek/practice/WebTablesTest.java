package com.cybertek.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTablesTest extends TestBase {



    public int countOfRows(){

        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    public int countOfRows(By by){

        return driver.findElements(by).size();
    }
     @Test
    public void countOfRowsTest1(){

         Assert.assertEquals(countOfRows(),5,"Number of rows doesn't match");
    }
    @Test
    public void countOfRowsTest2(){

        Assert.assertEquals(countOfRows(By.xpath("//table[1]//tr")),5,"Number of rows doesn't match");
    }
    public int countOfColumns(){

        return driver.findElements(By.cssSelector("#table1 th")).size();
    }
    public int countOfColumns(By by){

        return driver.findElements(by).size();
    }
    @Test
    public void countOfColumnsTest(){

        Assert.assertEquals(countOfColumns(By.cssSelector("#table1 th")),6,"Number of columns doesn't match");
    }
    @Test
    public void countOfColumnsTest2(){

        Assert.assertEquals(countOfColumns(),6,"Number of columns doesn't match");
    }
    public int[] tableSize(){
        int[] size={countOfRows(),countOfColumns()};

        return size;
    }


    public int[] tableSize(By rowLocator,By columnLocator){
        int[] size={countOfRows(rowLocator),countOfColumns(columnLocator)};

        return size;
    }
    @Test
    public void tableSizeTest(){
        int[] expectedSize={5,6};
        int[] actualSize=tableSize();
        Assert.assertEquals(actualSize,expectedSize,"Table size doesn't match");

    }
    @Test
    public void tableSizeTes2(){
        int[] expectedSize={5,6};
        int[] actualSize=tableSize(By.xpath("//table[1]//tr"),By.xpath("//table[1]//th"));
        Assert.assertEquals(actualSize,expectedSize,"Table size doesn't match");

    }

   public List<WebElement> getHeaders(){

        return driver.findElements(By.cssSelector("#table1 th"));

    }
    public List<String> getHeaderstext(){
        List<String>headers=new ArrayList<>();
        for (WebElement tableHeader:getHeaders())
             {headers.add(tableHeader.getText());

        }
        return headers;

    }

    @Test
    public void getHeaderTest(){
        List<String>expectedColumnName= Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");

        Assert.assertEquals(getHeaderstext(),expectedColumnName);
    }


    @Test
    public void sortColumn(){
        driver.findElement(By.xpath("//table[1]//th//span[text()='First Name']")).click();
        System.out.println(getColumnData("First Name"));
    }

    public List<String>getColumnData(String columnName){
        int columnNumber=0;
        for (int i = 0; i <countOfColumns() ; i++) {
            if (columnName.equals(getHeaderstext().get(i))){
                columnNumber=i+1;
            }
        }
        String locatorForColumn="//table[1]//tbody//tr//td["+columnNumber+"]";
        List<WebElement> columnCollection=driver.findElements((By.xpath(locatorForColumn)));
        List<String>columnCollectionText=new ArrayList<>();
        for (WebElement element:columnCollection) {
          columnCollectionText.add(element.getText()) ;
        }
    return columnCollectionText;
    }
    
}
