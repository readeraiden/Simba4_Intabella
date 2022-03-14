package com.intabella.pages;

import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class DriverFilterPage extends BasePage{


    @FindBy(css= ".dropdown-item.choice-value")
    public List<WebElement> menuOptions;

    @FindBy(xpath = "//button[normalize-space()='contains']")
    public WebElement containsButton;

    @FindBy(xpath = "//input[@name='value']")
    public WebElement inputKeyword;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//td[@data-column-label='Driver']")
    public List<WebElement> keywordResults;

    @FindBy(xpath = "//td[@data-column-label='Location']")
    public List<WebElement> keywordResult;


    public WebElement MethodsName(String methodsName){
        return Driver.get().findElement(By.xpath("//button[normalize-space()='"+methodsName+"']"));
    }

    public WebElement SelectMethod (String selectMethod){
        String selectMethods = selectMethod.toLowerCase();
        return Driver.get().findElement(By.xpath("//a[normalize-space()='"+selectMethods+"']"));
    }
}
