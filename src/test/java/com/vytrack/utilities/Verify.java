package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Verify {

    public static void verifyTitleSubtitle(String  expectedTitle, String expectedSubtitle){

        WebDriver driver=Driver.get();

        ExplicitlyWait.waitTitle(expectedTitle);

        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        String actualSubtitle=driver.findElement(By.xpath("(//h1)[2]")).getText();
        Assert.assertEquals(actualSubtitle,expectedSubtitle);


    }

}
