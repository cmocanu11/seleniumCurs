package curs4.Tema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class BuyBook extends BaseTest {
    WebDriverWait wait;

    @Test(priority = 1)
    private void buyBook() throws InterruptedException {
        wait = new WebDriverWait(driver,10);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class*='search_submit'][title='Open search']"));
        searchButton.click();
        WebElement searchField = driver.findElement(By.cssSelector("input[class='search_field']"));
        searchField.sendKeys("The story about me");
        searchButton.click(); //aici mai are momente cand la unele rulari ceva ii da cu virgula si se blocheaza
        WebElement viewMoreButton = driver.findElement(By.cssSelector("a[id='viewmore_link']"));
        viewMoreButton.click();
        WebElement searchedBook = driver.findElement(By.cssSelector("a[href$='about-me/']"));

        wait.until(ExpectedConditions.textToBePresentInElement(searchedBook,"The story about me"));
        searchedBook.click();

        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-story-about-me/");

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[class*='single_add_to_cart_button']"));
        addToCartButton.click();

        WebElement addedToCartMessage = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
        assertTrue(addedToCartMessage.getText().contains("“The story about me” has been added to your cart."));

        WebElement viewCartButton = driver.findElement(By.cssSelector("a[href$='cart/']"));
        viewCartButton.click();
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/cart/");
    }
    @Test(priority = 2)
    private void cartTests() throws InterruptedException {
        WebElement qtyInput = driver.findElement(By.cssSelector("input[class*='input-text qty']"));
        qtyInput.clear();
        qtyInput.sendKeys("2");
        WebElement updateCart = driver.findElement(By.cssSelector("button[class='button'][name='update_cart']"));
        updateCart.click();
        WebElement updatedCartMessage = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
        assertEquals(updatedCartMessage.getText(),"Cart updated.");
        WebElement proceedToCheckout = driver.findElement(By.cssSelector("a[class*='checkout-button']"));
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
//        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
//        Thread.sleep(2000); //am pus cu thread.sleep din cauza faptului ca atunci cand foloseam wait. mergea aleator si n-am gasit alta solutie momentan
        jse.executeScript("window.scrollBy(0,300)");
        proceedToCheckout.click();
        assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/checkout/");

        WebElement billingDetails = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields'] > h3"));
        assertTrue(billingDetails.isDisplayed());

        WebElement additionalInformation = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields'] > h3"));
        assertTrue(billingDetails.isDisplayed());

    }




}
