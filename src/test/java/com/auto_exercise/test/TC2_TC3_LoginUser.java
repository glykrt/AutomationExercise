package com.auto_exercise.test;

import com.auto_exercise.pages.LoginPage;
import com.auto_exercise.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_TC3_LoginUser extends TestBase{

    LoginPage loginPage;

    @Test
    public void test_positiveLoginUser() {
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
        loginPage.login();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(loginPage.loggedUsername.getText(),"Gulay");

        extentLogger.info(" Click 'Delete Account' button");
        loginPage.deleteAccountBtn.click();

        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible");
        extentLogger.pass("Passed");

    }

    @Test
    public void test_negativeLoginUser() {
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

        extentLogger.info("Enter incorrect email address and password");
        loginPage.loginEmail.sendKeys("glykr@gmail.com");
        loginPage.loginPassword.sendKeys("glykrt12");

        extentLogger.info("Click 'login' button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify error 'Your email or password is incorrect!' is visible");
        Assert.assertEquals(loginPage.incorrectMsg.getText(),"Your email or password is incorrect!");
    }

}
