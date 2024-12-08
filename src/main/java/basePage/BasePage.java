package basePage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * BasePage is an abstract base class providing utility methods for common
 * web page interactions using Selenium WebDriver. This class contains methods
 * for waiting, interacting with elements, and asserting conditions on web pages.
 */
public abstract class BasePage {

    /**
     * WebDriver instance for interacting with the browser. 
     */
    protected WebDriver driver;

    /**
     * WebDriverWait instance for handling dynamic waits. 
     */
    protected WebDriverWait wait;

    /**
     * Constructor to initialize the BasePage with a WebDriver instance.
     *
     * @param driver the WebDriver instance to interact with the browser.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Waits until the specified element is visible on the page.
     *
     * @param elementBy the locator of the element to wait for.
     */
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    /**
     * Waits until the specified element contains the expected text.
     *
     * @param elementBy the locator of the element to wait for.
     * @param text the expected text to be present in the element.
     */
    public void waitForTextToBeLoaded(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Waits until the specified element is no longer visible on the page.
     *
     * @param elementBy the locator of the element to wait for invisibility.
     */
    public void waitInvisibility(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    /**
     * Waits until the specified element is clickable.
     *
     * @param elementBy the locator of the element to wait for.
     */
    public void waitToBeClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    /**
     * Retrieves a single WebElement based on the provided locator.
     *
     * @param locator the locator of the element to retrieve.
     * @return the WebElement found by the locator.
     */
    private WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Retrieves a list of WebElements based on the provided locator.
     *
     * @param elementBy the locator of the elements to retrieve.
     * @return a list of WebElements found by the locator.
     */
    public List<WebElement> getElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    /**
     * Clicks on the specified element.
     *
     * @param elementBy the locator of the element to click.
     */
    protected void clickElement(By elementBy) {
        WebElement element = getElement(elementBy);
        element.click();
    }

    /**
     * Clears the text of the specified input element.
     *
     * @param elementBy the locator of the input element to clear.
     */
    public void clearText(By elementBy) {
        getElement(elementBy).clear();
    }

    /**
     * Types the specified text into the input element identified by the locator.
     *
     * @param elementBy the locator of the input element.
     * @param text the text to type into the input element.
     */
    protected void typeIn(By elementBy, String text) {
        WebElement element = getElement(elementBy);
        clearText(elementBy);
        element.sendKeys(text);
    }

    /**
     * Retrieves the text content of the specified element.
     *
     * @param elementBy the locator of the element.
     * @return the text content of the element.
     */
    public String getText(By elementBy) {
        return getElement(elementBy).getText();
    }

    /**
     * Retrieves the number of elements matching the specified locator.
     *
     * @param elementBy the locator of the elements to count.
     * @return the number of elements matching the locator.
     */
    public int getNumberOfElements(By elementBy) {
        return getElements(elementBy).size();
    }

    /**
     * Asserts that two strings are equal.
     *
     * @param actualText the actual string to compare.
     * @param expectedText the expected string to compare.
     */
    public void assertStringsEqual(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * Asserts that the specified element is displayed on the page.
     *
     * @param elementBy the locator of the element to check.
     */
    public void assertElementDisplayed(By elementBy) {
        Assert.assertTrue(getElement(elementBy).isDisplayed());
    }

}
