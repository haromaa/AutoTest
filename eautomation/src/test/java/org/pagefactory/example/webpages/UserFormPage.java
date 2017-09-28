package org.pagefactory.example.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class UserFormPage
{
    // Webdriver
    private WebDriver driver;

    // Locators
    @FindBy(how = How.CSS, using ="#details h2")
    private WebElement textHeader;

    @FindBy(how = How.CSS, using ="#TitleId")
    private WebElement dropdownTitle;

    @FindBy(how = How.CSS, using ="#Initial")
    private WebElement inputInitial;

    @FindBy(how = How.CSS, using ="#FirstName")
    private WebElement inputFirstName;

    @FindBy(how = How.CSS, using ="#MiddleName")
    private WebElement inputMiddleName;

    @FindBy(how = How.CSS, using = "#details input[name=Male]")
    private WebElement radioMale;

    @FindBy(how = How.CSS, using = "#details input[name=Female]")
    private WebElement radioFemale;

    @FindBy(how = How.CSS, using = "#details input[name=english]")
    private WebElement checkboxEnglish;

    @FindBy(how = How.CSS, using = "#details input[name=Hindi]")
    private WebElement checkboxHindi;

    @FindBy(how = How.CSS, using = "#details input[type=button]")
    private WebElement buttonSave;

    // Constructor
    public UserFormPage(WebDriver driver)
    {
        this.driver = driver;


        //Initialise Elements
        PageFactory.initElements(driver,this);
    }

    // Page open assertion with boolean value
    public boolean isPageOpened()
    {
        return textHeader.getText().contains("User Form");
    }

    public void setAttributeValue(WebElement element, String attr, String value)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",element, attr, value);
    }


    public void selectDropdownValue(WebElement element, int value)
    {
        Select dropdown = new Select(element);


        // Print dropdown
        List<WebElement> lista = dropdown.getOptions();
        int itemCount = lista.size();
        for (int i = 0 ; i < itemCount ; i++)
            System.out.println(lista.get(i).getText());
        dropdown.selectByIndex(value);
    }


    public void FillUserForm(String firstname, String middlename, boolean male, boolean english)
    {
        // Not Correct option to select dropdown value but works for attributes
        //setAttributeValue(comboboxTitle, "data-val-number", "1");

        selectDropdownValue(dropdownTitle,1);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputInitial.sendKeys((firstname.substring(1) + middlename.substring(1).toUpperCase()));
        inputFirstName.sendKeys(firstname);
        inputMiddleName.sendKeys(middlename);

        if (!male)
        {
            radioFemale.click();
        }
        if (!english)
        {
            checkboxHindi.click();
        }
    }

    public void SaveForm()
    {
        buttonSave.click();
    }


}
