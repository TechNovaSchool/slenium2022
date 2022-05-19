package pages.actionClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TelerikPage {

    public TelerikPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@id=\"draggable\"]")
    public WebElement smallCircle;

    @FindBy(xpath = "//div[@id=\"droptarget\"]")
    public WebElement bigCircle;

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement cookies;
}
