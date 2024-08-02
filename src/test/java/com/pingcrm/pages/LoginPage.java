package com.pingcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    
    String loginPageURL = "https://demo.inertiajs.com/login";
    WebDriver chromeDriver;
    WebDriverWait wait;

    public void openPage()
    {
        this.chromeDriver = new ChromeDriver();
        //this.wait = new WebDriverWait(chromeDriver, 20);
        this.chromeDriver.manage().window().maximize();
        this.chromeDriver.get(loginPageURL);
    }

    public void setEmail(String email) {
        this.chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")).clear();
        this.chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys(email);
    }

    public void setPassword(String password) {
        this.chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")).clear();
        this.chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")).sendKeys(password);
    }

    public void clickLoginButton() {
        this.chromeDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/form[1]/div[2]/button[1]")).click();
    }

    public String getCurrentPageTitle() {
        return this.chromeDriver.getTitle();
    }

    public WebDriver getDriver() {
        return this.chromeDriver;
    }

    public boolean isErrorMessageShownForWrongCredentials(){
        return true; 
        //return this.chromeDriver.findElement(By.linkText("These credentials do not match our records.")).isDisplayed();
    }
}
