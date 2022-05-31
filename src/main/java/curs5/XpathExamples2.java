package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class XpathExamples2 extends BaseTest {
//    @Test
    public void xpathExample1() throws InterruptedException {
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

        //following-sibling
        ////div[contains(@class,'login_field')]/following-sibling::div[contains(@class,'remember_field')]/input
        WebElement rememberMeBox = driver.findElement(
                By.xpath("//div[contains(@class,'login_field')]/following-sibling::div[contains(@class,'remember_field')]/input"));
        background(rememberMeBox);
        rememberMeBox.click();

        //preceding
        ////form[contains(@class,'login_form')]/preceding::input[@class='submit_button']
        WebElement loginButton = driver.findElement(By.xpath("//form[contains(@class,'login_form')]/preceding::input[@class='submit_button']"));
        loginButton.click();
        Thread.sleep(3000);
    }

    @Test
    public void xpathExample2(){
        WebElement loginMenu = driver.findElement(By.xpath("//a[contains(@class,'popup_link')]/parent::li[@class='menu_user_login']"));
        background(loginMenu);
        loginMenu.click();


        //ancestor
        //input[contains(@class,'submit_button')]/ancestor::form/div[contains(@class,'login_field')]/input
        WebElement userField= driver.findElement(By.xpath("//input[contains(@class,'submit_button')]/ancestor::form/div[contains(@class,'login_field')]/input"));
        background(userField);
        userField.sendKeys("TestUser");

        //input[contains(@class,'submit_button')]/ancestor::form/child::div[contains(@class,'password_field')]
        WebElement passField = driver.findElement(By.xpath("//input[contains(@class,'submit_button')]/ancestor::form/child::div[contains(@class,'password_field')]/input"));
        background(passField,"orange");
        passField.sendKeys("12345@67890");

        //input[contains(@class,'submit_button')]/ancestor::form/preceding::input[@id='rememberme']
        WebElement rememberMeBox = driver.findElement(
                By.xpath("//input[contains(@class,'submit_button')]/ancestor::form/preceding::input[@id='rememberme']"));
        background(rememberMeBox);
        rememberMeBox.click();
    }
}
