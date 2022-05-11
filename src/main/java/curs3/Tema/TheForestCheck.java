package curs3.Tema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class TheForestCheck extends BaseTest {
    WebElement carte;
    @Test
    public void checkTheForest() throws InterruptedException {

        List<WebElement> webElement = driver.findElements(By.cssSelector("li[role='tab']"));

        for (WebElement element:webElement) {
            element.click();
            carte = driver.findElement(By.linkText("The forest"));
            assertTrue(carte.isDisplayed());
            Thread.sleep(1*1000);
        }
//        carte.click(); // Nu inteleg de ce nu merge asa, se sterge cumva elementul carte dupa ce se termina for-ul, nu ar fi trebuit sa ramana elementul?
        driver.findElement(By.linkText("The forest")).click();
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-forest/");
    }
}
