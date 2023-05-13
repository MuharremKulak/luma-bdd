package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(how = How.ID, using = "email")
    protected WebElement emailInput;

    @FindBy(how = How.ID, using = "pass")
    protected WebElement passwordInput;

    @FindBy(how = How.ID, using = "send2")
    protected WebElement signInBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/text()")
    protected WebElement errorMessage;


    public void enterUsername(String username){
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSignInBtn(){
        Assert.assertTrue("Sign in Button is not enabled", signInBtn.isEnabled());
        signInBtn.click();
    }

    public void verifySignInError(){
        Assert.assertTrue(errorMessage.isDisplayed());
    }


}
