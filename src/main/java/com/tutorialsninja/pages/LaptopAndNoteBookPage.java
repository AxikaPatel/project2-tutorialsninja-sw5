package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNoteBookPage extends Utility
{
    public LaptopAndNoteBookPage()
    {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement>productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    public String getLaptopsAndNotebooksText()
    {
        Reporter.log(" Verify the text ‘Laptops & Notebooks’");
        CustomListeners.test.log(Status.PASS," Verify the text ‘Laptops & Notebooks’");
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        Reporter.log("Get Products Price List");
        CustomListeners.test.log(Status.PASS, "Get Products Price List");
        List<WebElement> products = productsPrices;
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option)
    {
        Reporter.log("Select Sort By Price (High > Low)");
        selectByVisibleTextFromDropDown(sortBy,option);
        CustomListeners.test.log(Status.PASS,"Select Sort By Price (High > Low)");
    }

    public void selectProductByName(String product) {
        Reporter.log("Select Product By Name");
        CustomListeners.test.log(Status.PASS, "Select Product By Name");
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }


}
