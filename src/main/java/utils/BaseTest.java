package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public JavascriptExecutor jse;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();

        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
//        driver.manage().window().setPosition(new Point((int)width+1,0));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        openSite();
        jse = (JavascriptExecutor)driver;
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4*1000);
        driver.quit();
    }


    public void background (WebElement element){
        jse.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red');",element);
    }

    public void background (WebElement element,String color){
        jse.executeScript("arguments[0].setAttribute('style','background:"+color+"; border:4px solid red');",element);
    }

    public void openSite(){
        driver.get("https://keybooks.ro");
    }

    public void openSite(String url){
        driver.get(url);
    }
}
