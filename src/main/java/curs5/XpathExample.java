package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class XpathExample extends BaseTest {

    @Test
    public void xpathExample1() throws InterruptedException {

        //css --> li[class='menu_user_login']
        //xpath --> //li[@class='menu_user_login']

        WebElement loginMenu = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
        background(loginMenu);
        loginMenu.click();

        WebElement userField = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
        background(userField);
        userField.sendKeys("TestUser");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
        background(passwordField);
        passwordField.sendKeys("12345@67890");

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberme']"));
        checkBox.click();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit_button']"));
        loginButton.click();
        Thread.sleep(4000);

        WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
        assertEquals(userName.getText(),"Test User");
    }

    @Test(priority = 2)
    public void xpathExample2(){
        WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
        userName.click();

        WebElement settingsLink = driver.findElement(By.xpath("//a[contains(text(), 'Settings')]"));
        settingsLink.click();

        WebElement recentOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'recent')]"));
        background(recentOrdersLink);
        recentOrdersLink.click();

        WebElement orderTableHeader = driver.findElement(By.xpath("//th[contains(@class,'woocommerce-orders-table__header')]/span[contains(text(),'Order')]"));
        background(orderTableHeader);

        WebElement statusTableHeader = driver.findElement(By.xpath("(//th[contains(@class,'woocommerce-orders-table__header')]/span)[3]"));
        background(statusTableHeader);

        WebElement orderNr= driver.findElement(By.xpath("//td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1653')]"));
        //xpath --> //td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1653')]
        //css --> td[class*='woocommerce-orders-table__cell'][data-title='Order']>a[href*='1653']
        orderNr.click();
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/account/view-order/1653/");
    }
}
