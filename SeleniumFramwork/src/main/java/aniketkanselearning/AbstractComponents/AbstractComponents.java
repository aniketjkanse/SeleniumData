package aniketkanselearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aniketkanselearning.pageobject.CartPage;
import aniketkanselearning.pageobject.OrderPage;

public class AbstractComponents {

		WebDriver driver;
		
		public AbstractComponents(WebDriver driver) 
		{
			//Super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(css="[routerlink*='cart']")
		WebElement Cart;
		
		
		@FindBy(css="[routerlink*='myorders']")
		WebElement Order;
		public void waitVisibility(By findBy)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		public void waitVisibilityofElement(WebElement findBy)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));
		}

		public void waitInvisibility(WebElement ele)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	
		public CartPage GoToCartPage()
		{
			 Cart.click();
			 CartPage cartpage = new CartPage(driver);
			 return cartpage;
			 
		}
		public OrderPage GoToOrderPage()
		{
			 Order.click();
			 OrderPage orderpage = new OrderPage(driver);
			 return orderpage;
		}

	
	}


