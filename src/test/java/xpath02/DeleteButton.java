package xpath02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DeleteButton {
    public static void main(String[] args) {

//        Open Chrome browser
//        2. Go to https://the-internet.herokuapp.com/add_remove_elements/
//        3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click to “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]"));

        addElement.click();

        WebElement deleteElement = driver.findElement(By.xpath("//*[.=\"Delete\"]"));

        if (deleteElement.isDisplayed()){
            System.out.println("Button is displayed");

        }
        else   {
            System.out.println("Button IS NOT displayed");
        }

        deleteElement.click();
//
        try {
            WebElement deleteButtonReferenceAfterClick = driver.findElement(By.xpath("//button[.='Delete']"));
            if (deleteButtonReferenceAfterClick.isDisplayed()) {
                System.out.println("Delete button is displayed. Verification FAILED!!!");
            } else {
                System.out.println("Delete button is NOT displayed. Verification PASSED!!!");
            }
        }catch (NoSuchElementException a){
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }



    }
}
