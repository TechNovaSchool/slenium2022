package findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetTheLinks {

    public static void main(String[] args) {
//        Task #1 - Check all link on the page
//        Open Chrome browser
//        Go to https://www.technovaschool.com/
//        Count the number of the links on the web-page (expected 41)
//        Print out all the texts of the links on the page
//        Count the number of the links that doesn’t have text (expected 19)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.technovaschool.com/");

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));

        int numberOfLinks = links.size();
        int expectedNumOfLinks = 41;

        if(numberOfLinks == expectedNumOfLinks) {
            System.out.println("The number of links are correct -- Test Pass");
        }
        else {
            System.out.println("The number of links are incorrect -- Test Fail");

        }

        int linksWithNoText = 0;
        for(WebElement link: links) {
            System.out.println(link.getText());
            if(link.getText().isEmpty()){
                linksWithNoText++;
            }
        }
        System.out.println(linksWithNoText);

        if (linksWithNoText == 19){
            System.out.println("Test Pass ");
        }
        else {
            System.out.println("Test fail");
        }

        driver.close();





    }
}
