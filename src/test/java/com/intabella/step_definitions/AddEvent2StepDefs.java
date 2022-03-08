package com.intabella.step_definitions;

import com.intabella.pages.AddEventPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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

    }
