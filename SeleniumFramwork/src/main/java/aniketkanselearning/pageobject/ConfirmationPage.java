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

public class ConfirmationPage extends AbstractComponents
{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css= ".hero-primary")
	WebElement text;
	
	
	public String getConfirmation()
	{
		return text.getText();
	}
	
	
		
	

	}

