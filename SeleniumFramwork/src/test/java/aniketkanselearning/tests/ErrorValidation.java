package aniketkanselearning.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import aniketkanselearning.AbstractComponents.AbstractComponents;
import aniketkanselearning.TestComponents.BaseTest;
import aniketkanselearning.TestComponents.Retry;
import aniketkanselearning.pageobject.CartPage;
import aniketkanselearning.pageobject.CheckoutPage;
import aniketkanselearning.pageobject.ConfirmationPage;
import aniketkanselearning.pageobject.LandingPage;
import aniketkanselearning.pageobject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest{

		@Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void SubmitOrder() throws IOException
		{
		String productname = "ADIDAS ORIGINAL";
		String CountryName = "Ind";
		landingpage.LoginPage("abc9696@gmail.com", "Aniket@1234");
		System.out.println(landingpage.getErrorMessage());
		Assert.assertEquals("Incorrect email o password.", landingpage.getErrorMessage());
		
		
		
		
		
	}

}
