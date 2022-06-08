package utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.NavMenuPage;

import java.awt.*;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public JavascriptExecutor jse;
    public NavMenuPage navMenu;

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

        navMenu = new NavMenuPage(driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4*1000);
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot poza = (TakesScreenshot)driver;
            File picture = poza.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            try {
                Files.copy(picture, new File("screenshots/" + result.getName() + "__" + timestamp + ".png"));
                System.out.println("Picture saved");
            } catch (IOException e) {
                System.out.println("Picture could not be saved");
                e.printStackTrace();
            }
        }
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
