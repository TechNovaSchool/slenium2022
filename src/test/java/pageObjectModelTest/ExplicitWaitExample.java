package pageObjectModelTest;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.waits.DynamicElementPage;
import utilities.Driver;

public class ExplicitWaitExample {

    @Test
    public void explicitWait() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicElementPage dynamicElementPage = new DynamicElementPage();
        dynamicElementPage.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(dynamicElementPage.helloText));

        String str = dynamicElementPage.helloText.getText();
        Assert.assertTrue(str.equals("Hello World!"));
    }
}
