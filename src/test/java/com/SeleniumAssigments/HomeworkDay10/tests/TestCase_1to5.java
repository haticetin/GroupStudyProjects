package com.SeleniumAssigments.HomeworkDay10.tests;

import com.SeleniumAssigments.HomeworkDay10.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCase_1to5 {

    WebDriver driver=null;
    @BeforeMethod
    public void before() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //The implicit wait will tell to the web driver to wait for a certain amount of time before it throws a "No Such Element Exception". The default setting is 0
        //The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or the maximum time exceeded before throwing an "ElementNotVisibleException" exception.
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
    }
    @AfterMethod

    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testCase1() throws InterruptedException {
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Enter “wrong_dob” into date of birth input box.
//        Step 4. Verify that warning message is displayed: “The date of birth is not valid”

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String expectedMessage = "The date of birth is not valid";
        String actualMessage=null;
       WebElement warningMessage= driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
       actualMessage = warningMessage.getText();
       Assert.assertTrue(warningMessage.isDisplayed(), "Warning message is displayed");
       Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void testCase2(){
//        Step 1. Go to “https://practicecybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

       WebElement c_Cbox = driver.findElement(By.xpath("//*[.='C++']"));
       WebElement java_Cbox = driver.findElement(By.xpath("//*[.='Java']"));
       WebElement JavaScript_Cbox = driver.findElement(By.xpath("//*[.='JavaScript']"));

       Assert.assertTrue(c_Cbox.isDisplayed()," c++ is displayed");
       Assert.assertTrue(java_Cbox.isDisplayed()," Java is displayed");
       Assert.assertTrue(JavaScript_Cbox.isDisplayed()," JavaScript is displayed");
    }

    @Test
    public void testCase3(){
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Enter only one alphabetic character into first name input box.
//        Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("firstname")).sendKeys("a");

        WebElement firstnameWarning = driver.findElement(By.xpath("//*[@data-bv-for='firstname'][2]"));
        String actualMessage = firstnameWarning.getText();


        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(firstnameWarning.isDisplayed(),"firstnameWarning is displayed");

    }

    @Test
    public void testCase4(){
//        Step 1. Go to https://practice-cybertekschool.herokuapp.com
//        Step 2. Click on “Registration Form”
//        Step 3. Enter only one alphabetic character into last name input box.
//        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("lastname")).sendKeys("a");

        WebElement lastnameWarning = driver.findElement(By.xpath("//*[@data-bv-for='lastname'][2]"));
        String actualMessage = lastnameWarning.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(lastnameWarning.isDisplayed(),"lastnameWarning is displayed");
    }
    @Test
    public void testCase5() throws InterruptedException {
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//        Step 2. Click on “Registration Form”
//        Step 3. Enter any valid first name
//        Step 4. Enter any valid last name.
//        Step 5. Enter any valid user name.
//        Step 6. Enter any valid password.
//        Step 7. Enter any valid phone number.
//        Step 8. Select gender.
//        Step 9. Enter any valid date of birth.
//        Step 10. Select any department.
//        Step 11. Enter any job title.
//        Step 12. Select java as a programming language.
//        Step 13. Click Sign up.
//        Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
        Faker fake = new Faker();
        driver.findElement(By.name("firstname")).sendKeys(fake.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(fake.name().lastName());
        driver.findElement(By.name("username")).sendKeys("talha43gs");
        driver.findElement(By.name("email")).sendKeys(fake.internet().emailAddress());
        driver.findElement(By.name("password")).sendKeys(fake.internet().password(8,9));
        driver.findElement(By.name("phone")).sendKeys("123-321-1234");
        driver.findElement(By.cssSelector("*[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("09/16/1988");

        WebElement dropdownElement1 = driver.findElement(By.name("department"));
        Select officeDropdown = new Select(dropdownElement1);
        officeDropdown.selectByVisibleText("Tresurer's Office");  // sec click yap


        WebElement dropdownElement2 = driver.findElement(By.name("job_title"));
        Select jobDropdown = new Select(dropdownElement2);
        jobDropdown.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        // Verify
        String expectedMessage = "You've successfully completed registration!";
        WebElement message = driver.findElement(By.tagName("p"));
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(message.isDisplayed(),"Message is displayed");

    }
}
