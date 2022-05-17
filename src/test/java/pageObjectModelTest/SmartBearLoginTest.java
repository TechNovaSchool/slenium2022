package pageObjectModelTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
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

    @Test
    public void loginWithInvalidUsername() {
        loginPage.username.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(Config.getProperty("pass"));
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.username.sendKeys(Config.getProperty("login"));
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void loginWithNoUsername() {
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void loginWithNoPassword() {
        loginPage.username.sendKeys(Config.getProperty("login"));
        loginPage.loginBtn.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
}
