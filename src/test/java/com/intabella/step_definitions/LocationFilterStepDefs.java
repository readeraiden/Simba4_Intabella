package com.intabella.step_definitions;

import com.intabella.pages.DriverFilterPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class LocationFilterStepDefs {

    DriverFilterPage driverFilterPage = new DriverFilterPage();


    @Then("the result should be in accordance with the {string} and {string} result")
    public void theResultShouldBeInAccordanceWithTheAndResult(String methods, String keyword) {

        BrowserUtils.waitFor(2);

        List<String> actualResults = BrowserUtils.getElementsText(driverFilterPage.keywordResult);
        for (String actualResult : actualResults) {
            switch (methods){
                case "Contains":
                    Assert.assertTrue(actualResult.contains(keyword));
                    break;
                case "Does Not Contain":
                    Assert.assertFalse(actualResult.contains(keyword));
                    break;
                case "Is Equal To":
                    Assert.assertEquals(keyword,actualResult);
                    break;
                case "Starts With":
                    Assert.assertTrue(actualResult.startsWith(keyword));
                    break;
                case "Ends With":
                    Assert.assertTrue(actualResult.endsWith(keyword));
                    break;
            }

        }
    }
}
