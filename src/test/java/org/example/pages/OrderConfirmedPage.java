package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmedPage {

    private WebDriver driver;

    public OrderConfirmedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]")
    WebElement orderConfirmedMessage;

    public String getOrderConfirmedText(){
        return orderConfirmedMessage.getText();
    }
}
