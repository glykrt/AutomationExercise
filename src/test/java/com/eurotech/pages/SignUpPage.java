package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends HomePage{

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement accountInformationText;

    @FindBy(xpath = "//label[@for='id_gender2']//../label")
    public WebElement titleGender;

    @FindBy(id = "password")
    public WebElement password;
}
