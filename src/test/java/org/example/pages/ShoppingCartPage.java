package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "termsofservice")
    WebElement termsAndConditions;
    @FindBy(id = "checkout")
    WebElement checkout;

    public void acceptTermsAndConditions(){
        termsAndConditions.click();
    }

    public CheckOutPage clickOnCheckout(){
        checkout.click();
        return new CheckOutPage(driver);
    }
}
