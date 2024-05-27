package com.auto_exercise.test;

import com.auto_exercise.pages.LoginPage;
import com.auto_exercise.pages.SignupPage;
import com.auto_exercise.utilities.BrowserUtils;
import com.auto_exercise.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_ExistingEmail extends TestBase{

    LoginPage loginPage;

    @Test
    public void test_existingEmail() {

        loginPage = new LoginPage();

        extentLogger = report.createTest("Register User Test");
        extentLogger.info("Go to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        extentLogger.info("Click SignUp/Login Button");
        loginPage.signUp_loginBtn.click();

        extentLogger.info("Verify 'New User Signup!' is visible");
        Assert.assertEquals(loginPage.newUserSignUp.getText(),"New User Signup!");

        extentLogger.info("Enter name and already registered email address");
        loginPage.newUserSignup();

        BrowserUtils.waitFor(2);

        extentLogger.info("Verify error 'Email Address already exist!' is visible");
        Assert.assertEquals(loginPage.existingEmailMsg.getText(),"Email Address already exist!");

        extentLogger.pass("Passed");

    }


}
