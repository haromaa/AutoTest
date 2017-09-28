package org.pagefactory.example.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="http://executeautomation.com/demosite/Login.html";

    //Locators

    @FindBy(how = How.NAME, using = "UserName")
    private WebElement inputUserName;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement inputPassword;

    @FindBy(how = How.CSS, using = "#userName input[type=\"submit\"]")
    private WebElement buttonLogin;

    //Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    // Page open assertion with boolean value
    public boolean isPageOpenedFAIL()
    {
        return inputUserName.getText().contains("User Form");
    }

    public void setAttributeValue(WebElement element, String attr, String value)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",element, attr, value);
    }

    public void LoginToExecuteAutomation(String username, String password)
    {
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonLogin.click();

    }


}
