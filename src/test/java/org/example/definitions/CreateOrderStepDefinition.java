package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateOrderStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    AccountHomePage accountHomePage;
    ItemPage itemPage;
    CheckOutPage checkOutPage;
    ShoppingCartPage shoppingCartPage;
    OrderConfirmedPage orderConfirmedPage;

    @Given("any user is logged in on the website")
    public void userLogin(){
        signInPage = homePage.clickLogin();
        signInPage.enterEmail();
        signInPage.enterPassword();
        accountHomePage = signInPage.clickLogin();
    }

    @When("user adds a product to cart")
    public void userAddsProductToCart(){
        accountHomePage.clickOnApparel();
        accountHomePage.clickOnShoes();
        accountHomePage.shoesRedColor();
        itemPage = accountHomePage.clickOnAddToCart();
        itemPage.selectSizeEight();
        itemPage.clickOnAddToCart();
        shoppingCartPage = itemPage.clickOnShoppingCart();
    }

    @And("user creates an order")
    public void userCreatesAnOrder(){
        shoppingCartPage.acceptTermsAndConditions();
        checkOutPage = shoppingCartPage.clickOnCheckout();
        checkOutPage.enterCity();
        checkOutPage.enterAddress1();
        checkOutPage.enterAddress2();
        checkOutPage.enterPostalCode();
        checkOutPage.enterPhoneNumber();
        checkOutPage.selectCountry();
        checkOutPage.selectState();
        orderConfirmedPage = checkOutPage.clickOnContinueBtn();
    }

    @Then("order is created successfully")
    public void orderIsCreatedSuccessfully(){
        Assert.assertTrue(orderConfirmedPage.getOrderConfirmedText().contains("Your order has been successfully processed!"));
    }
}
