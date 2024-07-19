package aniketkanselearning.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aniketkanselearning.AbstractComponents.AbstractComponents;
import aniketkanselearning.TestComponents.BaseTest;
import aniketkanselearning.pageobject.CartPage;
import aniketkanselearning.pageobject.CheckoutPage;
import aniketkanselearning.pageobject.ConfirmationPage;
import aniketkanselearning.pageobject.LandingPage;
import aniketkanselearning.pageobject.OrderPage;
import aniketkanselearning.pageobject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

	
public class SubmitOrder extends BaseTest{

		String productname = "ADIDAS ORIGINAL";
		@Test(dataProvider="getData",groups= {"Purchase"})
		//public void SubmitOrder(String email,String password,String productname) throws IOException, InterruptedException
		public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
			
		String CountryName = "Ind";
		ProductCatalog productcatalog =  landingpage.LoginPage(input.get("email"), input.get("password"));
		List<WebElement>product =productcatalog.productList();
		productcatalog.addToCart(input.get("product"));

		CartPage cartpage = productcatalog.GoToCartPage();
		Boolean match = cartpage.CartVerification(input.get("product"));
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage = cartpage.CheckOut();
		checkoutpage.SelectCountry(CountryName);
		ConfirmationPage confirmationpage = checkoutpage.SubmitOrder();
		
		String confirmationMessage = confirmationpage.getConfirmation();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//text.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		//Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
		
	}
		@Test(dependsOnMethods= {"SubmitOrder"})
		public void OrderHistory()
		{
			ProductCatalog productcatalog =  landingpage.LoginPage("abc9696@gmail.com", "Aniket@123");
			
			OrderPage orderpage = productcatalog.GoToOrderPage();
			Assert.assertTrue(orderpage.VerifyOrder(productname));
			
		}
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			
		/*	HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "abc9696@gmail.com");
			map.put("password", "Aniket@123");
			map.put("product", "ADIDAS ORIGINAL");
			
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email", "swati143@gmail.com");
			map1.put("password", "Swati@123");
			map1.put("product", "ADIDAS ORIGINAL");*/
			
			List<HashMap<String,String>>data = getJsonDataToMap(System.getProperty("user.dir")+ "//src//test//java//aniketkanselearning//Data//PurchaseOrder.json");
			
			return new Object [][] {{data.get(0)}, {data.get(1)}};
			//return new Object [][] {{map}, {map1}};
			
			//return new Object [][] {{"abc9696@gmail.com", "Aniket@123","ADIDAS ORIGINAL"},{"swati143@gmail.com", "Swati@123","ADIDAS ORIGINAL"}};
		}
}
