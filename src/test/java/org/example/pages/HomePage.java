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
    WebElement itemEuroPrice;

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
    public String checkCurrencyIsEuro(){
        return itemEuroPrice.getText();
    }
}
