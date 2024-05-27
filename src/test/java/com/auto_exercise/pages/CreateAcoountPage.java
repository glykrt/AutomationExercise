package com.auto_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAcoountPage extends BasePage{
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueCreateBtn;
}
