package pageObjectModelTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.waits.DynamicElementPage;
import utilities.Driver;

public class ImplicitWaitExample {
    @Test
    public void implicitWait()  {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");
        DynamicElementPage dynamicElementPage = new DynamicElementPage();
        dynamicElementPage.startButton.click();

//        String str = dynamicElementPage.helloText.getText();
        boolean testData = dynamicElementPage.helloText.isDisplayed();


        Assert.assertTrue(testData);
    }
}
