package com.pingcrm.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pingcrm.pages.LoginPage;

public class LoginTests {
    
    @Test
    public void canUserLoginWithPostiveInputs()
    {
        LoginPage loginPage = new LoginPage();
        String expectedPageTitle = "Dashboard - Ping CRM";

        loginPage.openPage();

        loginPage.setEmail("johndoe@example.com");
        loginPage.setPassword("secret");
        loginPage.clickLoginButton();

        WebDriverWait webDriverWait = new WebDriverWait(loginPage.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.titleIs(expectedPageTitle));

        String actualPageTitle = loginPage.getCurrentPageTitle();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title mismatch.");
    }

    @Test
    public void canUserSeeErrorMessageWhenLoginWithWrongCredentials()
    {  
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();

        loginPage.setEmail("johndoe@example.com");
        loginPage.setPassword("wrongpassword");
        loginPage.clickLoginButton();

        boolean isErrorMessageShownForWrongCredentials = loginPage.isErrorMessageShownForWrongCredentials();

        Assert.assertTrue(isErrorMessageShownForWrongCredentials, "Error message shown for login with invalid credentials.");
    }
}
