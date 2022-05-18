package ActionClass;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.actionClass.HoversOverPage;
import utilities.Driver;

public class Hovers {
//    1. Go to https://the-internet.herokuapp.com/hovers
//            2. Hover over to first image
//3. Assert: “name: user1” is displayed
//4. Hover over to second image
//5. Assert:  “name: user2” is displayed
//6. Hover over to third image
//7. Confirm: “name: user3” is displayed

    HoversOverPage hoversOverPage = new HoversOverPage();


    @Test
    public void hoverOver() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(hoversOverPage.avatar1).perform();
        Assert.assertTrue(hoversOverPage.name1.isDisplayed());

        actions.moveToElement(hoversOverPage.avatar2).build().perform();
        Assert.assertTrue(hoversOverPage.name2.isDisplayed());

        actions.moveToElement(hoversOverPage.avatar3).perform();
        Assert.assertTrue(hoversOverPage.name3.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }



}
