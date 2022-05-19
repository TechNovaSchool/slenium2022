package pages.actionClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyStorePage {

    public MyStorePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class=\"product-image-container\"])[1]")
    public WebElement product;

    @FindBy (xpath = "(//a[@data-id-product=\"1\"])[1]")
    public WebElement addToCartButton;

    @FindBy (xpath = "//a[@title=\"Proceed to checkout\"]")
    public WebElement proceedToCart;

    @FindBy (xpath = "//span[@id=\"total_price\"]")
    public WebElement price;
}
