package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonTask {
    public static void main(String[] args) {
//        1. Open a chrome browser
//        2. Go to amazon.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
        String searchTerm = "java book";

//        3. Enter any search "term"
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchTerm);
        //        4. Click on search button

        driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();

        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(searchTerm);


//        5. Verify title contain "term"
        String actualValue = driver.getTitle();

        if(actualValue.contains(searchTerm)) {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
}
