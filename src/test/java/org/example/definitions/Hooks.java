package org.example.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    protected HomePage homePage;

    @Before
    public void setUp(){
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7 , TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
