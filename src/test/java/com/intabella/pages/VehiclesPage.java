package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class VehiclesPage extends BasePage {

    Random rand = new Random();

    @FindBy(css = "a.add-filter-button")
    public WebElement manageFilters;

    @FindBy(css = ".fa-filter.hide-text")
    public WebElement filterIcon;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement lastOdometerAllbtn;

    @FindBy(xpath = "//div[@class='filter-item oro-drop open-filter']//button[@class='btn dropdown-toggle']")
    public WebElement lastOdometerBetween;

    @FindBy(xpath = "//span[@class='filter-items']/div[7]/div[2]//ul/li")
    public List<WebElement> methodOptions;

    @FindBy(xpath= "//div[@class='filter-start']/input")
    public WebElement filterStart;

    @FindBy(xpath = "//div[@class='filter-end']/input")
    public WebElement filterEnd;

    @FindBy(xpath = "//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-LastOdometer']")
    public List<WebElement> lastOdometerValues;

    @FindBy(xpath = "//input[@id='LastOdometer']/../button")
    public WebElement updateBtn;

    @FindBy(xpath = "//div[@class='filter-start']/input")
    public WebElement equalsInput;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']//span/b")
    public WebElement Allbtn;



    @FindBy (xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement viewPerPageButton;

    //Selects all the rows on the vehicle table:to find row number
    @FindBy (xpath = "//tr[@class='grid-row']")
    public List<WebElement> tableRowNumbers;

    @FindBy(xpath = "//td//div/a[@data-toggle='dropdown']")
    public List<WebElement> threeDots;

    public WebElement threeDot = threeDots.get(rand.nextInt(threeDots.size()));

    @FindBy(xpath = "//i[@class='fa-trash-o hide-text']")
    public List<WebElement> deleteButton;

    public WebElement createLocator(String optionName) {
        return Driver.get().findElement(By.xpath( "//input[@value='" +optionName+ "']"));
    }

    public void filterIconClick() {
        BrowserUtils.waitFor(5);
        if (!Driver.get().findElement(By.xpath("//a//i[@class='fa-filter hide-text']/..")).getAttribute("class").contains("pressed")) {
            filterIcon.click();
        }
    }

    public WebElement FilterMethods(String FilterName){
        return Driver.get().findElement(By.xpath("//div[normalize-space(text())='"+FilterName+"']"));
    }


    public WebElement filterTypeLocators(String methodName) {
        return Driver.get().findElement(By.xpath("//a[text()=\""+methodName+"\"]"));
    }









}
