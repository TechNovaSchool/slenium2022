package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smartBear.SmartBear;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EditTable {

//    For HomeWork:
//    Task 1 —Delete Order
//1. Open browser and Login to smartBear
//2. Delete”Mark Smith” from the list
//3. Assert it is deleted from the list
//    Task 2 — Edit order
//1. Open browser and login to SmartBear
//2. Click too edit button from the right for “Steve Johns”
//            3. Change the name to “ your favorite actor/ sport star”
//            4. Click Update
//5. Assert “your actor name” is in the list
//    Task 3 — Create a method called removeName()
//1. Accept two parameters: Webdriver, String name
//2. Method will remove the given name from the list of SmartBear
//3. Create a new TestNG test, and call your method
//4. Assert that your method removed the given name

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void deleteOrder() {
        SmartBear.loginToSmartBear(driver);
        String givenName = "Mark Smith";

        WebElement checkBox = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='" +givenName +"']/../td[1]"));
        checkBox.click();

        WebElement deleteOrder = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_btnDelete\"]"));
        deleteOrder.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for(WebElement names : allNames) {
            Assert.assertFalse(names.getText().equals(givenName));
        }

    }
    @Test
    public void editOrder() {
        SmartBear.loginToSmartBear(driver);

        String givenName = "Steve Johns";

        WebElement editButton = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='"+givenName +"']/../td[13]"));
        editButton.click();

        WebElement customerName = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        customerName.clear();
        customerName.sendKeys("Nicolas Cage");

        WebElement updateBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
        updateBtn.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for(WebElement name : allNames){
            if(name.getText().equals("Nicolas Cage")) {
                Assert.assertEquals(name.getText(),"Nicolas Cage", "The fail" );

            }
        }
    }


    public static void removeName(String name, WebDriver driver) {

        WebElement nameToBeDeleted = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='" +name +"']/../td[1]"));
        nameToBeDeleted.click();

        WebElement deleteOrder = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_btnDelete\"]"));
        deleteOrder.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for(WebElement names : allNames) {
            Assert.assertFalse(names.getText().equals(name));
            Assert.assertEquals(1,1,"test fail");

        }

    }

    @Test
    public void deleteName() {
        SmartBear.loginToSmartBear(driver);
        removeName("Samuel Clemens",driver);
    }


}
