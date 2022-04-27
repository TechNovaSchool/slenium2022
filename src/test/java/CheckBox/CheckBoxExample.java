package CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxExample {
    public static void main(String[] args) {
//        1. Open a Chrome browser
////        2. Go to https://the-internet.herokuapp.com/checkboxes
////        3. Verify Checkbox 2 is Checked
////        4. Click on check-box 1
////        5. Verify CheckboxOne is Checked


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));

        if (checkbox2.isSelected()) {
            System.out.println("Test 1 Pass");
        }
        else {
            System.out.println("Test 1 Fail");
        }

         checkbox1.click();

        if (checkbox1.isSelected()) {
            System.out.println("Test 2 Pass");
        }
        else {
            System.out.println("Test 2 Fail");
        }
    }
}
