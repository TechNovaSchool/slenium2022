package dropDown;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectPractice {
    //https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html

    public static void main(String[] args) {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement dropDown1 = driver.findElement(By.xpath("//select[@id=\"dropdowm-menu-1\"]"));
        WebElement dropDown2 = driver.findElement(By.xpath("//select[@id=\"dropdowm-menu-2\"]"));
        WebElement dropDown3 = driver.findElement(By.xpath("//select[@id=\"dropdowm-menu-3\"]"));

        Select select1 = new Select(dropDown1);
        select1.selectByVisibleText("Python");


        Select select2 = new Select(dropDown2);
        select2.selectByIndex(1);

        Select select3 = new Select(dropDown3);
        select3.selectByValue("javascript");


    }
}
