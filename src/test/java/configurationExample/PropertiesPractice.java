package configurationExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertiesPractice {

    @Test
    public void setProperties() throws IOException {
//     1.Create a path the file
        String path = "configuration.properties";
//  2. Create Properties object (this is coming from java library)
        Properties properties = new Properties();
//  3.Open the file using FileInputStream
        FileInputStream file = new FileInputStream(path);
//  4.Load properties from the file to the properties object
        properties.load(file);
//  5.Read the values from the object using getProperty()
        System.out.println(properties.getProperty("login"));
        System.out.println(properties.getProperty("pass"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(properties.getProperty("smartBearUrl"));


        WebElement login = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$username\"]"));
        WebElement pass = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$password\"]"));
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$login_button\"]"));

        login.sendKeys(properties.getProperty("login"));
        pass.sendKeys(properties.getProperty("pass"));
        submitBtn.click();



    }

}
