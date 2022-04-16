package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTask1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("The title test pass");
        }
        else {
            System.out.println("The title test failed");
        }


//        Task#2
//        1.Open Chrome browser

//        2.Go to https://www.technovaschool.com/
            driver.get("https://www.technovaschool.com/");

//        3.Verify URL contains : technovaschool
            String actualUrl = driver.getCurrentUrl();
            String expected = "technovaschool";

            if (actualUrl.contains(expected)) {
                System.out.println("The second test pass");
            }
            else {
                System.out.println("Second test fail");
            }


//        4.Verify title expected: IT School Online | Tech Nova School

        String actualtitleSchool = driver.getTitle();
        String expextedtitleSchool = "IT School Online | Tech Nova School";

        if (actualtitleSchool.equals(expextedtitleSchool)) {
            System.out.println("The third test pass");
        }
        else {
            System.out.println("Third test fail");
        }




    }
}
