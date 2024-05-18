package com.eurotech.test;

import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.ConfigurationReader;
import com.google.common.base.Verify;
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
        extentLogger.info("Enter correct email address and password");
        loginPage.loginEmail.sendKeys("glykrt@gmail.com");
        loginPage.loginPassword.sendKeys("glykrt123");
        extentLogger.info("Click 'login' button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(loginPage.loggedUsername.getText(),"Gulay");
        extentLogger.info("Click 'Logout' button");
        loginPage.logoutBtn.click();
        extentLogger.info("Verify that user is navigated to login page");
        Assert.assertEquals(loginPage.yourAccountText.getText(),"Login to your account");
        extentLogger.pass("Passed");
    }
    //
//    Test Case 4: Logout User
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter correct email address and password
//7. Click 'login' button
//8. Verify that 'Logged in as username' is visible
//9. Click 'Logout' button
//10. Verify that user is navigated to login page
}
