import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class CalenderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String year = "2030";
		String monthNumber = "02";
		String date = "07";
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//month/day/year - 02/07/2030
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(month)-1).click();
		//driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();

		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();

		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		*/
		String monthNumber = "6";

		String date = "15";

		String year = "2027";

		String[] expectedList = {monthNumber,date,year};

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();

		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();

		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for(int i =0; i<actualList.size();i++)

		{

		System.out.println(actualList.get(i).getAttribute("value"));

		//Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		

		}

		driver.close();


	}

}
