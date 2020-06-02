package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy (xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement options;

    @FindBy (css = ".input-widget")
    public WebElement pageNumber;

    @FindBy(xpath ="//*[contains(@class,'btn dropdown-toggle')]")
    public WebElement viewPerPage;

    @FindBy (css = "table tr.grid-row")
    public WebElement allRows;

    @FindBy (css = ".fa-chevron-right.hide-text")
    public WebElement nextPageLink;

    @FindBy (xpath = "//*[@class='dib'][2]")
    public WebElement totalPage;

    @FindBy (xpath = "//*[@class='dib'][3]")
    public WebElement totalRecords;

    @FindBy (xpath = "//button//input")
    public WebElement allCheckbox;

    @FindBy (css = ".grid-body-cell-title")
    public WebElement titleCells;

    @FindBy(css = "button[data-toggle='dropdown'][class='btn dropdown-toggle ']")
    public WebElement viewPerPageNumber;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement viewPerPageSelect100;

    @FindBy(xpath = "//label[starts-with(text(), 'Total')]")
    public WebElement textOFnumberOfEvents;

    @FindBy(xpath = "//div[.='Testers meeting']")
    public WebElement testerMeetingControlTitle;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']") //(//i[@class='caret'])[1]")
    public WebElement topCheckBox;

    @FindBy(xpath = "(//a[text()='All'])[2]")
    public WebElement allButton;

    @FindBy(xpath = "//tbody/tr/td/input")  // "//input[@type='checkbox']")
    public List<WebElement> allCheckBox;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement changePage;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> listOfRecord;

    @FindBy(xpath = "(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[1]")
    public WebElement titleButton;

    @FindBy(name="value")
    public WebElement titleBox;

    @FindBy(xpath = "//button[@class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement manageFiltersBtn;

    @FindBy(xpath = "//a[contains(text(),'...')]")
    public WebElement dropdownBtn;

    @FindBy(xpath = "//a[@title='View']")
    public WebElement editBtn;

    @FindBy(xpath = "//div[@class='control-label']")
    public List<WebElement> testerMeetingText;


    public int calculateNumberOfEvents() {
        viewPerPage.click();
        viewPerPageSelect100.click();
        int selectedRowsNumber = Integer.parseInt(viewPerPageNumber.getText());
        String pathRows = null;
        int countPageNumber = 0;
        for (int i = 1; i <= selectedRowsNumber; i++) {
            pathRows = "tr.grid-row:nth-of-type(" + i + ")";
            try {
                if (!(Driver.get().findElement(By.cssSelector(pathRows)).equals(null))) {
                    countPageNumber++;
                }
                if (i == selectedRowsNumber) {
                    Driver.get().findElement(By.cssSelector(".fa-chevron-right.hide-text")).click();
                    waitUntilLoaderScreenDisappear();
                    i = 0;
                }
            } catch (NoSuchElementException e) {//NoSuchElementException coming from org.openga.selenium.
                //System.out.println(e.toString());
                return countPageNumber;
            }
        }
        return countPageNumber;
    }








    public String getTotalPageString(){

       return totalPage.getText().split(" ")[1];
    }


    public int getTotalPageInt(){
        BrowserUtils.waitFor(2);
//        String[] totalPagee = totalPage.getText().split(" ");
//        System.out.println(Arrays.toString(totalPagee));
     //  System.out.println(Integer.valueOf(totalPage.getText().split(" ")[1]));
        return Integer.valueOf(totalPage.getText().split(" ")[1]);
    }


    public boolean isLastPage(){
       // System.out.println(pageNumber.getAttribute("value"));
       // System.out.println(totalPage());
        if (pageNumber.getAttribute("value").equals(getTotalPageString())) {
            return true;
        }
        return false;
    }


    public int getRowsNumbers(){
        BrowserUtils.waitFor(1);
        return Driver.get().findElements(By.cssSelector("table tr.grid-row")).size();
    }

    public int getTotalRecords(){

        return Integer.valueOf(totalRecords.getText().split(" ")[2]);
    }

    public WebElement getControlElement(String data){

        return Driver.get().findElement(By.xpath("//div[@class='control-label'][contains(text(),'" + data + "')]"));
    }

    public void selectCheckBox(){
        topCheckBox.click();
        waitUntilLoaderScreenDisappear();
        allButton.click();
        waitUntilLoaderScreenDisappear();
    }

    public List<WebElement> getCheckBox() {

        return allCheckBox;
    }
    public List<WebElement> getListOfRecord(){

        return listOfRecord;
    }

    public void searchEvents(String eventName) {
        manageFiltersBtn.click();
        waitUntilLoaderScreenDisappear();
        titleButton.click();
        waitUntilLoaderScreenDisappear();
        titleBox.sendKeys(eventName);
        updateButton.click();
        waitUntilLoaderScreenDisappear();
    }

    public void verifyTestersMeeting(){

        Actions actions = new Actions(Driver.get());

        BrowserUtils.waitFor(3);

        for(int i=1;i<=4;i++) {
            actions.moveToElement(Driver.get().findElement(By.xpath("(//a[contains(text(),'...')])["+ i +"]"))).perform();
            BrowserUtils.clickWithJS(editBtn);
        }

    }

    }