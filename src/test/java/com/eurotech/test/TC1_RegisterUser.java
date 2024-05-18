package com.eurotech.test;


import com.eurotech.pages.AccountPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.SignUpPage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_RegisterUser extends TestBase {


    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountPage accountPage;

    @Test
    public void test_registerUser() {

        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
        accountPage = new AccountPage();

        extentLogger = report.createTest("Register User Test");
        extentLogger.info("Go to "+ ConfigurationReader.get("url")+" website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        extentLogger.info("Click SignUp/Login Button");
        loginPage.signUp_loginBtn.click();
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
        Assert.assertFalse(signUpPage.titleGender.isSelected());
        signUpPage.password.sendKeys("glykrt123");
        signUpPage.selectDayDropdown("8");
        signUpPage.selectMonthDropdown("2");
        signUpPage.selectYearDropdown("1988");
        extentLogger.info(" Select checkbox 'Sign up for our newsletter!'");
        signUpPage.newsletters.click();
        extentLogger.info("Select checkbox 'Receive special offers from our partners!'");
        signUpPage.optin.click();
        extentLogger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        signUpPage.addressInformation();
        extentLogger.info("Click 'Create Account button'");
        signUpPage.createAccountBtn.click();
        extentLogger.info("Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertEquals(accountPage.accountCreatedText.getText(),"ACCOUNT CREATED!");
        extentLogger.info("Click 'Continue' button");
        accountPage.continueCreateBtn.click();
        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertEquals(accountPage.loggedUsername.getText(),"Gulay");
//        extentLogger.info("Click 'Delete Account' button");
//        accountPage.deleteAccountBtn.click();
//        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
//        Assert.assertEquals(accountPage.accountDeleteText.getText(),"ACCOUNT DELETED!");
//        accountPage.continueDeleteBtn.click();








    }
}
