package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class XpathExamples2 extends BaseTest {
    @Test
    public void xpathExample1(){
        WebElement loginMenu = driver.findElement(By.xpath("//a[contains(@class,'popup_link')]/parent::li[@class='menu_user_login']"));
        background(loginMenu);
        loginMenu.click();

        //Descendant --> //form[contains(@class,'popup_form')]/descendant::input[@id='log']
        //Child --> //form[contains(@class,'popup_form')]/child::div[contains(@class,'login_field')]/child::input[@id='log']
        WebElement userField= driver.findElement(By.xpath("//form[contains(@class,'popup_form')]/child::div[contains(@class,'login_field')]/child::input[@id='log']"));
        background(userField);
        userField.sendKeys("TestUser");

        WebElement passField = driver.findElement(By.xpath("//form[contains(@class,'popup_form')]/descendant::input[@id='password']"));
        background(passField,"orange");
        passField.sendKeys("12345@67890");
    }
}
