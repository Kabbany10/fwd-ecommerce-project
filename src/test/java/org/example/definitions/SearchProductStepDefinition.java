package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AccountHomePage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProductStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;


    @Given("user is logged in")
    public void userLogin(){
        signInPage = homePage.clickLogin();
        signInPage.enterEmail();
        signInPage.enterPassword();
        accountHomePage = signInPage.clickLogin();
    }

    @When("user search for a product")
    public void userSearchesForProduct(){
        accountHomePage.searchForItem();
    }

    @Then("user is navigated to the product")
    public void userNavigatedToProduct(){
        Assert.assertTrue(accountHomePage.checkItem());
    }
}