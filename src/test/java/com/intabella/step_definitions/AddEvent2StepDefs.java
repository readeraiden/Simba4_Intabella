package com.intabella.step_definitions;
import com.intabella.pages.GeneralInformationPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddEvent2StepDefs {


    GeneralInformationPage addEventPage = new GeneralInformationPage();

    @Then("User can mark the event with any color")
    public void user_can_mark_the_event_with_any_color() {
        BrowserUtils.waitForPageToLoad(3);

        for (int i=1; i<addEventPage.colors.size(); i++){
            addEventPage.colors.get(i).click();
            BrowserUtils.waitFor(2);
            Assert.assertTrue(addEventPage.colors.get(i).isEnabled());
        }
    }
    @Then("User can mark the event as an all-day event")
    public void user_can_mark_the_event_as_an_all_day_event() {
            BrowserUtils.waitForPageToLoad(3);
            addEventPage.allDayEventCheckbox.click();
            BrowserUtils.waitFor(2);
            Assert.assertTrue(addEventPage.allDayEventCheckbox.isSelected());

        }
    @Then("Repeat down menu should include below options")
    public void repeat_down_menu_should_include_below_options(List<String> options) {
        addEventPage.repeatCheckbox.click();
        for (int i = 0; i < options.size()-1 ; i++) {
            Assert.assertTrue(addEventPage.repeatDropdownMenu.get(i).getText().contains(options.get(i)));
        }

    }
    @Then("Ending options should be clickable")
    public void ending_options_should_be_clickable() {
        addEventPage.repeatCheckbox.click();
        for (WebElement endingOptions : addEventPage.endsOptions) {
            endingOptions.click();
            BrowserUtils.waitFor(2);
            Assert.assertTrue(endingOptions.isSelected());
        }
    }

    @When("User add an event")
    public void user_add_an_event() {
        addEventPage.titleInputBox.sendKeys("Trial Event");
        addEventPage.organizerDisplayNameInputBox.sendKeys("Mrs. Jane");
        addEventPage.organizerEmailInputBox.sendKeys("whattodo@gma.co");
        addEventPage.saveButton.click();
    }

    @Then("User should see the event on general information page")
    public void user_should_see_the_event_on_general_information_page() {
        System.out.println(addEventPage.newEventName.getText());
        Assert.assertEquals("Trial Event", addEventPage.newEventName.getText());

    }


}
