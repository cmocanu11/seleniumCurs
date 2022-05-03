package Curs2.Tema;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;

import static org.testng.Assert.assertTrue;

public class CheckElements extends BaseTest {


    @Test(priority = 1)
    public void checkLogin() throws InterruptedException {
        boolean status;
        WebElement loginButton = driver.findElement(By.cssSelector("a[class*='popup_login_link']"));
        assertTrue(loginButton.isDisplayed());

        WebElement userField = driver.findElement(By.id("log"));
        WebElement passwordField = driver.findElement(By.id("password"));
        SoftAssert sa = new SoftAssert();

        status = userField.isDisplayed();
        Reporter.log("Check if user field is not displayed when page is loaded : "+ status,true);
        sa.assertTrue(!status);

        status = passwordField.isDisplayed();
        Reporter.log("Check if password field is not displayed when page is loaded : "+status,true);
        sa.assertTrue(!status);
        sa.assertAll();

        Reporter.log("Click on login button");
        loginButton.click();

        status = userField.isDisplayed();
        Reporter.log("Check if user field is displayed when page is loaded : "+status,true);
        sa.assertTrue(status);

        status = passwordField.isDisplayed();
        Reporter.log("Check if user field is displayed when page is loaded : "+status,true);
        sa.assertTrue(passwordField.isDisplayed());
        sa.assertAll();

    }
}
