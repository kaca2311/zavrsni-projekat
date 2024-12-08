package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * ProductPage class represents the product page in the e-commerce application under test.
 * It provides methods for interacting with product-related elements and performing cart and checkout operations.
 * Extends the BasePage class to utilize common web interaction utilities.
 */
public class ProductPage extends BasePage {

    /**
     * Constructor that initializes the ProductPage with a WebDriver instance.
     *
     * @param driver the WebDriver instance used for interacting with the browser.
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * An instance of the HomePage class to interact with elements from the home page.
     */
    HomePage homePage = new HomePage(driver);

    // Locators for elements on the Product Page
    protected By plusProductButtonBy = By.id("btn-increase-quantity");
    protected By addToCartButtonBy = By.id("btn-add-to-cart");
    protected By headerHomeBy = By.xpath("//a[text()='Home']");
    protected By pliersBy = By.xpath("//h5[text()=' Pliers ']");
    protected By itemsNumberBubbleBy = By.id("lblCartCount");
    protected By notificationPopupBy = By.xpath("//div[text()=' Product added to shopping cart. ']");
    protected By cartIconBy = By.cssSelector("[data-icon='cart-shopping']");
    protected By proceedToCheckoutButtonBy = By.xpath("//button[text()='Proceed to checkout']");
    protected By proceedToCheckoutButton2By = By.xpath("//button[text()=' Proceed to checkout ']");
    protected By proceedToCheckoutButton3By = By.xpath("//button[text()='Proceed to checkout ']");
    protected By emailBarBy = By.xpath("//input[@id='email']");
    protected By passwordBarBy = By.xpath("//input[@id='password']");
    protected By loginButtonBy = By.xpath("//input[@class='btnSubmit']");
    protected By stateBarBy = By.id("state");
    protected By postcodeBarBy = By.id("postcode");
    protected By paymentMethodDropdownBy = By.id("payment-method");
    protected By cashOnDeliveryOptionBy = By.xpath("//option[text()='Cash on Delivery']");
    protected By confirmButtonBy = By.xpath("//button[text()=' Confirm ']");
    protected By paymentSuccessfulNotificationBy = By.xpath("//div[text()='Payment was successful']");
    protected By orderConfirmedBy = By.id("order-confirmation");

    /**
     * Increases the quantity of the product by 1.
     */
    protected void addTwoItems() {
        waitVisibility(plusProductButtonBy);
        clickElement(plusProductButtonBy);
    }

    /**
     * Clicks the 'Add to Cart' button to add the current product to the cart.
     */
    protected void clickAddToCartButton() {
        waitVisibility(addToCartButtonBy);
        clickElement(addToCartButtonBy);
    }

    /**
     * Navigates to the home page by clicking the Home link.
     */
    protected void clickHome() {
        clickElement(headerHomeBy);
    }

    /**
     * Selects the pliers product from the list on the product page.
     */
    protected void clickPliers() {
        waitVisibility(pliersBy);
        clickElement(pliersBy);
    }

    /**
     * Asserts that the number of items in the cart matches the expected value (3 items).
     */
    protected void assertNumberOfItemsAdded() {
        String currentNumberOfItems = getText(itemsNumberBubbleBy);
        assertStringsEqual(currentNumberOfItems, "3");
    }

    /**
     * Navigates to the cart page by clicking the cart icon.
     */
    protected void clickCart() {
        waitInvisibility(notificationPopupBy);
        clickElement(cartIconBy);
    }

    /**
     * Asserts that the total price in the cart matches the expected total of $40.31.
     */
    protected void assertTotalToPay() {
        double combinedPliersPrice = 14.15;
        double pliersPrice = 12.01;

        double totalDouble = (2 * combinedPliersPrice) + pliersPrice;
        String totalString = "$" + totalDouble;
        Assert.assertEquals(totalString, "$40.31");
    }

