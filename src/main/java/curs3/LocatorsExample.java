package curs3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class LocatorsExample extends BaseTest {
    @Test(priority = 1)
    public void tagNameLocator() throws InterruptedException {
        WebElement tagName = driver.findElement(By.tagName("em"));
        System.out.println(tagName.isDisplayed() + " " + tagName.getText());

        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",tagName);
        assertEquals(tagName.getText(),"Discover");
    }

    @Test(priority = 2)
    public void linkTextLocator() throws InterruptedException {
        WebElement linkText = driver.findElement(By.linkText("BOOKS"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",linkText);
        linkText.click();
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/");
    }

    @Test(priority = 3)
    public void partialLinkTextLocator() {
        WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
        cookingBook.click();
        assertEquals(driver.getTitle(),"Cooking with love – Booklovers");
    }

    @Test(priority = 4)
    public void classNameLocator(){
        WebElement productPrice = driver.findElement(By.className("price"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",productPrice);
        assertTrue(productPrice.getText().contains("20.55"));
    }

    @Test(priority =5)
    public void idLocator() {
        //<li class="reviews_tab active" id="tab-title-reviews" role="tab" aria-controls="tab-reviews">
        WebElement tabReview = driver.findElement(By.id("tab-title-reviews"));
        jse.executeScript("window.scrollBy(0,500);");

        tabReview.click();
        WebElement comment = driver.findElement(By.id("reply-title"));
        jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')",
                comment);
        assertTrue(comment.isDisplayed());
    }

    @Test(priority = 6)
    public void checkBoxTest(){
        WebElement checkbox = driver.findElement(By.id("wp-comment-cookies-consent"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",checkbox);
//        checkbox.isSelected();
    }

    @Test(priority = 7)
    public void xpathLocator() throws InterruptedException {
        WebElement commentField = driver.findElement(By.xpath("//textarea[@id='comment']"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",commentField);
        commentField.sendKeys("My comment");
    }

    @Test(priority = 8)
    public void nameLocator() throws InterruptedException {
        WebElement nameField = driver.findElement(By.name("author"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",nameField);
        nameField.sendKeys("John Doe");
        nameField.clear();
        nameField.sendKeys("Johnny Bravo");
    }

    @Test(priority = 9)
    public void cssLocator() throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')",emailField);
        emailField.sendKeys("johhnny.bravo@cnn.com");

        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkBox.submit();
        WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit'"));
        submitButton.click();

        //Alerte JS
        Alert alertJs = driver.switchTo().alert();
        alertJs.accept();

        WebElement rating = driver.findElement(By.cssSelector("a[class='star-3']"));
        rating.click();
        submitButton.click();
        Thread.sleep(2000);

    }



}
