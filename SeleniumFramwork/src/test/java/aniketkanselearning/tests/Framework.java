package aniketkanselearning.tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriverManager.chromedriver().setup();
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("abc9696@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Aniket@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//WebDriverWait wait1 = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		//driver.findElement(By.cssSelector(".cart button:last-of-type")).click();
		
		List<WebElement> cartlists = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean actualitem = cartlists.stream().anyMatch(cartlist-> cartlist.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(actualitem);
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		
		//section/button[2]
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='ta-item']:nth-child(3)")));
		
		driver.findElement(By.cssSelector("[class*='ta-item']:nth-child(3)")).click();
		
		driver.findElement(By.cssSelector("[class*='action__submit']")).click();
		
		String text = driver.findElement(By.cssSelector("[class='hero-primary']")).getText();
		text.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		System.out.println(text);
		
		
		
		
		
		
	}

}
