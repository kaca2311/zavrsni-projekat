package tests;

import org.testng.annotations.Test;
import pages.ProductPage;

/**
 * CartTest class contains the test methods related to the shopping cart functionality.
 * It performs actions related to adding items to the cart, verifying the cart contents,
 * and proceeding through the checkout process.
 * This class extends the BaseTest class, inheriting setup and teardown operations.
 */
public class CartTest extends BaseTest {

    /**
     * Test method for adding and checking items in the shopping cart.
     * This test simulates the following steps:
     * 1. Adds items to the cart.
     * 2. Verifies the number of items in the cart.
     * 3. Proceeds to checkout and completes the payment process.
     *
     * This method calls the performCartTest method from the ProductPage class
     * to execute the shopping cart and checkout functionality.
     */
    @Test(description = "Adding and checking items in the cart")
    public void cartTest() {
        ProductPage productPage = new ProductPage(driver);
        productPage.performCartTest();
    }

}
