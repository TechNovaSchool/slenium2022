package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.linkText("About")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "About";

        if(actualTitle.contains(expectedTitle)) {
            System.out.println("The test case pass");
        }
        else {
            System.out.println("The test case fail");
        }
    }
}
