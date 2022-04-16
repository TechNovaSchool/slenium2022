package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumPractice {
    //main
    //psvm

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // this line creates connection between driver and selenium
        //and set up the driver

        WebDriver driver = new ChromeDriver();//we create instance of chromeDriver
        driver.manage().window().maximize();

        driver.get("https://www.google.com/"); //it will navigate to the http address

        System.out.println(driver.getTitle());

        driver.navigate().back();
        driver.navigate().forward();

        driver.navigate().to("https://www.etsy.com");//this is similar to driver.get()
        // but not waiting for page to load
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close(); //it will close the browser



//        Task #1
//        1.Open Chrome browser
//        2.Go to https://www.google.com
//        3.Verify title: Expected title is Google
//
//
//        Task#2
//        1.Open Chrome browser
//        2.Go to https://www.technovaschool.com/
//        3.Verify URL contains : technovaschool
//        4.Verify title expected: IT School Online | Tech Nova School










    }

}
