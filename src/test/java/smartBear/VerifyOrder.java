package smartBear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VerifyOrder {
    public static void main(String[] args) {

//        TC#3 
//        1. Open browser and login to smartbear software 
//        2. Click on view all orders
//        3. Verify Susan McLaren has order on date “01/05/2010”
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);

        WebElement dateOfOrderSusan = driver.findElement(By.xpath("//td[.=\"Susan McLaren\"]/../td[5]"));
        WebElement dateOfOrderSusanV2 = driver.findElement(By.xpath("//td[.=\"Susan McLaren\"]/following-sibling::td[3]"));

        String date = "01/05/2010";

        if(date.equals(dateOfOrderSusan)) {
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test failed");
        }

        SmartBear.verifyOrder(driver, "Steve Johns");





    }

}
