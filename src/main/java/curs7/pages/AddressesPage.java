package curs7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {
    public WebDriver driver;

    public AddressesPage(WebDriver driver) {

        this.driver = driver;

    }

    //Main page
    public By editShippingAddress = By.xpath("//h3[contains(text(),'Shipping address')]/following-sibling::a[@class='edit']");

    public void navigateToEditShippingAddress(){
        driver.findElement(editShippingAddress).click();
    }


    //Sub-page
    public By countryDropDown = By.name("shipping_country");
    public By provinceDropDown = By.name("shipping_state");
    public WebElement dropDown;
    public Select selectDropDown;

    public void filterByValue(String value, By orderDropDown){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByValue(value);
    }
    //41 - canada
    public void filterByIndex(int index, By orderDropDown){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByIndex(index);
    }

    public String getCurrentSelectedOption(By orderDropDown){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        return selectDropDown.getFirstSelectedOption().getText();
    }

}
