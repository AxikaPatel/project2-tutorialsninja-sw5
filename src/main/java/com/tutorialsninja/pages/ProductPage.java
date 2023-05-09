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

public class ProductPage extends Utility
{
    public ProductPage()
    {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;
    By calendarButton = By.xpath("//div[@class = 'input-group date']//button");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");

    @CacheLookup
    @FindBy(css = "#input-quantity")
    By qtyField = By.cssSelector("#input-quantity");

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    By datePicker = By.xpath("//div[@class = 'input-group date']//button");


    public String getProductText() {
        Reporter.log("get Product Text  " + productText.toString());
        CustomListeners.test.log(Status.PASS, "get Product Text " + productText);
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on add to cart button  " + addToCartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart button " + addToCartButton);
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        Reporter.log("get Product Added Success Message  " + successMessage.toString());
        CustomListeners.test.log(Status.PASS, "get Product Added Success Message " + successMessage);
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        Reporter.log("click On Shopping Cart LinkI nto Message  " + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "click On Shopping Cart LinkI nto Message " + shoppingCartLink);
        clickOnElement(shoppingCartLink);
    }

    public void enterQuantity(String qty) {
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
    }
}
