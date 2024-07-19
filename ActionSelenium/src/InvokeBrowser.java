import java.io.File;
import java.util.Iterator;
import java.util.Set;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String>window = driver.getWindowHandles();
		Iterator<String>it = window.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/#/index");
		
		String Text = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(Text);
		
		//take screenshot
		/*File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file,new File("logo.png"));
		*/
		
		//Get Height and width
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		
		
		
	
	}

}
