package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ProfilePage class represents the user profile page in the e-commerce application under test.
 * It provides methods to interact with the profile, including verifying items added to the favorites or wishlist.
 * Extends the BasePage class to utilize common web interaction utilities.
 */
public class ProfilePage extends BasePage {

    /**
     * Constructor that initializes the ProfilePage with a WebDriver instance.
     *
     * @param driver the WebDriver instance used for interacting with the browser.
     */
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * An instance of the LoginPage class for interacting with login-related elements.
     */
    LoginPage loginPage = new LoginPage(driver);

    /**
     * An instance of the ProductPage class for interacting with product-related elements.
     */
    ProductPage productPage = new ProductPage(driver);

    /**
     * An instance of the HomePage class to interact with home page elements.
     */
    HomePage homePage = new HomePage(driver);

    // Locator for the name of the product added to the favorites
    protected By combinedPliersTextBy = By.cssSelector(".card-title");

    /**
     * Asserts that "Combination Pliers" is added to the favorites list.
     */
    protected void assertPliersAddedToFavorites() {
        waitVisibility(combinedPliersTextBy);
        String currentItemName = getText(combinedPliersTextBy);
        assertStringsEqual(currentItemName, "Combination Pliers");
    }

    /**
     * Performs a complete wishlist test by logging in, adding a product to the wishlist,
     * and verifying that the product appears in the user's profile favorites.
     */
    public void performWishlistTest() {
        loginPage.performLogin();
        productPage.clickHome();
        homePage.clickCombinationPliers();
        homePage.addCombinationPliersToWishlist();
        homePage.clickJaneDoe();
        homePage.clickProfileFavorites();
        assertPliersAddedToFavorites();
    }

}
