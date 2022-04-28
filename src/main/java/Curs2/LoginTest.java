package Curs2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Function;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginTest() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

//        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:5px solid red;')",usernameField);
//        Thread.sleep(3*1000);
//        jse.executeScript("arguments[0].setAttribute('style','display:none;')",usernameField);
//        assertTrue(usernameField.isDisplayed());
//        jse.executeScript("arguments[0].setAttribute('disabled','')",usernameField);
//        assertTrue(usernameField.isEnabled());

        usernameField.click();
        usernameField.sendKeys("tomsmith");
        passwordField.click();
        passwordField.sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        WebElement successMsg = driver.findElement(By.id("flash"));
        assertTrue(successMsg.getText().contains("You logged into a secure area!"));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4*1000);
        driver.quit();
    }
}
