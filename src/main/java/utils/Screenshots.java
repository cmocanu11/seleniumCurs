package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    public void screenshot(WebDriver driver){
        TakesScreenshot poza = (TakesScreenshot)driver;
        File picture = poza.getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(picture,new File("screenshots/screen.png"));
            System.out.println("Picture saved");
        } catch (IOException e) {
            System.out.println("Picture could not be saved");
            e.printStackTrace();
        }

    }

}
