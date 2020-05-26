package com.vytrack.pages.DeadPages;

import com.vytrack.utilities.DeadPool.ExplicitlyWait;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VytrackUtilities {

    public static void navigateToModulePage ( String moduleName, String pageName ) {
        WebDriver driver = Driver.get();
        WebElement module = driver.findElement(By.xpath("//a//span[contains(text(),'" + moduleName + "')]"));
        WebElement page = driver.findElement(By.xpath("//span[.='" + pageName + "']"));

        Actions action = new Actions(driver);
        action.moveToElement(module).perform();

        page.click();

        expWait_Loader();
    }


    public static void expWait_Loader(){
        WebDriver driver = Driver.get();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loader= driver.findElement(By.cssSelector(".loader-mask>.loader-frame"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
    }


    public static void verifyTitleSubtitle (String expectedTitle, String expectedSubtitle) {

        WebDriver driver = Driver.get();

        ExplicitlyWait.waitTitle(expectedTitle);

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualSubtitle = driver.findElement(By.xpath("(//h1)[2]")).getText();
        Assert.assertEquals(expectedSubtitle, actualSubtitle);
    }

}
