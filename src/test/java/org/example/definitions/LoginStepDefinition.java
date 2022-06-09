package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AccountHomePage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage(){
        signInPage = homePage.clickLogin();
    }

    @When("user enters valid username and password")
    public void userEntersValidData(){
        signInPage.enterEmail();
        signInPage.enterPassword();
    }

    @And("user clicks login button")
    public void userClicksLogin(){
        accountHomePage = signInPage.clickLogin();
    }

    @Then("user logins successfully")
    public void userLoginsSuccessfully(){
        Assert.assertTrue(accountHomePage.checkAccountHomePage());
    }
}
