package org.example.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHomePage {

    private WebDriver driver;

    public AccountHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
    WebElement searchBtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
    WebElement adidasItem;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[3]/a")
    WebElement apparel;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")
    WebElement shoes;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[1]/div/div[2]/ul/li[3]/label/span")
    WebElement shoesRedColor;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/h2/a")
    WebElement checkRedColor;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div[2]/button[1]")
    WebElement addToCartBtn;

    public Boolean checkAccountHomePage(){
        return searchBtn.isDisplayed();
    }

    public void searchForItem(){
        searchBox.sendKeys("adidas");
        searchBtn.click();
    }

    public Boolean checkItem(){
        return adidasItem.isDisplayed();
    }

    public void clickOnApparel(){
        apparel.click();
    }

    public void clickOnShoes(){
        shoes.click();
    }

    public void shoesRedColor(){
        shoesRedColor.click();
    }

    public Boolean checkRedColor(){
        return checkRedColor.isDisplayed();
    }

    public ItemPage clickOnAddToCart(){
        try {
            addToCartBtn.click();
        }
        catch (StaleElementReferenceException e) {
            addToCartBtn.click();
        }
        return new ItemPage(driver);
    }
}
