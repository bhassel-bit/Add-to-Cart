# TC03 – Add to Cart Automation Test

## Overview
This Java Selenium WebDriver test automates adding a product to the shopping cart on the [Cloudberry Store](https://cloudberrystore.services/). It verifies that the application displays a success notification after the **HP LP3065** is added to the cart.

## Test Case Details
- **Test case ID:** TC03
- **Java class:** `day7.TC03_AddtoCart`
- **Test type:** Functional UI automation / add-to-cart flow
- **Browser:** Google Chrome
- **Test application:** Cloudberry Store
- **Expected result:** A success message appears after adding the selected item to the cart.

## Test Steps
1. Launch Chrome using Selenium WebDriver.
2. Navigate to `https://cloudberrystore.services/` and maximize the browser window.
3. Open **Laptops & Notebooks**.
4. Select **Show All Laptops & Notebooks**.
5. Scroll to and select **HP LP3065**.
6. Calculate a delivery date five days after the current date and enter it in `MM/dd/yyyy` format.
7. Scroll to the **Add to Cart** button and click it.
8. Read the success notification and check whether it contains `Success`.
9. Close the browser using `driver.quit()`.

## Tools and Technologies
- Java
- Selenium WebDriver
- ChromeDriver
- XPath locators
- JavaScriptExecutor for scrolling elements into view
- Java `LocalDate` and `DateTimeFormatter` for dynamic date input

## Prerequisites
- JDK installed and configured
- Google Chrome installed
- Selenium Java library added to the Java project
- A compatible ChromeDriver available through Selenium Manager or your WebDriver setup
- Internet access to the test website

## How to Run
1. Add `TC03_AddtoCart.java` to the `day7` package in a Java project with Selenium dependencies.
2. Open the project in your Java IDE (such as Eclipse).
3. Run `TC03_AddtoCart.java` as a **Java Application**.
4. Check the console output for the test result.

## Test Validation
The test checks the text of the success alert:

```java
if (actualMessage.contains("Success")) {
    System.out.println("Test Passed");
} else {
    System.out.println("Test Failed");
}
```

**Expected console output:** `Test Passed` when the application displays the expected success notification. Otherwise, the check prints `Test Failed`.

## Notes and Possible Enhancements
- The script uses a 30-second implicit wait and short `Thread.sleep()` delays. Explicit waits could make interactions more reliable.
- Scrolling helps locate product controls across different viewport sizes, but this test does not perform cross-resolution or cross-browser coverage.
- Checking only for `Success` does not independently confirm the cart contents or quantity.
- The test prints results to the console rather than using an assertion framework such as JUnit or TestNG.
- If an exception occurs before the end, the browser may remain open; a `try/finally` block would improve cleanup.

## Source File
`TC03_AddtoCart.java`
