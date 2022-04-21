package curs1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestNgDependency {

    @Test
    public void method1(){
        System.out.println("Method 1");
    }

    @Test(dependsOnMethods = "method1")
    public void method2(){
        System.out.println("Method 2");
    }

    @Test
    public void method3(){
        System.out.println("Method 3");
    }
}
