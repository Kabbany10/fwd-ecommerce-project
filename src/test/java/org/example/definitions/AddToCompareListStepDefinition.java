package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.example.pages.AccountHomePage;
import org.example.pages.HomePage;
import org.example.pages.ItemPage;
import org.example.pages.SignInPage;

public class AddToCompareListStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;
    ItemPage itemPage;

    @Given("user is logged in on the website")
    public void userLogin(){
        signInPage = homePage.clickLogin();
        signInPage.enterEmail();
        signInPage.enterPassword();
        accountHomePage = signInPage.clickLogin();
    }

    @When("user chooses a product to add to compare list")
    public void userChoosesItem(){
        accountHomePage.clickOnApparel();
        accountHomePage.clickOnShoes();
        accountHomePage.shoesRedColor();
        itemPage = accountHomePage.clickOnAddToCart();
    }

    @And("user adds product to compare list")
    public void userChoosesAProduct(){
        itemPage.selectSizeEight();
        itemPage.clickOnAddToCompareList();
    }

    @Then("item added to compare list successfully")
    public void productAddedToCompareList(){
        Assert.assertTrue(itemPage.checkAddedToCompareListMessage().contains("The product has been added to your product comparison"));
    }
}
