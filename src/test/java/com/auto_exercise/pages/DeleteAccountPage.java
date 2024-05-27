package com.auto_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeleteText;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueDeleteBtn;

}
