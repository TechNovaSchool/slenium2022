package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Etsy {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.etsy.com");
    }

    @Test
    public void windowHandleTest() {
        String mainWindow = driver.getWindowHandle();

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class=\"height-placeholder\"])[1]"));
        firstProduct.click();

        for(String tabs : driver.getWindowHandles()){
            if ( !tabs.equals(mainWindow)){
                driver.switchTo().window(tabs);
            }
        }
        System.out.println(driver.getTitle());

        String productDetail = driver.findElement(By.xpath("//h1")).getText();

        String expected = "Necklace";
        Assert.assertTrue(productDetail.contains(expected));




    }
}
