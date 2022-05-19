package ActionClass;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actionClass.MyStorePage;
import utilities.Driver;

import javax.swing.*;

public class MyStore {

    MyStorePage myStorePage = new MyStorePage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void myStore() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
        actions.moveToElement(myStorePage.product).perform();
        myStorePage.addToCartButton.click();
        myStorePage.proceedToCart.click();
        Assert.assertTrue(myStorePage.price.getText().contains("18.51"));
    }
}
