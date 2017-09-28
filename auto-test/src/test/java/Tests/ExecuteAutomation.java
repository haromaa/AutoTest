package Tests;


import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExecuteAutomation {
    WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        driver = "chrome".equals(System.getProperty("selenide.browser")) ?
                new ChromeDriver() : new FirefoxDriver();
    }

    @AfterTest
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void LaunchAndLoginToPage()
    {
        LoginPage page = new LoginPage();
        page.GoTo(driver);
        page.LogIn("herman", "armando");

    }

}










}
