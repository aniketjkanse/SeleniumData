import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//search a element in search bar
		driver.findElement(By.cssSelector("[type='search']")).sendKeys("Rice");
		List <WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

		List<WebElement>filteredList = veggies.stream().filter(veg-> veg.getText().contains("Rice")).collect(Collectors.toList());

		Assert.assertEquals(veggies.size(), filteredList.size());
		
		
		
		
	}

}
