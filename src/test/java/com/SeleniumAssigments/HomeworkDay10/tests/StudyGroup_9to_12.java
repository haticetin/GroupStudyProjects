package com.SeleniumAssigments.HomeworkDay10.tests;

import com.SeleniumAssigments.HomeworkDay10.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StudyGroup_9to_12 {
    //        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
   //        Step 2. And click on “Status Codes”.
  //        Step 3. Then click on “****”.200 301 404 500    // 900 olmadığını test edelim
 //        Step 4. Verify that following message is displayed:“This page returned a **** status code”

    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        //driver.findElement(By.xpath("//a[.='Status Codes']"));
    }

    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider (name ="codes")
    public Object[] createCodes(){
     Object[] codes= {"200","301","404","900","500"};    // 1 tane hata verecek case ekledik 900!!
        // icinde arayler tutan aray lazm / yada tek array
        return codes;
        // return {200,301,404,500};  // easy way
//        return new Object[] {
//                new String("200"),
//                new String("300")  ....
//        }
    }

    @Test (dataProvider = "codes")
    public void test9_12(String value){

        driver.findElement(By.linkText(value)).click();

        WebElement message = driver.findElement(By.xpath("//p[contains(text(),' "+ value +" ')]"));
        //String actualMesaage = message.getText().substring(0,37);  direct manuel WAY!!
        String actualMesaage2 = message.getText();
        int index = actualMesaage2.indexOf(".");
        actualMesaage2= actualMesaage2.substring(0,index+1);

        String expectedMessage= "This page returned a "+value+" status code.";

        Assert.assertEquals(actualMesaage2,expectedMessage);
        Assert.assertTrue(message.isDisplayed());

        // 4 tane başarılı 1 basarısz test olacak teyit et !!!
    }
}
