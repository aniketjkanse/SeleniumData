package aniketkanselearning.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aniketkanselearning.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	ProductCatalog productcatalog;
	
	public LandingPage(WebDriver driver) 
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		//driver.findElement(By.id("userEmail")).sendKeys("abc9696@gmail.com");
		@FindBy(css="#userEmail")    //PageFactory
		WebElement userEmail; 
		
		//driver.findElement(By.id("userPassword")).sendKeys("Aniket@123");
		@FindBy(id="userPassword")    
		WebElement userPassword;
		
		//driver.findElement(By.id("login")).click();
		@FindBy(id="login")    
		WebElement Submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement ErrorMessage;
		
		public ProductCatalog LoginPage(String email, String pass)
		{
			userEmail.sendKeys(email);
			userPassword.sendKeys(pass);
			Submit.click();
			productcatalog = new ProductCatalog(driver);
			return productcatalog;
		}
		
		public void URL()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public String getErrorMessage()
		{
			waitVisibilityofElement(ErrorMessage);
			
			return ErrorMessage.getText();
		}

		
				
		

	}

