package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SliderStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("user is directed to website's homepage")
    public void userNavigatesToHomePage(){
        homePage.checkHomePage();
    }

    @When("user clicks on home slider 1")
    public void userClicksOnNokiaSlider(){
        homePage.clickOnHomeSlider();
    }

    @Then("user is directed to Nokia Lumia Page")
    public void checkCurrentUrl(){
        Assert.assertEquals(homePage.clickOnHomeSlider() , "https://demo.nopcommerce.com/nokia-lumia-1020");
        //expected to fail (as required)
    }
}
