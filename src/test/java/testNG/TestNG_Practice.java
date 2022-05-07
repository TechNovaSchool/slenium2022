package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Practice {

//    public static void main(String[] args) {
//
//    }

    @BeforeClass
    public void myThirdTest() {
        System.out.println("This is beforeClass Example");
    }

    @Test
    public void bfirstTest() {
        System.out.println("This is my B first testNG run");
    }


    @Test
    public void afirstTest() {
        System.out.println("This is my A first testNG run");
//        Assert.assertEquals(12,15);
//        Assert.assertTrue(12==20);
       Assert.assertFalse(12==20);
       Assert.assertEquals("GoogleTitle", "Goog11leTitle","The title is different");
    }

    @BeforeMethod
    public void myForthTest() {
        System.out.println("This is running before each method");
        //login as an example
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is after method example");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is after class");
        System.out.println("We can use this to close the browser");
    }






}
