package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1;
    @FindBy(id = "BillingNewAddress_Address2")
    WebElement address2;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
    WebElement continueBtn;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement state;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement continueShippingBtn;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    WebElement continuePaymentMethodBtn;
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button ")
    WebElement continuePaymentInfoBtn;
    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
    WebElement confirmBtn;

    public void enterCity(){
        city.sendKeys("Cairo");
    }

    public void enterAddress1(){
        address1.sendKeys("Cairo");
    }

    public void enterAddress2(){
        address2.sendKeys("Cairo");
    }

    public void enterPostalCode(){
        postalCode.sendKeys("12345");
    }

    public void enterPhoneNumber(){
        phoneNumber.sendKeys("0100000000");
    }

    public void selectCountry(){
        Select dropDownValue = new Select(country);
        dropDownValue.selectByValue("123");
    }

    public void selectState(){
        Select dropDownValue = new Select(state);
        dropDownValue.selectByValue("0");
    }

    public OrderConfirmedPage clickOnContinueBtn(){
        continueBtn.click();
        continueShippingBtn.click();
        continuePaymentMethodBtn.click();
        continuePaymentInfoBtn.click();
        confirmBtn.click();
        return new OrderConfirmedPage(driver);
    }
}
