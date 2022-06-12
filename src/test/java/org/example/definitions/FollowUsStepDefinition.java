package org.example.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class FollowUsStepDefinition {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @When("user clicks facebook")
    public void userClicksFacebook(){
        homePage.clickFacebook();
    }

    @Then("user is directed to a new tab with facebook website")
    public void checkFacebookCurrentUrl(){
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(homePage.getCurrentUrl() , "https://www.facebook.com/nopCommerce");
        driver.close();
        driver.switchTo().window(Tabs.get(0));
    }

    @When("user clicks twitter")
    public void userClicksTwitter(){
        homePage.clickTwitter();
    }

    @Then("user is directed to a new tab with twitter website")
    public void checkTwitterCurrentUrl(){
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(homePage.getCurrentUrl() , "https://twitter.com/nopCommerce");
        driver.close();
        driver.switchTo().window(Tabs.get(0));
    }

    @When("user clicks on rss")
    public void userClicksRss(){
        homePage.clickRss();
    }

    @Then("user is directed to a new tab with rss website")
    public void checkRssCurrentUrl(){
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(homePage.getCurrentUrl() , "https://demo.nopcommerce.com/new-online-store-is-open");
        driver.close();
        driver.switchTo().window(Tabs.get(0));
        //expected to fail
    }

    @When("user clicks on youtube")
    public void userClicksYoutube(){
        homePage.clickYoutube();
    }

    @Then("user is directed to a new tab with youtube website")
    public void checkYoutubeCurrentUrl(){
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(homePage.getCurrentUrl() , "https://www.youtube.com/user/nopCommerce");
        driver.close();
        driver.switchTo().window(Tabs.get(0));
    }
}
