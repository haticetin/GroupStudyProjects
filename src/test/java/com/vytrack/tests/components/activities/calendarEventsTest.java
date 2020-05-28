package com.vytrack.tests.components.activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
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
           /*1. Go to “https://qa1.vytrack.com/
            // 2.// 2. Login as a store manager
           3. Navigate to “Activities -> Calendar Events”
           4. Verify that number of calendar events (rows in the table) is equals to number of records*/

    @Test(priority = 3, description = "TestCase #4")


    public void verifyRowsTable() {
        extentLogger = report.createTest(("TestCase #4:Verify Rows in Table"));

        testCaseSameLines();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        String totalRecordText = calendarEventsPage.textOFnumberOfEvents.getText();
        System.out.println(totalRecordText);

        int expectedOfNumberOfEvents = Integer.valueOf(totalRecordText.replaceAll("[^0-9]", ""));

        int actualNumberOfEvents = calendarEventsPage.calculateNumberOfEvents();

        Assert.assertEquals(actualNumberOfEvents, expectedOfNumberOfEvents);

        System.out.println(expectedOfNumberOfEvents);
        System.out.println(actualNumberOfEvents);

       /* @Test
        /*public void testcase4_2() {
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in the table) is equals to number of records
         */
            /*extentLogger = report.createTest("Total Record Number Verification");
            extentLogger.info("Login as a Store Manager");
            new LoginPage().loginAsStoreManager();
            DashboardPage dashboardPage = new DashboardPage();
            extentLogger.info("Navigate to Activities -- Calendar Events");
            dashboardPage.navigateToModule("Activities", "Calendar Events");

            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            //System.out.println(calendarEventsPage.totalRecords.getText());
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            extentLogger.info("Getting the number of rows");
            int rowSizePerPAge = calendarEventsPage.allRows.size();
            extentLogger.info("Getting the total page number");

            String[] s = calendarEventsPage.pageNumberRecord.getText().split(" ");
            String pageNumber = s[1]; //63
            int pageRecordNumber = Integer.parseInt(s[1]);  //63
            extentLogger.info("Getting the row number of last page");
            calendarEventsPage.pageNumber.sendKeys(pageNumber + Keys.ENTER);
           // waitFor(5);
            int totalRowSize = calendarEventsPage.allRows.size() + ((pageRecordNumber-1) * rowSizePerPAge);
            System.out.println(totalRowSize);
            extentLogger.info("Verify actual displayed record number is "+totalRowSize);
            Assert.assertEquals(1559, totalRowSize, "verify displayed total record number is equal to total row number");
            extentLogger.pass("PASS: Calender Events Total Record Test");
        }


    }

}

             */
    }

    @Test(priority = 4, description = "TestCase #5")
    public void verifyEventsSelected() {

        extentLogger = report.createTest(("TestCase #4:Verify all checkbox selected"));

        testCaseSameLines();
        calendarEventsPage.selectCheckBox();

        boolean flag = true;
        int page =0;
        int totalSelectedRecords= 0;
        do {
            for (WebElement selectedElement : calendarEventsPage.getCheckBox()) {
                Assert.assertTrue(selectedElement.isSelected(),"verify checkbox is selected");
                totalSelectedRecords++;
            }
            String firstrow = calendarEventsPage.getListOfRecord().get(1).getText();
            calendarEventsPage.getListOfRecord().clear();
            calendarEventsPage.changePage.click();
            page++;
            BrowserUtils.waitFor(2);
            if(calendarEventsPage.listOfRecord.get(1).getText().equals(firstrow) && totalSelectedRecords==calendarEventsPage.getTotalRecords()
                    && page==calendarEventsPage.getTotalPageInt()){
                flag=false;
            }
        }while (flag);


        System.out.println("page = " + page);
        System.out.println("totalSelectedRecords = " + totalSelectedRecords);
        System.out.println("flag = " + flag);


    }
}
