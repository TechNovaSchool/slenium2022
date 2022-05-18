package pageObjectModelTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.waits.DynamicElementPage;
import utilities.Driver;

public class WaitForAlert {

    @Test
    public void explicitWait() {
        Driver.getDriver().get("https://letcode.in/waits");
        DynamicElementPage dynamicElementPage = new DynamicElementPage();
        dynamicElementPage.acceptButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
}
