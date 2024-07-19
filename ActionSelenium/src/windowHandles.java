import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String>window = driver.getWindowHandles(); //You will get all the windows [parent,child]
		
	    Iterator<String> it = window.iterator();
	    String ParentId = it.next();
	    String ChildId =it.next();
	    
	    driver.switchTo().window(ChildId);
	    
	    System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
	    
	    String EmailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	    
	    driver.switchTo().window(ParentId);
	    
	    driver.findElement(By.id("username")).sendKeys(EmailId);
	   //driver.quit();
	    
	}
	  

}
