package configurationExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Config;

import java.util.concurrent.TimeUnit;

public class ConfigTest {

    @Test
    public void testConfig(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Config.getProperty("smartBearUrl"));


        WebElement login = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$username\"]"));
        WebElement pass = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$password\"]"));
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$login_button\"]"));

        login.sendKeys(Config.getProperty("login"));
        pass.sendKeys(Config.getProperty("pass"));
        submitBtn.click();
    }
}
