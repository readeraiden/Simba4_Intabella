package com.intabella.step_definitions;

import com.intabella.pages.AddEventPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEvent2StepDefs {

        AddEventPage addEventPage = new AddEventPage();

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
        ArrayList<String> option=new ArrayList<>();
        for (int i=0; i<4 ;i++ ) {
            option.add(i, options.get(i));
        }
        List<WebElement> allOptions = addEventPage.repeatDropdownMenu;
        for (int i = 0; i < option.size()-1 ; i++) {
            Assert.assertTrue(allOptions.get(i).getText().contains(option.get(i)));
        }
    }


}
