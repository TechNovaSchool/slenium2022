package selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearTask {
    public static void main(String[] args) {
//        Task #5 -- Basic login authentication
//        1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        2. Go to : http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        3. Verify title equals -->expected "Web orders Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("The first test pass");
        }
        else {
            System.out.println("The first test fail");
        }
//        4. Enter username : Tester
            driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
//        5. Enter Password: test
            driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

//        6. Click "Sign In" button
            driver.findElement(By.id("ctl00_MainContent_login_button")).click();
//        7. Verify title equals --> expected Web Orders

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Web Orders";

        if(actualTitle2.equals(expectedTitle2)) {
            System.out.println("The second test pass");
        }
        else {
            System.out.println("The second test fail");
        }


    }
}
