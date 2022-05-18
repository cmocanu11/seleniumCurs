package curs4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class JsAlerts extends BaseTest {

    @Test(priority = 1)
    public void simpleJsAlert() throws InterruptedException {
        openSite("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick*='Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals(result,"You successfully clicked an alert");
    }

    @Test(priority = 2)
    public void confirmJsAlert() throws InterruptedException {
        openSite("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick*='Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals(result,"You clicked: Cancel");
    }

    @Test(priority = 3)
    public void promptJsAlert() throws InterruptedException {
        openSite("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick*='Prompt']")).click();
        Thread.sleep(3000);
        String text = "text";
        Alert alertaJs = driver.switchTo().alert();
        alertaJs.sendKeys(text);
        alertaJs.accept();
        String result = driver.findElement(By.id("result")).getText();
        assertEquals(result,"You entered: "+text);
    }
}
