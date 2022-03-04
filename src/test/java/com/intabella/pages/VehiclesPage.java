package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehiclesPage extends BasePage {

    @FindBy(css = "a.add-filter-button")
    public WebElement manageFilters;

    @FindBy(css = ".fa-filter.hide-text")
    public WebElement filterIcon;

    @FindBy(xpath = "//div[@class='ui-multiselect-footer']/../ul/li")
    public List<WebElement> filterOptions;

    @FindBy(xpath = "//div[@class='ui-multiselect-footer']/../ul/li[7]")
    public WebElement lastOdometer;



    public void filterIconClick() {
        BrowserUtils.waitFor(5);
        if (!Driver.get().findElement(By.xpath("//a//i[@class='fa-filter hide-text']/..")).getAttribute("class").contains("pressed")) {
            filterIcon.click();
        }
    }
}
