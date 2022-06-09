package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span/a")
    WebElement forgetPasswordBtn;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement password;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement loginBtn;

    public ForgetPasswordPage clickForgetPasswordBtn(){
        forgetPasswordBtn.click();
        return new ForgetPasswordPage(driver);
    }

    public void enterEmail(){
        email.sendKeys("FWD@eg.com");
    }

    public void enterPassword(){
        password.sendKeys("123456");
    }

    public AccountHomePage clickLogin(){
        loginBtn.click();
        return new AccountHomePage(driver);
    }
}
