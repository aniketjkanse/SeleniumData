import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://qaclickacademy.com/practice.php");
		//1.Get a count of links present on webpage
		int linkcount = driver.findElements(By.tagName("a")).size();
		
		System.out.println(linkcount);
		
		//2.Get a count of links present in footer section of webpage
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		
		int footerlinkcount = footerdriver.findElements(By.tagName("a")).size();
		
		System.out.println(footerlinkcount);
		
		//3.Get a count of links present in first column of footer section of webpage
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		
		int columnlinkcount  = columndriver.findElements(By.tagName("a")).size();
		System.out.println(columnlinkcount);
		
		//4.Click on each link of the column and check if webpages are opening
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
				{
						String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
						columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
						Thread.sleep(5000L);
			
				}
		
		Set<String>window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		
	}

}
