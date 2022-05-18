package pages.actionClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HoversOverPage {

    public HoversOverPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//img[@alt=\"User Avatar\"])[1]")
    public WebElement avatar1;

    @FindBy (xpath = "(//img[@alt=\"User Avatar\"])[2]")
    public WebElement avatar2;

    @FindBy (xpath = "(//img[@alt=\"User Avatar\"])[3]")
    public WebElement avatar3;

    @FindBy (xpath = "(//h5)[1]")
    public WebElement name1;

    @FindBy (xpath = "(//h5)[2]")
    public WebElement name2;

    @FindBy (xpath = "(//h5)[3]")
    public WebElement name3;
}
