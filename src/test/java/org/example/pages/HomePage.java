package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public String clickOnHomeSlider(){
        homeSlider1.click();
        nokiaHomeSlider1.click();
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
}
