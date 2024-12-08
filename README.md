# Final Project

This project is a Selenium-based automation framework designed to test the functionality of a sample e-commerce web application. It utilizes Java, TestNG, and WebDriverManager to facilitate browser automation in a modular and scalable manner.

---

## Features

- **Login Functionality**: Tests invalid login scenario.
- **Cart Operations**: Verifies adding products to the cart and completing checkout.
- **Category Filtering**: Confirms that category filtering reduces displayed product counts.
- **Wishlist Management**: Ensures users can add products to their favorites.
- **Reusable Utilities**: Modular methods for common UI interactions and assertions.
- **Data-Driven Testing**: Implements TestNG’s DataProvider for invalid login test cases.
- **Scalable Design**: Supports easy addition of new tests and cross-browser testing.

---

## Project Structure

```plaintext
.
├── basePage/
│   └── BasePage.java       # Contains common Selenium methods for actions and validations.
├── pages/
│   ├── HomePage.java       # Page Object for the Home Page.
│   ├── LoginPage.java      # Page Object for the Login Page.
│   ├── ProductPage.java    # Page Object for the Product Page.
│   ├── ProfilePage.java    # Page Object for the Profile Page.
├── tests/
│   ├── BaseTest.java       # Manages WebDriver setup and teardown.
│   ├── CartTest.java       # Tests cart functionality.
│   ├── CategoryTest.java   # Verifies product count filtering in categories.
│   ├── NegativeLoginTest.java # Tests invalid login scenarios using DataProvider.
│   ├── WishlistTest.java   # Validates addition of products to favorites.
├── utils/
│   └── DataProvider.java   # Supplies test data for parameterized tests.
└── pom.xml                 # Maven configuration and dependency management.
