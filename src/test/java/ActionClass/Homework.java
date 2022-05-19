package ActionClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actionClass.HerokuAppPage;
import pages.actionClass.TelerikPage;
import utilities.Driver;

public class Homework {
//    Drag And Drop
//1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
//            2. Drag and drop the small circle to bigger circle.
//3. Assert:
//            -Text in big circle changed to: “You did great!”
//
//    Context Click – HOMEWORK (right click)
//1. Go to https://the-internet.herokuapp.com/context_menu
//            2. Right click to the box.
//3. Alert will open.
//4. Accept alert
//    No assertion needed for this practice.
    TelerikPage telerikPage = new TelerikPage();
    HerokuAppPage herokuAppPage = new HerokuAppPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void dragAndDrop(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        telerikPage.cookies.click();
        actions.dragAndDrop(telerikPage.smallCircle, telerikPage.bigCircle).perform();

        String actualText= telerikPage.bigCircle.getText();
        Assert.assertEquals(actualText, "You did great!");
    }

    @Test
    public void contextClick() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        actions.contextClick(herokuAppPage.theBox).perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

}
