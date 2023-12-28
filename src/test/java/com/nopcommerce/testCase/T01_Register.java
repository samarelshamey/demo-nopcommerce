package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T01_Register extends BaseTest {
    WebDriver driver;
    P01_Register registerPage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void RegisterWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        registerPage = new P01_Register(driver);
        Assert.assertEquals(driver.getCurrentUrl(), getProperty("application_url"));
        registerPage.clickOnRegisterButton();
        registerPage.chooseGender();
        registerPage.enterFirstName(getProperty("firstName"));
        registerPage.enterLastName(getProperty("lastName"));
        registerPage.SelectBirthDate(26, 12, 1990);
        registerPage.enterValidEmail("smsmelshamey@gmail.com");
        registerPage.enterValidPass("123456");
        registerPage.reEnterValidPass("123456");
        registerPage.clickOnSubmitRegisterButton();
        WebElement successMessage = driver.findElement(By.xpath("//div[@class=\"result\"]"));
        softAssert.assertTrue(successMessage.getText().contains("Your registration completed"));
        String successMessageColor = successMessage.getCssValue("color");
        softAssert.assertEquals(successMessageColor, "#4cb17c");

        softAssert.assertAll();

    }
}
