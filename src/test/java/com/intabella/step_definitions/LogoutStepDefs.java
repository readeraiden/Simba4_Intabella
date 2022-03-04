package com.intabella.step_definitions;

import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user can log out by using log out button")
    public void user_can_log_out_by_using_log_out_button() {
        BrowserUtils.waitFor(3);
        loginPage.userMenu.click();
        loginPage.logoutButton.click();

    }

    @When("user can not go to home page again by clicking the step back button")
    public void user_can_not_go_to_home_page_again_by_clicking_the_step_back_button() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();
    }





}