    /**
     * Clicks the 'Proceed to Checkout' button (first variant) in the checkout process.
     */
    protected void clickProceedToCheckout() {
        waitToBeClickable(proceedToCheckoutButtonBy);
        clickElement(proceedToCheckoutButtonBy);
    }

    /**
     * Clicks the 'Proceed to Checkout' button (second variant) in the checkout process.
     */
    protected void clickProceedToCheckout2() {
        waitToBeClickable(proceedToCheckoutButton2By);
        clickElement(proceedToCheckoutButton2By);
    }

    /**
     * Clicks the 'Proceed to Checkout' button (third variant) in the checkout process.
     */
    protected void clickProceedToCheckout3() {
        waitToBeClickable(proceedToCheckoutButton3By);
        clickElement(proceedToCheckoutButton3By);
    }

    /**
     * Types the email address into the email input field during login.
     *
     * @param email the email address to enter.
     */
    protected void typeInEmail(String email) {
        waitVisibility(emailBarBy);
        typeIn(emailBarBy, email);
    }

    /**
     * Types the password into the password input field during login.
     *
     * @param password the password to enter.
     */
    protected void typeInPassword(String password) {
        typeIn(passwordBarBy, password);
    }

    /**
     * Clicks the login button to submit the login form.
     */
    protected void clickLoginButton() {
        waitVisibility(loginButtonBy);
        clickElement(loginButtonBy);
    }

    /**
     * Types the state in the respective input field during the checkout process.
     *
     * @param state the state to enter.
     */
    protected void typeInState(String state) {
        try {
            Thread.sleep(1000); // Wait for UI to settle
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitToBeClickable(stateBarBy);
        typeIn(stateBarBy, state);
    }

    /**
     * Types the postcode in the respective input field during the checkout process.
     *
     * @param postcode the postcode to enter.
     */
    protected void typeInPostcode(String postcode) {
        waitToBeClickable(postcodeBarBy);
        typeIn(postcodeBarBy, postcode);
    }

    /**
     * Clicks the dropdown menu for payment methods during the checkout process.
     */
    protected void clickPaymentMethodDropdown() {
        waitVisibility(paymentMethodDropdownBy);
        clickElement(paymentMethodDropdownBy);
    }

    /**
     * Selects 'Cash on Delivery' as the payment method.
     */
    protected void clickCashOnDeliveryOption() {
        waitToBeClickable(cashOnDeliveryOptionBy);
        clickElement(cashOnDeliveryOptionBy);
    }

    /**
     * Confirms the payment method and proceeds to final confirmation.
     */
    protected void clickConfirm() {
        waitVisibility(confirmButtonBy);
        clickElement(confirmButtonBy);
    }

    /**
     * Performs a full cart test including adding products to the cart, checking the total price,
     * logging in, and completing the checkout process.
     */
    public void performCartTest() {
        homePage.clickCombinationPliers();
        addTwoItems();
        clickAddToCartButton();
        waitForTextToBeLoaded(itemsNumberBubbleBy, "2");
        clickHome();
        clickPliers();
        clickAddToCartButton();
        waitForTextToBeLoaded(itemsNumberBubbleBy, "3");
        assertNumberOfItemsAdded();
        clickCart();
        assertTotalToPay();
        clickProceedToCheckout();
        typeInEmail("customer@practicesoftwaretesting.com");
        typeInPassword("welcome01");
        clickLoginButton();
        clickProceedToCheckout2();
        typeInState("Test state");
        typeInPostcode("1111");
        clickProceedToCheckout3();
        clickPaymentMethodDropdown();
        clickCashOnDeliveryOption();
        clickConfirm();
        waitVisibility(paymentSuccessfulNotificationBy);
        assertElementDisplayed(paymentSuccessfulNotificationBy);
        clickConfirm();
        waitVisibility(orderConfirmedBy);
        assertElementDisplayed(orderConfirmedBy);
    }

}
