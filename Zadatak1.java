package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ShopPage;

public class Zadatak1 {
	private WebDriver driver;
	private Actions actions;
	private JavascriptExecutor js;
	private ShopPage shopPage;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		this.shopPage = new ShopPage(driver);
	}
	
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("http://cms.demo.katalon.com/");
		
		List<WebElement> products = shopPage.getProductItems();
//		Thread.sleep(3000);
		for (int i = 0; i < products.size(); i++) {
			
			js.executeScript("arguments[0].scrollIntoView();", products.get(i));
			Thread.sleep(500);
			actions.moveToElement(products.get(i)).perform();
			WebElement addToCartBtn = 
					products.get(i).findElement(By.className("add_to_cart_button"));
			
			Assert.assertTrue(addToCartBtn.isDisplayed(), "Add To Cart Button is not visible on hovering.");
		}
		
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
}
