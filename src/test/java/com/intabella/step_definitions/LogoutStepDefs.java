package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LogoutStepDefs {
    LoginPage loginPage = new LoginPage();
    String url= ConfigurationReader.get("url");
    String firstUrl;
    String url1;





    @Given("user can log out by using log out button")
    public void user_can_log_out_by_using_log_out_button() {
        BrowserUtils.waitFor(3);
        loginPage.userMenu.click();
        loginPage.logoutButton.click();
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("user/login"));

    }

    @When("user can not go to home page again by clicking the step back button")
    public void user_can_not_go_to_home_page_again_by_clicking_the_step_back_button() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();
    }
    @Given("user close the tab")
    public void user_close_the_tab() {
        BrowserUtils.waitFor(3);
       firstUrl=Driver.get().getCurrentUrl();
       Driver.closeDriver();


  }
    @When("verify that user is logged out")
    public void verify_that_user_is_logged_out() {

        Driver.get().get(firstUrl);
        BrowserUtils.waitFor(5);

       Assert.assertNotEquals(firstUrl,Driver.get().getCurrentUrl());

    }
    @Given("user is away the from  keyboard for three minutes")
    public void user_is_away_the_from_keyboard_for_three_minutes() {
        url1= Driver.get().getCurrentUrl();
        BrowserUtils.waitFor(182);

    }

    @When("user must be logged out")
    public void userMustBeLoggedOut() {
        String url2= Driver.get().getCurrentUrl();
        Assert.assertNotEquals(url2,url1);
    }



}
