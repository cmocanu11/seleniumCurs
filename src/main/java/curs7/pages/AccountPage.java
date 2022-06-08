package curs7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {

        this.driver = driver;

    }

    public By editAddress = By.xpath("//li[contains(@class,'woocommerce-MyAccount-navigation-link--edit-address')]/a");

    public AddressesPage navigateToEditAddress(){
        driver.findElement(editAddress).click();
        return new AddressesPage(driver);
    }

}
