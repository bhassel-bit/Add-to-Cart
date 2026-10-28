package day7;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 3rd Test case - TC03_AddToCart - Continue ------- 1. Launch Browser (chrome)
		 * 2. Open URL https://cloudberrystore.services/ 3. Click on Laptops and
		 * NoteBooks 4. Click on Show all Laptops and NoteBooks 5. Select an item
		 * "HP LP3065" 6. Set Delivery Date 7. Click on Add to Cart 8. Validate Item
		 * added to the cart successfully 9. Close WebDriver
		 */

		// 1. Launch Browser (chrome)
		WebDriver driver = new ChromeDriver(); // open the chrome
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicitly Wait

		// 2. Open URL https://cloudberrystore.services/
		driver.get("https://cloudberrystore.services/");
		driver.manage().window().maximize();

		// 3. Click on Laptops and NoteBooks.
		driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']")).click();

		// 4. Click on Show all Laptops and NoteBooks
		driver.findElement(By.xpath("//a[normalize-space()='Show All Laptops & Notebooks']")).click();

		// 5. Select an item "HP LP3065"
		WebElement elementHP = driver
				.findElement(By.xpath("//div[@class='description']//a[contains(text(),'HP LP3065')]"));

		// Scroll to view and click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementHP);
		// Add a small wait
		Thread.sleep(1000);
		elementHP.click(); // click on element

		// 6. Set Delivery Date
		LocalDate CurrentDate = LocalDate.now();
		// System.out.println("Current Date: " + CurrentDate);

		// Add 5 days
		LocalDate DeliveryDate = CurrentDate.plusDays(5);
		// System.out.println(DeliveryDate);

		// Convert to format MM/dd/yyyy
		String formattedDeliveryDate = DeliveryDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		// System.out.println(formattedDeliveryDate);

		driver.findElement(By.xpath("//input[@id='input-option-225']")).sendKeys(formattedDeliveryDate);

		// 7.Click on Add to Cart
		WebElement elementAddToCart = driver.findElement(By.xpath("//button[@id='button-cart']"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementAddToCart);
		// Add a small wait
		Thread.sleep(1000);
		elementAddToCart.click();

		// 8. Validate Item added to the cart successfully

		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();

		if (actualMessage.contains("Success")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		// 9. Close WebDriver
		driver.quit();

	}
}

