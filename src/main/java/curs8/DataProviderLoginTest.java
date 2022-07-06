package curs8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DataProviderLoginTest extends BaseTest {

    @DataProvider(name = "loginTestData")
    public Object[][] loginTestData(){

        Object data[][] = new Object[3][3];

        //valid username + password + boolean
        data[0][0] = "TestUser";
        data[0][1] = "12345@67890";
        data[0][2] = true;

        //invalid username + password + boolean
        data[1][0] = "UserGresit";
        data[1][1] = "ParolaGresita";
        data[1][2] = false;

        //invalid username + password + boolean
        data[2][0] = "User2Gresit";
        data[2][1] = "ParolaGresita";
        data[2][2] = false;
        return data;
    }

    @Test(dataProvider = "loginTestData")
    public void loginTests(String username, String password, boolean success){
        LoginPage loginPage = navMenu.navToLogin();
        loginPage.loginInApp(username,password);

        if (success) {
            assertTrue(loginPage.isLoginSuccessMessageDisplayed());
            loginPage.logoutFromApp();
        } else {
            assertTrue(loginPage.isLoginErrorMessageDisplayed());
            loginPage.closePopup();
        }
    }
}
