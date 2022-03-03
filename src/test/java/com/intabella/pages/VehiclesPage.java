package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage {

    @FindBy(css = "a.add-filter-button")
    public WebElement manageFilters;

    @FindBy(css = ".fa-filter.hide-text")
    public WebElement filterIcon;


    public void filterIconClick() {
        BrowserUtils.waitFor(5);
        if (!Driver.get().findElement(By.xpath("//a//i[@class='fa-filter hide-text']/..")).getAttribute("class").contains("pressed")) {
            filterIcon.click();
        }
    }
}
