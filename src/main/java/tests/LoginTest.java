package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class LoginTest extends BaseTest {

    @Parameters({"user","pass"})
    @Test (groups = "LoginFunctionality", priority = 1)
    public void loginTestValid(String username, String password){
        LoginPage loginPage = navMenu.navToLogin();
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickSubmit();
        assertEquals(navMenu.getLoggedUsername(), "Test User");
        loginPage.logoutFromApp();
    }

    @Parameters({"invalidUser","invalidPass"})
    @Test (groups = "LoginFunctionality", priority = 2)
    public void loginTestInvalid(String username, String password){
        LoginPage loginPage = navMenu.navToLogin();
        loginPage.loginInApp(username,password);
        assertTrue(loginPage.isLoginErrorMessageDisplayed());

    }
}
