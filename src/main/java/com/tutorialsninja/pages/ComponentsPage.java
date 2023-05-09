package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ComponentsPage extends Utility
{
    public ComponentsPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;

    public String getComponentsText() {
        Reporter.log("Get component Text  " + componentsText.toString());
        CustomListeners.test.log(Status.PASS,"Get component Text " + componentsText);
        return getTextFromElement(componentsText);
    }
}
