package Pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {


    public void GoTo(WebDriver driver)
    {
        System.setProperty("webdriver.chrome.driver", "c:\\bin\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.start-maximized", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        open("http://executeautomation.com/demosite/Login.html");
        $(By.cssSelector("body")).shouldHave(text("Login"));


    }

    public void LogIn(String username, String password)
    {
        $(By.name(username)).val(password);
        $(By.name("Password")).val("automation");
        $(By.cssSelector("#userName input[type=\"submit\"]")).click();
        $(By.cssSelector("#details h2")).shouldHave(text("User Form"));
    }

}
