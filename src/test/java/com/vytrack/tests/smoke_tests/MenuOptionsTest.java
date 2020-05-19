package com.vytrack.tests.smoke_tests;

import com.vytrack.pages.LoginPage_GS;
import com.vytrack.pages.SetAndClosePage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.NavigateToPage;
import com.vytrack.utilities.StaticWait;
import org.testng.annotations.Test;

public class MenuOptionsTest extends SetAndClosePage {
    //WebDriver driver; KULLANMA !!

    @Test (description = "Menu options, driver")
    public void test1_driver() throws InterruptedException {

        // Driver login home page
//        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));
//        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password"));
//        driver.findElement(By.id("_submit")).click();

        LoginPage_GS.userLogin(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));

        NavigateToPage.navigateToModulePage("Fleet","Vehicles");

        StaticWait.waitLine(10);




    }
}
