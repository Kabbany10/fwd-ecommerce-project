package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HoverStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @When("user hovers on computers")
    public void userHoversOnComputers(){
        homePage.hoverOnComputers();
    }

    @And("user clicks on desktop")
    public void userClicksOnDesktop(){
        homePage.clickOnDesktops();
    }

    @Then("user is directed desktops page")
    public void checkUserIsDirectedToDesktops(){
        Assert.assertEquals(homePage.getCurrentUrl() , "https://demo.nopcommerce.com/desktops");
    }
}
