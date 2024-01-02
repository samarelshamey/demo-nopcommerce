package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P03_Search;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class T03_Search extends BaseTest {
    P03_Search searchPage = new P03_Search();

    @Test
    public void SearchWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "search with valid data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Search");


        searchPage.SearchWithData("Apple");
        searchPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.verifySearchResult("Apple"));
        searchPage.SearchWithData("“Card");
        searchPage.clickOnSearchButton();
        Assert.assertFalse(searchPage.verifySearchResult("Apple"));
        Assert.assertTrue(searchPage.verifySearchResult("Card"));
        searchPage.SearchWithData("Apple");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.getSearchResult()));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchPage.verifySearchResult("Apple"));
        softAssert.assertAll();
    }
}
