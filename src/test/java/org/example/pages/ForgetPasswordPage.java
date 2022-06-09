package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {

    private WebDriver driver;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    WebElement email;
    @FindBy(name = "send-email")
    WebElement recoverBtn;
    @FindBy(xpath = "//p[@class=\"content\"]")
    WebElement recoveryMessage;

    public void enterEmail(){
        email.sendKeys("FWD@eg.com");
    }

    public void clickRecoverBtn(){
        recoverBtn.click();
    }

    public String getRecoveryMessage() throws InterruptedException {
        Thread.sleep(3000);
        return recoveryMessage.getText();
    }

}
