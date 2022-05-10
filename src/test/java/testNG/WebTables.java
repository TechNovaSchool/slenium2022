package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openLink(){
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void changeName() {
        String newName = "Alisa";
        WebElement editBtn = driver.findElement(By.cssSelector("#edit-record-1"));
        editBtn.click();
        WebElement name = driver.findElement(By.cssSelector("#firstName"));
        name.clear();
        name.sendKeys(newName);
        Assert.assertTrue(1==2);

        WebElement submitBtn = driver.findElement(By.cssSelector("#submit"));
        submitBtn.click();
        WebElement updatedName = driver.findElement(By.xpath("//div[.='"+newName+"']"));
        Assert.assertEquals(updatedName.getText(), newName);
    }
    @Test
    public void deleteRow() {
    WebElement deleteBtn = driver.findElement(By.cssSelector("#delete-record-2"));
    deleteBtn.click();
    //add assertion
    }

    @AfterClass
    public void tearDown() {
    driver.close();
    }
}
