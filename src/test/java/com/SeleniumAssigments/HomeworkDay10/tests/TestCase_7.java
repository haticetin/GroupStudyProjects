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

public class TestCase_7 {
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
    public void testCase7() {
//        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//        Step 2. And click on “File Upload".
//        Step 3. Upload any file with .txt extension from your computer.
//        Step 4. Click “Upload” button.
//        Step 5. Verify that subject is: “File Uploaded!”
//        Step 6. Verify that uploaded file name is displayed.
//        Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='File Upload']")).click();
        // linkText de olabilir
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //chooseFile.sendKeys("C:\\Users\\ASUS\\Downloads\\test.txt");
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/file.txt";

        String filePath = projectPath+ "/" + relativePath;
        chooseFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        // STEP 5 Verify
        String expectedSubject = "File Uploaded!";
        String actualSubject = driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();

        Assert.assertEquals(actualSubject,expectedSubject);

        //STEP 6 Verify
        WebElement uploadFileName= driver.findElement(By.id("uploaded-files"));
        String expectedFileName = "file.txt";
        String actualFileName = uploadFileName.getText();
        Assert.assertTrue(uploadFileName.isDisplayed());
        Assert.assertEquals(actualFileName,expectedFileName);

    }
}