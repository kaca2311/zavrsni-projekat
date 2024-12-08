package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest is a base class for test classes that initializes and manages
 * the Selenium WebDriver instance. It provides setup and teardown methods
 * to ensure a consistent test environment.
 */
public class BaseTest {

    /**
     * Static WebDriver instance to be used by test classes.
     */
    static WebDriver driver;

    /**
     * Sets up the test environment before any test methods in the class are run.
     *
     * <ul>
     *     <li>Initializes the Chrome WebDriver using WebDriverManager.</li>
     *     <li>Maximizes the browser window.</li>
     *     <li>Navigates to the default test URL: "https://practicesoftwaretesting.com".</li>
     * </ul>
     */
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com");
    }

    /**
     * Cleans up the test environment after all test methods in the class have been run.
     *
     * <ul>
     *     <li>Quits the WebDriver instance if it is not null.</li>
     * </ul>
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
