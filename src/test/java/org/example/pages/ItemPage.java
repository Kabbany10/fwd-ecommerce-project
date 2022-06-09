package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {

    private WebDriver driver;

    public ItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "product_attribute_9")
    WebElement selectSizeDropDown;
    @FindBy(xpath = "//*[@id=\"product_attribute_9\"]/option[2]")
    WebElement selectSizeEight;
    @FindBy(id = "add-to-cart-button-25")
    WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    WebElement itemAddedToCartSuccessfully;
    @FindBy(id = "add-to-wishlist-button-25")
    WebElement addToWishList;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    WebElement itemAddedToWishListSuccessfully;
    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]/button")
    WebElement addToCompareList;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    WebElement itemAddedToCompareListSuccessfully;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    WebElement shoppingCart;

    public void selectSizeEight(){
        Select dropDownValue = new Select(selectSizeDropDown);
        dropDownValue.selectByValue("21");
    }

    public void clickOnAddToCart(){
        addToCart.click();
    }

    public String checkAddedToCartMessage(){
        return itemAddedToCartSuccessfully.getText();
    }

    public void clickOnAddToWishList(){
        addToWishList.click();
    }

    public String checkAddedToWishListMessage(){
        return itemAddedToWishListSuccessfully.getText();
    }

    public void clickOnAddToCompareList(){
        addToCompareList.click();
    }

    public String checkAddedToCompareListMessage(){
        return itemAddedToCompareListSuccessfully.getText();
    }

    public ShoppingCartPage clickOnShoppingCart(){
        shoppingCart.click();
        return new ShoppingCartPage(driver);
    }
}
