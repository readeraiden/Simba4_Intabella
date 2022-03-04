package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FilterMenuStepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @Given("the user click on the filter button")
    public void theUserClickOnTheFilterButton() {
        BrowserUtils.waitForPageToLoad(10);
        vehiclesPage.filterIconClick();
        BrowserUtils.waitFor(2);
       // Driver.get().findElement(By.cssSelector("i.fa-filter.hide-text")).click();
    }

    @When("the user click on manage filter button")
    public void the_user_click_on_manage_filter_button() {
        BrowserUtils.waitFor(3);
        vehiclesPage.manageFilters.click();

    }

    @Then("verify Manage Filter button is hidden")
    public void verifyManageFilterButtonIsHidden() {

        Assert.assertFalse(new VehiclesPage().manageFilters.isDisplayed());
    }

    @Then("verify Manage Filter button is displayed")
    public void verifyManageFilterButtonIsDisplayed() {
        Assert.assertTrue(new VehiclesPage().manageFilters.isDisplayed());
    }

    @When("the user log out and log in again")
    public void theUserLogOutAndLogInAgain() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.logOut();
        Driver.get().get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        new LoginPage().login(username,password);
        BrowserUtils.waitForPageToLoad(10);
        new DashboardPage().navigateToModule("Fleet","Vehicles");
        BrowserUtils.waitForPageToLoad(10);

    }

    @When("the user click on {string}")
    public void theUserClickOn(String option){
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.createLocator(option).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the {string} should be selected")
    public void theShouldBeSelected(String option) {
       Assert.assertTrue( new VehiclesPage().createLocator(option).isSelected());

    }

    @When("the user types {string} on the filter input box")
    public void theUserTypesOnTheFilterInputBox(String wordsToSearch) {
        Driver.get().findElement(By.xpath("//input[@type='search']")).sendKeys(wordsToSearch);
        BrowserUtils.waitFor(2);

    }

    @Then("verify  {string} filter option is displayed")
    public void verifyFilterOptionIsDisplayed(String wordsToSearch) {
        Assert.assertTrue(new VehiclesPage().createLocator(wordsToSearch).isDisplayed());
    }

    @When("the user click on {string} ,{string} , {string}")
    public void theUserClickOn(String arg0, String arg1, String arg2) {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.createLocator(arg0).click();
        vehiclesPage.createLocator(arg1).click();
        vehiclesPage.createLocator(arg2).click();
        BrowserUtils.waitFor(3);


    }

    @Then("Verify that {string}, {string} and {string} options are selected")
    public void verifyThatAndOptionsAreSelected(String arg0, String arg1, String arg2) {
        Assert.assertTrue( new VehiclesPage().createLocator(arg0).isSelected());
        Assert.assertTrue( new VehiclesPage().createLocator(arg1).isSelected());
        Assert.assertTrue( new VehiclesPage().createLocator(arg2).isSelected());

    }

    @When("the user click on reset button")
    public void theUserClickOnResetButton() {
        new VehiclesPage().resetButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("verify that {string}, {string},{string} filters are not selected")
    public void verifyThatFiltersAreNotSelected(String arg0, String arg1, String arg2) {
        Assert.assertFalse( new VehiclesPage().createLocator(arg0).isSelected());
        Assert.assertFalse( new VehiclesPage().createLocator(arg1).isSelected());
        Assert.assertFalse( new VehiclesPage().createLocator(arg2).isSelected());

    }
}

