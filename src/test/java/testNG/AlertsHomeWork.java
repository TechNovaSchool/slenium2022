package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsHomeWork {

//    Navigate to https://webdriveruniversity.com/Popup-Alerts/index.html
//            "Click Me" on JavaScript Alert
//"Click Me" on Modal Popup
//"CLICK ME!" JavaScript Confirm Box and dismiss alert
//    Assert that text "You pressed Cancel!" is displayed

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
    }

    @Test
    public void handleAlerts() {
        WebElement warningAlert = driver.findElement(By.xpath("//span[@id=\"button1\"]"));
        warningAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement warningAlert2 = driver.findElement(By.xpath("//span[@id=\"button2\"]"));
        warningAlert2.click();
        WebElement closeBtn = driver.findElement(By.xpath("//button[.=\"Close\"]"));
        closeBtn.click();

        WebElement confirmationAlert = driver.findElement(By.xpath("//span[@id=\"button4\"]"));
        confirmationAlert.click();

        alert.dismiss();

        WebElement dismissMessage = driver.findElement(By.xpath("//p[@id=\"confirm-alert-text\"]"));

        Assert.assertTrue(dismissMessage.isDisplayed());




    }


}
