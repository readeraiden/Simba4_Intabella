package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleTableArrangements {

    VehiclesPage vehiclesPage=new VehiclesPage();

    @Then("verify Manage Filter button is {string} by default.")
    public void verify_Manage_Filter_button_is_by_default(String defaultValue) {
        defaultValue="25";
        BrowserUtils.waitFor(7);
        String viewPerPAgeDefaultValue = vehiclesPage.viewPerPageButton.getText();
        Assert.assertTrue(viewPerPAgeDefaultValue.contains(defaultValue));

    }

    //-------------------
    @Given("the user click on the view per page button")
    public void theUserClickOnTheViewPerPageButton() {
       BrowserUtils.waitFor(8);
       vehiclesPage.viewPerPageButton.click();
    }


    @Then("the user click click {string} from drop down menu")
    public void theUserClickClickFromDropDownMenu(String options) {

        //normal-space()=trim methodu ile aynı boşlukları siliyor

        WebElement myOption = Driver.get().findElement(By.xpath("//a[normalize-space()='"+options+"']"));

        //if(!myOption.getText().contains("25")){
            myOption.click();
       // }



    }




    @Then("the user click on view per page button  values should be {string}, {string},{string},{string}")
    public void theUserClickOnViewPerPageButtonValuesShouldBe(String value1, String value2, String value3, String value4) {
        ArrayList<String> values=new ArrayList<>();
        //Add expected view per page values in  to the arraylist
        values.add(value1);
        values.add(value2);
        values.add(value3);
        values.add(value4);

        //Put actual view per page options in to the List
        List<WebElement> allOptions = Driver.get().findElements(By.xpath("//a[@class='dropdown-item']"));
        for (int i = 0; i < values.size()-1 ; i++) {
            Assert.assertTrue(allOptions.get(i).getText().contains(values.get(i)));
        }
    }
//------------------------------



    @And("verify that the user able to see only {string} rows from the table")
    public void verifyThatTheUserAbleToSeeOnlyRowsFromTheTable(String options) {

        BrowserUtils.waitFor(7);

        int opt= Integer.parseInt(options);

       Assert.assertEquals(opt,vehiclesPage.tableRowNumbers.size());
    }

//------------
    @When("the user click {string} column  from table")
    public void theUserClickColumnFromTable(String options) {

        BrowserUtils.waitFor(7);
        WebElement myElement =Driver.get().findElement(By.xpath("//th[contains(@class,'grid-cell grid-header-cell grid-header-cell-"+options +"')]"));

        if(myElement.isDisplayed()){
            myElement.click();

        }else{
            JavascriptExecutor jse=(JavascriptExecutor) Driver.get() ;
            jse.executeScript("arguments[0].scrollIntoView(true);",myElement);
            BrowserUtils.waitFor(7);
            myElement.click();

        }
        BrowserUtils.waitFor(7);






    }


    @Then("the column is sorted by {string} order")
    public void theColumnIsSortedByOrder (String sortColumn){

        switch (sortColumn) {
             case "ascending":
                Assert.assertTrue(Driver.get().findElement(By.xpath("(//th[contains(@class,'ascending')])[1]")).getAttribute("class").contains("ascending"));
                break;

            case "descending":
                Assert.assertTrue(Driver.get().findElement(By.xpath("(//th[contains(@class,'descending')])[1]")).getAttribute("class").contains("descending"));
                break;
        }

            }


    @When("the user click {string} from drop down menu")
    public void theUserClickFromDropDownMenu(String value) {

        BrowserUtils.waitFor(7);
        vehiclesPage.viewPerPageButton.click();
        WebElement myOption = Driver.get().findElement(By.xpath("//a[normalize-space()='"+value+"']"));
        myOption.click();

    }

    @Then("verify that the user able to see only {string} rows from table")
    public void verifyThatTheUserAbleToSeeOnlyRowsFromTable(String value) {
        BrowserUtils.waitFor(7);

        int opt= Integer.parseInt(value);

        Assert.assertEquals(opt,vehiclesPage.tableRowNumbers.size());
    }

    @Given("the user click on {string} colum from table")
    public void theUserClickOnColumFromTable(String columnName) {

        WebElement myElement =Driver.get().findElement(By.xpath("//th[contains(@class,'grid-cell grid-header-cell grid-header-cell-"+columnName +"')]"));

        BrowserUtils.waitFor(4);
        if(myElement.isDisplayed()){
            myElement.click();

        }else{
            JavascriptExecutor jse=(JavascriptExecutor) Driver.get() ;
            jse.executeScript("arguments[0].scrollIntoView(true);",myElement);
            BrowserUtils.waitFor(7);
            myElement.click();

        }

    }

    @Then("verify that the list is not sorted by {string}")
    public void verifyThatTheListIsNotSortedBy(String sortColumn) {


       WebElement columnSorted=Driver.get().findElement(By.xpath("(//th[contains(@class,'grid-cell grid-header-cell grid-header-cell-"+sortColumn+"')])"));
       Assert.assertFalse(columnSorted.getAttribute("class").contains("ascending"));

    }


    @When("the user click on reset button")
    public void theUserClickOnResetButton() {
        new VehiclesPage().resetButton.click();
        BrowserUtils.waitFor(2);

    }


}


