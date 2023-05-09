package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountLoginPage extends Utility
{
    public AccountLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() {
        Reporter.log("Returning Customer Text " + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS,"Returning Customer Text " + returningCustomerText);
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter EmailId " + emailAddressField.toString());
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + emailAddressField);
        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password " + emailAddressField.toString());
        CustomListeners.test.log(Status.PASS,"Enter Password " + emailAddressField);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login Button " + emailAddressField.toString());
        CustomListeners.test.log(Status.PASS,"Click on login Button " + emailAddressField);
        clickOnElement(loginBtn);
    }

}
