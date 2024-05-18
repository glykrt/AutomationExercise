package com.eurotech.test;

import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.google.common.base.Verify;
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
        loginPage.username.sendKeys("Gulay");
        loginPage.email.sendKeys("glykrt@gmail.com");
        BrowserUtils.waitFor(2);
        extentLogger.info("Click Submit Button");
        loginPage.signUpBtn.click();
        extentLogger.info("Verify error 'Email Address already exist!' is visible");
        Assert.assertEquals(loginPage.existingEmailMsg.getText(),"Email Address already exist!");
        extentLogger.pass("Passed");

    }

    //    Test Case 5: Register User with existing email
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible
}
