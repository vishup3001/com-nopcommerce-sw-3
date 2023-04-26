package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String email;

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        // Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);


    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";

        // Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // Verify the text “Cell phones”
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(1000);
        // Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        // Verify the text “Nokia Lumia 1020”
        expectedMessage = "Nokia Lumia 1020";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Verify the price “$349.00”
        expectedMessage = "$349.00";
        actualMessage = getTextFromElement(By.xpath("//div[@class='product-price']//span[normalize-space()='$349.00']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        // Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        Thread.sleep(1000);
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//div[@id='bar-notification']"));
        verifyTwoTextMessage(expectedMessage2, actualMessage2);
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        Thread.sleep(1000);
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        mouseHoverAndClick(By.xpath("//button[normalize-space()='Go to cart']"));
        // Verify the message "Shopping cart"
        Thread.sleep(1000);
        expectedMessage = "Shopping cart";
        actualMessage = getTextFromElement(By.xpath("//h1"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Verify the quantity is 2
        expectedMessage = "2";
        actualMessage = getAttributeValueFromElement(By.xpath("//input[contains(@id,'itemquantity')]"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // 2.14 Verify the Total $698.00
        expectedMessage = "$698.00";
        actualMessage = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // Verify the Text “Welcome, Please Sign In!”
        expectedMessage = "Welcome, Please Sign In!";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        // Fill the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='Email']"), email);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Admin@123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Admin@123");
        // Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // Verify the message “Your registration completed”
        expectedMessage = "Your registration completed";
        actualMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        System.out.println("-----------------Fail because of bug--------------------------");
        System.out.println("=================================================================");
        System.out.println("-----------------Shopping cart is getting empty--------------------------");

        expectedMessage = "Shopping cart";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "primetesting@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Mehsana");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Tintodan");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "382865");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9898989898");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);

        selectRadioButton(By.xpath("//input[@id='shippingoption_2']"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        selectRadioButton(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5573615091331588");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);

        expectedMessage = "Credit Card";
        actualMessage = getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        expectedMessage = "2nd Day Air";
        actualMessage = getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        expectedMessage = "$698.00";
        actualMessage = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        String expectedMessage9 = "Thank you";
        String actualMessage9 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        verifyTwoTextMessage(expectedMessage9, actualMessage9);


        expectedMessage = "Your order has been successfully processed!";
        actualMessage = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        expectedMessage = "Welcome to our store";
        actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

        expectedMessage = "Log out";
        actualMessage = getTextFromElement(By.xpath("//a[normalize-space()='Log out']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }
}
