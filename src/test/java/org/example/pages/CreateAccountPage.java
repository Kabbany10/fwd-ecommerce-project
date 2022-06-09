package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="gender-male")
    WebElement maleGenderBtn;
    @FindBy(id="FirstName")
    WebElement firstName;
    @FindBy(id="LastName")
    WebElement lastName;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Company")
    WebElement company;
    @FindBy(id="Password")
    WebElement password;
    @FindBy(id="ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(name="DateOfBirthDay")
    WebElement dayDOB;
    @FindBy(name="DateOfBirthMonth")
    WebElement monthDOB;
    @FindBy(name="DateOfBirthYear")
    WebElement yearDOB;
    @FindBy(id="register-button")
    WebElement registerBtn;

    public void fillGender(){
        maleGenderBtn.click();
    }
    public void fillFirstName(){
        firstName.sendKeys("Mohamed");
    }
    public void fillLastName(){
        lastName.sendKeys("El-Kabbany");
    }
    public void fillPassword(){
        password.sendKeys("123456");
    }
    public void fillConfirmPassword(){
        confirmPassword.sendKeys("123456");
    }
    public void fillEmail(){
        email.sendKeys("FWD@eg.com");
    }
    public void fillCompany(){
        company.sendKeys("FWD");
    }

    public void selectDays(String days) {
        WebElement element = driver.findElement((By.id("days")));
        Select daysDropDownElement = new Select(element);
        daysDropDownElement.selectByValue(days);
    }
    public void selectMonths(String months){
        Select monthsDropDownElement = new Select(driver.findElement(By.id("months")));
        monthsDropDownElement.selectByValue(months);
    }
    public void selectYears(String years){
        Select yearsDropDownElement = new Select(driver.findElement(By.id("years")));
        yearsDropDownElement.selectByValue(years);
    }

    public RegistrationCompletePage clickRegister() throws InterruptedException {
        Thread.sleep(3000);
        registerBtn.click();
        return new RegistrationCompletePage(driver);
    }

}
