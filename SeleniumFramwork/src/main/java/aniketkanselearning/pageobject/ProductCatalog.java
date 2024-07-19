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

public class ProductCatalog extends AbstractComponents{

	WebDriver driver;
	CartPage cartpage;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement Spinner;

	@FindBy(css=".cartSection h3")
	List<WebElement> CartItems;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement Checkout;
	By productsBy = By.cssSelector(".mb-3");
	By CartAddProduct = By.cssSelector(".card-body button:last-of-type");
	By ToastMessage = By.id("toast-container");
	
	public List<WebElement> productList()
	{
		waitVisibility(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String ProductName)
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(CartAddProduct).click();
		waitVisibility(ToastMessage);
		waitInvisibility(Spinner);
	}
	
	
	public List<WebElement> CartList()
	{
		return CartItems;
	}

	
	
	
		
	

	}

