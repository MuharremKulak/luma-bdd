package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    private HomePage homePage;
    private WebDriver driver;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage.clickSignInLink();
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals("Customer Login", loginPageTitle);
    }

    @When("user enter valid username \"kevin.lee@gmail.com")
    public void user_enter_valid_username_kevin_lee_gmail_com(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user click on the sign in button")
    public void user_click_on_the_sign_in_button() {
        loginPage.clickSignInBtn();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        myAccountPage.verifyTitle();
        myAccountPage.verifyMyAccountHeader();
    }

    @When("user enters a invalid password {string}")
    public void user_enters_a_invalid_password() {
        loginPage.verifySignInError();
    }

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
