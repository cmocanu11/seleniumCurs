package curs7;

import curs7.pages.AccountPage;
import curs7.pages.AddressesPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class Tema extends BaseTest {

    @Test
    public void shippingTest() {
        NavMenuPage navMenuPage = new NavMenuPage(driver);
        LoginPage loginPage = navMenuPage.navToLogin();
        loginPage.loginInApp("TestUser", "12345@67890");
        AccountPage accountPage = navMenuPage.navToAccountPage();
        AddressesPage addressesPage = accountPage.navigateToEditAddress();
        addressesPage.navigateToEditShippingAddress();
        addressesPage.filterByIndex(41, addressesPage.countryDropDown);
        assertEquals("Canada", addressesPage.getCurrentSelectedOption(addressesPage.countryDropDown));

        addressesPage.filterByValue("NL", addressesPage.provinceDropDown);
        assertEquals("Newfoundland and Labrador", addressesPage.getCurrentSelectedOption(addressesPage.provinceDropDown));
    }

}
