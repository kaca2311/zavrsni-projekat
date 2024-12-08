package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * HomePage class represents the home page of the application under test and provides
 * methods to interact with its elements. It extends the BasePage class to reuse common
 * functionality for interacting with web elements.
 */
public class HomePage extends BasePage {

    /**
     * Constructor to initialize the HomePage with a WebDriver instance.
     *
     * @param driver the WebDriver instance to interact with the browser.
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators for elements on the Home Page
    protected By signInButtonBy = By.xpath("//a[text()='Sign in']");
    protected By combinationPliersBy = By.xpath("//h5[text()=' Combination Pliers ']");
    protected By favoritesButtonBy = By.id("btn-add-to-favorites");
    protected By janeDoeBy = By.xpath("//a[text()=' Jane Doe ']");
    protected By profileFavoritesBy = By.xpath("//a[text()='My favorites']");
    protected By productCardBy = By.cssSelector(".card");
    protected By categoriesBy = By.xpath("//a[text()=' Categories ']");
    protected By powerToolsBy = By.xpath("//a[text()='Power Tools']");
    protected By grinderCheckbox = By.xpath("//label[text()=' Grinder']");
    protected By sanderCheckbox = By.xpath("//label[text()=' Sander']");
    protected By sawCheckbox = By.xpath("//label[text()=' Saw']");

    /**
     * Clicks the 'Sign In' button.
     */
    protected void clickSignInButton() {
        clickElement(signInButtonBy);
    }

    /**
     * Clicks on the 'Combination Pliers' product.
     */
    protected void clickCombinationPliers() {
        waitVisibility(combinationPliersBy);
        clickElement(combinationPliersBy);
    }

    /**
     * Adds 'Combination Pliers' to the wishlist by clicking the favorites button.
     */
    protected void addCombinationPliersToWishlist() {
        waitVisibility(favoritesButtonBy);
        clickElement(favoritesButtonBy);
    }

    /**
     * Clicks on the 'Jane Doe' user profile link.
     */
    protected void clickJaneDoe() {
        waitVisibility(janeDoeBy);
        clickElement(janeDoeBy);
    }

    /**
     * Clicks on the 'My Favorites' link in the user profile.
     */
    protected void clickProfileFavorites() {
        waitVisibility(profileFavoritesBy);
        clickElement(profileFavoritesBy);
    }

    /**
     * Gets the number of product cards displayed on the page.
     *
     * @return the number of product cards.
     */
    protected int getNumberOfItems() {
        try {
            Thread.sleep(1000); // Pause for 1 second
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getNumberOfElements(productCardBy);
    }

    /**
     * Clicks the 'Categories' menu item.
     */
    protected void clickCategories() {
        clickElement(categoriesBy);
    }

    /**
     * Clicks the 'Power Tools' category link.
     */
    protected void clickPowerTools() {
        waitVisibility(powerToolsBy);
        clickElement(powerToolsBy);
    }

    /**
     * Checks the 'Grinder' checkbox in the filter options.
     */
    protected void checkGrinder() {
        try {
            Thread.sleep(1000); // Pause for 1 second
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickElement(grinderCheckbox);
    }

    /**
     * Checks the 'Sander' checkbox in the filter options.
     */
    protected void checkSander() {
        try {
            Thread.sleep(1000); // Pause for 1 second
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickElement(sanderCheckbox);
    }

    /**
     * Checks the 'Saw' checkbox in the filter options.
     */
    protected void checkSaw() {
        try {
            Thread.sleep(1000); // Pause for 1 second
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickElement(sawCheckbox);
    }

    /**
     * Performs a category filtering test.
     * <p>
     * Steps:
     * <ol>
     *     <li>Get the initial number of items displayed on the page.</li>
     *     <li>Click the 'Categories' menu and navigate to 'Power Tools'.</li>
     *     <li>Apply filters by checking the 'Grinder', 'Sander', and 'Saw' checkboxes.</li>
     *     <li>Get the updated number of items displayed.</li>
     *     <li>Assert that the filtered number of items is less than the default.</li>
     * </ol>
     * </p>
     */
    public void performCategoryTest() {
        int defaultNumberOfItems = getNumberOfItems();
        clickCategories();
        clickPowerTools();
        checkGrinder();
        checkSander();
        checkSaw();
        int powerToolsNumberOfItems = getNumberOfItems();

        System.out.println("Full items list: " + defaultNumberOfItems);
        System.out.println("Power tools items list: " + powerToolsNumberOfItems);

        Assert.assertTrue(defaultNumberOfItems > powerToolsNumberOfItems);
    }

}
