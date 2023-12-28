package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login {
    WebDriver driver;
    public  P02_Login (WebDriver driver){
        this.driver = driver;
    }
    By login = By.xpath("//a[@class=\"ico-login\"]");
    By emailField = By.xpath("//input[@class=\"email\"]");
    By passwordField = By.xpath("//input[@class=\"password\"]");
    By loginButton = By.xpath("(//button[@type=\"submit\"])[2]");

    public void clickOnLogin () {
        driver.findElement(login).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clickOnLoginButton () {
        driver.findElement(loginButton).click();
    }

}
