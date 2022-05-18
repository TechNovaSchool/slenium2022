package pages.waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicElementPage {

    public DynamicElementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[.=\"Start\"]")
    public WebElement startButton;

    @FindBy (xpath = "//div[@id=\"finish\"]")
    public WebElement helloText;

    @FindBy (xpath = "//button[@id=\"accept\"]")
    public WebElement acceptButton;


}
