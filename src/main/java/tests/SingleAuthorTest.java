package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

import static org.testng.Assert.*;


public class SingleAuthorTest extends BaseTest {

    @Test
    public void singleAuthorTest() {

        SingleAuthorPage singleAuthorPage = new NavMenuPage(driver).navToSingleAuthorPage();
        String dramaValue = singleAuthorPage.objectValue(singleAuthorPage.dramaValue);
        String biographyValue = singleAuthorPage.objectValue(singleAuthorPage.biographyValue);
        String cooksbookValue = singleAuthorPage.objectValue(singleAuthorPage.cookBooksValue);

        assertEquals(dramaValue, "95%");
        assertEquals(biographyValue, "75%");
        assertEquals(cooksbookValue, "82%");
    }
}
