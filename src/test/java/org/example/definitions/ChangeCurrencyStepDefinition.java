package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ChangeCurrencyStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("user is on website's homepage")
    public void userNavigatesToHomePage(){
        homePage.checkHomePage();
    }

    @When("user changes currency from dollar to euro")
    public void userChangesCurrency(){
        homePage.changeToEuro();
    }

    @Then("currency is changed successfully")
    public void checkCurrentCurrency(){
        Assert.assertEquals(homePage.checkCurrencyIsEuro1() , "€1032.00");
        Assert.assertEquals(homePage.checkCurrencyIsEuro2() , "€1548.00");
        Assert.assertEquals(homePage.checkCurrencyIsEuro3() , "€210.70");
        Assert.assertEquals(homePage.checkCurrencyIsEuro4() , "€21.50");
    }
}
