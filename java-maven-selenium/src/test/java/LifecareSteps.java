import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;

import java.util.List;

import static java.awt.SystemColor.text;

public class LifecareSteps {
    @Step("This is a Test Step")
    public void TestStepMethod() {

    }

    @Step("Login to web interface with <username> and <password> and validate")
    public void LoginToWebInterfaceAndValidate(String username, String password) {
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.id("Username")).sendKeys(username);
        webDriver.findElement(By.id("Password")).sendKeys(password);
        webDriver.findElement(By.cssSelector("#page input[name=login]")).click();


    }

    @Step("Validate that user has logged in succesfully")
    public void ValidateUserLogIn() {
        WebDriver webDriver = Driver.webDriver;
        String text = "Home";
        List<WebElement> list = webDriver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue("Text:" + text +" not found on the page!", list.size() > 0);

    }
}
