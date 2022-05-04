package dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    public static void main(String[] args) {
//        https://ultimateqa.com/simple-html-elements-for-automation/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement gender = driver.findElement(By.xpath("//input[@value=\"male\"]"));
        WebElement car = driver.findElement(By.xpath("//input[@value=\"Car\"]"));

        gender.click();
        car.click();


        WebElement dropDown = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Saab");
        dropDown.sendKeys(Keys.BACK_SPACE);


    }
}
