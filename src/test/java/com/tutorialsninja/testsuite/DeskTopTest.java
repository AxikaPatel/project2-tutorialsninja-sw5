package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DeskTopTest extends BaseTest
{
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopsPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        desktopsPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopsPage.getProductsNameList();
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        desktopsPage.selectSortByOption("Name (A - Z)");
        desktopsPage.selectProductByName("HP LP3065");
        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");
        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}
