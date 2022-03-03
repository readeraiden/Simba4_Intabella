package com.intabella.step_definitions;

import com.intabella.pages.CreateCarPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.CarGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateCarStepsDefs {

    CreateCarPage createCarPage = new CreateCarPage();



    @Then("the user clicks on Create Car button")
    public void theUserClicksOnCreateCarButton() {
        createCarPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(createCarPage.createCarButton);
    }

    @And("the user enters new Car information")
    public void theUserEntersNewCarInformation() throws InterruptedException {
        CarGenerator.newCarGenerator();

    }

    @Then("the user clicks on save changes button")
    public void theUserClicksOnSaveChangesButton() {

        createCarPage.saveAndCloseButton.click();


    }
}
