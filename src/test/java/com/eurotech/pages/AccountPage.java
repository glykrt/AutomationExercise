package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueCreateBtn;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeleteText;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueDeleteBtn;

}
