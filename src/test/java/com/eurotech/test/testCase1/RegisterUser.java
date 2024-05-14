package com.eurotech.test.testCase1;

import com.aventstack.extentreports.ExtentReports;
import com.eurotech.pages.HomePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.SignUpPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @Test
    public void test_registerUser() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();

        extentLogger = report.createTest("Register User Test");
        extentLogger.info("Go to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        extentLogger.info("Click SignUp/Login Button");
        homePage.signUp_loginBtn.click();
        extentLogger.info("Verify 'New User Signup!' is visible");
        Assert.assertEquals(loginPage.newUserSignUp.getText(),"New User Signup!");
        extentLogger.info("Enter Register User Name");
        loginPage.username.sendKeys("Gulay");
        BrowserUtils.waitFor(2);
        extentLogger.info("Enter Register Email");
        loginPage.email.sendKeys("glykrt@gmail.com");
        BrowserUtils.waitFor(2);
        extentLogger.info("Click Submit Button");
        loginPage.submitBtn.click();
        extentLogger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertEquals(signUpPage.accountInformationText.getText(),"ENTER ACCOUNT INFORMATION");
        extentLogger.info("Fill details: Title, Name, Email, Password, Date of birth");
        signUpPage.titleGender.click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(signUpPage.titleGender.isSelected());
        signUpPage.password.sendKeys("glykrt123");






    }
}
