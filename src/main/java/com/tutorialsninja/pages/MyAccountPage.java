package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccountPage extends Utility
{

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public String getAccountLogoutText() {
        Reporter.log("get Account Logout Text  " + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "get Account Logout Text " + accountLogoutText);
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        Reporter.log("get Your Account Has Been Created Text  " + accountCreatedText.toString());
        CustomListeners.test.log(Status.PASS, "get Your Account Has Been Created Text " + accountCreatedText);
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueButton() throws InterruptedException {
        Reporter.log("Click on continue button " + continueBtn.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button " + continueBtn);
        Thread.sleep(1000);
        clickOnElement(continueBtn);
    }
}
