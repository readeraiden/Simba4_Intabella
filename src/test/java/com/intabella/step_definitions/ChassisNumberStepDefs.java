package com.intabella.step_definitions;

import com.intabella.pages.DriverFilterPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class ChassisNumberStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();

    @When("the user click on All button")
    public void theUserClickOnAllButton() {
        vehiclesPage.Allbutton.click();
    }

    @Then("Chassis Number filter should provide the {string}")
    public void chassisNumberFilterShouldProvideThe(String methods) {

        BrowserUtils.waitFor(3);
        List<String> actualmethods = BrowserUtils.getElementsText(vehiclesPage.methodOptionsChassis);
        Assert.assertEquals("the list doesn't contain "+methods+" option","["+methods+"]",actualmethods.toString());
    }


    @And("the user enters {string} and {string}")
    public void theUserEntersAnd(String value1, String value2) {

        vehiclesPage.betweenValue1input.sendKeys(value1);
        BrowserUtils.waitFor(2);
        vehiclesPage.betweenValue2input.sendKeys(value2);
        BrowserUtils.waitFor(2);
        vehiclesPage.updateButtonn.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the results should be between the {string} and {string} in {string}")
    public void theResultsShouldBeBetweenTheAndIn(String value1, String value2, String methodName) {
        BrowserUtils.waitFor(4);
        List<String> results = BrowserUtils.getElementsText(vehiclesPage.betweenValues(methodName));
        for(String result : results){
            result=result.replace(",","");
            if(Integer.parseInt(result) >= Integer.parseInt(value1) && Integer.parseInt(result) <= Integer.parseInt(value2)){
                BrowserUtils.waitFor(2);
                Assert.assertTrue("the result must be equal or bigger than min filtered value",(Integer.parseInt(result)) >= Integer.parseInt(value1));
                BrowserUtils.waitFor(2);
                Assert.assertTrue("the result must be equal or less than max filtered value",(Integer.parseInt(result)) <= Integer.parseInt(value2));
            }
            System.out.println(result);
        }
    }

    @When("the user select {string}")
    public void theUserSelect(String method) {

        vehiclesPage.filterTypeLocators(method).click();
        BrowserUtils.waitFor(2);
        }
    }




