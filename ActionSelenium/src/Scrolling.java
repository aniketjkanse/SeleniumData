import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(200L);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		List<WebElement> value = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum=0;
		for(int i=0;i<value.size();i++)
		{
			sum=sum+Integer.parseInt(value.get(i).getText());
		}
		System.out.println(sum);
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
		WebElement table=driver.findElement(By.id("product"));
		
		//.Find the rowcount of second table
		int rowcount = table.findElements(By.xpath("//table[@class='table-display']//tbody/tr")).size();  //.table-display tr 
		System.out.println("The rowcount is : "+rowcount);
		
		//.Find the columncount of second table
		
		int columncount = table.findElements(By.xpath("//table[@class='table-display']//tbody/tr[1]/th")).size();
		System.out.println("The columncount is : "+columncount);
		
		List<WebElement> rowtext = table.findElements(By.xpath("//table[@class='table-display']//tbody/tr[4]/td"));
		for(int i=0;i<rowtext.size();i++)
		{
			String Text = rowtext.get(i).getText();
			System.out.println(Text);
		}
		
	/*	code provided by rahul shetty
	    WebElement table=driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());

		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());
		*/
	}

}
