package curs8.Tema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class Tema8 extends BaseTest {

    @DataProvider(name = "booksTestData")
    public Object[][] booksTestData(){

        Object data[][] = new Object[4][2];

        //valid username + password + boolean
        data[0][0] = "A banquet of mouse";
        data[0][1] = "img[alt='A banquet of  mouse']";

        //invalid username + password + boolean
        data[1][0] = "Cooking with love";
        data[1][1] = "img[alt='Cooking with love']";

        //invalid username + password + boolean
        data[2][0] = "Let the sun shine";
        data[2][1] = "img[alt='Let the sun shine']";

        data[3][0] = "New galaxy";
        data[3][1] = "img[alt='New galaxy']";

        return data;
    }

    @Test(dataProvider = "booksTestData")
    public void test(String bookTitle, String selector) throws InterruptedException {
        WebElement searchButton = driver.findElement(By.cssSelector("button[class = 'search_submit icon-search']"));
        searchButton.click();
        WebElement inputText = driver.findElement(By.cssSelector("input[class = 'search_field']"));
        inputText.clear();
        inputText.sendKeys(bookTitle);
        inputText.submit();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector)));
        assertTrue(driver.findElement(By.cssSelector(selector)).isDisplayed());
        Thread.sleep(2000);
    }
}
