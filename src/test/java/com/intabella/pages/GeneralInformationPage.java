package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    public WebElement addEventPopup;

    @FindBy(xpath = "(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate'])[5]") //onePlate
    public WebElement oneVehicleToClick;

    @FindBy(css = "label[class='required']")
    public List<WebElement> labels;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    public WebElement titleInputBox;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[organizerDisplayName]']")
    public WebElement organizerDisplayNameInputBox;

    @FindBy(name = "oro_calendar_event_form[organizerEmail]")
    public WebElement organizerEmailInputBox;

    @FindBy(xpath = "//span[contains(text(),'This value should not be blank.')]")
    public WebElement blankFieldwarningMessage;

    @FindBy(xpath = "//span[normalize-space()='General Information']")
    public WebElement generalInfo;

    @FindBy(xpath = "//span[@class='color']")
    public List<WebElement> colors;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement allDayEventCheckbox;

    @FindBy(xpath = " //div[normalize-space()='Calendar event saved']")
    public WebElement calendarEventAddedPopup;

    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatCheckbox;

    @FindBy(xpath = "//select[starts-with(@id,'recurrence-repeat')]//option")
    public List<WebElement> repeatDropdownMenu;

    @FindBy(xpath = "(//input[@type='radio'])")
    public List<WebElement> endsOptions;

    @FindBy(css = "div.message-item")
    public WebElement newEventName;

    @FindBy(xpath = "//span[text()='General Information']")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;
  
    @FindBy(xpath = "//a[text()='Yes, Delete']")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "//*[text()='Car deleted']")
    public WebElement carDeleted;

    public List<String> getAllInfo() {

        List<String> info = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            info.add(Driver.get().findElement(By.xpath("(//div[@class='responsive-cell responsive-cell-no-blocks']//div[@class='control-label'])[" + i + "]")).getText());
        }
        return info;


/*
@FindBy(xpath ="//label[@class='control-label']" )
    public List<WebElement> generalInformationPageKeys;
@FindBy(xpath ="//div[@class='control-label']" )
    public List<WebElement> getGeneralInformationPageValues;
*/

    }
}