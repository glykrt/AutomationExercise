package com.auto_exercise.test;


import com.auto_exercise.pages.CreateAcoountPage;
import com.auto_exercise.pages.DeleteAccountPage;
import com.auto_exercise.pages.LoginPage;
import com.auto_exercise.pages.SignupPage;
import com.auto_exercise.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_RegisterUser extends TestBase {


    LoginPage loginPage;
    SignupPage signupPage;
    CreateAcoountPage createAcoountPage;
    DeleteAccountPage deleteAccountPage;


    @Test
    public void test_registerUser() {

        loginPage = new LoginPage();
        signupPage = new SignupPage();
        deleteAccountPage = new DeleteAccountPage();

        extentLogger = report.createTest("Register User Test");
        extentLogger.info("Go to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        extentLogger.info("Click SignUp/Login Button");
        loginPage.signUp_loginBtn.click();

        extentLogger.info("Verify 'New User Signup!' is visible");
        Assert.assertEquals(loginPage.newUserSignUp.getText(),"New User Signup!");

        extentLogger.info("Enter Register User Name and Email, click submit button");
        loginPage.newUserSignup();

        extentLogger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertEquals(signupPage.accountInformationText.getText(),"ENTER ACCOUNT INFORMATION");

        extentLogger.info("Fill details: Title, Name, Email, Password, Date of birth");
        signupPage.accountInformation();

        extentLogger.info(" Select checkbox 'Sign up for our newsletter!'");
        signupPage.newsletters.click();
        extentLogger.info("Select checkbox 'Receive special offers from our partners!'");
        signupPage.optin.click();

        extentLogger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number and Click 'Create Account button'");
        signupPage.addressInformation();

        extentLogger.info("Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertEquals(createAcoountPage.accountCreatedText.getText(),"ACCOUNT CREATED!");

        extentLogger.info("Click 'Continue' button");
        createAcoountPage.continueCreateBtn.click();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(createAcoountPage.loggedUsername.getText(),"Gulay");

        extentLogger.info("Click 'Delete Account' button");
        deleteAccountPage.deleteAccountBtn.click();

        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        Assert.assertEquals(deleteAccountPage.accountDeleteText.getText(),"ACCOUNT DELETED!");
        deleteAccountPage.continueDeleteBtn.click();


    }
}
