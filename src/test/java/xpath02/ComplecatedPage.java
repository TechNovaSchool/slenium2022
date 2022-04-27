package xpath02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplecatedPage {
    public static void main(String[] args) {
//        Open chrome browser
//        2. Go to link https://ultimateqa.com/complicated-page
//        3. Enter any name in name field
//        4. Enter any email in email field
//        5. Add any description (you can use lorem to generate text)
//        6. Create a logic to pass captcha
//        7. Click submit
//        8. Close the driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/complicated-page");

        WebElement name = driver.findElement(By.cssSelector("#et_pb_contact_name_0"));
        WebElement email = driver.findElement(By.cssSelector("#et_pb_contact_email_0"));
        WebElement message = driver.findElement(By.cssSelector("#et_pb_contact_message_0"));

        WebElement sum = driver.findElement(By.xpath("//input[@name=\"et_pb_contact_captcha_0\"]"));
        WebElement submit = driver.findElement(By.xpath("(//button[@name=\"et_builder_submit_button\"])[1]"));
        WebElement textValueOfCaptha = driver.findElement(By.xpath("(//span[@class=\"et_pb_contact_captcha_question\"])[1]"));

        name.sendKeys("Andrew");
        email.sendKeys("andrew@test.com");
        message.sendKeys("Lorem Ipsum es simplemente el texto de " +
                "relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el " +
                "texto de relleno estándar de las industrias desde el año 1500, cuando un impreso");

        String numbers = textValueOfCaptha.getText();
        int plusSign = numbers.indexOf("+");


        String numOne = numbers.substring(0, plusSign-1);
        String numTwo = numbers.substring(plusSign+2);

        int one = Integer.parseInt(numOne);
        int two = Integer.parseInt(numTwo);

        int totalAmount = one + two;

        sum.sendKeys(String.valueOf(totalAmount));
        submit.click();








    }
}
