package curs7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {

    public WebDriver driver;
    public WebElement dropDown;
    public Select selectDropDown;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public By orderDropDown = By.name("orderby");

    public void filterByValue(String value){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByValue(value);
    }

    public void filterByIndex(int index){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByIndex(index);
    }

    public void filterByVisibleText(String text){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByVisibleText(text);
    }

    public String getCurrentSelectedOption(){
        dropDown = driver.findElement(orderDropDown);
        selectDropDown = new Select(dropDown);
        return selectDropDown.getFirstSelectedOption().getText();
    }
}
