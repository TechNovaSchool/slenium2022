package xpath02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParasoftBank {
    public static void main(String[] args) {

//        1. Open a chrome browser
//        2. Go to https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC
//        3. Enter any login
//        4. Enter any password
//        5. Verify total is equal 1692.67 (hint use getText())
//       " CMD +/"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

        WebElement login = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement pass = driver.findElement((By.xpath("//input[@name=\"password\"]")));
        WebElement signBtn = driver.findElement(By.xpath("//input[@type=\"submit\"]"));

        login.sendKeys("test");
        pass.sendKeys("pass");
        signBtn.click();

        WebElement message = driver.findElement(By.xpath("//p[@class=\"error\"]"));

        if (message.isDisplayed()){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }


    }
}
