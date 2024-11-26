package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

    //Base url
    String baseUrl = "https://demowebshop.tricentis.com/";

    //Set up the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));

        //1.2 Click on the Desktop
        clickOnElement(By.xpath("//li[@class='active']//a[normalize-space()='Desktops']"));

        //1.3 Select Sort By option "Name: Z to A"
        WebElement dropDown = findWebElement(By.xpath("//select[@id='products-orderby']"));
        selectOptionInSelectElement(dropDown, "Name: Z to A");

//        //1.4 Verify the Product will be arranged in Descending order.
        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='product-title']/a"));

        //store product name in the actualProductName List.
        List<String> actualProductsName = new ArrayList<>();
        for (WebElement product : productNames) {
            actualProductsName.add(product.getText());
        }

        List<String> expectedProductName = new ArrayList<>(actualProductsName);
        Collections.sort(expectedProductName, Collections.reverseOrder());

        Assert.assertEquals("Products are not in Descending order", expectedProductName, actualProductsName);
    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));

        //2.2 Click on the Desktop
        clickOnElement(By.xpath("//li[@class='active']//a[normalize-space()='Desktops']"));

        //2.3 Select Sort By option "Name: A to Z"
        WebElement dropDown = findWebElement(By.xpath("//select[@id='products-orderby']"));
        selectOptionInSelectElement(dropDown, "Name: A to Z");

        //2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElem(By.cssSelector("h1[itemprop='name']"));
        Assert.assertEquals("Build your own computer not displayed", expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        WebElement processorSelector = driver.findElement(RelativeLocator.with(By.tagName("select")).above(By.xpath("//label[normalize-space()='RAM']")));
        selectOptionInSelectElement(processorSelector, "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using the Select class.
        WebElement selectRAM = findWebElement(RelativeLocator.with(By.tagName("select")).below(By.xpath("//label[normalize-space()='RAM']")));
        selectOptionInSelectElement(selectRAM, "8GB [+60.00]");

        //2.8 Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[contains(text(),'400 GB')]")));

        //2.9 Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[contains(text(),'Windows 10')]")));

        //2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[contains(text(),'Total Commander')]")));

        //2.11 Verify the price "1200.00"
        String actualPrice = getTextFromElem(By.xpath("//div[@class='product-price']/span"));
        String expectedPrice = "1200.00";
        Assert.assertEquals("The price 1200 is not displayed", expectedPrice, actualPrice);

        //2.12 Click on the "Add to card" Button.
        clickOnElement(By.xpath("//div[@class='add-to-cart-panel']/input[2]"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        String actualMessage = getTextFromElem(By.xpath("//p[@class='content']"));
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("The Message The product has been added to your shopping cart is not displayed", expectedMessage, actualMessage);

        //2.14 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHooverAndClickOnElement(findWebElement(By.xpath("//span[normalize-space()='Shopping cart']")));

        //2.16 Verify the message "Shopping cart"
        String actualShoppingCartMessage = getTextFromElem(By.xpath("//h1[normalize-space()='Shopping cart']"));
        String expectedShoppingCartMessage = "Shopping cart";
        Assert.assertEquals("The message shopping cart is not displayed", expectedShoppingCartMessage, actualShoppingCartMessage);

        //2.17 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextOnElement(By.xpath("//td[@class='qty nobr']/input"), "2");
        clickOnElement(By.xpath("//input[@name='updatecart']"));

        //2.18 Verify the Total "2,950.00"
        String actualTotal = getTextFromElem(By.xpath("//span[@class='product-subtotal']"));
        String expetedTotal = "2950.00";
        Assert.assertEquals("The Total 2950.00 is not displayed", expetedTotal, actualTotal);

        //2.19 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.20 Click on “Checkout”
        clickOnElement(By.id("checkout"));

        //2.21 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = getTextFromElem(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        String expectedWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("The text Welcome Please sign In is not displayed", expectedWelcomeText, actualWelcomeText);

        //2.22 Click on the “Checkout as Guest” Tab
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        //2.23 Enter the First name
        sendTextOnElement(By.id("BillingNewAddress_FirstName"), "Payal");

        //2.24 Enter the Last name
        sendTextOnElement(By.id("BillingNewAddress_LastName"), "Patel");

        //2.25 Enter the email
        sendTextOnElement(By.id("BillingNewAddress_Email"), "Payal123@gmail.com");

        //2.26 Select the Country “United Kingdom” using the select class
        WebElement selectCountry = findWebElement(By.id("BillingNewAddress_CountryId"));
        selectOptionInSelectElement(selectCountry, "United Kingdom");
        //2.27 Enter the city
        sendTextOnElement(By.id("BillingNewAddress_City"), "London");

        //2.28 Enter the Address1
        sendTextOnElement(By.id("BillingNewAddress_Address1"), "238D DreamStreet");

        //2.29 Enter the Zip/Postal code
        sendTextOnElement(By.id("BillingNewAddress_ZipPostalCode"), "HA0 0QQ");

        //2.30 Enter the Phone number
        sendTextOnElement(By.id("BillingNewAddress_PhoneNumber"), "2323232323");

        //2.31 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        //2.32 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        //2.33 Click on the Radio Button “Next Day Air($0.00)”
        //clickOnElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[normalize-space()='Next Day Air (0.00)']")));
        clickOnElement(By.xpath("//li[@id='opc-shipping_method']//li[2]//div[1]/input"));

        //2.34 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/input"));

        //2.35 Select the Radio Button “Credit Card”
        //clickOnElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//label[normalize-space()='Credit Card']")));
        clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/input"));


        //2.36 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/input"));

        //2.37 Select “Master card” From the Select credit card dropdown using the Select class
        WebElement selectCardType = findWebElement(By.xpath("//select[@id='CreditCardType']"));
        selectOptionInSelectElement(selectCardType, "Master card");

        //2.38 Enter the Cardholder's name
        sendTextOnElement(By.xpath("//input[@id='CardholderName']"), "Payal Patel");

        //2.39 Enter the Card number
        sendTextOnElement(By.xpath("//input[@id='CardNumber']"), "5420623654376573");

        //2.40 Select the Expiration date using the select class
        WebElement selectMonth = findWebElement(By.xpath("//select[@id='ExpireMonth']"));
        selectOptionInSelectElement(selectMonth, "06");
        WebElement selectYear = findWebElement(By.xpath("//select[@id='ExpireYear']"));
        selectOptionInSelectElement(selectYear, "2026");

        //2.41 Enter the Card code
        sendTextOnElement(By.xpath("//input[@id='CardCode']"), "123");

        //2.42 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/input"));

        //2.43 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = getTextFromElem(By.xpath("//li[@class='payment-method']"));
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals("The Payment Method is not credit card", expectedPaymentMethod, actualPaymentMethod);

        //2.44 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMethod = getTextFromElem(By.xpath("//li[@class='shipping-method']"));
        String expectedShippingMethod = "Next Day Air";
        Assert.assertEquals("The Shipping Method is next day air is not displayed", expectedShippingMethod, actualShippingMethod);

        //2.45 Verify Total is “2,950.00”
        String actualTotalPrice = getTextFromElem(By.xpath("//span[@class='product-subtotal']"));
        String expectedTotalPrice = "2950.00";
        Assert.assertEquals("The Price is not displayed", expectedTotalPrice, actualTotalPrice);

        //2.46 Click on the “Confirm” button
        clickOnElement(By.xpath("//input[@value='Confirm']"));

        //2.47 Verify the Text “Thank You”
        String actualThankYou = getTextFromElem(By.xpath("//h1[normalize-space()='Thank you']"));
        String expectedThankYou = "Thank you";
        Assert.assertEquals("The text thank you is not displayed ", expectedThankYou, actualThankYou);

        //2.48 Verify the message “Your order has been successfully processed!”
        String actualSuccess = getTextFromElem(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        String expectedSuccess = "Your order has been successfully processed!";
        Assert.assertEquals("The message is not displayed ", expectedSuccess, actualSuccess);

        //2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //2.50 Verify the text “Welcome to our store”
        String actualWelcomeMessage = getTextFromElem(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String expectedWelcomeMessage = "Welcome to our store";
        Assert.assertEquals("The message is not displayed ", expectedWelcomeMessage, actualWelcomeMessage);

    }

    //Close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
