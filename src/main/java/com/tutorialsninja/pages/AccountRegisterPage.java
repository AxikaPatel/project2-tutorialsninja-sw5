package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility
{
    public AccountRegisterPage() {
    PageFactory.initElements(driver, this);
}
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    //
    By subscribeRadios = By.xpath("//fieldset[3]//input");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getRegisterAccountText() {
        Reporter.log("Get Register Account Text " + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS,"Get Register Account Text " + registerAccountText);
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter First name " + firstNameField.toString());
        CustomListeners.test.log(Status.PASS,"Enter First name  " + firstNameField);
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter last name " + LastNameField.toString());
        CustomListeners.test.log(Status.PASS,"Enter last name  " + LastNameField);
        sendTextToElement(LastNameField, lName);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter Email  " + emailField.toString());
        CustomListeners.test.log(Status.PASS,"Enter Email  " + emailField);
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {
        Reporter.log("Enter telephone  " + telephoneField.toString());
        CustomListeners.test.log(Status.PASS,"Enter telephone  " + telephoneField);
        sendTextToElement(telephoneField, telephone);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password  " + passwordField.toString());
        CustomListeners.test.log(Status.PASS,"Enter password  " + passwordField);
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log("Enter Confirm password  " + passwordField.toString());
        CustomListeners.test.log(Status.PASS,"Enter Confirm password  " + passwordField);
        sendTextToElement(passwordConfirmField, cPassword);
    }

    public void selectSubscription(String option) {
        Reporter.log("select Subscription  " + subscribeRadios.toString());
        CustomListeners.test.log(Status.PASS,"select Subscription  " + subscribeRadios);
        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("click On Privacy Policy CheckBox  " + subscribeRadios.toString());
        CustomListeners.test.log(Status.PASS,"click On Privacy Policy CheckBox   " + subscribeRadios);
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {
        Reporter.log("click On Continue Button  " + continueBtn.toString());
        CustomListeners.test.log(Status.PASS,"click On Continue Button    " + continueBtn);
        clickOnElement(continueBtn);
    }
}
