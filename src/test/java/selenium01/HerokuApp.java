package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuApp {
    public static void main(String[] args) {
//        Task #8 HerokuApp Url verification
//        1. Open Chrome browser
//        2. Go to https://the-internet.herokuapp.com/forgot_password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");

//        3. Enter any email into input box
            driver.findElement(By.name("email")).sendKeys("myemail@gmail.com");
//        4. Click on Retrieve password
            driver.findElement(By.id("form_submit")).click();
//        5. Verify URL contains Expected : -->  "Internal Server Error"

            String actualValue = driver.findElement(By.tagName("h1")).getText();
            String expectedValue = "Internal Server Error";

            if(actualValue.contains(expectedValue)){
                System.out.println("Test Pass");
            }
            else {
                System.out.println("Test Fail");
            }

            driver.close();
    }
}
