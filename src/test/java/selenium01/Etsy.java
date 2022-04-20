package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {
    public static void main(String[] args) {
//        Task #6 -- Etsy Title Verification
//        1. Open a Chrome browser
//        2. Go to https://www.etsy.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");

//        3. Search for gift box
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("gift box" + Keys.ENTER);


//        4. Verify title --> expected Gift box | Etsy
        String actualTile = driver.getTitle();
        String expectedTitle = "Gift box | Etsy";

        if (actualTile.equals(expectedTitle)) {
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Fail");
        }



    }
}
