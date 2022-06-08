package pages;

import curs7.pages.AccountPage;
import curs7.pages.ContactsPage;
import curs7.pages.ShopPage;
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
    public By shopLink = By.linkText("BOOKS");
    public By contactsLink = By.linkText("CONTACTS");
    public By settings = By.linkText("Settings");

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

    public ShopPage navToShopPage() {
        driver.findElement(shopLink).click();
        return new ShopPage(driver);
    }

    public ContactsPage navToContactsPage() {
        driver.findElement(contactsLink).click();
        return new ContactsPage(driver);
    }

    public AccountPage navToAccountPage(){
        driver.findElement(loggedUsername).click();
        driver.findElement(settings).click();
        return new AccountPage(driver);
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
