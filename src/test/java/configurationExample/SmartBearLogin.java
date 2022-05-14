package configurationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class SmartBearLogin {


    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
    }

    @Test
    public void login() {
        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@name=\"ctl00$MainContent$username\"]"));
        WebElement pass = Driver.getDriver().findElement(By.xpath("//input[@name=\"ctl00$MainContent$password\"]"));
        WebElement submitBtn = Driver.getDriver().findElement(By.xpath("//input[@name=\"ctl00$MainContent$login_button\"]"));

        login.sendKeys(Config.getProperty("login"));
        pass.sendKeys(Config.getProperty("pass"));
        submitBtn.click();
    }
}
