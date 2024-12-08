package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage class represents the login page of the application under test.
 * It provides methods to interact with login elements and perform login operations.
 * Extends the BasePage class for common web interaction utilities.
 */
public class LoginPage extends BasePage {

    /**
     * Constructor to initialize the LoginPage with a WebDriver instance.
     *
     * @param driver the WebDriver instance to interact with the browser.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * An instance of the HomePage to allow navigation to the home page and interaction with its elements.
     */
    HomePage homePage = new HomePage(driver);

    // Locators for elements on the Login Page
    protected By emailBarBy = By.xpath("//input[@id='email']");
    protected By passwordBarBy = By.xpath("//input[@id='password']");
    protected By loginButtonBy = By.cssSelector(".btnSubmit");

    /**
     * Types the provided email into the email input field.
     *
     * @param email the email to be entered.
     */
    protected void typeEmail(String email) {
        waitVisibility(emailBarBy);
        clearText(emailBarBy);
        typeIn(emailBarBy, email);
    }

    /**
     * Types the provided password into the password input field.
     *
     * @param password the password to be entered.
     */
    protected void typePassword(String password) {
        waitVisibility(passwordBarBy);
        clearText(passwordBarBy);
        typeIn(passwordBarBy, password);
    }

    /**
     * Clicks the login button.
     */
    protected void clickLoginButton() {
        clickElement(loginButtonBy);
    }

    /**
     * Performs a negative login scenario to validate the application does not allow login
     * with incorrect credentials.
     *
     * @param email    the email to use for login.
     * @param password the password to use for login.
     */
    public void performNegativeLogin(String email, String password) {
        homePage.clickSignInButton();
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
        assertElementDisplayed(loginButtonBy); // Assert the login button is still displayed, indicating login failed.
    }

    /**
     * Performs a positive login scenario using valid credentials.
     * <p>
     * Steps:
     * <ol>
     *     <li>Clicks the 'Sign In' button on the Home Page.</li>
     *     <li>Enters a valid email and password.</li>
     *     <li>Clicks the login button.</li>
     *     <li>Waits until the 'Jane Doe' profile link is visible, indicating a successful login.</li>
     * </ol>
     * </p>
     */
    public void performLogin() {
        homePage.clickSignInButton();
        typeEmail("customer@practicesoftwaretesting.com");
        typePassword("welcome01");
        clickLoginButton();
        waitVisibility(homePage.janeDoeBy);
    }

}
