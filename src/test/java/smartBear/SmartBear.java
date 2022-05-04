package smartBear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {
    public static void main(String[] args) {
//        #1: Smartbear   software    link    verification
//        1.Open   browser
//        2.Go to  website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

//        WebElement login = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$username\"]"));
//        WebElement pass = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$password\"]"));
//        WebElement submitBtn = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$login_button\"]"));
//
////        3.Enter username: "Tester"
//        login.sendKeys("Tester");
////        4.Enter password: "test"
//        pass.sendKeys("test");
////        5.Click to Login button
//        submitBtn.click();

        loginToSmartBear(driver);
//        6.Print out and count of all the links on landing page //a
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        int count = links.size();
        System.out.println(count);
//        7.Print out each link text on this page
        for (WebElement link :links) {
//            System.out.println(link);
           System.out.println(link.getText());
        }
//
//        Mini-Task:
//        1. Create a method called loginToSmartBear
//        2. This method simply logs in to SmartBear when you call it
    }

    public static void loginToSmartBear (WebDriver driver) {
        WebElement login = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$username\"]"));
        WebElement pass = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$password\"]"));
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$login_button\"]"));

        login.sendKeys("Tester");
        pass.sendKeys("test");
        submitBtn.click();
    }
}
