package CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");

        List<WebElement> list = driver.findElements(By.xpath("//body//a"));

        int expectedValue = 19;
        int actualValue = list.size();
        System.out.println(actualValue);

        if(expectedValue == actualValue) {
            System.out.println("Test pass");
        }
        else {
            System.out.println("Test Fail");
        }

        int counter= 0;
        for(WebElement myList: list) {
            if (myList.getText().isEmpty()){
                counter++;
                continue;

            }
            System.out.println(myList.getText());
        }
        System.out.println(counter);


    }
}
