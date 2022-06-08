package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {

    public WebDriver driver;

    public SeleniumWrappers(WebDriver driver){
        this.driver = driver;
    }

    public void customClick(By element){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement webElement = driver.findElement(element);
            webElement.click();

        }catch (Exception e){
            //retry mechanism -- orice ai nevoie
        }
    }
}
