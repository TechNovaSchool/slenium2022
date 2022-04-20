package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributePractice {
    public static void main(String[] args) {

        // Task #9 -- Zero Bank header verification
//1. Open Chrome browser
//2. Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

//3. Get attribute value of href from the "Forgot your password" link
        WebElement linkElement = driver.findElement(By.partialLinkText("Forgot"));


//       String actualAttributeValue = driver.findElement(By.partialLinkText("Forgot")).getAttribute("href");
        String actualAttributeValue = linkElement.getAttribute("href");
        String expectedAttributeValue = "forgot-password";
//5. Verify attribute value contains Expected --> "forgot-password"

        if (actualAttributeValue.contains(expectedAttributeValue)) {

            System.out.println("Value is correct");
        }
        else{
            System.out.println("Value is false");
        }
// 4.  Check if "Forgotten Password" is present in the page
//        driver.findElement(By.partialLinkText("Forgot")).click();
        linkElement.click();

         boolean header = driver.findElement(By.tagName("h3")).isDisplayed();

         if(header){
             System.out.println("Test Pass");
         }
         else {
             System.out.println("Test fail");
         }


    }
}
