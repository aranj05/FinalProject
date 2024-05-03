package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;

public class PlaceOrderTest {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage= new LoginPage(driver);
		listPage= new ProductListPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage= new CheckOutPage(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
		
	}
	
	@Test (priority=1)
	public void validLogin() {
		loginPage.login("standard_user", "secret_sauce");	
		boolean isValid= listPage.isOnProducts();
		Assert.assertTrue(isValid);
	}
	
	@Test  (priority=2)
	public void addItem() {
		listPage.addToCart();
		listPage.viewCart();
		boolean isItemAvl= cartPage.isItemAdded();
		Assert.assertTrue(isItemAvl);
	}
	
	@Test  (priority=3)
	public void checkoutTest() {
		cartPage.checkoutItems();
		checkOutPage.provideDetails("Adarsh", "Ranjan", "123456");
		checkOutPage.checkoutOrder();
		boolean isMsg= checkOutPage.isOrderSuccess();
		Assert.assertTrue(isMsg);
	}
	

}
