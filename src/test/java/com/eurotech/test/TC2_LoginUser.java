package com.eurotech.test;

import com.eurotech.pages.LoginPage;
import com.eurotech.pages.SignUpPage;
import com.eurotech.utilities.ConfigurationReader;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_LoginUser extends TestBase{

    LoginPage loginPage;
    SignUpPage signUpPage;
    @Test
    public void test_loginUser() {
        signUpPage = new SignUpPage();
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
        extentLogger.info("nter correct email address and password");
        loginPage.loginEmail.sendKeys("glykrt@gmail.com");
        loginPage.loginPassword.sendKeys("glykrt123");
        extentLogger.info("Click 'login' button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(signUpPage.loggedUsername.getText(),"Gulay");
        extentLogger.info(" Click 'Delete Account' button");
        loginPage.deleteAccountBtn.click();
        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible");
        extentLogger.pass("Passed");


    }

}
