package aniketkanselearning.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aniketkanselearning.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents
{
	ConfirmationPage confirmationpage;
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css="[class*='ta-item']:nth-child(3)")
	WebElement SelectCountry;
	
	@FindBy(css="[class*='action__submit']")
	WebElement Submit;
	
	By waitCountryAppears = By.cssSelector("[class*='ta-item']:nth-child(3)");

	public void SelectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitVisibility(waitCountryAppears);
		SelectCountry.click();
	}
	public ConfirmationPage SubmitOrder()
	{
		Submit.click();
		confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}
	
	
	
		
	

	}

