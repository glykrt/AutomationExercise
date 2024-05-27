package com.auto_exercise.test;

import com.auto_exercise.pages.LoginPage;
import com.auto_exercise.utilities.BrowserUtils;
import com.auto_exercise.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4_LogoutUser extends TestBase{
    LoginPage loginPage;
    @Test
    public void test_logoutUser() {
        loginPage = new LoginPage();

        extentLogger = report.createTest("Login User Test");
        extentLogger.info("Go to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage.signUp_loginBtn.click();

        extentLogger.info("Verify 'Login to your account' is visible");
        Assert.assertEquals(loginPage.yourAccountText.getText(),"Login to your account");

        extentLogger.info("Enter correct email address and password and click login button");
        BrowserUtils.waitFor(2);

        loginPage.login();
        BrowserUtils.waitFor(2);

        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(loginPage.loggedUsername.getText(),"Gulay");
        BrowserUtils.waitFor(2);

        extentLogger.info("Click 'Logout' button");
        loginPage.logoutBtn.click();

        extentLogger.info("Verify that user is navigated to login page");
        Assert.assertEquals(loginPage.yourAccountText.getText(),"Login to your account");
        extentLogger.pass("Passed");
    }
}
