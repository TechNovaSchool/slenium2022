package xpath02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoBank {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.applitools.com/app.html");

        WebElement totalBalance = driver.findElement(By.xpath("(//div[@class=\"balance-value\"]/span)[1]"));
        WebElement creditAvailabile = driver.findElement(By.xpath("//div[@class=\"balance\"]/div[@class=\"balance-value\"]"));
        WebElement dangerValue = driver.findElement(By.xpath("//div[@class=\"balance\"]/div[@class=\"balance-value danger\"]"));

        String numTwoString = creditAvailabile.getText().replace("$","");

       int numOne = Integer.valueOf(totalBalance.getText().replace("$",""));
       int numTwo = Integer.valueOf(numTwoString.replace(",", ""));
       int numThree = Integer.valueOf(dangerValue.getText().replace("$", ""));

       int total = numOne  + numTwo +numThree;

        System.out.println(total);


    }
}
