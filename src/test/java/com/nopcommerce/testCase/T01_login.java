package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T01_login extends BaseTest {
    P02_Login loginPage = new P02_Login(driver);
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        loginPage.clickOnLogin();
        loginPage.enterEmail("smsmelshamey@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String myaccount = driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).getText();
        softAssert.assertEquals(myaccount, "MY ACCOUNT");
    }

    @Test
    public void loginWithInvalidData () {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        loginPage.clickOnLogin();
        loginPage.enterEmail("smsm_elshamey.gmail");
        loginPage.enterPassword("kaljaskdhahdga");
        loginPage.clickOnLoginButton();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
        softAssert.assertTrue(errorMessage.getText().contains("Login was unsuccessful"));
        String errorMessageColor = errorMessage.getCssValue("color");
        softAssert.assertEquals(errorMessageColor, " #e4434b");

        softAssert.assertAll();

    }

}
