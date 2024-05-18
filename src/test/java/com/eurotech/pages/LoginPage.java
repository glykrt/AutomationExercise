package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUp;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement yourAccountText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement incorrectMsg;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement existingEmailMsg;

}
