package com.intabella.step_definitions;

import com.intabella.pages.GeneralInformationPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralInformationDefs {

    VehiclesPage vehiclesPage=new VehiclesPage();
    Actions actions = new Actions(Driver.get());
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();


    @Then("the user can see the General Information page")
    public void the_user_can_see_the_General_Information_page() throws InterruptedException {
  WebElement generalInformation= Driver.get().findElement(By.className("user-fieldset"));
  Assert.assertEquals(generalInformation.getText(),"General Information");
  Thread.sleep(3000);


    }


    @When("the user clicks {string} from {string}")
    public void theUserClicksFrom(String rowNumber, String columName) {
        BrowserUtils.waitFor(5);
        WebElement oneCell= Driver.get().findElement(By.xpath("((//tr[@class='grid-row row-click-action'])["+rowNumber+"])/td[contains(@class,'"+columName+"')]"));
        oneCell.click();
    }
    @When("the user clicks at the end row three points")
    public void the_user_clicks_at_the_end_row_three_points() throws InterruptedException {

        //BrowserUtils.waitFor(2);

      // actions.moveToElement(vehiclesPage.dropdownToggle).build().perform();
       BrowserUtils.hover(new VehiclesPage().dropdownToggle);
        BrowserUtils.waitFor(3);
       BrowserUtils.clickWithJS(new VehiclesPage().dropdownToggle);
       Assert.assertTrue( new VehiclesPage().viewIcon.isDisplayed());
        Thread.sleep(3000);
    }



    @When("user clicks eye icon")
    public void user_clicks_eye_icon() throws InterruptedException {
       actions.moveToElement(vehiclesPage.viewIcon).click().build().perform();
        Thread.sleep(3000);
    }

    @Then("Edit, Delete and Add Event buttons will be displayed")
    public void Edit_Delete_and_Add_Event_buttons_will_be_displayed() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(generalInformationPage.editButton.isDisplayed());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(generalInformationPage.deleteButton.isDisplayed());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
        BrowserUtils.waitFor(2);

    }
    List<String> allInfoOfVehiclePage;
    @Then("check and store all information of {int} .row")
    public void check_and_store_all_information_of_row(Integer rowNumber) {

        allInfoOfVehiclePage = new VehiclesPage().getAllInfoOfRow(rowNumber);
    }

    @Then("verify the all information are all same for both pages")
    public void verify_the_all_information_are_all_same_for_both_pages() {
        List<String> allInfoOfGeneralInformationPage = new GeneralInformationPage().getAllInfo();
        System.out.println("allInfoOfVehiclePage = " + allInfoOfVehiclePage);
        System.out.println("allInfoOfGeneralInformationPage = " + allInfoOfGeneralInformationPage);
        Assert.assertEquals("Compare All Info of 2 Pages", allInfoOfVehiclePage, allInfoOfGeneralInformationPage);
    }


}
