package org.example.pages;

import org.example.definitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "ico-register")
    WebElement registerBtn;
    @FindBy(className = "ico-login")
    WebElement loginBtn;
    @FindBy(id = "customerCurrency")
    WebElement changeCurrency;
    @FindBy(xpath = "//*[@id=\"customerCurrency\"]/option[2]")
    WebElement euroCurrency;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span")
    WebElement itemEuroPrice1;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[1]/span")
    WebElement itemEuroPrice2;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[1]/span")
    WebElement itemEuroPrice3;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[1]/span")
    WebElement itemEuroPrice4;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[1]")
    WebElement homeSlider1;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[1]/div[2]/a[2]")
    WebElement homeSlider2;
    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/a[2]")
    WebElement iphoneHomeSlider2;
    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/a[1]")
    WebElement nokiaHomeSlider1;
    @FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a")
    WebElement facebookFollowUs;
    @FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[2]/a")
    WebElement twitterFollowUs;
    @FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a")
    WebElement rssFollowUs;
    @FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a")
    WebElement youtubeFollowUs;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computersCategory;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    WebElement desktopsSubCategory;

    @FindBy(css = "span[class=\"price actual-price\"]")
    WebElement euroPrices;

    public void checkHomePage(){
        registerBtn.isDisplayed();
    }

    public CreateAccountPage clickRegisterButton(){
        registerBtn.click();
        return new CreateAccountPage(driver);
    }

    public SignInPage clickLogin(){
        loginBtn.click();
        return new SignInPage(driver);
    }

    public void changeToEuro(){
        changeCurrency.click();
        euroCurrency.click();
    }

    public String checkCurrencyIsEuro1(){
        return itemEuroPrice1.getText();
    }

    public String checkCurrencyIsEuro2(){
        return itemEuroPrice2.getText();
    }

    public String checkCurrencyIsEuro3(){
        return itemEuroPrice3.getText();
    }

    public String checkCurrencyIsEuro4(){
        return itemEuroPrice4.getText();
    }

    public String clickOnHomeSlider1(){
        homeSlider1.click();
        nokiaHomeSlider1.click();
        return driver.getCurrentUrl();
    }

    public String clickOnHomeSlider2(){
        homeSlider2.click();
        iphoneHomeSlider2.click();
        return driver.getCurrentUrl();
    }

    public void clickFacebook(){
        facebookFollowUs.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickTwitter(){
        twitterFollowUs.click();
    }

    public void clickRss(){
        rssFollowUs.click();
    }

    public void clickYoutube(){
        youtubeFollowUs.click();
    }

    public void hoverOnComputers(){
        Actions actions = new Actions(driver);
        actions.moveToElement(computersCategory).perform();
    }

    public void clickOnDesktops(){
        desktopsSubCategory.click();
    }

    public void assertOnEuroPrices(){
        int count = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for (int i = 0 ; i < count ; i++){
            String text = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(i).getText();
            Assert.assertTrue(text.contains("€"));
        }
    }
}
