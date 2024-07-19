package aniketkanselearning.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aniketkanselearning.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	CheckoutPage checkoutpage;
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	

	public Boolean CartVerification(String ProductName) 
	{
		
		boolean ActualProduct = CartProducts.stream().anyMatch(cartlist-> cartlist.getText().equalsIgnoreCase(ProductName));
		return ActualProduct;	
	}
	public CheckoutPage CheckOut()
	{
		checkout.click();
		checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}
	
	
		
	

	}

