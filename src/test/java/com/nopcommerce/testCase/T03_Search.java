package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P03_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T03_Search extends BaseTest {
    P03_Search searchPage = new P03_Search(driver);

    @Test
    public void SearchWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        searchPage.SearchWithData("Apple");
        searchPage.clickOnSearchButton();
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class=\"product-item\"]"));
        int size = driver.findElements(By.xpath("\"//div[@class=\\\"product-item\\\"]\")")).size();
        for (int i = 0; i < size; i++) {
            String text = searchResult.get(i).getText();
            Assert.assertTrue(text.contains("Apple"));
        }
        searchPage.SearchWithData("“Card");
        searchPage.clickOnSearchButton();
        List<WebElement> cardSearchResult = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
        int size2 = driver.findElements(By.xpath("\"//div[@class=\\\"product-item\\\"]\")")).size();
        for (int i = 0; i < size; i++) {
            String text = searchResult.get(i).getText();
            Assert.assertFalse(text.contains("Apple"));
            Assert.assertTrue(text.contains("Card"));
        }



    }
}
