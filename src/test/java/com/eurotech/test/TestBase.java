package com.eurotech.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpReport(){
        // This will initialize the ExtentReports Class
        report = new ExtentReports();

        // Create a report path --> how can we find our project dynamically
        String projectPath = System.getProperty("user.dir");
        // To create a new report for every execution separately with TimeStamp
        //String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String path = projectPath+"/test-output/report"+date+".html";
        String path = projectPath+"/test-output/report.html";

        // Initialize the HTML report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // Attach the HTML report to the report object
        report.attachReporter(htmlReporter);

        // We need to give a title to our Report
        htmlReporter.config().setReportName("Batch15 Smoke Suit");

        // Set environment information --> tester name, test name, browser, test steps, test data....
        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Ihsan");
    }
    @AfterTest
    public void tearDownReport(){
        // this is when the report is actually created
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        // driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // If the test is FAILED
        if (result.getStatus()==ITestResult.FAILURE){ // If the result object is failed
            //Record the name of the failed test
            extentLogger.fail(result.getName());

            // Take the screenshot and return its location
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());

            // Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            // Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
