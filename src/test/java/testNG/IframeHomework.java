package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class IframeHomework {
//    Navigate to https://webdriveruniversity.com/IFrame/index.html
//    Assert that GREAT SERVICE! text is displayed
//    Assert that header WebdriverUniversity.com (IFrame) on the top is displayed

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/IFrame/index.html");
    }

    @Test
    public void iFrame() {
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));

        driver.switchTo().frame(iframe);

        WebElement greatService = driver.findElement(By.xpath("//p[.=\"GREAT SERVICE!\"]"));
        Assert.assertTrue(greatService.isDisplayed());

        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.xpath("//a[.=\"WebdriverUniversity.com (IFrame)\"]"));
        Assert.assertTrue(header.isDisplayed());

    }
}
