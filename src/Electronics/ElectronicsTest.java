package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    //Base url
    String baseUrl = "https://demowebshop.tricentis.com/";

    //Set up the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on the “ELECTRONICS” Tab
        WebElement electronicsTab = findWebElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));
        mouseHooverOnElement(electronicsTab);

        //1.2 Mouse Hover on the “Cell phones” and click
        Thread.sleep(3000);
        WebElement CellPhone = findWebElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Cell phones']"));
        mouseHooverAndClickOnElement(CellPhone);

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElem(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Cell phones text not displayed", expectedText, actualText);

    }

    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on the “ELECTRONICS” Tab
        WebElement electronicsTab = findWebElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));
        mouseHooverOnElement(electronicsTab);

        //2.2 Mouse Hover on the “Cell phones” and click
        WebElement CellPhone = findWebElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Cell phones']"));
        mouseHooverAndClickOnElement(CellPhone);

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElem(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Cell phones text not displayed", expectedText, actualText);

        //2.4 Select View as option ‘List’
        WebElement selectOption = findWebElement(By.xpath("//select[@id='products-viewmode']"));
        selectOptionInSelectElement(selectOption, "List");

        //2.5 Click on the product name “Smartphone” link
        clickOnElement(By.linkText("Smartphone"));

        //2.6 Verify the text “Smartphone”
        String actualSmartPhoneText = getTextFromElem(By.cssSelector("h1[itemprop='name']"));
        String expectedSmartPhoneText = "Smartphone";
        Assert.assertEquals("The text Smartphone is not displayed", expectedSmartPhoneText, actualSmartPhoneText);

        //2.7 Verify the price “100.00”
        String actualSmartPhonePrice = getTextFromElem(By.cssSelector(".price-value-43"));
        String expectedSmartPrice = "100.00";
        Assert.assertEquals("The text Smartphone is not displayed", expectedSmartPrice, actualSmartPhonePrice);

        //2.8 Change the quantity to 2
        sendTextOnElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//label[normalize-space()='Qty:']")), "2");

        //2.9 Click on the “Add to cart” tab
        clickOnElement(By.xpath("//div[@class='add-to-cart-panel']/input[2]"));

        //2.10Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = getTextFromElem(By.xpath("//p[@class='content']"));
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("", expectedMessage, actualMessage);
        //2.11 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.12 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHooverAndClickOnElement(findWebElement(By.xpath("//span[normalize-space()='Shopping cart']")));

        //2.13 Verify the message "Shopping cart"
        String actualShoppingCartMessage = getTextFromElem(By.xpath("//h1[normalize-space()='Shopping cart']"));
        String expectedShoppingCartMessage = "Shopping cart";
        Assert.assertEquals("The message shopping cart is not displayed", expectedShoppingCartMessage, actualShoppingCartMessage);

        //2.14 Verify the quantity is 2
        /*String actualQty = getTextFromElem(By.xpath("//tbody/tr[1]/td[5]/input"));
        String expectedQty = "2";
        Assert.assertEquals("The quantity is not 2.",expectedQty,actualQty);*/

        //2.15 Verify the Total “200.00”
        String actualTotal = getTextFromElem(By.xpath("//span[@class='product-subtotal']"));
        String expectedTotal = "200.00";
        Assert.assertEquals("The Total 200.00 is not displayed", expectedTotal, actualTotal);

        //2.16 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.17 Click on the “Checkout” button
        clickOnElement(By.id("checkout"));

        //2.18 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = getTextFromElem(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        String expectedWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("The text Welcome Please sign In is not displayed", expectedWelcomeText, actualWelcomeText);

        //2.19 Click on the “Register” tab
        clickOnElement(By.xpath("//input[@value='Register']"));

        //2.20 Verify the text “Register”
        String actualRegisterText = getTextFromElem(By.xpath("//h1[normalize-space()='Register']"));
        String expectedRegisterText = "Register";
        Assert.assertEquals("The text Register is not displayed", expectedRegisterText, actualRegisterText);

        //2.21Select the Male radio button
        clickOnElement(By.xpath("//input[@id='gender-male']"));

        //2.22 Enter the First name
        sendTextOnElement(By.xpath("//input[@id='FirstName']"), "Neel");

        //2.23 Enter the Last name
        sendTextOnElement(By.xpath("//input[@id='LastName']"), "Patel");

        //2.24 Enter the Email
        sendTextOnElement(By.xpath("//input[@id='Email']"), "Neel267@gmail.com");

        //2.25 Enter the Password
        sendTextOnElement(By.xpath("//input[@id='Password']"), "Payal123@");

        //2.26 Enter the Confirm password
        sendTextOnElement(By.xpath("//input[@id='ConfirmPassword']"), "Payal123@");

        //2.27 Click on the “Register” button
        clickOnElement(By.xpath("//input[@id='register-button']"));

        //2.28 Verify the message “Your registration completed”
        /*String actualRegisterComText = getTextFromElem(By.xpath("//input[@id='register-button']"));
        String expectedRegisterComText = "Your registration completed";
        Assert.assertEquals("The registration message is not displayed",expectedRegisterComText,actualRegisterComText);*/

        //2.29 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //2.30 Verify the text “Shopping card”
        Thread.sleep(3000);
        String actualShoppingCart = getTextFromElem(By.xpath("//h1[normalize-space()='Shopping cart']"));
        String expectedShoppingCart = "Shopping cart";
        Assert.assertEquals("The message shopping cart is not displayed", expectedShoppingCart, actualShoppingCart);

        //click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.32 Click on the “Checkout”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.33 Select the Country “United Kingdom” using the select class
        WebElement selectCountry = findWebElement(By.id("BillingNewAddress_CountryId"));
        selectOptionInSelectElement(selectCountry, "United Kingdom");

        //2.34 Enter the city
        sendTextOnElement(By.id("BillingNewAddress_City"), "London");

        //2.35 Enter the Address1
        sendTextOnElement(By.id("BillingNewAddress_Address1"), "238D DreamStreet");

        //2.36 Enter the Zip/Postal code
        sendTextOnElement(By.id("BillingNewAddress_ZipPostalCode"), "HA0 0QQ");

        //2.37 Enter the Phone number
        sendTextOnElement(By.id("BillingNewAddress_PhoneNumber"), "2323232323");

        //2.38 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        //2.39 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        //2.40 Click on the Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//li[@id='opc-shipping_method']//li[3]//div[1]/input"));

        //2.41 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/input"));

        //2.42 Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/input"));

        //2.43 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/input"));

        //2.44 Select the “Visa” From Select credit card dropdown
        WebElement selectCardType = findWebElement(By.xpath("//select[@id='CreditCardType']"));
        selectOptionInSelectElement(selectCardType, "Visa");

        //2.45 Enter the Cardholder's name
        sendTextOnElement(By.xpath("//input[@id='CardholderName']"), "Payal Patel");

        //2.46 Enter the Card number
        sendTextOnElement(By.xpath("//input[@id='CardNumber']"), "4915678617150676");

        //2.47 Select the Expiration date using the select class
        WebElement selectMonth = findWebElement(By.xpath("//select[@id='ExpireMonth']"));
        selectOptionInSelectElement(selectMonth, "06");
        WebElement selectYear = findWebElement(By.xpath("//select[@id='ExpireYear']"));
        selectOptionInSelectElement(selectYear, "2026");

        //2.48 Enter the Card code
        sendTextOnElement(By.xpath("//input[@id='CardCode']"), "123");

        //2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/input"));

        //2.50 Verify the “Payment Method” is “Credit Card”
        String actualPaymentMethod = getTextFromElem(By.xpath("//li[@class='payment-method']"));
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals("The Payment Method is not credit card", expectedPaymentMethod, actualPaymentMethod);

        //2.51 Verify the “Shipping Method” is “2nd Day Air”
        String actualShippingMethod = getTextFromElem(By.xpath("//li[@class='shipping-method']"));
        String expectedShippingMethod = "2nd Day Air";
        Assert.assertEquals("The Shipping Method 2nd Day Air is not displayed", expectedShippingMethod, actualShippingMethod);

        //2.52 Verify the Total is “200.00”
        String actualTotalPrice = getTextFromElem(By.xpath("//span[@class='product-subtotal']"));
        String expectedTotalPrice = "200.00";
        Assert.assertEquals("The Price is not displayed", expectedTotalPrice, actualTotalPrice);

        //2.53 Click on the “Confirm” button
        clickOnElement(By.xpath("//input[@value='Confirm']"));

        //2.54 Verify the Text “Thank You”
        String actualThankYou = getTextFromElem(By.xpath("//h1[normalize-space()='Thank you']"));
        String expectedThankYou = "Thank you";
        Assert.assertEquals("The text thank you is not displayed ", expectedThankYou, actualThankYou);

        //2.55 Verify the message “Your order has been successfully processed!”
        String actualSuccess = getTextFromElem(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        String expectedSuccess = "Your order has been successfully processed!";
        Assert.assertEquals("The message is not displayed ", expectedSuccess, actualSuccess);

        //2.56 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //2.57 Verify the text “Welcome to our store”
        String actualWelcomeMessage = getTextFromElem(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String expectedWelcomeMessage = "Welcome to our store";
        Assert.assertEquals("The message is not displayed ", expectedWelcomeMessage, actualWelcomeMessage);

        //2.58 Click on the “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        //2.59 Verify the URL is “https://demowebshop.tricentis.com/”
        String actualURL= driver.getCurrentUrl();
        String expectedURL ="https://demowebshop.tricentis.com/";
        Assert.assertEquals("Current Url is not same as expected url.",expectedURL,actualURL);
    }

    //Close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
