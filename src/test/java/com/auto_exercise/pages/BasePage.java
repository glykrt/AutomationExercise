package com.auto_exercise.pages;

import com.auto_exercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = " //a[text()=' Signup / Login']")
    public WebElement signUp_loginBtn;

    @FindBy(xpath = "//b[text()='Gulay']")
    public WebElement loggedUsername;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    public WebElement deleteAccountBtn;

    @FindBy(xpath = "//a[text()=' Logout']")
    public WebElement logoutBtn;
}
