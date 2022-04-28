package Curs2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class FindElementsExample extends BaseTest {

    @Test(priority = 2)
    public void findElementsExample(){
        List<WebElement> carti = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
        int size = carti.size();
        System.out.println(size);
        carti.get(2).click();

        String expectedUrl = "https://keybooks.ro/shop/life-in-the-garden/";
        assertEquals(expectedUrl,driver.getCurrentUrl());

        String pageTitle = "Life in the garden – Booklovers";
        assertEquals(pageTitle,driver.getTitle());

        WebElement bookTitle = driver.findElement(By.cssSelector("h1[class*='product_title'"));
        assertEquals(bookTitle.getText(),"Life in the garden");
    }

    @Test(priority = 1)
    public void findElementsExample1() throws InterruptedException {
        List<WebElement> carti = driver.findElements(By.cssSelector("figure[class*='sc_image']"));
        Actions actions = new Actions(driver);
        for (WebElement image:carti) {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
//            actions.moveToElement(image);
            actions.moveToElement(image,100,200);
            jse.executeScript("arguments[0].setAttribute('style','border:10px solid red;')",image);
            Thread.sleep(1000);

        }


    }

}
