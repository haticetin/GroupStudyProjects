package com.vytrack.tests.components.activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class calendarEventsTest extends TestBase {
    //Vytrack HomeWork

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    public void testCaseSameLines() {

        extentLogger.info("username: " + "storemanager");
        extentLogger.info("password: " + "UserUser123");

        // i added  loader wait ib login method so i dont need wait extra
        extentLogger.info("Login as a Store Manager");
        loginPage.loginAs("storemanager");

        extentLogger.info("Navigate to Activities -> Calendar Events");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        calendarEventsPage.waitUntilLoaderScreenDisappear();
    }

    @Test(priority = 0, description = "TestCase #1")
    public void calendarEventsOptionTest() {

        extentLogger = report.createTest("TestCase #1: Calendar Events Option Display");

        testCaseSameLines();

        extentLogger.info("Verify subtitle Option is displayed");
        Assert.assertTrue(calendarEventsPage.options.isDisplayed(), "Option is displayed");

        extentLogger.pass("PASS: TestCase #1 Calendar Events Option Display ");
    }


    @Test(priority = 1, description = "TestCase #2")
    public void calendarEventsPageNumberTest() {

        extentLogger = report.createTest("TestCase #2:Calendar Events Option Page Number Verification");

        testCaseSameLines();

        extentLogger.info("Verify that page number is equals to \"1\"");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), "1");

        extentLogger.pass("PASS: TestCase #2 Calendar Events Option Page Number Verification");
    }

    @Test(priority = 2, description = "TestCase #3")
    public void verifyPageNumberTest() {

        extentLogger = report.createTest("TestCase #2:Calendar Events Option Page Number Verification");

        testCaseSameLines();

        extentLogger.info("Verify that view per page number is equals to \"25\"");

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.viewPerPage.getText().trim(), "25");

        extentLogger.pass("PASS: TestCase #2 Calendar Events view per page number Verification");


    }

}
