package curs1;

import org.testng.annotations.Test;

public class TestNgPriority {

    @Test(priority = 0)
    public void one(){
        System.out.println("First");
    }

    @Test(priority = 3)
    public void two(){
        System.out.println("Second");
    }

    @Test(priority = 2)
    public void three(){
        System.out.println("Third");
    }

    @Test
    public void four(){
        System.out.println("Fourth");
    }

    @Test
    public void five(){
        System.out.println("Fifth");
    }

}
