package com.nopcommerce.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_Search {
    WebDriver driver;

    public P03_Search(WebDriver driver) {
        this.driver = driver;
    }

    By searchTextBox = By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]");
    By searchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");

    public void SearchWithData(String data) {
        driver.findElement(searchTextBox).sendKeys(data);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }
}