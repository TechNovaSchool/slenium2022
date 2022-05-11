package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    public void informationalAlert() {
        WebElement jsAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Alert\"]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement messageResult = driver.findElement(By.xpath("//p[@id=\"result\"]"));

        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(messageResult.getText(), expectedResult, "The result is different");
    }

    @Test
    public void confirmationAlert() {
       WebElement confirmAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Confirm\"]"));
       confirmAlert.click();
//
        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//        WebElement messageResult = driver.findElement(By.xpath("//p[@id=\"result\"]"));
//
//        Assert.assertTrue(messageResult.getText().contains("Ok"));
//        confirmAlert.click();
        alert.dismiss();

        WebElement messageResultForDismiss = driver.findElement(By.xpath("//p[@id=\"result\"]"));

        Assert.assertTrue(messageResultForDismiss.getText().contains("Cancel"));

    }

    @Test
    public void promptAlert() {
        String myTextForAlert = "Hello Alert Class!";
        WebElement promptAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Prompt\"]"));
        promptAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(myTextForAlert);
        alert.accept();

        WebElement messageResult = driver.findElement(By.xpath("//p[@id=\"result\"]"));

        Assert.assertTrue(messageResult.getText().contains(myTextForAlert));

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
