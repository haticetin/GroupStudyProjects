package com.vytrack.pages;

import com.vytrack.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.BrowserUtils.waitFor;


public class SetAndClosePage {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected Actions actions;

    @BeforeMethod
    protected void beforeMethod(){
        //driver = WebDriverFactory.getDriver("chrome");
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
    }

    @AfterMethod
    protected void afterMethod()  {
      //  Thread.sleep(2000);  //!!!!
       // StaticWait.waitLine(2);
       waitFor(2);
       // driver.quit();
       // driver=null;
        Driver.closeDriver();
    }

}
