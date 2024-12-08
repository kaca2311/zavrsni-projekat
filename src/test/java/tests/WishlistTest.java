package tests;

import org.testng.annotations.Test;
import pages.ProfilePage;

/**
 * WishlistTest class contains the test method for verifying the functionality of adding items
 * to the wishlist (favorites) on the application. It ensures that the item is correctly added
 * to the wishlist and can be viewed under the user's profile.
 * This class extends the BaseTest class, inheriting the setup and teardown operations.
 */
public class WishlistTest extends BaseTest {

    /**
     * Test method to verify the addition of an item to the wishlist (favorites).
     * The test performs the following actions:
     * 1. Logs in with valid credentials.
     * 2. Adds an item (Combination Pliers) to the wishlist.
     * 3. Navigates to the profile page and checks if the item is present in the wishlist.
     *
     * The method uses the `performWishlistTest` method from the `ProfilePage` class to carry out
     * the steps and assertions for this test case.
     */
    @Test(description = "Checking if the item is added to favorites")
    public void wishlistTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.performWishlistTest();
    }

}
