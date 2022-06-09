package org.example.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.ForgetPasswordPage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgetPasswordStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage;
    ForgetPasswordPage forgetPasswordPage;

    @Given("user navigate to login page")
    public void userNavigateToLoginPage(){
        signInPage = homePage.clickLogin();
    }

    @When("user clicks forget password")
    public void userClickForgetPassword(){
        forgetPasswordPage = signInPage.clickForgetPasswordBtn();
    }

    @And("user enters valid email")
    public void userEnterEmail(){
        forgetPasswordPage.enterEmail();
    }

    @And("user clicks recover")
    public void userClicksRecover(){
        forgetPasswordPage.clickRecoverBtn();
    }

    @Then("user recovers password successfully")
    public void userRecoversSuccessfully() throws InterruptedException {
        Assert.assertEquals(forgetPasswordPage.getRecoveryMessage() , "Email with instructions has been sent to you.");
    }
}
