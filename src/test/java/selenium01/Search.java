package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

         driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

         String actualTile = driver.getTitle();
         String expectedTile = "apple";

         if(actualTile.contains(expectedTile)) {
             System.out.println("The title test PASS");
         }
         else {
             System.out.println("The title test FAIL" );
         }

    }

//    Task #4
//            1. Open Chrome browser
//2. Go to google.com
//3. Write "apple" in search box
//4. Click google search button
//5. Verify title it should contain a word "apple"

}
