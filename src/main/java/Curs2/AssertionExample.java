package Curs2;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class AssertionExample {

    @Test(priority = 1)
    public void softAssert(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Soft Assert incepe aici");
        softAssert.assertTrue(false);
        System.out.println("Cod dupa soft assert!");
        softAssert.assertTrue(false);
        System.out.println("Soft assert se inchide aici");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void hardAssert(){
        System.out.println("Hard assert incepe aici");
        assertTrue(false);
        System.out.println("Cod dupa hard assert!");

        System.out.println("Hard assert se inchide aici");

    }

}
