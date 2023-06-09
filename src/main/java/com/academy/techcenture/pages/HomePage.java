package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign In")
    protected WebElement signInLink;


    public void clickSignInLink(){
        signInLink.click();
    }
}
