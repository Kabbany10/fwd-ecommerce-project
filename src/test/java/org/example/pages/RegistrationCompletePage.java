package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationCompletePage {

    private WebDriver driver;

    public RegistrationCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"result\"]")
    WebElement registrationCompleteMessage;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")
    WebElement continueBtn;

    public String getRegistrationCompleteMessage(){
        return registrationCompleteMessage.getText();
    }

    public AccountHomePage clickContinue(){
        continueBtn.click();
        return new AccountHomePage(driver);
    }

}
