package ActionClass;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actionClass.DoubleClickPage;
import utilities.Driver;

public class DoubleClick {
//    DoubleClickTest
//1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//            2. Switch to iframe.
//3. Double click on the text “Double-click me to change my text color.”
//            4. Assert: Text’s “style” attribute value contains “red”.


    DoubleClickPage doubleClickPage = new DoubleClickPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void doubleClick() {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(doubleClickPage.iframe);
        actions.doubleClick(doubleClickPage.doubleClickText).perform();
        Assert.assertTrue(doubleClickPage.doubleClickText.getAttribute("style").contains("red"));
    }
}
