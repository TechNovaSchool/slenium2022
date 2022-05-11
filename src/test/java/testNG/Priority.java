package testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority {

    @Test (priority = 1)
    public void test1() {
        System.out.println("This is test1 running");
    }

    @Ignore
    @Test (priority = 1)
    public void test2() {
        System.out.println("This is test2 running");
    }

////    @Test (priority = 1)
//    public void test2() {
//        System.out.println("This is test2 running");
//    }


    @Test (priority = 2,dependsOnMethods = "login")
    public void test3() {
        System.out.println("This is test3 running");
    }

    @Test (priority = 3)
    public void login() {
        System.out.println("This is test4 running");

    }

    @Test (dependsOnMethods = "login")
    public void test5() {
        System.out.println("This is test5 running");
    }
}
