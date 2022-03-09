package com.intabella.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEventPage extends BasePage {

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







}
