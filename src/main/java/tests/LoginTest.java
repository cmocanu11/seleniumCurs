package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        NavMenuPage navMenuPage = new NavMenuPage(driver);
        navMenuPage.navigateToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField("TestUser");
        loginPage.setPasswordField("12345@67890");
        loginPage.clickSubmit();

        assertEquals(navMenuPage.getLoggedUsername(), "Test User");
    }
}
