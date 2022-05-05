package faker;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoGuru {
    public static void main(String[] args) {
        Faker faker = new Faker();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
        WebElement phone = driver.findElement(By.xpath("//input[@name=\"phone\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@name=\"userName\"]"));

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        phone.sendKeys(faker.phoneNumber().cellPhone());
        email.sendKeys(faker.internet().emailAddress());

        WebElement streetAddress = driver.findElement(By.xpath("//input[@name=\"address1\"]"));
        WebElement city = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        WebElement state = driver.findElement(By.xpath("//input[@name=\"state\"]"));
        WebElement postalCode = driver.findElement(By.xpath("//input[@name=\"postalCode\"]"));

        streetAddress.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        postalCode.sendKeys(faker.address().zipCode());

        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        Select select = new Select(countryDropDown);
        select.selectByIndex(faker.number().numberBetween(0,100));

        WebElement userName = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        WebElement pass = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        WebElement confirmPass = driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]"));
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name=\"submit\"]"));

        String password = faker.internet().password();

        userName.sendKeys(faker.name().username());
        pass.sendKeys(password);
        confirmPass.sendKeys(password);
        submitBtn.click();

    }
}
