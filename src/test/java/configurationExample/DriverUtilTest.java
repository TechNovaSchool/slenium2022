package configurationExample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

public class DriverUtilTest {

    @Test
    public void testDriver() {
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
