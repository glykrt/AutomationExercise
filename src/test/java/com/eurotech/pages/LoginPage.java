package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement submitBtn;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUp;
}
