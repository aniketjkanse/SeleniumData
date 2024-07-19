import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamPagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on the first column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		Thread.sleep(2000L);
		
		//select all the data in 1st table and getText() -This is original list
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("Original List : "+originalList);
		
		//sort the original list into sortlist and compare 
		List<String> sortList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List : "+sortList);
		Assert.assertTrue(originalList.equals(sortList));
		
		List<String> price;
		//print the value of veggi whose name is "Beans" using customer method in Selenium stream
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s-> s.getText().contains("Rice")).
				map(s->getVeggiePrice(s)).collect(Collectors.toList());
		price.forEach(a-> System.out.println(a));
		
		if(price.size()<1)
		{
			Thread.sleep(1000L);
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
	}while(price.size()<1);
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}