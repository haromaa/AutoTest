package Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ExecuteAutomation {

    private WebDriver driver;


    @Test(priority=1)
    public void LaunchPage()
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
    @Test(priority=2)
    public void LoginToPage()
    {
        $(By.name("UserName")).val("execute");
        $(By.name("Password")).val("automation");
        $(By.cssSelector("#userName input[type=\"submit\"]")).click();
        $(By.cssSelector("#details h2")).shouldHave(text("User Form"));
    }

    

//    @AfterTest
//    public void CloseBrowser()
//    {
//        driver.close();
//    }




}
