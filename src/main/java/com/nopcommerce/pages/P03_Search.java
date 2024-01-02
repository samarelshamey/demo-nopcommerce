package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_Search extends BaseConfig {

    By searchTextBox = By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]");
    By searchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    By searchResultLocator = By.xpath("//div[@class=\"product-item\"]");


    public void SearchWithData(String data) {
        driver.findElement(searchTextBox).sendKeys(data);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getSearchResult() {
        return driver.findElements(searchResultLocator);
    }


    public Boolean verifySearchResult (String word) {
        List<WebElement> searchResults = getSearchResult();
        int size = driver.findElements(By.xpath("//div[@class=\"product-item\"]")).size();
        for (int i = 0; i < size; i++) {
            String text = searchResults.get(i).getText();
            if (!text.contains(word))
                return false;
        }
        return true;

    }

}
