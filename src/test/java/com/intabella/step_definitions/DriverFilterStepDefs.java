package com.intabella.step_definitions;

import com.intabella.pages.DriverFilterPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

import com.intabella.pages.DriverFilterPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DriverFilterStepDefs {

    DriverFilterPage driverFilterPage = new DriverFilterPage();


    @Then("the {string} filter should be selected")
    public void theFilterShouldBeSelected(String FilterMenu) {
      Assert.assertTrue(new VehiclesPage().createLocator(FilterMenu).isSelected());
    }


    @Then("the user should see the following options")
    public void theUserShouldSeeTheFollowingOptions(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        List<String> actualOptions = BrowserUtils.getElementsText(driverFilterPage.menuOptions);

        Assert.assertEquals(menuOptions,actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }

    @And("the user click on {string} button")
    public void theUserClickOnButton(String buttonName) {
        driverFilterPage.MethodsName(buttonName.toLowerCase()).click();
    }

    @When("the user select {string}")
    public void theUserSelect(String method) {
        driverFilterPage.SelectMethod(method).click();

    }

    @And("the user enters {string} into inputBox")
    public void theUserEntersIntoInputBox(String keyword) {
        driverFilterPage.inputKeyword.sendKeys(keyword);

    }

    @And("the user click onto the Update button")
    public void theUserClickOntoTheUpdateButton() {
        driverFilterPage.updateButton.click();
    }

    @Then("the result should be in accordance with the {string} and {string}")
    public void theResultShouldBeInAccordanceWithTheAnd(String methods, String keyword) {
        BrowserUtils.waitFor(2);

        List<String> actualResults = BrowserUtils.getElementsText(driverFilterPage.keywordResults);
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


    @Then("the methods should not accept NonAlphabetical keyword")
    public void theMethodsShouldNotAcceptNonAlphabeticalKeyword() {
        String getInput =driverFilterPage.inputKeyword.getAttribute("value");
        System.out.println("getInput = " + getInput);
        Assert.assertTrue(getInput.isEmpty());
    }


}
