package com.SeleniumAssigments.HomeworkDay10.tests;

import com.SeleniumAssigments.HomeworkDay10.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class TestCase_6 {
    WebDriver driver=null;
    @BeforeMethod
    public void before() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod

    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testCase6() throws InterruptedException {
//        Step 1. Go to "https://www.tempmailaddress.com/"
//        Step 2. Copy and save email as a string.
//        Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
//        Step 4. And click on “Sign Up For Mailing List".
//        Step 5. Enter any valid name.
//        Step 6. Enter email from the Step 2.
//        Step 7. Click Sign Up
//        Step 8. Verify that following message is displayed:“Thank you for signing up. Click the button below to return to the home page.”
//        Step 9. Navigate back to the “https://www.tempmailaddress.com/”
//        Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
//        Step 11. Click on that email to open it.
//        Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
//        Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        Faker fake = new Faker();
        driver.get("https://www.fakemail.net/");
      //  WebElement copyButton =   driver.findElement(By.xpath("//a[@class='color cetc hidden-desktop']"));
      //  WebDriverWait wait = new WebDriverWait(driver,10);
      //  wait.until(ExpectedConditions.elementToBeClickable(copyButton));
     //((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", copyButton);

       //Actions action = new Actions(driver);
      // action.moveToElement(copyButton).perform();
     //  copyButton.click();
        // a[class='color cetc']  click copy için !!
        String email =driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/sign_up\"]")).click();  // yada linkText al!!
        driver.findElement(By.name("full_name")).sendKeys(fake.name().fullName());
        driver.findElement(By.name("email")).sendKeys(email );   // use ctrl v
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage ="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.name("signup_message"));
        String actualMessage = message.getText();
        // STEP 8 VERIFY
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(message.isDisplayed(), "Expected message is displayed");
        Thread.sleep(2000);
        driver.navigate().to("https://www.fakemail.net/");
        Thread.sleep(1000);

        String expectedFrom ="do-not-reply@practice.cybertekschool.com";
        //WebElement mailFrom = driver.findElement(By.xpath("(//span[@class='odMobil']) [1]"));  //error
       // WebElement mailFrom = driver.findElement(By.xpath("(//*[@class=\"glyphicon glyphicon-envelope\"])[1]"));  //error
        //WebElement mailFrom = driver.findElement(By.xpath("(//span[@class=\"odMobil\"])[1]"));  //error
        WebElement mailFrom = driver.findElement(By.xpath("(//tr/td)[1]"));
        //WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOf(mailFrom));
        String actualFrom = mailFrom.getText().trim();
        // STEP 10 VERIFY
        Assert.assertEquals(actualFrom,expectedFrom);
        Assert.assertTrue(mailFrom.isDisplayed(), "New email is displayed");

        driver.findElement(By.xpath("(//*[@class='from'])[1]")).click();
        String actualFromInMail = driver.findElement(By.id("odesilatel")).getText();
        // STEP 12 VERIFY
        Assert.assertEquals(actualFromInMail,expectedFrom);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();

        // STEP 13 VERIFY
        Assert.assertEquals(actualSubject,expectedSubject);


    }
}
