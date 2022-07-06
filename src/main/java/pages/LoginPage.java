package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //driver.findElement(By.id("log"))
    //driver.findElement(usernameField)
    public By usernameField = By.id("log");
    public By passwordField = By.id("password");
    public By submitButton = By.cssSelector("input[class='submit_button']");
    public By loginSuccessMessage = By.cssSelector("div[class*='sc_infobox_style_success']");

    public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
    public By loginErrorMessage  = By.cssSelector("div[class*='sc_infobox_style_error']");
    public By popupClose = By.cssSelector("a[class='popup_close']");

    public void setUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public void loginInApp(String user, String pass){
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(submitButton).click();
    }

    public void closePopup(){
        driver.findElement(popupClose).click();
    }

    public void logoutFromApp(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public boolean isLoginErrorMessageDisplayed(){
        return driver.findElement(loginErrorMessage).isDisplayed();
    }
    public boolean isLoginSuccessMessageDisplayed(){
        return driver.findElement(loginSuccessMessage).isDisplayed();
    }

}
