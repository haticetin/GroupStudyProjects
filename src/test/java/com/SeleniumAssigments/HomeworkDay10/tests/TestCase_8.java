package com.SeleniumAssigments.HomeworkDay10.tests;

import com.SeleniumAssigments.HomeworkDay10.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_8 {
    WebDriver driver=null;
    @BeforeMethod
    public void before() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod

    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase8() {
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//        Step 2. And click on “Autocomplete”.
//        Step 3. Enter “United States of America” into country input box.
//        Step 4. Verify that following message is displayed:“You selected: United States of America”
//

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        WebElement result = driver.findElement(By.id("result"));
        String expectedResult = "You selected: United States of America";
        String actulaResult = result.getText();

        Assert.assertEquals(actulaResult,expectedResult);
        Assert.assertTrue(result.isDisplayed(), "Expected result is displayed");


    }
}
