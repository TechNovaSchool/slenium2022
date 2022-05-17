package pageObjectModelTest;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.smartBear.LoginPage;
import utilities.Config;
import utilities.Driver;

public class SmartBearLoginTest {

    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
    }

    @Test
    public void loginTest() {
        loginPage.username.sendKeys(Config.getProperty("login"));
        loginPage.password.sendKeys(Config.getProperty("pass"));
        loginPage.loginBtn.click();
    }
}
