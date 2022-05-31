package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavMenuPage {

    public WebDriver driver;

    public NavMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public By loginLink = By.linkText("Login");
    public By homeLink = By.linkText("HOME");
    public By singleAuthorLink = By.linkText("SINGLE AUTHOR");

    public By loggedUsername = By.cssSelector("span[class='user_name']");

    //metoda 1
    public void navigateToLogin(){
        driver.findElement(loginLink).click();
    }

    public void navigateToHome(){
        driver.findElement(homeLink).click();
    }

    public SingleAuthorPage navToSingleAuthorPage() {
        driver.findElement(singleAuthorLink).click();
        return new SingleAuthorPage(driver);
    }

    //metoda 2
    public void navigateToLocator(By locator){
        driver.findElement(locator).click();
    }

    //metoda 3
    public LoginPage navToLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public String getLoggedUsername(){
        return driver.findElement(loggedUsername).getText();
    }

}
