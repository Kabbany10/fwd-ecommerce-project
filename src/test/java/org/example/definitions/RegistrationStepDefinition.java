package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.example.pages.RegistrationCompletePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    CreateAccountPage createAccountPage;
    RegistrationCompletePage registrationCompletePage;


    @Given("user navigates to registration page")
    public void userNavigatesToRegistrationPage(){
        createAccountPage = homePage.clickRegisterButton();
    }

    @When("user enters valid registration data")
    public void userEntersValidData(){
        createAccountPage.fillGender();
        createAccountPage.fillFirstName();
        createAccountPage.fillLastName();
        createAccountPage.fillEmail();
        createAccountPage.fillCompany();
        createAccountPage.fillPassword();
        createAccountPage.fillConfirmPassword();
    }

    @And("user clicks register button")
    public void userClicksRegister() throws InterruptedException {
        registrationCompletePage = createAccountPage.clickRegister();
    }

    @Then("user is registered successfully")
    public void userRegistersSuccessfully(){
        Assert.assertEquals(registrationCompletePage.getRegistrationCompleteMessage() , "Your registration completed");
    }
}
