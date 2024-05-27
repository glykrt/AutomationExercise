package com.auto_exercise.pages;

import com.auto_exercise.utilities.BrowserUtils;
import com.auto_exercise.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage{
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement accountInformationText;

    @FindBy(xpath = "//label[@for='id_gender2']//../label")
    public WebElement titleGender;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletters;

    @FindBy(id = "optin")
    public WebElement optin;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "country")
    public WebElement countryDropdown;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipCode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountBtn;


    public void selectDropdown(String day,String month,String year){
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue(day);
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue(month);
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue(year);
    }
    public void selectCountryDropdown(String country){
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue(country);
        BrowserUtils.waitFor(2);
    }

    public void enterAccountInformation(){
        titleGender.click();
        password.sendKeys(ConfigurationReader.get("password"));
        selectDropdown("5","5","1990");
        newsletters.click();
        optin.click();
        addressInformation();

    }

    public void addressInformation(){

        firstName.sendKeys("Gulay");
        lastName.sendKeys("Krt");
        company.sendKeys("Google");
        address1.sendKeys("A street B blok No:7");
        address2.sendKeys("B street Google company");
        selectCountryDropdown("United States");
        state.sendKeys("NewYork");
        city.sendKeys("NewYork");
        zipCode.sendKeys("00234");
        mobileNumber.sendKeys("05555555");
        createAccountBtn.click();
    }


}
