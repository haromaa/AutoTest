package org.pagefactory.example.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.pagefactory.example.webpages.HomePage;
import org.pagefactory.example.webpages.UserFormPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExecuteAutomationTests {

    static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Temp\\ExtentReport.html");
    static ExtentReports extent = new ExtentReports();
    static ExtentTest logger;
    static WebDriver driver;


    @BeforeTest
    public void setup()
    {
        // Use Chrome Driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        extent.attachReporter(htmlReporter);

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "ExecuteAutomation");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Herkko Aromaa");

        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }


    @Test
    public void ThisIsTestOne()
    {
        logger = extent.createTest("This Is Test One");
        // Create Launch and Login To Page
        HomePage home = new HomePage(driver);
        // Execute Login
        logger.log(Status.INFO, "Logging in to app");
        home.LoginToExecuteAutomation("herman", "armando");

        // Create UserForm Page
        UserFormPage userform = new UserFormPage(driver);

        // Execute Steps
        logger.log(Status.INFO, "Validating page is opened");
        userform.isPageOpened();
        logger.log(Status.INFO, "Filling user form with basic details");
        userform.FillUserForm("herman", "jose", false,false);
        userform.SaveForm();
    }

    @Test
    public void ThisIsTestTwo()
    {
        logger = extent.createTest("This Is Test Two");
        // Create Launch and Login To Page
        HomePage home = new HomePage(driver);
        // Execute Login
        logger.log(Status.INFO, "Logging in to app");
        home.LoginToExecuteAutomation("herman", "armando");

        // Create UserForm Page
        UserFormPage userform = new UserFormPage(driver);

        // Execute Steps
        logger.log(Status.INFO, "FAILING TEST CASE");
        home.isPageOpenedFAIL();
        logger.log(Status.INFO, "Filling user form with basic details");
        userform.FillUserForm("herman", "jose", false,false);
        userform.SaveForm();
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            //logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }else if(result.getStatus() == ITestResult.SKIP){
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
    }

    @AfterTest
    public void close()
    {
        driver.close();
        extent.flush();
    }
}
