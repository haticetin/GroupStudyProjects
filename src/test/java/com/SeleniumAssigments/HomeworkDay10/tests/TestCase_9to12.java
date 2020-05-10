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

public class TestCase_9to12 {
    WebDriver driver=null;
    @BeforeMethod
    public void before() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();

    }
    @AfterMethod

    public void after() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider(name = "codes")
    public Object[][] createData() {
        //Object[][] codes = { {"200"},{"301"},{"404"},{"500"} };
        return new Object[][] { {"200"},{"301"},{"404"},{"500"}
//                 { new String("200") },
//                { new String("301") },
//                { new String("404") },
//                { new String("500") },
//               // { new String("900") } // if we put unvalid data, just this  test run failures!!
        };
    }


    @Test (dataProvider = "codes")
    public void testCase9to12(String str) {
//        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
//        Step 2. And click on “Status Codes”.
//        Step 3. Then click on “****”.
//        Step 4. Verify that following message is displayed:“This page returned a **** status code”

        driver.findElement(By.linkText(str)).click();

        String expectedMessage= "This page returned a "+str+" status code.";
        WebElement message= driver.findElement(By.xpath("//p[contains(text(),'This page returned a "+str+" status code.')]"));
        String actualMessage = message.getText().substring(0,37);

        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(message.isDisplayed(), "Result message is displayed");

        System.out.println("\"" + str + "\" Status Codes value is tested");
    }
}
