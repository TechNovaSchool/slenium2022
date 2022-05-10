package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smartBear.SmartBear;

import java.util.concurrent.TimeUnit;

public class DeleteAll {


//    TestNG and SmartBear
//    Task DeleteAll
//1. Open a chrome browser
//2. Go to :http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//            3. Enter username : “Tester”
//            4. Enter password: “test”
//            5. Click on logon button
//6. Click checkAll
//7. Click “Delete Selected”
//            8. Assert “List of orders is empty. In order to add new order use  this link.” text is displayed

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void deleteAllTest() {
        SmartBear.loginToSmartBear(driver);
        WebElement checkAllBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_btnCheckAll\"]"));
        checkAllBtn.click();
        WebElement deleteAllBtn = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_btnDelete\"]"));
        deleteAllBtn.click();
        WebElement message = driver.findElement(By.xpath("//div[@id=\"ctl00_MainContent_orderMessage\"]"));

        Assert.assertTrue(message.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
