package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = " //a[text()=' Signup / Login']")
    public WebElement signUp_loginBtn;

    @FindBy(xpath = "//b[text()='Gulay']")
    public WebElement loggedUsername;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    public WebElement deleteAccountBtn;
}
