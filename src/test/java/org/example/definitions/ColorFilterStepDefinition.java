package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.example.pages.AccountHomePage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;

public class ColorFilterStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;

    @Given("user navigates to account homepage")
    public void userNavigatesToAccountHomePage(){
        signInPage = homePage.clickLogin();
        signInPage.enterEmail();
        signInPage.enterPassword();
        accountHomePage = signInPage.clickLogin();
    }

    @When("user selects shoes in apparel")
    public void userClicksShoesInApparel(){
        accountHomePage.clickOnApparel();
        accountHomePage.clickOnShoes();
    }

    @And("user clicks red color")
    public void userClicksRedColor(){
        accountHomePage.shoesRedColor();
    }

    @Then("items with red color appears")
    public void userViewRedColorItems(){
        Assert.assertTrue(accountHomePage.checkRedColor());
    }
}