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

public class AddToShoppingCartStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;
    ItemPage itemPage;

    @Given("user logins on the website")
    public void userLogin(){
        signInPage = homePage.clickLogin();
        signInPage.enterEmail();
        signInPage.enterPassword();
        accountHomePage = signInPage.clickLogin();
    }

    @When("user chooses a product")
    public void userChoosesAProduct(){
        accountHomePage.clickOnApparel();
        accountHomePage.clickOnShoes();
        accountHomePage.shoesRedColor();
        itemPage = accountHomePage.clickOnAddToCart();
    }

    @And("user adds product to cart")
    public void userAddsProductToCart(){
        itemPage.selectSizeEight();
        itemPage.clickOnAddToCart();
    }

    @Then("item added to cart successfully")
    public void productAddedToCart(){
        Assert.assertTrue(itemPage.checkAddedToCartMessage().contains("The product has been added to your"));
    }
}