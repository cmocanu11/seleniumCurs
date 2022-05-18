package curs4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

public class CssSelectorExample extends BaseTest {

//    @Test
    public void cssSelector1(){

        WebElement elementLoginButton = driver.findElement(By.cssSelector("a[class*='popup_link']"));
        elementLoginButton.click();

        //and
        WebElement element = driver.findElement(By.cssSelector("input[id='log']"));

        background(element);

        WebElement usernameField = driver.findElement(By.cssSelector("input[id='log'][type='text'][name='log']"));
        usernameField.sendKeys("TestUser");

        //or
        WebElement elementPass = driver.findElement(By.cssSelector("input[id='password']"));
        background(elementPass);

        WebElement passwordField = driver.findElement(By.cssSelector("input[id='password'],[type='password'],[name='pwd']"));
        passwordField.sendKeys("12345@67890");

        WebElement loginButton = driver.findElement(By.cssSelector("input[class='submit_button'],[type='submit'],[value='Login']"));
        loginButton.click();

    }

    @Test
    public void cssSelector2() throws InterruptedException {

        //contains | contine chiar daca nu este cuvantul intreg , nu este exact match
        //dintr-o lista de mai multe elemente, da click mereu pe primul
        WebElement bookTitle = driver.findElement(By.cssSelector("h3[class*='sc_title_regular']"));
        System.out.println(bookTitle.getText());

        //contains word |Diferenta e ca trebuie cuvantul sa fie intreg, este exact match
        WebElement discoverMoreBooksButton = driver.findElement(By.cssSelector("a[class~='sc_button_style_filled']"));
        System.out.println(discoverMoreBooksButton.getText());

        //starting with
        WebElement bookStartingWith = driver.findElement(By.cssSelector("a[href^='its-a-really-']"));
        System.out.println(bookStartingWith.getText());
        background(bookStartingWith);

        //ends with
        WebElement bookEndsWith = driver.findElement(By.cssSelector("a[href$='garden']"));
        System.out.println(bookEndsWith.getText());

        //not
//        li[class*='sc_tabs_title']:not([aria-selected='true'])
//        li[class*='sc_tabs_title']:not([class*='ui-state-active'])
//        li[class*='sc_tabs_title']:not(.ui-state-active)
        List<WebElement> menuTabs = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));

        //menuTabs.get(3);
        //xpath: (//li[contains(@class,'sc_tabs_title')])[3]
        //css: li[class*='sc_tabs_title']:nth-child(3)

        for (WebElement element : menuTabs) {
            background(element);
            System.out.println(element.getText());
        }
        //nth-child
        WebElement thirdMenuEntry = driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-child(3)"));
        background(thirdMenuEntry,"red");
    }

}
