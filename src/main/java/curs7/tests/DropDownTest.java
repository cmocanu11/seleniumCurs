package curs7.tests;

import curs7.pages.ShopPage;
import org.testng.annotations.Test;
import pages.NavMenuPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class DropDownTest extends BaseTest {

    public ShopPage shopPage;
    @Test (groups = "ProductFunctionality")
    public void filterByValue() {
        shopPage = navMenu.navToShopPage();
        shopPage.filterByValue("popularity");
        assertEquals(shopPage.getCurrentSelectedOption(),"Sort by popularity");
    }

    @Test(groups = "ProductFunctionality")
    public void filterByIndex(){
        shopPage = navMenu.navToShopPage();
        shopPage.filterByIndex(3);
        assertEquals(shopPage.getCurrentSelectedOption(),"Sort by latest");
    }

    @Test(groups = "ProductFunctionality")
    public void filterByVisibleText(){
        shopPage = navMenu.navToShopPage();
        shopPage.filterByVisibleText("Sort by price: high to low");
        assertEquals(shopPage.getCurrentSelectedOption(),"Sort by price: high to low");
    }
}
