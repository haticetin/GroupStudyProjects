package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.StaticWait;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class SetAndClosePage {

   protected WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(){
        //driver = WebDriverFactory.getDriver("chrome");
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    protected void afterMethod()  {
      //  Thread.sleep(2000);  //!!!!
        StaticWait.waitLine(2);
       // driver.quit();
       // driver=null;
        Driver.closeDriver();
    }

}
