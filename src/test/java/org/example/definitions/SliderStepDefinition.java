package org.example.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SliderStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @When("user clicks on home slider 1")
    public void userClicksOnNokiaSlider(){
        homePage.clickOnHomeSlider1();
    }

    @Then("user is directed to Nokia Lumia Page")
    public void checkCurrentUrlNokia(){
        Assert.assertEquals(homePage.clickOnHomeSlider1() , "https://demo.nopcommerce.com/nokia-lumia-1020");
        //expected to fail (as required)
    }

    @When("user clicks on home slider 2")
    public void userClicksOnIphoneSlider(){
        homePage.clickOnHomeSlider1();
    }

    @Then("user is directed to Iphone Page")
    public void checkCurrentUrlIphone(){
        Assert.assertEquals(homePage.clickOnHomeSlider1() , "https://demo.nopcommerce.com/iphone-6");
        //expected to fail (as required)
    }
}
