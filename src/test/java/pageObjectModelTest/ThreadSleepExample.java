package pageObjectModelTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.waits.DynamicElementPage;
import utilities.Driver;

public class ThreadSleepExample {

    @Test
    public void threadSleep() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicElementPage dynamicElementPage = new DynamicElementPage();
        dynamicElementPage.startButton.click();
        Thread.sleep(5000);// this coming from Java and is not recommended to use
        String str = dynamicElementPage.helloText.getText();
        Assert.assertTrue(str.equals("Hello World!"));
    }
}
