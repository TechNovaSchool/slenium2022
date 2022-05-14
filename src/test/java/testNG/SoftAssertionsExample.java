package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsExample {
    SoftAssert softAssert;

    @Test
    public void test1() {

        Assert.assertTrue(2==2);
        Assert.assertTrue(2==2);

        String weekEnd = "Sunday";
        String weekDay = "Monday";
       Assert.assertEquals(weekDay,weekEnd);

        System.out.println("This is hard assertion");
    }

    @Test
    public void softAssertion() {
        System.out.println("This is soft assertion example");
        softAssert = new SoftAssert();

        softAssert.assertEquals(5,8);
        System.out.println("This is after soft assert");
//        Assert.assertEquals(5,8);
        System.out.println("This is after herd assert");
//        softAssert.assertAll();
        Assert.assertTrue(5==5);
    }
    @AfterMethod
    public void tearDown() {
       softAssert.assertAll();
    }

}
