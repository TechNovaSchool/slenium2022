package smartBear;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OrderPlacing {
    public static void main(String[] args) {
//        TC#2: Smartbear software order placing
//        1.Open   browser
//        2.Go to  website:    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//        3.Enter username: "Tester"
//        4.Enter password: "test"
//        5.Click on Login button
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);
//        6.Click on Order
        WebElement order = driver.findElement(By.xpath("//a[.=\"Order\"]"));
        order.click();
//        7.Select familyAlbum from product, set quantity to 2
//        8.Click to "Calculate"button

        WebElement product = driver.findElement(By.xpath("//select[@name=\"ctl00$MainContent$fmwOrder$ddlProduct\"]"));
        WebElement quantity = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$txtQuantity\"]"));
        WebElement calculate = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Select select = new Select(product);
        select.selectByIndex(1);
        quantity.clear();
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys("2");
        calculate.click();


//        9.Fill address Info with JavaFaker
        Faker faker = new Faker();
        WebElement customerName = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$txtName\"]"));
        WebElement streetAddress = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox2\"]"));
        WebElement city = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox3\"]"));
        WebElement zipCode = driver.findElement(By.xpath("//*[@name=\"ctl00$MainContent$fmwOrder$TextBox5\"]"));
        WebElement state = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox4\"]"));
        WebElement visa = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox6\"]"));
        WebElement expirationDate = driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox1\"]"));
        WebElement submitBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));

        customerName.sendKeys(faker.name().fullName());
        streetAddress.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        zipCode.sendKeys(faker.address().zipCode().substring(0, 5));
        visa.click();
        cardNumber.sendKeys(faker.finance().creditCard().replace("-", ""));
        expirationDate.sendKeys("05/05");
        submitBtn.click();



//      •Generate: name, street, city, state, zip code
//        10.Click on "visa" radio button
//        11.Generate card number using JavaFaker
//        12.Click on "Process"
//        13.Verify success message "New order has been successfully added."

        WebElement infoMessage = driver.findElement(By.xpath("//div[@class=\"buttons_process\"]/strong"));

        if(infoMessage.isDisplayed()) {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
}
