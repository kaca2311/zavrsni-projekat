package tests;

import org.testng.annotations.Test;
import utils.DataProvider;
import pages.LoginPage;

/**
 * NegativeLoginTest class contains the test method for verifying the login functionality
 * of the application with invalid credentials. It ensures that the application correctly
 * handles invalid login attempts by showing the login button or an error message.
 * This class extends the BaseTest class, inheriting the setup and teardown operations.
 */
public class NegativeLoginTest extends BaseTest {

    /**
     * Test method to verify that the login functionality works correctly with invalid credentials.
     * The test uses different invalid email and password combinations provided by the DataProvider
     * to perform the negative login test.
     *
     * The test follows these steps:
     * 1. Attempts to log in with invalid credentials.
     * 2. Verifies that the login button is still displayed, indicating a failed login attempt.
     *
     * The method uses the "Invalid login credentials" data provider to supply the test data
     * (invalid email and password combinations).
     *
     * @param email The email address to use for login.
     * @param password The password to use for login.
     */
    @Test(description = "testing the login functionality of the app",
            dataProviderClass = DataProvider.class,
            dataProvider = "Invalid login credentials")
    public void negativeLoginTest(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performNegativeLogin(email, password);
    }

}
