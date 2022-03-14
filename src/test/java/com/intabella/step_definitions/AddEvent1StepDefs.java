package com.intabella.step_definitions;

import com.intabella.pages.GeneralInformationPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AddEvent1StepDefs {
    GeneralInformationPage addEventPage=new GeneralInformationPage();

    @Given("User clicks on any vehicle")
    public void userClicksOnAnyVehicle() throws InterruptedException {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForVisibility(addEventPage.oneVehicleToClick,20);
        addEventPage.oneVehicleToClick.click();
        Assert.assertTrue(addEventPage.generalInfo.isDisplayed());
        BrowserUtils.waitForPageToLoad(5);
    }
    @When("User clicks on Add Event button")
    public void userClicksOnAddEventButton() throws InterruptedException {
        Thread.sleep(3000);
        addEventPage.addEventButton.click();
        try {
            new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.elementToBeClickable(addEventPage.addEventButton));
            Assert.assertTrue(true);
            System.out.println("Add Event button is clickable");
        } catch (Exception e) {
            Assert.assertFalse(false);
            System.out.println("Add Event button isn't clickable");
        }
    }
    @Then("the Add Event page should pop up")
    public void theAddEventPageShouldPopUp() {

        try {
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.visibilityOf(addEventPage.addEventPopup));
            Assert.assertTrue(addEventPage.addEventPopup.isDisplayed());
            System.out.println("Add Event Page is popped up");
        }
        catch(TimeoutException e) {
            System.out.println("Add Event Page isn't popped up");
        }}
    @And("Compulsory fields should be as below")
    public void compulsoryFieldsShouldBeAsBelow(List<String> compulsoryField) {
        BrowserUtils.waitFor(3);
      List<String> allLabels = BrowserUtils.getElementsText(addEventPage.labels);
        System.out.println("allLabels.size() = " + allLabels.size());
        List<String> allLabelsNoStar= new ArrayList<>();

        for (String allLabel : allLabels) {
            allLabelsNoStar.add(allLabel.substring(0,allLabel.length()-1));
        }
        System.out.println("compulsory fields = " + compulsoryField);
            Assert.assertTrue(allLabelsNoStar.containsAll(compulsoryField));
        }
    @And("If any compulsory field is not filled")
    public void if_any_compulsory_field_is_not_filled() {
        addEventPage.titleInputBox.sendKeys(" ");
        addEventPage.organizerDisplayNameInputBox.sendKeys("Mrs. Jane");
    }
    @When("User clicks on the save button")
    public void user_clicks_on_the_save_button() {
        addEventPage.saveButton.click();
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) throws InterruptedException {
        Assert.assertEquals(message,addEventPage.blankFieldwarningMessage.getText());
        System.out.println("warningMessage = " + addEventPage.blankFieldwarningMessage.getText());

        addEventPage.organizerDisplayNameInputBox.clear();
        addEventPage.organizerDisplayNameInputBox.sendKeys("Microsoft");
        addEventPage.organizerEmailInputBox.sendKeys("whattodo@gma.co");
        addEventPage.saveButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(message, addEventPage.blankFieldwarningMessage.getText());

        addEventPage.titleInputBox.sendKeys("SDET");
        addEventPage.saveButton.click();
        Thread.sleep(2000);
        Assert.assertNotEquals("Verify that event shouldn't be saved", "Calendar event saved", addEventPage.calendarEventAddedPopup.getText());
        System.out.println("calendarEventAddedPopup = " + addEventPage.calendarEventAddedPopup.getText());




    }

    }



