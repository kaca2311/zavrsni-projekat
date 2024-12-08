package tests;

import org.testng.annotations.Test;
import pages.HomePage;

/**
 * CategoryTest class contains the test method for verifying the behavior of
 * the categories on the homepage. It checks if the number of items in a specific
 * category is lower than the total number of items available on the website.
 * This class extends the BaseTest class, inheriting setup and teardown operations.
 */
public class CategoryTest extends BaseTest {

    /**
     * Test method to check if the number of elements in a specific category
     * is lower than the total number of elements on the website.
     *
     * The test follows these steps:
     * 1. Navigates to the categories section on the homepage.
     * 2. Applies filters for a specific category.
     * 3. Compares the total number of items in the category to the overall item count.
     *
     * This method calls the performCategoryTest method from the HomePage class
     * to execute the filtering and verification of item counts.
     */
    @Test(description = "Checking if number of elements in category is lower than total")
    public void categoryTest() {
        HomePage homePage = new HomePage(driver);
        homePage.performCategoryTest();
    }
}
