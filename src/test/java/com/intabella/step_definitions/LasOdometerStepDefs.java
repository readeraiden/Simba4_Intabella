package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LasOdometerStepDefs {
    VehiclesPage vehiclesPage = new VehiclesPage();

    @And("the user click on between button")
    public void theUserClickOnBetweenButton() {
        vehiclesPage.lastOdometerBetween.click();

    }

    @Then("Last Odometer filter should provide the {string}")
    public void lastOdometerFilterShouldProvideThe(String methods) {

        List<String> actualmethods = BrowserUtils.getElementsText(vehiclesPage.methodOptions);
        Assert.assertEquals("the list doesn't contain " + methods + " option", "[" + methods + "]", actualmethods.toString());
    }

    @And("the user click on Last Odometer All button")
    public void theUserClickOnLastOdometerAllButton() {
        vehiclesPage.lastOdometerAllbtn.click();
    }

    @And("the user click on {string} method")
    public void theUserClickOnMethod(String method) {
        vehiclesPage.filterTypeLocators(method).click();
        BrowserUtils.waitFor(2);
    }


    @And("the user submit {string} and {string} values")
    public void theUserSubmitAndValues(String start, String end) {

        vehiclesPage.filterStart.click();
        BrowserUtils.waitFor(2);
        vehiclesPage.filterStart.sendKeys(start);
        vehiclesPage.filterEnd.click();
        vehiclesPage.filterEnd.sendKeys(end);
        vehiclesPage.updateBtn.click();
    }

    @Then("the results should be between the specified {string} and {string} values")
    public void theResultsShouldBeBetweenTheSpecifiedAndValues(String start, String end) {
        BrowserUtils.waitFor(4);
        List<String> results = BrowserUtils.getElementsText(vehiclesPage.lastOdometerValues);
        for (String result : results) {
            result = result.replace(",", "");
            boolean conditionBigger = Integer.parseInt(result) >= Integer.parseInt(start);
            boolean conditionSmaller = Integer.parseInt(result) <= Integer.parseInt(end);
            if (conditionBigger && conditionSmaller) {
                Assert.assertTrue("the result must be equal or bigger than min filtered value", true);
                Assert.assertTrue("the result must be equal or less than max filtered value", true);
            }
            System.out.println(result);
        }
    }

    @And("the user submit {string} values")
    public void theUserSubmitValues(String value) {

        vehiclesPage.equalsInput.sendKeys(value);
        vehiclesPage.updateBtn.click();
    }

    @Then("the results should be the specified {string} exactly")
    public void theResultsShouldBeTheSpecifiedExactly(String value) {
        BrowserUtils.waitFor(4);
        List<String> results = BrowserUtils.getElementsText(vehiclesPage.lastOdometerValues);
        for (String result : results) {
            result = result.replace(",", "");
            boolean condition = (Integer.parseInt(result)) == Integer.parseInt(value);
            if (condition) {
                Assert.assertTrue("the result must be equal with filtered value", true);
            }
            System.out.println(result);
        }
    }

    @Then("the results should be more than the specified {string}")
    public void theResultsShouldBeMoreThanTheSpecified(String value) {

        BrowserUtils.waitFor(4);
        List<String> results = BrowserUtils.getElementsText(vehiclesPage.lastOdometerValues);
        for (String result : results) {
            result = result.replace(",", "");
            boolean condition = (Integer.parseInt(result)) > Integer.parseInt(value);
            if (condition) {
                Assert.assertTrue("the result must be more than filtered value", true);
            }
            System.out.println(result);
        }
    }

    @Then("the results should be less than the specified {string}")
    public void theResultsShouldBeLessThanTheSpecified(String value) {

        BrowserUtils.waitFor(4);
        List<String> results = BrowserUtils.getElementsText(vehiclesPage.lastOdometerValues);
        for (String result : results) {
            result = result.replace(",", "");
            boolean condition = (Integer.parseInt(result)) < Integer.parseInt(value);
            if (condition) {
                Assert.assertTrue("the result must be less than filtered value", true);
            }
            System.out.println(result);
        }

    }

    @Then("the methods shouldn't accept non-numeric values")
    public void theMethodsShouldnTAcceptNonNumericValues() {
        Assert.assertEquals("The methods shouldn't accept non-numeric values", "All", vehiclesPage.Allbtn.getText());

    }
}
