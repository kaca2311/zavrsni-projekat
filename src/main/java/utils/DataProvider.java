package utils;

/**
 * DataProvider class provides test data for various test cases.
 * In this case, it specifically provides invalid login credentials
 * for testing the login functionality with invalid inputs.
 * This class is used with TestNG's @DataProvider annotation to supply
 * data to the test methods.
 */
public class DataProvider {

    /**
     * Provides invalid login credentials as test data for negative login tests.
     * This data is used to test the system's behavior when invalid login details are entered.
     *
     * @return 2D Object array containing invalid login credentials:
     *         the first element is the email, and the second is the password.
     */
    @org.testng.annotations.DataProvider(name = "Invalid login credentials")
    public static Object[][] negativeLoginData() {
        return new Object[][] {
                {"asd@asd.com", "asd"},
                {"", ""},
                {"qwerty", "asd@asd.com"}
        };
    }

}

