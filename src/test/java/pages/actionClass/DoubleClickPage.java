package pages.actionClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoubleClickPage {

    public DoubleClickPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//p[@id=\"demo\"]")
    public WebElement doubleClickText;

    @FindBy (xpath = "//iframe[@id=\"iframeResult\"]")
    public WebElement iframe;
}
